package ProtoInterface;

public class SekvenceTestInterpreter {

	/**
	 * A sekvenceTest interface akkor lep ki (nem add tobb tesztelesi lehetosEget)
	 * ha az exit true erteket vesz fel. 
	 */
	private boolean exit;
	
	/**
	 * Az interface parancsaihoz metodusok tartoznak.
	 * Ez az objektum a parancsokhoz tartozo logikat fogja ossze.
	 */
	private SekvenceTestInterfaceCommandFunction sekvenceTestInterfaceCommandFunction;
	
	
	/**
	 * Kontsruktor
	 */
	SekvenceTestInterpreter(){
		sekvenceTestInterfaceCommandFunction = new SekvenceTestInterfaceCommandFunction();
		exit = false;
	}
	
	/**
	 * visszaadja az exit erteket
	 */
	public boolean GetExit() {
		return exit;
	}
	
	/**
	 * Az interpreter ertelmezi, az adott sorban beerkezett parancsot.
	 * es visszater a parancshoz tartozo, azonosositoval, amin keresztul 
	 * azonositani lehet a vegrehajtando feladatot.
	 * @return
	 */
	public int Translator(String command) {
		int numberOfCommand;
		
		switch (command) {
			case "exit":
				numberOfCommand = 0;
				break;
			case "startgame":
				numberOfCommand = 1;
				break;
			case "normalmove":
				numberOfCommand = 2;
				break;
			case "dancemove":
				numberOfCommand = 3;
				break;
			case "anointwithresistanceagent":
				numberOfCommand = 4;
				break;
			case "anointwithdanceragent":
				numberOfCommand = 5;
				break;
			case "anointwithparalyzingagent":
				numberOfCommand = 6;
				break;
			case "anointwithalzheimeragent":
				numberOfCommand = 7;
				break;
			case "craftalzheimeragent":
				numberOfCommand = 8;
				break;
			case "craftparalyzingagent":
				numberOfCommand = 9;
				break;
			case "craftdanceragent":
				numberOfCommand = 10;
				break;
			case "craftresistanceagent":
				numberOfCommand = 11;
				break;
			case "learndancergencode":
				numberOfCommand = 12;
				break;
			case "learnresistancegencode":
				numberOfCommand = 13;
				break;
			case "learnparalyzinggencode":
				numberOfCommand = 14;
				break;
			case "learnalzheimergencode":
				numberOfCommand = 15;
				break;
			case "degradationofresistanceagent":
				numberOfCommand = 16;
				break;
			case "degradationofalzheimeragent":
				numberOfCommand = 17;
				break;
			case "degradationofdanceragent":
				numberOfCommand = 18;
				break;
			case "degradationofparalyzingagent":
				numberOfCommand = 19;
				break;
			case "takeglove":
				numberOfCommand = 20;
				break;
			case "takecape":
				numberOfCommand = 21;
				break;
			case "takebag":
				numberOfCommand = 22;
				break;
			case "takesubstance":
				numberOfCommand = 23;
				break;
			case "defensewithresistanceagent":
				numberOfCommand = 24;
				break;
			case "defensewithglove":
				numberOfCommand = 25;
				break;
			case "dropbag":
				numberOfCommand = 26;
				break;
			case "dropcape":
				numberOfCommand = 27;
				break;
			case "dropglove":
				numberOfCommand = 28;
				break;
			case "stealglove":
				numberOfCommand = 29;
				break;
			case "stealcape":
				numberOfCommand = 30;
				break;
			case "stealbag":
				numberOfCommand = 31;
				break;
			case "stealsubstance":
				numberOfCommand = 32;
				break;
			case "preventstealbag":
				numberOfCommand = 33;
				break;
			case "preventstealglove":
				numberOfCommand = 34;
				break;
			case "preventstealcape":
				numberOfCommand = 35;
				break;
			case "preventstealsubstance":
				numberOfCommand = 36;
				break;
			case "help":
				numberOfCommand = 37;
				break;
			default:
				numberOfCommand = -1;
				break;
		}
		return numberOfCommand;
	}
	
	
	/**
	 * A megadott azonositohoz tartozo metodust futtatja.
	 * 0 		: exit
	 * 1 - 36 	: parancsok
	 * 37		: help
	 * default (-1): fail
	 */
	public void Execute(int NumberOfCommand) {
		switch (NumberOfCommand) {
			case 0:
				exit = true;
				break;
			case 1:
				sekvenceTestInterfaceCommandFunction.StartGame();
				break;
			case 2:
				sekvenceTestInterfaceCommandFunction.NormalMove();
				break;
			case 3:
				sekvenceTestInterfaceCommandFunction.DanceMove();
				break;
			case 4:
				sekvenceTestInterfaceCommandFunction.AnointWithResistanceAgent();
				break;
			case 5:
				sekvenceTestInterfaceCommandFunction.AnointWithDancerAgent();
				break;
			case 6:
				sekvenceTestInterfaceCommandFunction.AnointWithParalyzingAgent();
				break;
			case 7:
				sekvenceTestInterfaceCommandFunction.AnointWithAlzheimerAgent();
				break;
			case 8:
				sekvenceTestInterfaceCommandFunction.CraftAlzheimerAgent();
				break;
			case 9:
				sekvenceTestInterfaceCommandFunction.CraftParalyzingAgent();
				break;
			case 10:
				sekvenceTestInterfaceCommandFunction.CraftDancerAgent();
				break;
			case 11:
				sekvenceTestInterfaceCommandFunction.CraftResistanceAgent();
				break;
			case 12:
				sekvenceTestInterfaceCommandFunction.LearnDancerGencode();
				break;
			case 13:
				sekvenceTestInterfaceCommandFunction.LearnResistanceGencode();
				break;
			case 14:
				sekvenceTestInterfaceCommandFunction.LearnParalyzingGencode();
				break;
			case 15:
				sekvenceTestInterfaceCommandFunction.LearnAlzheimerGencode();
				break;
			case 16:
				sekvenceTestInterfaceCommandFunction.DegradationOfResistanceAgent();
				break;
			case 17:
				sekvenceTestInterfaceCommandFunction.DegradationOfAlzheimerAgent();
				break;
			case 18:
				sekvenceTestInterfaceCommandFunction.DegradationOfDancerAgent();
				break;
			case 19:
				sekvenceTestInterfaceCommandFunction.DegradationOfParalyzingAgent();
				break;
			case 20:
				sekvenceTestInterfaceCommandFunction.TakeGlove();
				break;
			case 21:
				sekvenceTestInterfaceCommandFunction.TakeCape();
				break;
			case 22:
				sekvenceTestInterfaceCommandFunction.TakeBag();
				break;
			case 23:
				sekvenceTestInterfaceCommandFunction.TakeSubstance();
				break;
			case 24:
				sekvenceTestInterfaceCommandFunction.DefenseWithResistanceAgent();
				break;
			case 25:
				sekvenceTestInterfaceCommandFunction.DefenseWithGlove();
				break;
			case 26:
				sekvenceTestInterfaceCommandFunction.DropBag();
				break;
			case 27:
				sekvenceTestInterfaceCommandFunction.DropCape();
				break;
			case 28:
				sekvenceTestInterfaceCommandFunction.DropGlove();
				break;
			case 29:
				sekvenceTestInterfaceCommandFunction.StealGlove();
				break;
			case 30:
				sekvenceTestInterfaceCommandFunction.StealCape();
				break;
			case 31:
				sekvenceTestInterfaceCommandFunction.StealBag();
				break;
			case 32:
				sekvenceTestInterfaceCommandFunction.StealSubstance();
				break;
			case 33:
				sekvenceTestInterfaceCommandFunction.PreventStealBag();
				break;
			case 34:
				sekvenceTestInterfaceCommandFunction.PreventStealGlove();
				break;
			case 35:
				sekvenceTestInterfaceCommandFunction.PreventStealCape();
				break;
			case 36:
				sekvenceTestInterfaceCommandFunction.PreventStealSubstance();
				break;
			case 37:
				sekvenceTestInterfaceCommandFunction.Help();
				break;
			default:
				sekvenceTestInterfaceCommandFunction.Fail();
				break;
		}
	}

}
