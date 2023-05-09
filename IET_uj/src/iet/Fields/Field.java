package iet.Fields;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

import iet.Core.Game;
import iet.Core.Virologist;
import iet.Equipments.Equipment;
import iet.Gencodes.Gencode;
import iet.Graphics.JNeighbourField;

/**
 * A jatekpalya mezoit megvalosito osztaly.
 */

public class Field implements Serializable {

    /**
     * Default constructor
     */
    public Field() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    }

    /**
     * A palyan tartozkodo virologusok listaja.
     */
    protected ArrayList<Virologist> virologists = new ArrayList<>();
    
    /**
     * A palyan levo felszerelesek listaja.
     */
    protected ArrayList <Equipment> equipments = new ArrayList<>();
    
    /**
     * A szomszedos mezok listaja.
     */
    protected ArrayList<Field> neighbourFields = new ArrayList<Field>(); 
    
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
     * A parmeterben megadott virologus hozzaadasa a mezohoz.
     * @param v Hozzaadando virologus.
     */
    public void AddVirologist(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	virologists.add(v);
    }

    /**
     * A parameterben megadott virologus eltavolitasa a mezorol.
     * @param v Eltavolitando virologus.
     */
    public void RemoveVirologist(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        virologists.remove(v);
    }

    /**
     * A parameterben megadott sorszamu szomszedos mezo lekerese.
     * @param i A lekerni kivant mezo.
     * @return A kivant mezo.
     */
    public Field GetNeighbour(int i) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        return neighbourFields.get(i);
    }
    
    /**
     * A szomszedos mezok szamanak lekerese.
     */
    public int GetNeighbourFieldNum() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	return neighbourFields.size();
    }

    /** 
     * Felszereles elhelyezese Field mezon.
     * @param e Felszereles, ami a Field-re kerul.
     */
    public void AddEquipment(Equipment e) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	equipments.add(e);
    }

    /**
     * A mezorol felvett felszereles eltavolitasa.
     * @param e Eltavolitando felszereles.
     */
    public void RemoveEquipment(Equipment e) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
   
    	equipments.remove(e);
    }

	/**
	 * Getter a mezon allo virologusok listajahoz.
	 * @return Virologusok listaja.
	 */
	public ArrayList<Virologist> getVirologists() {
		return virologists;
	}

	/**
	 * Setter a virologusok listajahoz.
	 * @param virologists A beallitando virologusok.
	 */
	public void setVirologists(ArrayList<Virologist> virologists) {
		this.virologists = virologists;
	}

	/**
	 * Getter a mezon levo felszerelesekhez.
	 * @return equipments
	 */
	public ArrayList<Equipment> getEquipments() {
		return equipments;
	}

	/**
	 * Setter a mezon levo felszerelesekhez.
	 * @param equipments Mezore rakando felszerelesek.
	 */
	public void setEquipments(ArrayList<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	   /**
	    * Mezon levo amino mennyisegenek lekerese.
		* @return Csak a StorageField-eken nem 0.
		*/
		public int GetAmino(int i) {
			return 0;
		}
		
		public int getAmino() {
	    	return 0;
		}
		
		public int getNucleotid() {
	    	return 0;
		}

		/**
		 * Mezon levo amino mennyisegenek beallitasa.
		 * @param amino Amino mennyiseg (csak StorageField-en).
		 */
		public void setAmino(int amino) {}

		/**
		 * Mezon levo nukleotid mennyisegenek lekerese.
		 * @return Csak a StorageField-eken nem 0.
		 */
		public int GetNucleotid(int m) {
			return 0;
		}

		/**
		 * Mezon levo nukleotid mennyisegenek beallitasa.
		 * @param amino Nukleotid mennyiseg (csak StorageField-en).
		 */
		public void setNucleotid(int nucleotid) {}
		
		public void addNeighbour(Field f) {
			//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
	    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
			this.neighbourFields.add(f);
			f.neighbourFields.add(this);
		}
		
		/**
		 * ideiglenes setter a proto miatt, ami nem allit itt semmit, csak a labor mezoknel
		 * @param gencode
		 */
		public void setGencode(Gencode gencode) {}
		public Gencode getGencode() {return null;}
		
		/**
	     * minden mezon levo dolog listajaval ter vissza
	     */
		public ArrayList<JButton> getJItems() {
			ArrayList<JButton> items = new ArrayList<JButton>();
			for (Virologist v : virologists) {
				items.add(v.getView());
				if (v==Game.theGame.getActiveVirologist()) {
					items.get(items.size()-1).setText("YOU");
				}
			}
			
			for (Equipment e : equipments) {
				items.add(e.getView());
			}
			
			for (int i=0; i<neighbourFields.size(); ++i){
				items.add(neighbourFields.get(i).getView(i));
			}
			
			return items;
		}
		
		/**
	     * gombot keszit a mezohoz es visszater vele
	     */
		public JButton getView(int num) {
			return new JNeighbourField(this, num);
		}
		
}