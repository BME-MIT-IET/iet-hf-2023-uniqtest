package iet.Equipments;

import iet.AnointedBehaviours.*;
import iet.Core.Virologist;
import iet.Graphics.JCape;

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
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    }

    /**
     * Aktivalja a kopeny hatasat a virologuson, 82.3%-os esellyel megvedi a virologust agens kenestol.
     * @param v Virologus, akin aktivalodik a kopeny hatasa.
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	MightBlockAnoint mba = new MightBlockAnoint();
    	
    	if (v.getAnointedBehaviour().getPriority() < mba.getPriority())
    		v.setAnointedBehaviour(mba);
    }

    /** 
     * A virologusrol eltunik a kopeny hatasa.
     * @param v Virologus, akirol eltunik a kopeny hatasa.
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
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