package main.java.iet.Core;


import java.io.Serializable;
import java.util.*;
import main.java.iet.Agents.Agent;
import main.java.iet.AnointedBehaviours.AnointedBehaviour;
import main.java.iet.AnointedBehaviours.TakeAnoint;
import main.java.iet.Equipments.Equipment;
import main.java.iet.Fields.Field;
import main.java.iet.Gencodes.Gencode;
import main.java.iet.Graphics.JVirologist;
import main.java.iet.KillBehaviours.CantKill;
import main.java.iet.KillBehaviours.KillBehaviour;
import main.java.iet.MoveBehaviours.MoveBehaviour;
import main.java.iet.MoveBehaviours.NormalMove;
import main.java.iet.VirologistBehaviours.Normal;
import main.java.iet.VirologistBehaviours.VirologistBehaviour;

/**
 * Az osztaly feladata a jatekosok (virologusok) megvalositasa.
 */
public class Virologist implements Serializable {

    /**
     * Konstruktor
     * @param g A jatek, amiben jatszik a virologus.
     * @param f Mezo, amin a virologus all.
     */
    public Virologist(Game g, Field f) {
    	amino = 0;
    	nucleotid = 0;
    	maxSubstance = 10;
    	game = g;
    	field = f;
    	anointedBehaviour = new TakeAnoint();
    	moveBehaviour = new NormalMove();
    	virologistBehaviour = new Normal();
    	killBehaviour = new CantKill();
    	g.AddVirologist(this);
    	f.AddVirologist(this);
    }
    
    /**
     * ideiglenes id hogy a proton barmit be lehessen kezzel allitani
     */
     String id;
     
     /**
 	 * getter
 	 * @return effectId
 	 */
 	public String getId() {
 		return id;
 	}
 	
 	/**
 	 * setter
 	 */
 	public void setId(String name) {
 		id = name;
 	}
    
    /**
     * A virologus tulajdonaban levo amino mennyisege.
     */
    private int amino;

    /**
     * A virologus tulajdonaban levo nucleotid mennyisege.
     */
    private int nucleotid;

    /**
     * A maximum anyagmennyiseg, ami a virologusnal lehet.
     */
    private int maxSubstance;

    /**
     * A jatek, amelynek resze az adott virologus.
     */
    private Game game;

    /**
     * A mezo, amin all eppen az adott virologus.
     */
    private Field field;

    /**
     * A virologusnal talalhato felszerelesek listaja.
     */
    private ArrayList<Equipment> equipments = new ArrayList<>(3);

    /**
     * A virologus altal megtanult genetikai kodok listaja.
     */
    private HashSet<Gencode> gencodes = new HashSet<Gencode>();

    

    /**
     * Agensak maximum szama 
     */
    private int maxAgentNumber = 3;
    
	/**
     * A virologus altal keszitett, es meg nem hasznalt agensek.
     * !!Max4!!
     */
    private ArrayList<Agent> agents = new ArrayList<Agent>();

    /**
     * A virologus agenskenesnel torteno viselkedese (kivedi, engedi, visszadobja).
     */
    private AnointedBehaviour anointedBehaviour;

    /**
     * A virologus mozgasa (veletlenszeruen lep, siman lep).
     */
    private MoveBehaviour moveBehaviour;

    /**
     * A virologuson levo effektek listaja.
     */
    private ArrayList<Effect> effects = new ArrayList<>();

    /**
     * A virologus viselkedese (lepes, lopas eseten).
     */
    private VirologistBehaviour virologistBehaviour;
    
    /**
     * A virologus viselkedese (gyilkossag eseten).
     */
    private KillBehaviour killBehaviour;

    /**
     * A virologus mozog az i-edik (szomszedos) mezore.
     * @param i A mezo, amire lepni szeretnenk.
     */
    public void UseMove(int i) {
    	if (!game.GetMovengInThisRound()) {
    		moveBehaviour.Move(i, this);
        	game.SetMovengInThisRound();
            game.RefreshFrame();
    	}
    }

