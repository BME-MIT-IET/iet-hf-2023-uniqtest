package main.java.iet.Fields;

import java.util.ArrayList;

import javax.swing.JButton;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Equipment;
import main.java.iet.Graphics.JSubstance;

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
    }

    /**
     * A mezon levo amino felvetele, i-t tud felvenni
	 * @return amino
	 */
	@Override
	public int getAmino(int i) {

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
	@Override
	public void setAmino(int amino) {

		this.amino = amino;
	}

	@Override
	public int getAllAmino() {
    	return amino;
	}

	@Override
	public int getAllNucleotid() {
    	return nucleotid;
	}

	/**
	 * m-et tud felvenni
	 * A mezon levo nukleotid felvetele.
	 * @return nucleotid
	 */
	@Override
	public int getNucleotid(int m) {

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
	@Override
	public void setNucleotid(int nucleotid) {

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
	@Override
    public ArrayList<JButton> getJItems() {
		ArrayList<JButton> items = new ArrayList<>();
		
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
			items.add(neighbourFields.get(i).getView());
		}
		
		return items;
	}

}