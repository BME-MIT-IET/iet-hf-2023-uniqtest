package main.java.iet.Equipments;

import main.java.iet.Core.Virologist;
import main.java.iet.Graphics.JBag;

/**
 * Az egyik felszerelest, a maximum anyagmennyiseget novelo zsakot megvalosito osztaly.
 */
public class Bag extends Equipment {

    /**
     * Default constructor
     */
    public Bag(Virologist v) {
		super(v);
		setName("Bag");
    }

    /**
     * Aktivalja a zsak hatasat a virologuson, megnoveli a max felveheto anyagot.
     * @param v A virologus, akin aktivalodik.
     */
    public void Activate(Virologist v) {
    	v.setMaxSubstance(15);
    }

    /** 
     * A virologus tarolo kapacitasat kevesebbre allitja, majd megszunteti hatasat.
     * @param v A virologus, akirol eltunik a zsak hatasa.
     */
    public void Deactivate(Virologist v) {
    	v.setMaxSubstance(10);
    	setVirologist(null);
    }
    
    /**
     * gombot keszit a zsakhoz es visszater vele
     */
    public JBag getView() {
    	return new JBag(this);
    }

}