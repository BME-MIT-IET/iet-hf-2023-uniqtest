package Main;

import java.io.IOException;

import javax.swing.JFrame;

import Core.Game;
import Equipments.Bag;
import Graphics.*;
import ProtoInterface.Interface;


/**
 * a jatek inditasa
 *
 */
public class menu {
	
	public static void main(String[] args) {
	
		StartMenu m = new StartMenu();
		while (!m.isReady()) {
			try {Thread.sleep(2000);}
			catch (InterruptedException e) {}
		}
		
		Game game = m.getGame();
		game.StartGame();
		
		
		
		
		
		
		
		
		/*
		// A proto interface futtatasa.
		Interface protoInterface = new Interface();
		try {
			protoInterface.StartProtoInterface();
		}
		catch(IOException ioe) {
			ioe.toString();
		} 
		*/
		
	}
	
}