    /**
     * Meghivja a felkent viselkedesi forma felkent fuggvenyet.
     * @param by Aki felken.
     * @param with Amivel felken.
     */
    public void UseAnointed(Virologist by, Agent with) {
    	if (anointedBehaviour.Anointed(by, this, with))
    		game.AddSteppableToTimer(with);
    }

    /**
     * Adott genetikai kodbol agens eloallitasa.
     * @param g A genetikai kod, amibol agenst allitunk elo.
     */
    public void CraftAgent(Gencode g) {
        this.AddAgent( g.Craft(this) );
        game.RefreshFrame();
       
    }

    /** 
     * Ez a fuggveny megprobal eltavolitani adott felszerelest v-tol (csak akkor sikeres, ha v Paralyzed)
     * @param v Virologus, akitol lopunk.
     * @param e Lopni kivant felszereles.
     */
    public void StealEquipment(Virologist v, Equipment e) {
        v.UseRemoveEquipment(e, this);
        game.RefreshFrame();
    }

    /** 
     * Ez a fuggveny megprobal aminot es nukleotidot lopni v-tol.
     * @param v A virologus, akitol lopunk.
     */
    public void StealSubstance(Virologist v) {
    	int aSteal, nSteal;
    	if(3 <= maxSubstance-amino) aSteal = 3;
    	else aSteal = maxSubstance - amino;
    	if(3 <= maxSubstance-nucleotid) 
    		nSteal = 3;
    	else nSteal = maxSubstance - nucleotid;
    	
    	int newAmNu[] = v.UseRemoveSubstance(aSteal, nSteal);
    	this.setAmino(amino+newAmNu[0]);
    	this.setNucleotid(nucleotid+newAmNu[1]);
        game.RefreshFrame();
    }

    /**
     * A virologus megtanul (eltarol) egy uj genetikai kodot.
     * @param g Genetikai kod, amit megtanul a virologus.
     */
    public void TakeGencode(Gencode g) {
        AddGencode(g);
        if (gencodes.size() == 4)
        	game.setNooneHasWonYet(false);
        game.RefreshFrame();
        game.CheckWinCondition();
    }

    /**
     * A virologus felvesz egy felszerelest a mezorol.
     * @param e Felvenni kivant felszereles.
     */
    public void TakeEquipment(Equipment e) {
    	if(equipments.size()<3) {
            field.RemoveEquipment(e);
            AddEquipment(e);
            e.setVirologist(this);
            game.RefreshFrame();
    	}
    }

    /** A virologus eldobja a felszereleset, ami Field tipusu mezore kerul.
     * @param e Felszereles, amit a virologus eldob.
     */
    public void DropEquipment(Equipment e) {
    	RemoveEquipment(e);
    	field.AddEquipment(e);
    	game.RefreshFrame();
    	
    }

    
    /**
     * A virologus felvesz egy felszerelest, az kifejti hatasat.
     * @param e Felszereles, amit a virologushoz adunk.
     */
    public void AddEquipment(Equipment e) {
    	equipments.add(e);
    	AddEffect(e);
    }
    
    
    /** A virologusrol eltunik a felszereles es annak hatasa.
     * @param e Eldobott felszereles.
     */
    public void RemoveEquipment(Equipment e) {
    	equipments.remove(e);
    	RemoveEffect(e);
    	
    }
    
    /** 
     * V probal ettol a virologustol lopni (sikeres lesz, ha a virologistBehaviour Paralyzed eppen).
     * @param e Lopni kivant felszereles fajtaja.
     * @param v Virologus, aki lopni probal.
     */
    public void UseRemoveEquipment(Equipment e, Virologist v) {
        virologistBehaviour.RemoveEquipment(e, v, this);
    }

    /**
     * A virologus kore kovetkezik.
     */
    public void UseYourTurn() {
    	virologistBehaviour.YourTurn(this);
    }

    /**
     * A virologus felvesz anyagot egy mezorol.
     */
    public void TakeSubstance() {
        setAmino(field.GetAmino(maxSubstance-amino)+amino);
        setNucleotid(field.GetNucleotid(maxSubstance-nucleotid)+nucleotid);
        game.RefreshFrame();
    }
    
