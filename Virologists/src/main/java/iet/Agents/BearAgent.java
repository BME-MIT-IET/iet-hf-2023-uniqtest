package main.java.iet.Agents;

import main.java.iet.Core.Virologist;
import main.java.iet.MoveBehaviours.BearMove;

public class BearAgent extends Agent {
	public BearAgent() {
		setName("BearAgent");
	}
	
    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus lepesi viselkedeset medvere
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	BearMove bm = new BearMove();
    	setVirologist(v);
    	if (v.getMoveBehaviour().getPriority() < bm.getPriority())
    		v.setMoveBehaviour(bm);
    }

    /**
     * Dekivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus lepesi viselkedeset normalra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	//v.RefreshEffects();
    }
    
    public String getId() {
 		return "BearAg";
 	}

}
