package ProtoInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;



public class Interface {

	/**
	 * A proto interface akkor lep ki (nem add tobb tesztelesi lehetoseget)
	 * ha az exit true erteket vesz fel. 
	 */
	private boolean exit;
	
	/**
	 * Mindig az aktualisan olvasott sort tartalmazza.
	 */
	protected static String line;
	
	/**
	 * Az aktualis command parametereit tartalmazza ha vannak.
	 */
	private static ArrayList<String> parameters;
	
	/**
	 * SekvencTestInterpreter a szekvencia teszteles parancsertelmezeset fogja ossze.
	 */
	private SekvenceTestInterpreter sekvenceTestInterpreter;
	
	/**
	 * Game Test interpreter a game teszt parancsertelmezeset vegzi.
	 */
	private GameTestInterpreter gameTestInterpreter;
	
	/**
	 * Az eppen aktualis interface azonositoja
	 */
	private int interfaceId;
	
	/**
	 * Kontsruktor
	 */
	public Interface() {
		exit = false;
		sekvenceTestInterpreter = new SekvenceTestInterpreter();
		gameTestInterpreter = new GameTestInterpreter();
		interfaceId = 0;
	}
	
	/**
	 * visszaadja az aktualisan ervenyes promptot.
	 */
	String GetPrompt() {
		switch (interfaceId) {
		case 1:
			return "$ProtoInterface\\SekvenceTest>> ";
		case 2:
			return "$ProtoInterface\\GameTest>> ";
		default:
			return "$ProtoInterface>> ";
		}
		
	}
	
	/**
	 * Proto Interface inditasa.
	 * Feladata, hogy egy ciklusban, amely a kilepesig fut, beolvassa a parancsokat a konzolrol,
	 * es az ertelmezovel ertelmeztesse, valamint utana vegrehajtsa a megfelelo parancsot. 
	 */
	public void StartProtoInterface() throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to the Poto Intreface\n");
		System.out.println("Type the command\n" 
							+ "or visit the help menu with 'help' command.\n" 
							+ "At the end of the job you can exit with the 'exit' command.\n");
		
		while(!exit) {
			System.out.print(GetPrompt());
			line = bufferedReader.readLine();
			Interpreter(line);
		}
		
		System.out.println("Thank you for choosing Proto Interface services\n");
		//System.out.print("$>>");
	}
	
	
	/**
	 * Ertelmezi a konzolon megadott sorban szereplo parancsot es parametereit.
	 * Az ertelmezes utan a forditoval megkeresi a parancshoz tartozo azonositot
	 * es ez alapjan futtatja a parancshoz tartozo metodust.
	 */
	private void Interpreter(String line) {
		
		String[] lineSplit = line.split(" ");
		String command = lineSplit[0].toLowerCase();
		parameters = new ArrayList<String>(Arrays.asList(lineSplit));
		
		switch (interfaceId) {
		case 1:
			sekvenceTestInterpreter.Execute(sekvenceTestInterpreter.Translator(command));
			if (sekvenceTestInterpreter.GetExit()) interfaceId = 0;
			break;
		case 2:
			gameTestInterpreter.Execute(command);
			if (gameTestInterpreter.GetExit()) interfaceId = 0;
			break;
		default:
			ProtoInterpreter(command);
			break;
		}
		
	}
	
	/**
	 * a protointerface interpreter, ami osszefogja a szekvencia es game teszt interface-eit.
	 */
	private void ProtoInterpreter(String command) {
		switch (command) {
		case "exit":
			exit = true;
			break;
		case "sekvencetest":
			interfaceId = 1;
			break;
		case "gametest":
			interfaceId = 2;
			gameTestInterpreter.SetExit(false);
			break;
		case "help":
			Help();
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
		System.out.println("ProtoInterface Help - Kiadhato parancsok");
		System.out.println("	* sekvenceTest (ez a szkeleton tesztje)\n"
				+ "	* gameTest (ez a proto tesztje)\n"
				+ "	* exit\n"
				+ "	* help");
	}


	/**
	 * ha egyik parancsnak sem felelt meg a beirt sor
	 */
	public void Fail() {
		System.out.println("Fail: this command does not exist '" + Interface.line + "'\n" + "Try again or see the help menu");
	}

		
	public static ArrayList<String> GetTheParams(){
		return parameters;
	}
	
}