    /**
     * A virologus felvesz aminot egy mezorol.
     */
    public void TakeAmino() {
        setAmino(field.GetAmino(maxSubstance-amino)+amino);
    }
    
    /**
     * A virologus felvesz nukleotidot egy mezorol.
     */
    public void TakeNucleotide() {
        setNucleotid(field.GetNucleotid(maxSubstance-nucleotid)+nucleotid);
    }

    /**
     * Hozzaadja a parameterkent kapott effektet az effektek tarolojaba, valamint aktivalja.
     * @param e Az effekttel rendelkezo dolog.
     */
    public void AddEffect(Effect e) {
    	effects.add(e);
    	e.Activate(this);
    }

    /** 
     * Agens vagy felszereles hatasanak megszunese a virologuson.
     * @param e Hatas, ami megszunik a virologuson.
     */
    public void RemoveEffect(Effect e) {
    	e.Deactivate(this);
    	effects.remove(e);
    	RefreshEffects();
    }

    /**
     * Megprobal anyagot eltavolitani ettol a virologustol
     * @param a lopni kivant amino mennyiseg
     * @param n lopni kivant nukleotid mennyiseg
     * @return tomb, elvett amino es nukleotid mennyisege
     */
    public int[] UseRemoveSubstance(int a, int n) {
        int aBefore = amino;
        int nBefore = nucleotid;
        virologistBehaviour.RemoveSubstance(a, n, this);

		return new int[]{aBefore-amino, nBefore-nucleotid};
    }

    /**
     * Felkeni a parameterkent kapott virologust a parameterkent kapott agenssel.
     * majd torli az letrehozott agensek kozul.
     * @param v Akit felkennek.
     * @param with Amivel felkenik.
     */
    public void Anoint(Virologist v, Agent with) {
    	v.UseAnointed(this, with);
    	agents.remove(with);
    	game.RefreshFrame();
    }

    /**
     * Frissiti a virologus altal megszerzett, hatassal rendelkezo objektumok listajat.
     */
    public void RefreshEffects() {
    	for (Effect e: effects) {
    		e.Activate(this);
    	}
    }

	/**Getter az aminohoz.
	 * @return aminomennyiseg
	 */
	public int getAmino() {
		return amino;
	}

	/**Setter az aminonak.
	 * @param am Aminot erre kivanjuk allitani.
	 */
	public void setAmino(int am) {
		if(am>maxSubstance) this.amino = maxSubstance;
		else if(am < 0) this.amino = 0;
		else this.amino = am;
	}

	/**Getter a nucleotidhoz
	 * @return a nucleotid
	 */
	public int getNucleotid() {
		return nucleotid;
	}

	/**Setter a nucleotidnak
	 * @param nu nucleotidot erre kivanjuk allitani
	 */
	public void setNucleotid(int nu) {
    	
		if(nu>maxSubstance) this.nucleotid = maxSubstance;
		else if(nu < 0) this.nucleotid = 0;
		else this.nucleotid = nu;
	}

	/**
	 * Getter a maximum anyagmennyiseghez.
	 * @return maxSubstance
	 */
	public int getMaxSubstance() {
		return maxSubstance;
	}

	/**
	 * Setter a maximum anyagmennyiseghez.
	 * @param maxSubstance Beallitando anyagmennyiseg.
	 */
	public void setMaxSubstance(int maxSubstance) {
		this.maxSubstance = maxSubstance;
	}

	/**
	 * Getter a virologushoz tartozo jatekhoz.
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Setter a virologushoz tartozo jatekhoz.
	 * @param game Beallitando jatek.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Getter a virologus mezojehez.
	 * @return A field.
	 */
	public Field getField() {
		return field;
	}

	/**
	 * Setter a virologus mezojehez.
	 * @param field Beallitando mezo.
	 */
	public void setField(Field field) {
		this.field = field;
	}

	/**Getter a felszerelesekhez.
	 * @return equipments
	 */
	public ArrayList<Equipment> getEquipments() {
		return equipments;
	}

	/**
	 * Setter a virologus tulajdonaban levo felszerelesekhez.
	 * @param equipments Beallitando felszerelesek.
	 */
	public void setEquipments(ArrayList<Equipment> equipments) {
		this.equipments = equipments;
	}

