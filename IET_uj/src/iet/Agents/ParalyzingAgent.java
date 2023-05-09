package iet.Agents;


import iet.Core.Virologist;
import iet.VirologistBehaviours.Paralyzed;

/**
 * Paralyzing tipusu Agenseket megvalosito osztaly
 */
public class ParalyzingAgent extends Agent {

    /**
     * Default constructor
     */
    public ParalyzingAgent() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setName("ParalyzingAgent");
    }

    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus viselkedeset benultra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	v.setVirologistBehaviour(new Paralyzed());
    	setVirologist(v);
    }

    /**
     * Deakivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus viselkedeset normalra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        //v.setVirologistBehaviour(new Normal());
    }
    
    public String getId() {
 		return "ParAg";
 	}
}