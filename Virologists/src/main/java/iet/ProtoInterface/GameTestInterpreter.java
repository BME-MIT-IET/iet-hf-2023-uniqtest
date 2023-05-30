package main.java.iet.ProtoInterface;

import main.java.iet.Core.Game;

public class GameTestInterpreter {
	
	/**
	 * A gameTest interface akkor lep ki (nem add tobb tesztelesi lehetoseget)
	 * ha az exit true erteket vesz fel. 
	 */
	private boolean exit;
	
	/**
	 * Az interface parancsaihoz metodusok tartoznak.
	 * Ez az objektum a parancsokhoz tartozo logikat fogja ossze.
	 */
	private GameTestInterfaceCommandFunction gameTestInterfaceCommandFunction;
	
	
	/**
	 * Kontsruktor
	 */
	GameTestInterpreter() {
		gameTestInterfaceCommandFunction = new GameTestInterfaceCommandFunction();
		exit = false;
	}
	
	/**
	 * visszaadja az exit erteket
	 */
	public boolean GetExit() {
		return exit;
	}
	
	public void SetExit(boolean b) {
		exit = b;
	}
	
	/**
	 * A megadott parancshoz tartozo metodust futtatja.
	 */
	public void Execute(String command) {
		switch (command) {
			case "exit":
				exit = true;
				break;
			case "loadmap":
				gameTestInterfaceCommandFunction.LoadMap();
				break;
			case "save":
				gameTestInterfaceCommandFunction.Save();
				break;
			case "init":
				gameTestInterfaceCommandFunction.Init();
				break;
			case "field":
				gameTestInterfaceCommandFunction.Field();
				break;
			case "neighbours":
				gameTestInterfaceCommandFunction.Neighbours();
				break;
			case "setgencode":
				gameTestInterfaceCommandFunction.SetGencode();
				break;
			case "stepall":
				gameTestInterfaceCommandFunction.StepAll();
				break;
			case "viewgame":
				gameTestInterfaceCommandFunction.ViewGame();
				break;
			case "virologiststate":
				gameTestInterfaceCommandFunction.VirologistState();
				break;
			case "setvirologist":
				gameTestInterfaceCommandFunction.SetVirologist();
				break;
			case "setvirstate":
				gameTestInterfaceCommandFunction.SetVirState();
				break;
			case "kill":
				gameTestInterfaceCommandFunction.Kill();
				break;
			case "move":
				gameTestInterfaceCommandFunction.Move();
				break;
			case "learngencode":
				gameTestInterfaceCommandFunction.LearnGencode();
				break;
			case "craftagent":
				gameTestInterfaceCommandFunction.CraftAgent();
				break;
			case "useagent":
				gameTestInterfaceCommandFunction.UseAgent();
				break;
			case "takeequipment":
				gameTestInterfaceCommandFunction.TakeEquipment();
				break;
			case "dropequipment":
				gameTestInterfaceCommandFunction.DropEquipment();
				break;
			case "setequipment":
				gameTestInterfaceCommandFunction.SetEquipment();
				break;
			case "stealequipment":
				gameTestInterfaceCommandFunction.StealEquipment();
				break;
			case "stealsubstance":
				gameTestInterfaceCommandFunction.StealSubstance();
				break;
			case "setsubstance":
				gameTestInterfaceCommandFunction.SetSubstance();
				break;
			case "capeprotection":
				gameTestInterfaceCommandFunction.CapeProtection();
				break;
			case "takesubstance":
				gameTestInterfaceCommandFunction.TakeSubstance();
				break;
			case "help":
				Help();
				break;
			case "testmapinit":
				gameTestInterfaceCommandFunction.Test_Init();
				break;
			case "szipi":
				gameTestInterfaceCommandFunction.Main_Init(3, new Game(0));
				break;
			default:
				Fail();
				break;
		}
	}
	
	/**
	 * A help parancsot kiszolgalo fuggveny.
	 */
	public void Help() {
		System.out.println("GameTestInterface Help - Kiadhato parancsok");
		System.out.println(
				"\t* init\n"
				+ "\t* loadMap <filename>\n"
				+ "\t* viewGame\n"
				+ "\t* setVirologist <virologist ID> <Field ID>\n"
				+ "\t* virologistState <virologist ID>\n"
				+ "\t* setVirState <virologist ID> <state>\n"
				+ "\t* field <typeOfField> <field ID>\n"
				+ "\t* neighbours <field1 ID> <field2 ID>\n"
				+ "\t* move <virologist ID> <field ID> <randOnOff>\n"
				+ "\t* setEquipment <equipmentType> <equipment ID> <field ID>\n"
				+ "\t* setSubstance <type> <amount> <field ID>\n"
				+ "\t* setGencode <genType> <field ID>\n"
				+ "\t* capeProtection <random/on/off>\n"
				+ "\t* stealSubstance <virologist1 ID> <virologist2 ID>\n"
				+ "\t* stealEquipment <equipment ID> <virologist1 ID> <virologist2 ID>\n"
				+ "\t* learnGencode <virologist ID>\n"
				+ "\t* takeEquipment <equipment ID> <virologist ID>\n"
				+ "\t* dropEquipment <equipment ID> <virologist ID>\n"
				+ "\t* takeSubstance <substanceType> <virologistID>\n"
				+ "\t* kill <virologist1 ID> <virologist2 ID>\n"
				+ "\t* craftAgent <agentType> <virologist ID>\n"
				+ "\t* useAgent <agentType> <virologist1 ID> <virologist2 ID>\n"
				+ "\t* stepAll\n"
				+ "\t* save <fileName>\n"
				+ "\t* help\n"
				+ "\t* exit");
	}


	/**
	 * ha egyik parancsnak sem felelt meg a beirt sor
	 */
	public void Fail() {
		System.out.println("Fail: this command does not exist '" + Interface.line + "'\n" + "Try again or see the help menu");
	}

	
}
