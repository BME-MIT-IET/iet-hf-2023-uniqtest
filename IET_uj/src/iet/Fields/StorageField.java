package iet.Fields;

import java.util.ArrayList;

import javax.swing.JButton;

import iet.Core.Game;
import iet.Core.Virologist;
import iet.Equipments.Equipment;
import iet.Graphics.JSubstance;

/**
 * A palya mezoinek egyik fajtaja, Raktar. Itt van amino es nukleotid elszorva.
 */
public class StorageField extends Field {

    /**
     * Default constructor
     */
    public StorageField() {
    	amino=30;
    	nucleotid=30;
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    }

    /**
     * A mezon levo amino felvetele, i-t tud felvenni
	 * @return amino
	 */
	public int GetAmino(int i) {
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
		if (i<=amino) {
			setAmino(amino-i);
			return i;
		} else {
			int temp_i=amino;
			setAmino(0);
			return temp_i;
		}
	}

	/**
	 * Setter a mezon levo aminohoz.
	 * @param amino Beallitando amino mennyiseg.
	 */
	public void setAmino(int amino) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
		this.amino = amino;
	}
	
	public int getAmino() {
    	return amino;
	}
	
	public int getNucleotid() {
    	return nucleotid;
	}

	/**
	 * m-et tud felvenni
	 * A mezon levo nukleotid felvetele.
	 * @return nucleotid
	 */
	public int GetNucleotid(int m) {
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
		if (m<=nucleotid) {
			setNucleotid(nucleotid-m);
			return m;
		} else {
			int temp_m=nucleotid;
			setNucleotid(0);
			return temp_m;
		}
	}

	/**
	 * Setter a mezon levo nukleotidhoz.
	 * @param amino Beallitando nukleotid mennyiseg.
	 */
	public void setNucleotid(int nucleotid) {
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
		this.nucleotid = nucleotid;
	}

	/**
     * Mezon levo amino mennyisege.
     */
    private int amino;

    /**
     * Mezon levo nukleotid mennyisege.
     */
    private int nucleotid;
    
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
		
		
		items.add(new JSubstance(this));
		
		for (int i=0; i<neighbourFields.size(); ++i){
			items.add(neighbourFields.get(i).getView(i));
		}
		
		return items;
	}

}