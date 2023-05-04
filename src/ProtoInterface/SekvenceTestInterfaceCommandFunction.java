package ProtoInterface;

import java.io.IOException;

import Agents.AlzheimerAgent;
import Agents.DancerAgent;
import Agents.ParalyzingAgent;
import Agents.ResistanceAgent;
import AnointedBehaviours.BlockAnoint;
import AnointedBehaviours.ReturnAnoint;
import Core.Game;
import Core.Timer;
import Core.Virologist;
import Equipments.Bag;
import Equipments.Cape;
import Equipments.Glove;
import Fields.Field;
import Fields.ShelterField;
import Fields.StorageField;
import Gencodes.AlzheimerGencode;
import Gencodes.DancerGencode;
import Gencodes.ParalyzingGencode;
import Gencodes.ResistanceGencode;
import MoveBehaviours.DanceMove;
import VirologistBehaviours.Paralyzed;

/**
 * A Proto interface parancsait kiszolgalo osztaly.
 */
public class SekvenceTestInterfaceCommandFunction {

	
	/**
	 * A startgame parancsot kiszolgalo fuggveny.
	 */
	public void StartGame() {
		Game g = new Game(3);
		Timer t = new Timer();
		g.setTimer(t);
		System.out.println("................");
		g.StartGame();
	}
	
	
	/**
	 * A normalmove parancsot kiszolgalo fuggveny.
	 */
	public void NormalMove() {
		Field f1 = new Field();
		Field f2 = new Field();
		f1.addNeighbour(f2);
		Virologist v = new Virologist(null, f1);
		f1.AddVirologist(v);
		System.out.println("................");
		v.UseMove(0);
	}
	
	
	/**
	 * A dancemove parancsot kiszolgalo fuggveny.
	 */
	public void DanceMove() {
		Field f = new Field();
		ShelterField s = new ShelterField();
		f.addNeighbour(s);
		Virologist v = new Virologist(null, f);
		f.AddVirologist(v);
		v.setMoveBehaviour(new DanceMove());
		System.out.println("................");
		v.UseMove(0);
	}
	
	
	/**
	 * A anointwithresistanceagent parancsot kiszolgalo fuggveny.
	 */
	public void AnointWithResistanceAgent() {
		Game game = new Game(2);
		Timer time = new Timer();
		game.setTimer(time);
		Virologist v1 = new Virologist(game, null);
		Virologist v2 = new Virologist(game, null);
		ResistanceAgent ra = new ResistanceAgent();
		v1.AddAgent(ra);
		System.out.println("................");
		v1.Anoint(v2, ra);
	}
	
	 
	/**
	 * A anointwithdanceragent parancsot kiszolgalo fuggveny.
	 */
	public void AnointWithDancerAgent() {
		Game game = new Game(2);
		Timer time = new Timer();
		game.setTimer(time);
		Virologist v1 = new Virologist(game, null);
		Virologist v2 = new Virologist(game, null);
		DancerAgent da = new DancerAgent();
		v1.AddAgent(da);
		System.out.println("................");
		v1.Anoint(v2, da);
	}
	
	 
	/**
	 * A anointwithparalyzingagent parancsot kiszolgalo fuggveny.
	 */
	public void AnointWithParalyzingAgent() {
		Game game = new Game(2);
		Timer time = new Timer();
		game.setTimer(time);
		Virologist v1 = new Virologist(game, null);
		Virologist v2 = new Virologist(game, null);
		ParalyzingAgent pa = new ParalyzingAgent();
		v1.AddAgent(pa);
		System.out.println("................");
		v1.Anoint(v2, pa);
	}
	
	 
	/**
	 * A anointwithalzheimeragent parancsot kiszolgalo fuggveny.
	 */
	public void AnointWithAlzheimerAgent() {
		Game game = new Game(2);
		Timer time = new Timer();
		game.setTimer(time);
		Virologist v1 = new Virologist(game, null);
		Virologist v2 = new Virologist(game, null);
		AlzheimerAgent aa = new AlzheimerAgent();
		v1.AddAgent(aa);
		System.out.println("................");
		v1.Anoint(v2, aa);
	}
	
	 
	/**
	 * A craftalzheimeragent parancsot kiszolgalo fuggveny.
	 */
	public void CraftAlzheimerAgent() {
		Virologist virologist = new Virologist(null, null);
		AlzheimerGencode alzheimerGencode = new AlzheimerGencode();
		System.out.println("................");
		virologist.CraftAgent(alzheimerGencode);
	}
	
	 
	/**
	 * A craftparalyzingagent parancsot kiszolgalo fuggveny.
	 */
	public void CraftParalyzingAgent() {
		Virologist virologist = new Virologist(null, null);
		ParalyzingGencode paralyzingGencode = new ParalyzingGencode();
		System.out.println("................");
		virologist.CraftAgent(paralyzingGencode);
	}
	
	 
	/**
	 * A craftdanceragent parancsot kiszolgalo fuggveny.
	 */
	public void CraftDancerAgent() {
		Virologist virologist = new Virologist(null, null);
		DancerGencode dancerGencode = new DancerGencode();
		System.out.println("................");
		virologist.CraftAgent(dancerGencode);
	}
	
	 
	/**
	 * A craftresistanceagent parancsot kiszolgalo fuggveny.
	 */
	public void CraftResistanceAgent() {
		Virologist virologist = new Virologist(null, null);
		ResistanceGencode resistanceGencode = new ResistanceGencode();
		System.out.println("................");
		virologist.CraftAgent(resistanceGencode);
	}
	
	 
	/**
	 * A learndancergencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnDancerGencode() {
		System.out.print("Ez az utolso megtanult genetikai kod? (i/n) :");
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
		e.printStackTrace();
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		DancerGencode dancerGencode = new DancerGencode();
		if (s=='i') game.setNooneHasWonYet(false);
		System.out.println("................");
		virologist.TakeGencode(dancerGencode);
	}
	
	 
	/**
	 * A learnresistancegencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnResistanceGencode() {
		System.out.print("Ez az utolso megtanult genetikai kod? (i/n) :");
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
		e.printStackTrace();
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		ResistanceGencode resistanceGencode = new ResistanceGencode();
		if (s=='i') game.setNooneHasWonYet(false);
		System.out.println("................");
		virologist.TakeGencode(resistanceGencode);
	}
	
	 
	/**
	 * A learnparalyzinggencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnParalyzingGencode() {
		System.out.print("Ez az utolso megtanult genetikai kod? (i/n) :");
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
		e.printStackTrace();
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		ParalyzingGencode paralyzingGencode = new ParalyzingGencode();
		if (s=='i') game.setNooneHasWonYet(false);
		System.out.println("................");
		virologist.TakeGencode(paralyzingGencode);
	}
	
	 
	/**
	 * A learnalzheimergencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnAlzheimerGencode() {
		System.out.print("Ez az utolso megtanult genetikai kod? (i/n) :");
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
		e.printStackTrace();
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		AlzheimerGencode alzheimerGencode = new AlzheimerGencode();
		System.out.println("................");
		if (s=='i') game.setNooneHasWonYet(false);
		virologist.TakeGencode(alzheimerGencode);
	}
	
	
	/**
	 * A degradationofresistanceagent parancsot kiszolgalo fuggveny.
	 */
	public void DegradationOfResistanceAgent() {
		Timer t = new Timer();
		Virologist v = new Virologist(null, null);
		ResistanceAgent ra = new ResistanceAgent();
		ra.setVirologist(v);
		ra.setDuration(1);
		v.AddEffect(ra);
		t.AddSteppable(ra);
		System.out.println("................");
		t.Tick();
	}
	
	 
	/**
	 * A degradationofalzheimeragent parancsot kiszolgalo fuggveny.
	 */
	public void DegradationOfAlzheimerAgent() {
		Timer t = new Timer();
		Virologist v = new Virologist(null, null);
		AlzheimerAgent aa = new AlzheimerAgent();
		v.AddGencode(new DancerGencode());
		aa.setVirologist(v);
		aa.setDuration(1);
		v.AddEffect(aa);
		t.AddSteppable(aa);
		System.out.println("................");
		t.Tick();
	}
	
	 
	/**
	 * A degradationofdanceragent parancsot kiszolgalo fuggveny.
	 */
	public void DegradationOfDancerAgent() {
		Timer t = new Timer();
		Virologist v = new Virologist(null, null);
		DancerAgent da = new DancerAgent();
		da.setVirologist(v);
		da.setDuration(1);
		v.AddEffect(da);
		t.AddSteppable(da);
		System.out.println("................");
		t.Tick();
	}
	
	 
	/**
	 * A degradationofparalyzingagent parancsot kiszolgalo fuggveny.
	 */
	public void DegradationOfParalyzingAgent() {
		Timer t = new Timer();
		Virologist v = new Virologist(null, null);
		ParalyzingAgent pa = new ParalyzingAgent();
		pa.setVirologist(v);
		pa.setDuration(1);
		v.AddEffect(pa);
		t.AddSteppable(pa);
		System.out.println("................");
		t.Tick();
	}
	
	 
	/**
	 * A takeglove parancsot kiszolgalo fuggveny.
	 */
	public void TakeGlove() {
		ShelterField shelterField = new ShelterField();
		Virologist v = new Virologist(null, shelterField);
		Glove glove = new Glove(null);
		System.out.println("................");
		v.TakeEquipment(glove);
	}
	
	 
	/**
	 * A takecape parancsot kiszolgalo fuggveny.
	 */
	public void TakeCape() {
		ShelterField shelterField = new ShelterField();
		Virologist v = new Virologist(null, shelterField);
		Cape cape = new Cape(null);
		System.out.println("................");
		v.TakeEquipment(cape);
	}
	
	 
	/**
	 * A takebag parancsot kiszolgalo fuggveny.
	 */
	public void TakeBag() {
		ShelterField shelterField = new ShelterField();
		Virologist v = new Virologist(null, shelterField);
		Bag bag = new Bag(null);
		System.out.println("................");
		v.TakeEquipment(bag);
	}
	
	 
	/**
	 * A takesubstance parancsot kiszolgalo fuggveny.
	 */
	public void TakeSubstance() {
		StorageField sf = new StorageField();
		Virologist v = new Virologist(null, sf);
		System.out.println("................");
		v.TakeSubstance();
	}
	
	 
	/**
	 * A defensewithresistanceagent parancsot kiszolgalo fuggveny.
	 */
	public void DefenseWithResistanceAgent() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		BlockAnoint baAnoint = new BlockAnoint();
		v2.setAnointedBehaviour(baAnoint);
		AlzheimerAgent alzheimerAgent = new AlzheimerAgent();
		System.out.println("................");
		v1.Anoint(v2, alzheimerAgent);
	}

	
	/**
	 * A defensewithglove parancsot kiszolgalo fuggveny.
	 */
	public void DefenseWithGlove() {
		Game game = new Game(2);
		Timer timer = new Timer();
		game.setTimer(timer);
		Virologist v1 = new Virologist(game, null);
		Virologist v2 = new Virologist(game, null);
		//ReturnAnoint returnAnoint = new ReturnAnoint();
		//v2.setAnointedBehaviour(returnAnoint);
		DancerAgent dancerAgent = new DancerAgent();
		System.out.println("................");
		v1.Anoint(v2, dancerAgent);
	}
	

	/**
	 * A dropbag parancsot kiszolgalo fuggveny.
	 */
	public void DropBag() {
		Field field = new Field();
		Virologist virologist = new Virologist(null, field);
		Bag bag = new Bag(null);
		System.out.println("................");
		virologist.DropEquipment(bag);
	}

	
	/**
	 * A dropcape parancsot kiszolgalo fuggveny.
	 */
	public void DropCape() {
		Field field = new Field();
		Virologist virologist = new Virologist(null, field);
		Cape cape = new Cape(null);
		System.out.println("................");
		virologist.DropEquipment(cape);
	}

	
	/**
	 * A dropglove parancsot kiszolgalo fuggveny.
	 */
	public void DropGlove() {
		Field field = new Field();
		Virologist virologist = new Virologist(null, field);
		Glove glove = new Glove(null);
		System.out.println("................");
		virologist.DropEquipment(glove);
	}

	
	/**
	 * A stealglove parancsot kiszolgalo fuggveny.
	 */
	public void StealGlove() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Glove glove = new Glove(null);
		Paralyzed paralyzed = new Paralyzed();
		v2.setVirologistBehaviour(paralyzed);
		System.out.println("................");
		v1.StealEquipment(v2, glove);
	}
	
	
	/**
	 * A stealcape parancsot kiszolgalo fuggveny.
	 */
	public void StealCape() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Cape cape = new Cape(null);
		Paralyzed paralyzed = new Paralyzed();
		v2.setVirologistBehaviour(paralyzed);
		System.out.println("................");
		v1.StealEquipment(v2, cape);
	}

	
	/**
	 * A stealbag parancsot kiszolgalo fuggveny.
	 */
	public void StealBag() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Bag bag = new Bag(null);
		Paralyzed paralyzed = new Paralyzed();
		v2.setVirologistBehaviour(paralyzed);
		System.out.println("................");
		v1.StealEquipment(v2, bag);
	}
	
	
	/**
	 * A stealsubstance" parancsot kiszolgalo fuggveny.
	 */
	public void StealSubstance() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Paralyzed paralyzed = new Paralyzed();
		v2.setVirologistBehaviour(paralyzed);
		System.out.println("................");
		v1.StealSubstance(v2);
	}
	
	
	/**
	 * A preventstealbag parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealBag() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Bag bag = new Bag(null);
		System.out.println("................");
		v1.StealEquipment(v2, bag);
	}
	
	
	/**
	 * A preventstealglove parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealGlove() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Glove glove = new Glove(null);
		System.out.println("................");
		v1.StealEquipment(v2, glove);
	}
	
	
	/**
	 * A preventstealcape parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealCape() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Cape cape = new Cape(null);
		System.out.println("................");
		v1.StealEquipment(v2, cape);
	}
	
	
	/**
	 * A preventstealsubstance parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealSubstance() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		System.out.println("................");
		v1.StealSubstance(v2);
	}


	/**
	 * A help parancsot kiszolgalo fuggveny.
	 */
	public void Help() {
		System.out.println("SekvenceTestInterface Help - Kiadhato parancsok");
		System.out.println("	* startgame\n"
				+ "	* normalmove\n"
				+ "	* dancemove\n"
				+ "	* anointwithresistanceagent\n"
				+ "	* anointwithdanceragent\n"
				+ "	* anointwithparalyzingagent\n"
				+ "	* anointwithalzheimeragent\n"
				+ "	* craftalzheimeragent\n"
				+ "	* craftparalyzingagent\n"
				+ "	* craftdanceragent\n"
				+ "	* craftresistanceagent\n"
				+ "	* learndancergencode\n"
				+ "	* learnresistancegencode\n"
				+ "	* learnparalyzinggencode\n"
				+ "	* learnalzheimergencode\n"
				+ "	* degradationofresistanceagent\n"
				+ "	* degradationofalzheimeragent\n"
				+ "	* degradationofdanceragent\n"
				+ "	* degradationofparalyzingagent\n"
				+ "	* takeglove\n"
				+ "	* takecape\n"
				+ "	* takebag\n"
				+ "	* takesubstance\n"
				+ "	* defensewithresistanceagent\n"
				+ "	* defensewithglove\n"
				+ "	* dropbag\n"
				+ "	* dropcape\n"
				+ "	* dropglove\n"
				+ "	* stealglove\n"
				+ "	* stealcape\n"
				+ "	* stealbag\n"
				+ "	* stealsubstance\n"
				+ "	* preventstealbag\n"
				+ "	* preventstealglove\n"
				+ "	* preventstealcape\n"
				+ "	* preventstealsubstance\n"
				+ "	* help");
	}


	public void Fail() {
		System.out.println("Fail: this command is not exist '" + Interface.line + "'\n" + "Try agin or see the help menu");
	}
	
}
