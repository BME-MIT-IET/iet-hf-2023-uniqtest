package iet.Agents;

import iet.Core.Virologist;
import iet.MoveBehaviours.DanceMove;
import iet.MoveBehaviours.NormalMove;

/**
 * Dancer tipusu Agenseket megvalosito osztaly
 */
public class DancerAgent extends Agent {

    /**
     * Default constructor
     */
    public DancerAgent() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setName("DancerAgent");
    }

    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus lepesi viselkedeset tancolosra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	DanceMove dm = new DanceMove(); 
    	setVirologist(v);
    	if (v.getMoveBehaviour().getPriority() < dm.getPriority())
    		v.setMoveBehaviour(dm);
    }

    /**
     * Dekivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus lepesi viselkedeset normalra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	
    	v.setMoveBehaviour(new NormalMove());
    	v.RefreshEffects();
    	
    }
    
    public String getId() {
 		return "DanAg";
 	}
}