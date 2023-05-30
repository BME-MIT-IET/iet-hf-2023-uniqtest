package main.java.iet.Agents;

import main.java.iet.Core.Virologist;
import main.java.iet.MoveBehaviours.DanceMove;
import main.java.iet.MoveBehaviours.NormalMove;

/**
 * Dancer tipusu Agenseket megvalosito osztaly
 */
public class DancerAgent extends Agent {

    /**
     * Default constructor
     */
    public DancerAgent() {
    	setName("DancerAgent");
    }

    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus lepesi viselkedeset tancolosra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
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
    	v.setMoveBehaviour(new NormalMove());
    	v.RefreshEffects();    	
    }
    
    public String getId() {
 		return "DanAg";
 	}
}