package iet.FileManagement;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import iet.Agents.Agent;
import iet.Core.Effect;
import iet.Core.Game;
import iet.Core.Virologist;
import iet.Equipments.Equipment;
import iet.Fields.Field;
import iet.Gencodes.Gencode;

/**
 * jatek mentese fajlba
 * keszul olvashato es szerializalt fajl is
 *
 */
public class Serializer {
	public static void serialize(Game g,String filename) {
		try {
	         FileOutputStream fileOut = new FileOutputStream(filename + ".txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(g);
	         out.close();
	         fileOut.close();
	         
	         FileWriter fw = new FileWriter(filename + "_olvashato.txt");
	         ArrayList<Field> fields = g.getFields();
	 		 ArrayList<Virologist> virologists = g.getVirologists();
	         
	        fw.write("Mezok: ");
	 		for(int i=0; i<fields.size(); ++i){
	 			if(i!=fields.size()-1) fw.write(fields.get(i).getId() + ", ");
	 			else fw.write(fields.get(i).getId() + "\n");
	 		}
	 		
	 		
	 		for(int i=0; i<fields.size(); ++i){
	 			fw.write(fields.get(i).getId() + " szomszedai: ");
	 			for(int j=0; j<fields.get(i).GetNeighbourFieldNum(); ++j){
	 				if(j!=fields.get(i).GetNeighbourFieldNum()-1) fw.write(fields.get(i).GetNeighbour(j).getId() + ", ");
	 				else fw.write(fields.get(i).GetNeighbour(j).getId());
	 			}
	 			fw.write("\n");
	 		}
	 		
	 		
	 		fw.write("\nMezokon talalhato dolgok: \n");
	 		for(int i=0; i<fields.size(); ++i){
	 			ArrayList<Equipment> equipments = fields.get(i).getEquipments();
	 			ArrayList<Virologist> fieldVir = fields.get(i).getVirologists();
	 			fw.write(fields.get(i).getId() + " mezon levo dolgok: ");
	 			if(fieldVir!=null) {
	 				for(int j=0; j<fieldVir.size(); ++j){
	 					fw.write(fieldVir.get(j).getId() + " ");
	 				}
	 			}
	 			if(equipments!=null) {
	 				for(int j=0; j<equipments.size(); ++j){
	 					fw.write(equipments.get(j).getId() + " ");
	 				}
	 			}
	 			if(fields.get(i).getGencode()!=null) {
	 				fw.write(fields.get(i).getGencode().getType() + " ");
	 			}
	 			
	 			if(!(fields.get(i).getAmino()==0 && fields.get(i).getNucleotid()==0)) {
	 				fw.write(fields.get(i).getAmino() + " darab amino " + fields.get(i).getNucleotid() + " darab nukleotid");
	 			}
	 			fw.write("\n");
	 		}
	 		fw.write("\n");
	 		
	 		fw.write("Virologusoknal levo dolgok: \n");
	 		for(int i=0; i<virologists.size(); ++i){
	 			fw.write(virologists.get(i).getId() + "-nel levo dolgok: ");
	 			ArrayList<Equipment> equips = virologists.get(i).getEquipments();
	 			if(equips!=null){
	 				for(int j=0; j<equips.size(); ++j){
	 					fw.write(equips.get(j).getId() + " ");
	 				}
	 			}
	 			
	 			HashSet<Gencode> gencodes = virologists.get(i).getGencodes();
	 			Gencode[] codes = gencodes.toArray(new Gencode[gencodes.size()]);
	 			if(codes!=null){
	 				 for(int j=0; j<codes.length; ++j){
	 					fw.write(codes[j].getType() + " ");
	 				 }
	 			}
	 			
	 			ArrayList<Agent> agents =  virologists.get(i).getAgents();
	 			if(agents!=null){
	 				for(Agent a : agents){
	 					fw.write(a.getId() + " ");
	 				}
	 			}
	 			fw.write(virologists.get(i).getAmino() + " darab amino " + virologists.get(i).getNucleotid() + " darab nukleotid\n");
	 			//fw.write("\n");
	 		}
	 		
	 		fw.write("\nVirologusokon levo effect-ek: \n");
	 		
	 		for(int i=0; i<virologists.size(); ++i){
	 			ArrayList<Effect> effects = virologists.get(i).getEffects();
	 			fw.write(virologists.get(i).getId() + ": ");
	 			for(int j=0; j<effects.size(); ++j){
	 				if(j!=effects.size()-1) fw.write(effects.get(j).getId() + ", ");
	 				//else fw.write(effects.get(j).getId());
	 			}
	 			//fw.write("\n");
	 		
	 		fw.write("\n");
	 		
	 	}
	         
	         
	         fw.close();
	         
	         System.out.println("Saved");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	/**
	 * mentett jatek visszatoltese
	 * @param filename
	 * @return
	 */
	public static Game deserialize(String filename) {
		try {
	         FileInputStream fileIn = new FileInputStream(filename);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Game g = (Game) in.readObject();
	         in.close();
	         fileIn.close();
	         return g;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return null;
	      }
	}
}
