package Fields;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Core.Game;
import Core.Virologist;
import Equipments.Equipment;
import Gencodes.Gencode;
import Graphics.JGencode;
import Graphics.JSubstance;

/**
 * A palya egyik mezotipusat, a laboratoriumot megvalosito osztaly. Ezen a mezofajtan lehetnek genetikai kodok.
 */
public class LaboratoryField extends Field {

    /**
     * Default constructor
     */
    public LaboratoryField(Gencode gc) {
    	gencode = gc;
    }
    
    public LaboratoryField() {}

    /**
     * Mezon levo genetikai kod lekerese.
	 * @return gencode
	 */
	public Gencode getGencode() {
		return gencode;
	}

	/**
	 * Setter a mezon levo genetikai kodhoz.
	 * @param gencode Beallitando genetikai kod.
	 */
	public void setGencode(Gencode gencode) {
		this.gencode = gencode;
	}

	/**
     * A laboratorium falan levo genetikai kod.
     */
    private Gencode gencode;
    
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
		
		items.add(new JGencode(gencode));
		
		for (int i=0; i<neighbourFields.size(); ++i){
			items.add(neighbourFields.get(i).getView(i));
		}
		
		return items;
	}
}