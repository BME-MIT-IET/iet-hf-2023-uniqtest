package iet.Equipments;

import iet.Core.Virologist;
import iet.Graphics.JBag;

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
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    }

    /**
     * Aktivalja a zsak hatasat a virologuson, megnoveli a max felveheto anyagot.
     * @param v A virologus, akin aktivalodik.
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	v.setMaxSubstance(15);
    }

    /** 
     * A virologus tarolo kapacitasat kevesebbre allitja, majd megszunteti hatasat.
     * @param v A virologus, akirol eltunik a zsak hatasa.
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
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