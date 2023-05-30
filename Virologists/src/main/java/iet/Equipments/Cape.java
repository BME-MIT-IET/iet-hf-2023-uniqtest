package main.java.iet.Equipments;

import main.java.iet.Core.Virologist;
import main.java.iet.Graphics.JCape;
import main.java.iet.AnointedBehaviours.MightBlockAnoint;
import main.java.iet.AnointedBehaviours.TakeAnoint;

/**
 * Az egyik felszerelest, a vedo kopenyt megvalosito osztaly. 
 */
public class Cape extends Equipment {

    /**
     * Default constructor
     */
    public Cape(Virologist v) {
		super(v);
		setName("Cape");
    }

    /**
     * Aktivalja a kopeny hatasat a virologuson, 82.3%-os esellyel megvedi a virologust agens kenestol.
     * @param v Virologus, akin aktivalodik a kopeny hatasa.
     */
    public void Activate(Virologist v) {
    	
    	MightBlockAnoint mba = new MightBlockAnoint();
    	
    	if (v.getAnointedBehaviour().getPriority() < mba.getPriority())
    		v.setAnointedBehaviour(mba);
    }

    /** 
     * A virologusrol eltunik a kopeny hatasa.
     * @param v Virologus, akirol eltunik a kopeny hatasa.
     */
    public void Deactivate(Virologist v) {
    	v.setAnointedBehaviour(new TakeAnoint());
    	setVirologist(null);
    }
    
    /**
     * gombot keszit a kopenyhez es visszater vele
     */
    public JCape getView() {
    	return new JCape(this);
    }

}