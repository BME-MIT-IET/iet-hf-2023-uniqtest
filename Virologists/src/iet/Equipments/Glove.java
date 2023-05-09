package iet.Equipments;

import iet.AnointedBehaviours.ReturnAnoint;
import iet.AnointedBehaviours.TakeAnoint;
import iet.Core.Virologist;
import iet.Graphics.JGlove;

/**
 * Az egyik felszerelest, a vedelmet biztosito kesztyut megvalosito osztaly.
 */
public class Glove extends Equipment {

    /**
     * Default constructor
     */
    public Glove(Virologist v) {
		super(v);
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
   
    	setNumberOfUse(3);
    	setName("Glove");
    }

    /**
     * Aktivalja a kesztyu vedo hatasat a virologuson.
     * @param v Virologus, akin aktivalodik a hatas.
     */
    public void Activate(Virologist v) {      
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	ReturnAnoint ra = new ReturnAnoint(this);
    	
    	if (v.getAnointedBehaviour().getPriority() < ra.getPriority())
    		v.setAnointedBehaviour(ra);
    }

    /** 
     * A virologusrol eltunik a kesztyu hatasa.
     * @param v Virologus, akirol eltunik a kesztyu hatasa.
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
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