	/**
	 * Getter a gencode-okhoz.
	 * @return A virologus altal ismert genetikai kodok listaja.
	 */
	public HashSet<Gencode> getGencodes() {
		return gencodes;
	}

	/**
	 * Setter a gencode-okhoz.
	 * @param gencodes Beallitando genetikai kodok.
	 */
	public void setGencodes(HashSet<Gencode> gencodes) {
		this.gencodes = gencodes;
	}

	/**
	 * Getter az agenslistahoz.
	 * @return Az agensek listaja.
	 */
	public ArrayList<Agent> getAgents() {
		return agents;
	}

	/**
	 * Setter az agenslistahoz.
	 * @param agents Beallitando agenslista.
	 */
	public void setAgents(ArrayList<Agent> agents) {
		if(agents.size() <= maxAgentNumber) {
			this.agents = agents;
		}
	}

	/**
	 * Getter az anointedBehaviour-hoz.
	 * @return Az anointedBehaviour.
	 */
	public AnointedBehaviour getAnointedBehaviour() {
    	
		return anointedBehaviour;
	}

	/**
	 * Setter az anointedBehaviour-hoz.
	 * @param anointedBehaviour A beallitando anointedBehaviour.
	 */
	public void setAnointedBehaviour(AnointedBehaviour anointedBehaviour) {
		
		this.anointedBehaviour = anointedBehaviour;
	}

	/**
	 * Getter a moveBehaviour-hoz.
	 * @return A virologus moveBehaviour-je.
	 */
	public MoveBehaviour getMoveBehaviour() {
		
		return moveBehaviour;
	}

	/**
	 * Setter a moveBehaviour-hoz.
	 * @param moveBehaviour Az allitando moveBehaviour. 
	 */
	public void setMoveBehaviour(MoveBehaviour moveBehaviour) {
		
		this.moveBehaviour = moveBehaviour;
	}

	/**
	 * Getter az effektek listajahoz.
	 * @return Effektek listaja.
	 */
	public ArrayList<Effect> getEffects() {
		
		return effects;
	}

	/**
	 * Getter a virologistBehaviour-hoz.
	 * @return A virologus virologistBehaviour-je.
	 */
	public VirologistBehaviour getVirologistBehaviour() {
		
		return virologistBehaviour;
	}

	/**
	 * Setter a virologistBehaviour-hoz.
	 * @param virologistBehaviour Az allitando virologistBehaviour. 
	 */
	public void setVirologistBehaviour(VirologistBehaviour virologistBehaviour) {
		
		this.virologistBehaviour = virologistBehaviour;
	}
	
	 /**
	  * Hozzaad egy agenst a virologus agens listajahoz.
     * @param a Agens, amit az agensekhez akarunk adni.
     */
    public void AddAgent(Agent a) {
        if (agents.size() < maxAgentNumber) {
        	agents.add(a);
        }
    }
	
    /**
     * Hozzaad egy gencode-ot a gencode set-hez.
     * @param g Gencode, amit hozza akarunk adni.
     */
    public void AddGencode(Gencode g) {
    	gencodes.add(g);
    }

	/**
	 * @return killBehaviour
	 */
	public KillBehaviour getKillBehaviour() {
		return killBehaviour;
	}

	/**
	 * @param killBehaviour beallitando killBehaviour
	 */
	public void setKillBehaviour(KillBehaviour killBehaviour) {
		this.killBehaviour = killBehaviour;
	}
	
	/**
	 * meghal a virologus, amennyiben megtamadtak es medve
	 * @param v tamado virologus
	 */
	public boolean UseDie(Virologist v) { 
		return(moveBehaviour.Die(v, this));
	}
	
	/**
	 * A virologust megprobaljak megolni
	 * @param v virologus aki ol
	 */
	public void UseKill(Virologist v) {
		killBehaviour.Kill(this, v);
	}
	
	/**
	 * gombot keszit a virologusnak attol fuggoen, hogy medve-e vagy nem
	 * @return JVirologist
	 */
	public JVirologist getView() {
		return moveBehaviour.getView(this);
	}
}