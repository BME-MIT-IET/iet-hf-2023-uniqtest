package main.java.iet.Agents;


import main.java.iet.Core.Virologist;
import main.java.iet.VirologistBehaviours.Paralyzed;

/**
 * Paralyzing tipusu Agenseket megvalosito osztaly
 */
public class ParalyzingAgent extends Agent {

    /**
     * Default constructor
     */
    public ParalyzingAgent() {
    	setName("ParalyzingAgent");
    }

    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus viselkedeset benultra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
    	v.setVirologistBehaviour(new Paralyzed());
    	setVirologist(v);
    }

    /**
     * Deakivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus viselkedeset normalra
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Deactivate(Virologist v) {    }
    
    public String getId() {
 		return "ParAg";
 	}
}