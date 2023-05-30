package main.java.iet.ProtoInterface;

import java.io.IOException;
import java.util.logging.Logger;

import main.java.iet.Agents.AlzheimerAgent;
import main.java.iet.Agents.DancerAgent;
import main.java.iet.Agents.ParalyzingAgent;
import main.java.iet.Agents.ResistanceAgent;
import main.java.iet.AnointedBehaviours.BlockAnoint;
import main.java.iet.Core.Game;
import main.java.iet.Core.Timer;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Bag;
import main.java.iet.Equipments.Cape;
import main.java.iet.Equipments.Glove;
import main.java.iet.Fields.Field;
import main.java.iet.Fields.ShelterField;
import main.java.iet.Fields.StorageField;
import main.java.iet.Gencodes.AlzheimerGencode;
import main.java.iet.Gencodes.DancerGencode;
import main.java.iet.Gencodes.ParalyzingGencode;
import main.java.iet.Gencodes.ResistanceGencode;
import main.java.iet.MoveBehaviours.DanceMove;
import main.java.iet.VirologistBehaviours.Paralyzed;

/**
 * A Proto interface parancsait kiszolgalo osztaly.
 */
public class SekvenceTestInterfaceCommandFunction {
	private static final Logger logger = Logger.getLogger(SekvenceTestInterfaceCommandFunction.class.getName());
	private static final String DOTS = "................";
	private static final String LAST_GENCODE_QUESTION = "Ez az utolso megtanult genetikai kod? (i/n) :";

	/**
	 * A startgame parancsot kiszolgalo fuggveny.
	 */
	public void StartGame() {
		Game g = new Game(3);
		Timer t = new Timer();
		g.setTimer(t);
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
		v1.Anoint(v2, aa);
	}
	
	 
	/**
	 * A craftalzheimeragent parancsot kiszolgalo fuggveny.
	 */
	public void CraftAlzheimerAgent() {
		Virologist virologist = new Virologist(null, null);
		AlzheimerGencode alzheimerGencode = new AlzheimerGencode();
		System.out.println(DOTS);
		virologist.CraftAgent(alzheimerGencode);
	}
	
	 
	/**
	 * A craftparalyzingagent parancsot kiszolgalo fuggveny.
	 */
	public void CraftParalyzingAgent() {
		Virologist virologist = new Virologist(null, null);
		ParalyzingGencode paralyzingGencode = new ParalyzingGencode();
		System.out.println(DOTS);
		virologist.CraftAgent(paralyzingGencode);
	}
	
	 
	/**
	 * A craftdanceragent parancsot kiszolgalo fuggveny.
	 */
	public void CraftDancerAgent() {
		Virologist virologist = new Virologist(null, null);
		DancerGencode dancerGencode = new DancerGencode();
		System.out.println(DOTS);
		virologist.CraftAgent(dancerGencode);
	}
	
	 
	/**
	 * A craftresistanceagent parancsot kiszolgalo fuggveny.
	 */
	public void CraftResistanceAgent() {
		Virologist virologist = new Virologist(null, null);
		ResistanceGencode resistanceGencode = new ResistanceGencode();
		System.out.println(DOTS);
		virologist.CraftAgent(resistanceGencode);
	}
	
	 
	/**
	 * A learndancergencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnDancerGencode() {
		System.out.print("LAST_GENCODE_QUESTION");
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
			logger.severe("An error occurred in LearnDancerGencode: " + e.getMessage());
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		DancerGencode dancerGencode = new DancerGencode();
		if (s=='i') game.setNooneHasWonYet(false);
		System.out.println(DOTS);
		virologist.TakeGencode(dancerGencode);
	}
	
	 
	/**
	 * A learnresistancegencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnResistanceGencode() {
		System.out.print(LAST_GENCODE_QUESTION);
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
			logger.severe("An error occurred in LearnResistanceGencode: " + e.getMessage());
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		ResistanceGencode resistanceGencode = new ResistanceGencode();
		if (s=='i') game.setNooneHasWonYet(false);
		System.out.println(DOTS);
		virologist.TakeGencode(resistanceGencode);
	}
	
	 
	/**
	 * A learnparalyzinggencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnParalyzingGencode() {
		System.out.print(LAST_GENCODE_QUESTION);
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
			logger.severe("An error occurred in LearnParalyzingGencode: " + e.getMessage());
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		ParalyzingGencode paralyzingGencode = new ParalyzingGencode();
		if (s=='i') game.setNooneHasWonYet(false);
		System.out.println(DOTS);
		virologist.TakeGencode(paralyzingGencode);
	}
	
	 
	/**
	 * A learnalzheimergencode parancsot kiszolgalo fuggveny.
	 */
	public void LearnAlzheimerGencode() {
		System.out.print(LAST_GENCODE_QUESTION);
		char s='n';
		try {
		s = (char)System.in.read();
		} catch (IOException e) {
			logger.severe("An error occurred in LearnAlzheimerGencode: " + e.getMessage());
		}
		Game game = new Game(1);
		Virologist virologist = new Virologist(game, null);
		AlzheimerGencode alzheimerGencode = new AlzheimerGencode();
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
		t.Tick();
	}
	
	 
	/**
	 * A takeglove parancsot kiszolgalo fuggveny.
	 */
	public void TakeGlove() {
		ShelterField shelterField = new ShelterField();
		Virologist v = new Virologist(null, shelterField);
		Glove glove = new Glove(null);
		System.out.println(DOTS);
		v.TakeEquipment(glove);
	}
	
	 
	/**
	 * A takecape parancsot kiszolgalo fuggveny.
	 */
	public void TakeCape() {
		ShelterField shelterField = new ShelterField();
		Virologist v = new Virologist(null, shelterField);
		Cape cape = new Cape(null);
		System.out.println(DOTS);
		v.TakeEquipment(cape);
	}
	
	 
	/**
	 * A takebag parancsot kiszolgalo fuggveny.
	 */
	public void TakeBag() {
		ShelterField shelterField = new ShelterField();
		Virologist v = new Virologist(null, shelterField);
		Bag bag = new Bag(null);
		System.out.println(DOTS);
		v.TakeEquipment(bag);
	}
	
	 
	/**
	 * A takesubstance parancsot kiszolgalo fuggveny.
	 */
	public void TakeSubstance() {
		StorageField sf = new StorageField();
		Virologist v = new Virologist(null, sf);
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		DancerAgent dancerAgent = new DancerAgent();
		System.out.println(DOTS);
		v1.Anoint(v2, dancerAgent);
	}
	

