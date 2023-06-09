package main.java.iet.Agents;

import main.java.iet.AnointedBehaviours.BlockAnoint;
import main.java.iet.AnointedBehaviours.TakeAnoint;
import main.java.iet.Core.Virologist;

/**
 * Resistance tipusu Agenseket megvalosito osztaly
 */
public class ResistanceAgent extends Agent {

    /**
     * Default constructor
     */
    public ResistanceAgent() {
    	setName("ResistanceAgent");
    }

    /**
     * Akivalja az agens hatasat
     * Beallitja a parameterkent kapott virologus felkent viselkedeset benultra, amennyiben ez a legnagyobb prioritasu
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
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
        v.setAnointedBehaviour(new TakeAnoint());
        v.RefreshEffects();
    }
    
    public String getId() {
 		return "ResAg";
 	}

}