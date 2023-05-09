package iet.Agents;

import iet.AnointedBehaviours.BlockAnoint;
import iet.AnointedBehaviours.TakeAnoint;
import iet.Core.Virologist;

/**
 * Resistance tipusu Agenseket megvalosito osztaly
 */
public class ResistanceAgent extends Agent {

    /**
     * Default constructor
     */
    public ResistanceAgent() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setName("ResistanceAgent");
    }

    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus felkent viselkedeset benultra, amennyiben ez a legnagyobb prioritasu
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	BlockAnoint ba = new BlockAnoint();
    	setVirologist(v);
    	if (v.getAnointedBehaviour().getPriority() < ba.getPriority())
    		v.setAnointedBehaviour(ba);
    }

    /**
     * Deaktivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus felkent viselkedeset normalra, amennyiben ez a legnagyobb prioritasu
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	
        v.setAnointedBehaviour(new TakeAnoint());
        v.RefreshEffects();
    }
    
    public String getId() {
 		return "ResAg";
 	}

}