	/**
	 * A dropbag parancsot kiszolgalo fuggveny.
	 */
	public void DropBag() {
		Field field = new Field();
		Virologist virologist = new Virologist(null, field);
		Bag bag = new Bag(null);
		System.out.println(DOTS);
		virologist.DropEquipment(bag);
	}

	
	/**
	 * A dropcape parancsot kiszolgalo fuggveny.
	 */
	public void DropCape() {
		Field field = new Field();
		Virologist virologist = new Virologist(null, field);
		Cape cape = new Cape(null);
		System.out.println(DOTS);
		virologist.DropEquipment(cape);
	}

	
	/**
	 * A dropglove parancsot kiszolgalo fuggveny.
	 */
	public void DropGlove() {
		Field field = new Field();
		Virologist virologist = new Virologist(null, field);
		Glove glove = new Glove(null);
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
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
		System.out.println(DOTS);
		v1.StealSubstance(v2);
	}
	
	
	/**
	 * A preventstealbag parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealBag() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Bag bag = new Bag(null);
		System.out.println(DOTS);
		v1.StealEquipment(v2, bag);
	}
	
	
	/**
	 * A preventstealglove parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealGlove() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Glove glove = new Glove(null);
		System.out.println(DOTS);
		v1.StealEquipment(v2, glove);
	}
	
	
	/**
	 * A preventstealcape parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealCape() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		Cape cape = new Cape(null);
		System.out.println(DOTS);
		v1.StealEquipment(v2, cape);
	}
	
	
	/**
	 * A preventstealsubstance parancsot kiszolgalo fuggveny.
	 */
	public void PreventStealSubstance() {
		Virologist v1 = new Virologist(null, null);
		Virologist v2 = new Virologist(null, null);
		System.out.println(DOTS);
		v1.StealSubstance(v2);
	}


	/**
	 * A help parancsot kiszolgalo fuggveny.
	 */
	public void Help() {
		System.out.println("SekvenceTestInterface Help - Kiadhato parancsok");
		System.out.println("\t* startgame\n"
				+ "\t* normalmove\n"
				+ "\t* dancemove\n"
				+ "\t* anointwithresistanceagent\n"
				+ "\t* anointwithdanceragent\n"
				+ "\t* anointwithparalyzingagent\n"
				+ "\t* anointwithalzheimeragent\n"
				+ "\t* craftalzheimeragent\n"
				+ "\t* craftparalyzingagent\n"
				+ "\t* craftdanceragent\n"
				+ "\t* craftresistanceagent\n"
				+ "\t* learndancergencode\n"
				+ "\t* learnresistancegencode\n"
				+ "\t* learnparalyzinggencode\n"
				+ "\t* learnalzheimergencode\n"
				+ "\t* degradationofresistanceagent\n"
				+ "\t* degradationofalzheimeragent\n"
				+ "\t* degradationofdanceragent\n"
				+ "\t* degradationofparalyzingagent\n"
				+ "\t* takeglove\n"
				+ "\t* takecape\n"
				+ "\t* takebag\n"
				+ "\t* takesubstance\n"
				+ "\t* defensewithresistanceagent\n"
				+ "\t* defensewithglove\n"
				+ "\t* dropbag\n"
				+ "\t* dropcape\n"
				+ "\t* dropglove\n"
				+ "\t* stealglove\n"
				+ "\t* stealcape\n"
				+ "\t* stealbag\n"
				+ "\t* stealsubstance\n"
				+ "\t* preventstealbag\n"
				+ "\t* preventstealglove\n"
				+ "\t* preventstealcape\n"
				+ "\t* preventstealsubstance\n"
				+ "\t* help");
	}


	public void Fail() {
		System.out.println("Fail: this command is not exist '" + Interface.line + "'\n" + "Try agin or see the help menu");
	}
	
}
