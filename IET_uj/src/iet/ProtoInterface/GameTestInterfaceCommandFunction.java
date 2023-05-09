package iet.ProtoInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import iet.Agents.*;
import iet.AnointedBehaviours.*;
import iet.Core.*;
import iet.Equipments.*;
import iet.Fields.*;
import iet.FileManagement.Serializer;
import iet.Gencodes.*;
import iet.MoveBehaviours.*;
import iet.VirologistBehaviours.*;



public class GameTestInterfaceCommandFunction {
private Game game;
	
	/**
	 *betolt egy megadott fajlt, egy elore keszitett jatekteret
	 */
	public void LoadMap() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 2) {
			parameterProblem("parameter number problem");
			return;
		}
		game = Serializer.deserialize(params.get(1));
	}
	
	/**
	 *elmenti a jatek eppeni allasat
	 */
	public void Save() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 2) {
			parameterProblem("parameter number problem");
			return;
		}
		Serializer.serialize(game,params.get(1));
	}
	
	public void Save2() {
		
		Serializer.serialize(game,"bigMap");
	}
	/**
	 *uj jatekot indit, nullaz mindent, semmi nincs a palyan
	 */
	public void Init() {
		ArrayList<iet.Fields.Field> fields = new ArrayList<iet.Fields.Field>();
		Game g = new Game(0);
		g.getFields().addAll(fields);
		game = g;
	}
	
	/**
	 *adott tipusu es ID-ju mezo letrehozasa es palyahoz adasa
	 */
	public void Field() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 3) {
			parameterProblem("parameter number problem");
			return;
		}
		if (fieldIdIsExist(params.get(2))) {
			parameterProblem("field id alredy exist");
			return;
		}
		Field f1;
		String fieldType = params.get(1); 
		switch (fieldType) {
		case "normal":
			f1 = new Field();
			break;
		case "laboratory":
			f1 = new LaboratoryField();
			break;
		case "storage":
			f1 = new StorageField();
			break;
		case "shelter":
			f1 = new ShelterField();
			break;
		case "trap":
			f1 = new TrapField();
			break;
		default:
			parameterProblem("parameter value problem");
			return;
		}
		f1.setId(params.get(2));
		game.AddField(f1);
	}
	
	
	/**
	 * ellenorzi, hogy az aditt id-val rendelkezik e mar mezo
	 * @param i az ellenorzendo id
	 * @return hogy letezik e mar az id-vel mezo
	 */
	private boolean fieldIdIsExist(String id) {
		ArrayList<Field> fields = game.getFields();
		for (Field f : fields) {
			if (f.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 2 megadott ID-ju mezot szomszedokka tesz (belerakja egymas szomszedlistajaba)
	 */
	public void Neighbours() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 3) {
			parameterProblem("parameter number problem");
			return;
		}
		if (params.get(1) != params.get(2)) {
			ArrayList<Field> fields = game.getFields();
			for(int i=0; i<fields.size(); ++i){
				if(fields.get(i).getId().equals(params.get(1))) {
					for(int j=0; j<fields.size(); ++j){
						if(fields.get(j).getId().equals(params.get(2))) {
							fields.get(i).addNeighbour(fields.get(j));
							break;
						}
					}
					break;
				}
			}
		}
	}
	
	public void Neighbours2(String f1, String f2) {
		
		ArrayList<Field> fields = game.getFields();
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals(f1)) {
				for(int j=0; j<fields.size(); ++j){
					if(fields.get(j).getId().equals(f2)) {
						fields.get(i).addNeighbour(fields.get(j));
						break;
					}
				}
				break;
			}
		}
		
	}
	
	/**
	 * adott tipusu GenCode-t rak adott ID-ju mezore
	 */
	public void SetGencode() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 3) {
			parameterProblem("parameter number problem");
			return;
		}
		if (fieldIdIsExist(params.get(2))) {
			ArrayList<Field> fields = game.getFields();
			
			for(int i=0; i<fields.size(); ++i){
				if(fields.get(i).getId().equals(params.get(2))) {
					Gencode g;
					
					String gencodeType = params.get(1); 
					switch (gencodeType) {
					case "paralyzing":
						g = new ParalyzingGencode();
						break;
					case "dancer":
						g = new DancerGencode();
						break;
					case "resistance":
						g = new ResistanceGencode();
						break;
					case "alzheimer":
						g = new AlzheimerGencode();
						break;
					default:
						parameterProblem("parameter value problem");
						return;
					}
					fields.get(i).setGencode(g);
					break;
				}
			}
		}
	}
	
	/**
	 * oregit minden eppen hato agenst egy korrel (3 utan megszunnek az agensek)
	 */
	public void StepAll() {
		game.getTimer().Tick();
	}
	
	/**
	 * kilistaz mindent, ami a palyan van: mezok ID-jat, mezok szomszedait, virologusokat, es a virologusoknal levo osszes dolgot
	 */
	public void ViewGame() {
		ArrayList<Field> fields = game.getFields();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		
		System.out.printf("Mezok: ");
		for(int i=0; i<fields.size(); ++i){
			if(i!=fields.size()-1) System.out.printf(fields.get(i).getId() + ", ");
			else System.out.printf(fields.get(i).getId() + "\n");
		}
		
		
		for(int i=0; i<fields.size(); ++i){
			System.out.printf(fields.get(i).getId() + " szomszedai: ");
			for(int j=0; j<fields.get(i).GetNeighbourFieldNum(); ++j){
				if(j!=fields.get(i).GetNeighbourFieldNum()-1) System.out.printf(fields.get(i).GetNeighbour(j).getId() + ", ");
				else System.out.printf(fields.get(i).GetNeighbour(j).getId());
			}
			System.out.println();
		}
		
		
		System.out.println("\nMezokon talalhato dolgok: ");
		for(int i=0; i<fields.size(); ++i){
			ArrayList<Equipment> equipments = fields.get(i).getEquipments();
			ArrayList<Virologist> fieldVir = fields.get(i).getVirologists();
			System.out.printf(fields.get(i).getId() + " mezon levo dolgok: ");
			if(fieldVir!=null) {
				for(int j=0; j<fieldVir.size(); ++j){
					System.out.printf(fieldVir.get(j).getId() + " ");
				}
			}
			if(equipments!=null) {
				for(int j=0; j<equipments.size(); ++j){
					System.out.printf(equipments.get(j).getId() + " ");
				}
			}
			if(fields.get(i).getGencode()!=null) {
				System.out.printf(fields.get(i).getGencode().getType() + " ");
			}
			
			if(!(fields.get(i).getAmino()==0 && fields.get(i).getNucleotid()==0)) {
				System.out.printf(fields.get(i).getAmino() + " darab amino " + fields.get(i).getNucleotid() + " darab nukleotid");
			}
			System.out.println();
		}
		
		System.out.println("\nVirologusoknal levo dolgok: ");
		for(int i=0; i<virologists.size(); ++i){
			System.out.printf(virologists.get(i).getId() + "-nel levo dolgok: ");
			ArrayList<Equipment> equips = virologists.get(i).getEquipments();
			if(equips!=null){
				for(int j=0; j<equips.size(); ++j){
					System.out.printf(equips.get(j).getId() + " ");
				}
			}
			
			HashSet<Gencode> gencodes = virologists.get(i).getGencodes();
			Gencode[] codes = gencodes.toArray(new Gencode[gencodes.size()]);
			if(codes!=null){
				 for(int j=0; j<codes.length; ++j){
					System.out.printf(codes[j].getType() + " ");
				 }
			}
			
			ArrayList<Agent> agents =  virologists.get(i).getAgents();
			if(agents!=null) {
				for(Agent a : agents) {
	    			System.out.printf(a.getId() + " ");
				}
			}
			
			System.out.println(virologists.get(i).getAmino() + " darab amino " + virologists.get(i).getNucleotid() + " darab nukleotid");
		}
		
		System.out.println("\nVirologusokon levo effect-ek: ");
		
		for(int i=0; i<virologists.size(); ++i){
			ArrayList<Effect> effects = virologists.get(i).getEffects();
			System.out.printf(virologists.get(i).getId() + ": ");
			for(int j=0; j<effects.size(); ++j){
				if(j!=effects.size()-1) System.out.printf(effects.get(j).getId() + ", ");
				else System.out.printf(effects.get(j).getId());
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	/**
	 * kilistazza a virologus allapotat, azaz hogy mik vannak nala es milyen effect-ek vannak rajta
	 */
	public void VirologistState() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 2) {
			parameterProblem("parameter number problem");
			return;
		}
		ArrayList<Virologist> virologists = game.getVirologists();
		for(int i=0; i<virologists.size(); ++i){
			if(virologists.get(i).getId().equals(params.get(1))) {
				System.out.printf(virologists.get(i).getId() + "-nel levo dolgok: ");
				ArrayList<Equipment> equips = virologists.get(i).getEquipments();
				
				if(equips!=null){
					for(int j=0; j<equips.size(); ++j){
						System.out.printf(equips.get(j).getId() + " ");
						
					}
				}
				
				 HashSet<Gencode> gencodes = virologists.get(i).getGencodes();
				 Gencode[] codes = gencodes.toArray(new Gencode[gencodes.size()]);
				 if(codes!=null){
					 for(int j=0; j<codes.length; ++j){
						if(j!=codes.length-1) System.out.printf(codes[j].getType() + " ");
						else System.out.printf(codes[j].getType() + "\n");
					 }
				}
				
				ArrayList<Agent> agents =  virologists.get(i).getAgents();
				if(agents!=null) {
					for(Agent a : agents) {
						System.out.printf(a.getId() + " ");
					}
				}
				
				System.out.println(virologists.get(i).getAmino() + " darab amino, " + virologists.get(i).getNucleotid() + " darab nukleotid");
				
				System.out.println("Virologuson levo effect-ek: ");
				ArrayList<Effect> effects = virologists.get(i).getEffects();
				System.out.printf(virologists.get(i).getId() + ": ");
				for(int j=0; j<effects.size(); ++j){
					if(j!=effects.size()-1) System.out.printf(effects.get(j).getId() + " ");
					else System.out.printf(effects.get(j).getId());
				}
				System.out.println();
				
				return;
			}
		}
		parameterProblem("virologist not exist");
	}
	
	/**
	 * adott Id-ju, uj virologust adott ID-ju mezore tesz
	 */
	public void SetVirologist() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 3) {
			parameterProblem("parameter number problem");
			return;
		}
		if (virologistIdIsExist(params.get(1))) {
			parameterProblem("virologist id is alredy exist");
			return;
		}
		if (!fieldIdIsExist(params.get(2))) {
			parameterProblem("field id is not exist");
			return;
		}
		ArrayList<Field> fields = game.getFields();
		
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals(params.get(2))) {
				Virologist newbie = new Virologist(game, fields.get(i));
				newbie.setId(params.get(1));
				/*
				game.AddVirologist(newbie);
				fields.get(i).AddVirologist(newbie);
				*/		
			}
		}
	}
	
	/**
	 * ellenorzi, hogy az aditt id-val rendelkezik e mar virologus
	 * @param id az ellenorzendo id
	 * @return hogy letezik e mar az id-vel virologus
	 */
	private boolean virologistIdIsExist(String id) {
		ArrayList<Virologist> virologists = game.getVirologists();
		for (Virologist v : virologists) {
			if (v.getId().equals(id)) return true;
		}
		return false;
	}
	
	/**
	 * beallitja a virologus allapotat (normal,paralyzed,bear)
	 */
	public void SetVirState() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 3) {
			parameterProblem("parameter number problem");
			return;
		}
		if (!virologistIdIsExist(params.get(1))) {
			parameterProblem("virologist id not exist");
			return;
		}
		
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); i++) {
			
			if (virologists.get(i).getId().equals(params.get(1))) {
				switch (params.get(2)) {
				case "normal":
					
					virologists.get(i).setVirologistBehaviour(new Normal());
					virologists.get(i).setAnointedBehaviour(new TakeAnoint());
					virologists.get(i).setMoveBehaviour(new NormalMove());
					break;
				case "paralyzed":
					virologists.get(i).UseAnointed(virologists.get(i), new ParalyzingAgent());
					break;
				case "bear":
					virologists.get(i).UseAnointed(virologists.get(i), new BearAgent());
					break;
				case "dancer":
					virologists.get(i).UseAnointed(virologists.get(i), new DancerAgent());
					break;
				default:
					parameterProblem("parameter state value is not exist");
					break;
				}
				
				break;
			}
		}
	}
	
	/**
	 * a virologus megoli a medveve valt masik virologust
	 */
	public void Kill() {
		ArrayList<String> params = Interface.GetTheParams();
		
		if (params.size() < 3) {
			parameterProblem("parameter number problem");
			return;
		}
		if (!virologistIdIsExist(params.get(1))) {
			parameterProblem("parameter 1 virologist id not exist");
			return;
		}
		if (!virologistIdIsExist(params.get(2))) {
			parameterProblem("parameter 2 virologist id not exist");
			return;
		}
		
		ArrayList<Virologist> virologists = game.getVirologists();
		Virologist virologist1 = null;
		Field field;
		for (int i = 0; i < virologists.size(); i++) {
			if (virologists.get(i).getId().equals(params.get(2))) {
				virologist1 = virologists.get(i);
				break;
			}
		}
		field = virologist1.getField();
		virologists = field.getVirologists();
		for (int i = 0; i < virologists.size(); i++) {
			if (virologists.get(i).getId().equals(params.get(1))) {
				virologists.get(i).UseKill(virologist1);
				return;
			}
		}
		parameterProblem("the virologist1 can't touch virologist2");
	}
	
	/**
	 * a virologus leptetese a mezokon
	 */
	public void Move() {
		ArrayList<String> params = Interface.GetTheParams();
		if (params.size() < 4) {
			parameterProblem("parameter number problem");
			return;
		}
		if (!virologistIdIsExist(params.get(1))) {
			parameterProblem("parameter 1 virologist id not exist");
			return;
		}
		if (!fieldIdIsExist(params.get(2))) {
			parameterProblem("field id is not exist");
			return;
		}
		
		ArrayList<Virologist> virologists = game.getVirologists();
		
		if (params.get(3).equals("off")) {
			for (int i = 0; i < virologists.size(); ++i) {
				if (virologists.get(i).getId().equals(params.get(1))) {
					Field standsHere = virologists.get(i).getField();
					for (int j = 0; j < standsHere.GetNeighbourFieldNum(); j++) {
						if (standsHere.GetNeighbour(j).getId().equals(params.get(2))) {
							virologists.get(i).UseMove(j);
							break;
						}
					}
					break;
				}
			}
			return;
		}
		else if(params.get(3).equals("on")) {
			for (int i = 0; i < virologists.size(); ++i) {
				if (virologists.get(i).getId().equals(params.get(1))) {
					Field standsHere = virologists.get(i).getField();
					int randStep = new Random().nextInt(standsHere.GetNeighbourFieldNum());
					virologists.get(i).UseMove(randStep); 
				}
			}
			return;
		}
		parameterProblem("third parameter value problem");
	}
		
	
	
	/**
	 * megtanul egy genetikai kodot a virologus
	 */
	public void LearnGencode() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); ++i) {
			if (virologists.get(i).getId().equals(params.get(1))) {
				Field standsHere = virologists.get(i).getField();
				Gencode gencode = standsHere.getGencode(); 
				if (gencode != null) {
					virologists.get(i).TakeGencode(gencode);
				}
			}
		}
		
	}
	
	/**
	 * agenst keszit a virologus a genetikai kodbol
	 */
	public void CraftAgent() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); ++i) {
			if (virologists.get(i).getId().equals(params.get(2))) {
				HashSet<Gencode> gencodes = virologists.get(i).getGencodes();
				Gencode[] codes = gencodes.toArray(new Gencode[gencodes.size()]);
				if (codes != null){
					 for (int j = 0; j < codes.length; ++j){
						if (params.get(1).equals("paralyzing") && codes[j].getType().equals("parCode")) {
							virologists.get(i).CraftAgent(codes[j]);
						}
						else if (params.get(1).equals("alzheimer") && codes[j].getType().equals("alzCode")) {
							virologists.get(i).CraftAgent(codes[j]);
						}
						else if (params.get(1).equals("resistance") && codes[j].getType().equals("resCode")) {
							virologists.get(i).CraftAgent(codes[j]);
						}
						else if (params.get(1).equals("dancer") && codes[j].getType().equals("danCode")) {
							virologists.get(i).CraftAgent(codes[j]);
						}
					 }
				}
			}
		}
		
	}
	
	/**
	 * egy virologus megtamadja a masik virologust agenskenessel
	 */
	public void UseAgent() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		Virologist from = null;
		Virologist to = null;
		Agent with = null;
		
		for (int i = 0; i < virologists.size(); ++i){
			
			if (virologists.get(i).getId().equals(params.get(2))) {
				Field standsHere = virologists.get(i).getField();
				ArrayList<Virologist> standsHereVirologists = standsHere.getVirologists();
				for (int j = 0; j < virologists.size(); ++j){
					if (standsHereVirologists.get(j).getId().equals(params.get(3))) {
						ArrayList<Agent> agents =  virologists.get(i).getAgents();
						
						
							for(Agent agent : agents){
								if (params.get(1).equals("paralyzing") && agent.getId().equals("ParAg")) {
									from = virologists.get(i);
									to = standsHereVirologists.get(j);
									with = agent;
								}
								else if (params.get(1).equals("alzheimer") && agent.getId().equals("AlzAg")) {
									from = virologists.get(i);
									to = standsHereVirologists.get(j);
									with = agent;
								}
								else if (params.get(1).equals("resistance") && agent.getId().equals("ResAg")) {
									from = virologists.get(i);
									to = standsHereVirologists.get(j);
									with = agent;
								}
								else if (params.get(1).equals("dancer") && agent.getId().equals("DanAg")) {
									from = virologists.get(i);
									to = standsHereVirologists.get(j);
									with = agent;
								}
							}
							
					}	
				}
			}
		}
		if (from!=null && to!=null && with != null)
			from.Anoint(to, with);
		
	}
	
	/**
	 * adott virologus felvesz egy felszerelest a field-rol
	 */
	public void TakeEquipment() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Field> fields = game.getFields();
		ArrayList<Virologist> virologists = game.getVirologists();
		for(int i=0; i<virologists.size(); ++i){
			if(virologists.get(i).getId().equals(params.get(2))) {
				Field standsHere = virologists.get(i).getField();
				ArrayList<Equipment> eqs = standsHere.getEquipments();
				if(eqs!=null) {
					for(int j=0; j<eqs.size(); ++j){
						if(eqs.get(j).getId().equals(params.get(1))) {
							virologists.get(i).TakeEquipment(eqs.get(j));
						}
					}
				}
			}
		}
		
		
	}
	
	/**
	 * megadott virologustol eltavolit egy felszerelest, es a mezore dobja, amin all
	 */
	public void DropEquipment() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		for(int i=0; i<virologists.size(); ++i){
			if(virologists.get(i).getId().equals(params.get(2))) {
				ArrayList<Equipment> eqs = virologists.get(i).getEquipments();
				if(eqs!=null) {
					for(int j=0; j<eqs.size(); ++j){
						if(eqs.get(j).getId().equals(params.get(1))) {
							virologists.get(i).DropEquipment(eqs.get(j));
						}
					}
				}
			}
		}
		
		
		
	}
	
	/**
	 * adott tipusu felszerelest rak a megadott ID-ju mezore
	 */
	public void SetEquipment() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Field> fields = game.getFields();
		
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals(params.get(3))) {
				Equipment e;
				if(params.get(1).equals("glove")) e = new Glove(null);
				else if(params.get(1).equals("bag")) e = new Bag(null);
				else if(params.get(1).equals("axe")) e = new Axe(null);
				else e = new Cape(null);
				e.setId(params.get(2));
				fields.get(i).AddEquipment(e);
			}
		}
		
		
	}
	
	public void SetEquipment2(String kind, String field) {
		ArrayList<Field> fields = game.getFields();
		
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals(field)) {
				Equipment e;
				if(kind.equals("glove")) e = new Glove(null);
				else if(kind.equals("bag")) e = new Bag(null);
				else if(kind.equals("axe")) e = new Axe(null);
				else e = new Cape(null);
				fields.get(i).AddEquipment(e);
			}
		}
		
		
	}
	
	/**
	 * a virologus ellop egy masik virologustol felszerelest
	 */
	public void StealEquipment() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); ++i){
			
			if (virologists.get(i).getId().equals(params.get(2))) {
				Field standsHere = virologists.get(i).getField();
				ArrayList<Virologist> standsHereVirologists = standsHere.getVirologists();
				for (int x = 0; x < standsHereVirologists.size(); ++x) {
					if (standsHereVirologists.get(x).getId().equals(params.get(3))) {
						ArrayList<Equipment> equipments = standsHereVirologists.get(x).getEquipments();
						for (int j = 0; j < equipments.size(); ++j) {
							if (equipments.get(j).getId().equals(params.get(1))) {
								virologists.get(i).StealEquipment(standsHereVirologists.get(x), equipments.get(j));
							}
						}
					}
				}
			}
		}
			
	}
		
	
	
	/**
	 * a virologus ellop egy masik virologustol anyagot
	 */
	public void StealSubstance() {
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); ++i){
			
			if (virologists.get(i).getId().equals(params.get(1))) {
				Field standsHere = virologists.get(i).getField();
				ArrayList<Virologist> standsHereVirologists = standsHere.getVirologists();
				for (int x = 0; x < virologists.size(); ++x){
					if (standsHereVirologists.get(x).getId().equals(params.get(2))) {
						virologists.get(i).StealSubstance(standsHereVirologists.get(x));
					}
				}
			}
		}
	}
	
	/**
	 * adott mennyisegu amino/nucleotide rak a megadott ID-ju mezore (storage)
	 */
	public void SetSubstance(){
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Field> fields = game.getFields();
		
		for (int i = 0; i < fields.size(); ++i){
			
			if (fields.get(i).getId().equals(params.get(3))) {
				if (params.get(1).equals("amino")) {
					fields.get(i).setAmino(Integer.parseInt(params.get(2)));
				}
					
				else if (params.get(1).equals("nucleotide")) {
					fields.get(i).setNucleotid(Integer.parseInt(params.get(2)));
				}
			}
			
		}
		
	}
	
	/**
	 * kikapcsolja a nem determinisztikus kopenyt, vagy mindig ved, vagy sose, vagy vissza is lehet kapcsolni
	 */
	public void CapeProtection(){
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		if(params.get(1).equals("on")) {	
			for (int i = 0; i < virologists.size(); ++i){
				virologists.get(i).getAnointedBehaviour().setDet("on");
			}
		}
		else if(params.get(1).equals("off")) {
			for (int i = 0; i < virologists.size(); ++i){
				virologists.get(i).getAnointedBehaviour().setDet("off");
			}
		}
		else if(params.get(1).equals("random")) {
			for (int i = 0; i < virologists.size(); ++i){
				virologists.get(i).getAnointedBehaviour().setDet("random");
			}
		}
	}
	
	/**
	 * a virologus megadott tipusu anyagot vesz fel a mezorol
	 */
	public void TakeSubstance(){
		ArrayList<String> params = Interface.GetTheParams();
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); ++i){
			
			if (virologists.get(i).getId().equals(params.get(2))) {
				
				if (params.get(1).equals("amino")) {
					virologists.get(i).TakeAmino();
				}
				else if(params.get(1).equals("nucleotide")) {
					virologists.get(i).TakeNucleotide();
				}
			}
			
		}
		
	}
	/**
	 * map betolteset segiti
	 */
	public void Test_Init() {
		ArrayList<Virologist> virologists = game.getVirologists();
		
		for (int i = 0; i < virologists.size(); ++i){
			
			if (virologists.get(i).getId().equals("V2")) {
				virologists.get(i).AddGencode(new AlzheimerGencode());
				virologists.get(i).AddGencode(new ParalyzingGencode());
				virologists.get(i).AddGencode(new ResistanceGencode());
				virologists.get(i).setAmino(8);
				virologists.get(i).setNucleotid(8);
			} else if (virologists.get(i).getId().equals("V3")) {
				Cape c = new Cape(virologists.get(i));
				c.setId("C3");
				virologists.get(i).AddEquipment(c);
				
				Glove g = new Glove(virologists.get(i));
				g.setId("G3");
				virologists.get(i).AddEquipment(g);
				
				Bag b = new Bag(virologists.get(i));
				b.setId("B3");
				virologists.get(i).AddEquipment(b);
				virologists.get(i).setAmino(10);
				virologists.get(i).setNucleotid(10);
				ParalyzingAgent pa = new ParalyzingAgent();
				virologists.get(i).AddEffect(pa);
				game.AddSteppableToTimer(pa);
				
			} else if (virologists.get(i).getId().equals("V4")) {
				DancerAgent da = new DancerAgent();
				virologists.get(i).AddEffect(da);
				game.AddSteppableToTimer(da);
			}
		}
	}
	
	/**
	 * parameter problema eseten ez a fuggveny hivodik ami visszajelez
	 */
	private void parameterProblem(String problem) {
		System.out.println("Fail: " + problem);
	}
	
	/**
	 * fajl problema eseten hivodik
	 */
	private void fileProblem() {
		System.out.println("Fail: file problem. The file not exist.");
	}
	
	/**
	 * palyakeszito
	 * @param numOfPlayers jatekosok szama
	 * @param gam a jatek
	 */
	public void Main_Init(int numOfPlayers, Game gam) {
		game=gam;
		//int numOfFields = 50;
		//F0-F34 normal
		for(int i=1; i<36; ++i) {
			if(!(i==4 || i==5)) {
				Field f = new Field();
				f.setId("F"+i);
				gam.AddField(f);
			}
		}
		
		//ST0-ST4 storage
		for(int i=1; i<6; ++i) {
			Field f = new StorageField();
			f.setId("ST"+i);
			gam.AddField(f);	
		}
		
		//SH0-SH4 shelter
		for(int i=1; i<6; ++i) {
			Field f = new ShelterField();
			f.setId("SH"+i);
			gam.AddField(f);	
		}		
		
		//L0-L3 labor
		for(int i=1; i<5; ++i) {
			Field f = new LaboratoryField();
			f.setId("L"+i);
			gam.AddField(f);	
		}
		
		//T0-T1 trap
		for(int i=1; i<3; ++i) {
			Field f = new TrapField();
			f.setId("T"+i);
			gam.AddField(f);	
		}
		
		
		ArrayList<Field> fields = gam.getFields();
		
		Field F5 = new StorageField();
		Field F4 = new ShelterField();
		gam.AddField(F4);
		gam.AddField(F5);
		F5.setId("F5");
		F4.setId("F4");
		
		
		Neighbours2("ST1", "L1");
		Neighbours2("ST1", "T1");
		
		Neighbours2("T1", "L1");
		Neighbours2("T1", "F3");
		Neighbours2("T1", "SH1");

		Neighbours2("L1", "F1");
		
		Neighbours2("F3", "F4");
		Neighbours2("F3", "F5");
		
		Neighbours2("F4", "L2");
		
		
		Neighbours2("L2", "F5");
		Neighbours2("L2", "F6");
		
		Neighbours2("F6", "F8");
		Neighbours2("F6", "ST2");
		Neighbours2("F6", "F7");
		
		Neighbours2("F7", "ST2");
		
		Neighbours2("ST2", "F14");
		
		Neighbours2("F5", "F8");
		Neighbours2("F5", "SH1");
		
		Neighbours2("SH1", "F2");
		Neighbours2("SH1", "F9");
		
		Neighbours2("F9", "F10");
		Neighbours2("F9", "F8");
		
		Neighbours2("F8", "F13");
		
		Neighbours2("F1", "F2");
		Neighbours2("F1", "F11");
		
		Neighbours2("F2", "SH2");
		
		Neighbours2("F11", "F12");
		Neighbours2("F11", "F17");
		
		Neighbours2("F12", "F16");
		
		Neighbours2("SH2", "F10");
		Neighbours2("SH2", "F17");
		
		Neighbours2("F10", "ST3");
		
		Neighbours2("F16", "F17");
		Neighbours2("F16", "SH4");
		
		Neighbours2("SH4", "F17");
		Neighbours2("SH4", "F24");
		
		Neighbours2("F17", "F21");
		Neighbours2("F17", "ST4");
		
		Neighbours2("F24", "L4");
		Neighbours2("F24", "F25");
		
		Neighbours2("L4", "F25");
		Neighbours2("L4", "F31");
		
		Neighbours2("F25", "F29");
		Neighbours2("F25", "ST4");
		
		Neighbours2("ST4", "F26");
		
		Neighbours2("F35", "F31");
		Neighbours2("F35", "SH5");
		
		Neighbours2("F31", "F30");
		
		Neighbours2("F30", "F29");
		Neighbours2("F30", "T2");
		
		Neighbours2("T2", "F27");
		Neighbours2("T2", "F32");
		
		Neighbours2("F29", "F26");
		
		Neighbours2("F26", "F21");
		Neighbours2("F26", "F27");
		
		Neighbours2("F27", "F28");
		Neighbours2("F27", "F21");
		
		Neighbours2("F21", "F22");
		Neighbours2("F21", "ST3");
		
		Neighbours2("ST3", "F13");
		Neighbours2("ST3", "F22");
		
		Neighbours2("F22", "F18");
		
		Neighbours2("F13", "F18");
		Neighbours2("F13", "F14");
		
		Neighbours2("F14", "F15");
		
		Neighbours2("F15", "SH3");
		Neighbours2("F15", "F20");
		
		Neighbours2("SH3", "F19");
		Neighbours2("SH3", "F18");
		
		Neighbours2("F18", "F19");
		Neighbours2("F18", "L3");
		
		Neighbours2("L3", "F23");
		Neighbours2("L3", "F28");
		
		Neighbours2("F19", "F23");
		Neighbours2("F19", "F20");
		
		Neighbours2("F20", "F23");
		
		Neighbours2("F23", "F33");
		Neighbours2("F23", "32");
		
		Neighbours2("F28", "F32");
		
		Neighbours2("F32", "F34");
		
		Neighbours2("F34", "F33");
		Neighbours2("F34", "ST5");
		Neighbours2("F34", "SH5");
		
		Neighbours2("F33", "ST5");
		
		
		F5.setId("ST6");
		F4.setId("SH6");
		
			
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals("L1")) { 			
				Gencode g1 = new ParalyzingGencode();
				fields.get(i).setGencode(g1);
			}
		}
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals("L2")) { 			
				Gencode g2 = new DancerGencode();
				fields.get(i).setGencode(g2);
			}
		}
			
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals("L3")) { 			
				Gencode g3 = new ResistanceGencode();
				fields.get(i).setGencode(g3);
			}
		}
		
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals("L4")) { 			
				Gencode g4 = new AlzheimerGencode();
				fields.get(i).setGencode(g4);
			}
		}
		
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals("T1")) { 			
				Gencode g1 = new ParalyzingGencode();
				fields.get(i).setGencode(g1);
			}
		}
		
		
		for(int i=0; i<fields.size(); ++i){
			if(fields.get(i).getId().equals("T2")) { 			
				Gencode g2 = new DancerGencode();
				fields.get(i).setGencode(g2);
			}
		}
		
		SetEquipment2("cape", "SH1");
		SetEquipment2("glove", "SH1");
		SetEquipment2("axe", "SH1");
		SetEquipment2("bag", "SH1");
		SetEquipment2("glove", "SH1");
		SetEquipment2("axe", "SH2");
		SetEquipment2("bag", "SH2");
		
		SetEquipment2("glove", "SH3");
		SetEquipment2("cape", "SH3");
		SetEquipment2("axe", "SH4");
		SetEquipment2("bag", "SH4");
		SetEquipment2("glove", "SH4");
		SetEquipment2("cape", "SH4");
		SetEquipment2("axe", "SH5");
		SetEquipment2("bag", "SH5");
		SetEquipment2("cape", "SH5");
		SetEquipment2("bag", "SH5");
		
		SetEquipment2("bag", "SH6");
		SetEquipment2("glove", "SH6");
		SetEquipment2("cape", "SH6");
		
	}
	
	/**
	 * jatekosok elhelyezese a mezon
	 * @param numOfPlayers
	 * @param g
	 */
	public void PlayerPlace(int numOfPlayers, Game g){ 
		ArrayList<Field> fields = g.getFields();
		for(int i=0; i< numOfPlayers; ++i){ 	
			for(int j=0; j<fields.size(); ++j){
				if(fields.get(j).getId().equals("F3")) { 			
					new Virologist(g, fields.get(j));
				}
			}
		}
	}
	
	
	
	
	
}