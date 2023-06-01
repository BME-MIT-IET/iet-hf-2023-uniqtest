package main.java.iet.Equipments;

import main.java.iet.AnointedBehaviours.ReturnAnoint;
import main.java.iet.AnointedBehaviours.TakeAnoint;
import main.java.iet.Core.Virologist;
import main.java.iet.Graphics.JGlove;

/**
 * Az egyik felszerelest, a vedelmet biztosito kesztyut megvalosito osztaly.
 */
public class Glove extends Equipment {

    /**
     * Default constructor
     */
    public Glove(Virologist v) {
		super(v);
    	setNumberOfUse(3);
    	setName("Glove");
    }

    /**
     * Aktivalja a kesztyu vedo hatasat a virologuson.
     * @param v Virologus, akin aktivalodik a hatas.
     */
    public void Activate(Virologist v) {      
    	ReturnAnoint ra = new ReturnAnoint(this);
    	
    	if (v.getAnointedBehaviour().getPriority() < ra.getPriority())
    		v.setAnointedBehaviour(ra);
    }

    /** 
     * A virologusrol eltunik a kesztyu hatasa.
     * @param v Virologus, akirol eltunik a kesztyu hatasa.
     */
    public void Deactivate(Virologist v) {
    	v.setAnointedBehaviour(new TakeAnoint());
    	v.RefreshEffects();
    	setVirologist(null);
    }
    
    /**
     * gombot keszit a kesztyuhoz es visszater vele
     */
    public JGlove getView() {
    	return new JGlove(this);
    }
}