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
    public void Deactivate(Virologist v) { /* Medvere nem vonatkozik */ }
    
    public String getId() {
 		return "BearAg";
 	}

}
