package iet.Equipments;

import iet.Core.Virologist;
import iet.Graphics.JAxe;
import iet.KillBehaviours.CantKill;
import iet.KillBehaviours.KillWithAxe;

public class Axe extends Equipment {

	/**
	 * konstruktor
	 */
	public Axe(Virologist v) {
		super(v);
		setNumberOfUse(1);
		setName("Axe");
	}
	
    /**
     * Aktivalja a kopeny hatasat a virologuson, 82.3%-os esellyel megvedi a virologust agens kenestol.
     * @param v Virologus, akin aktivalodik a kopeny hatasa.
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	if (getNumberOfUse() != 0)
    		v.setKillBehaviour(new KillWithAxe(this));
    }

    /** 
     * A virologusrol eltunik a kopeny hatasa.
     * @param v Virologus, akirol eltunik a kopeny hatasa.
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	v.setKillBehaviour(new CantKill());
    	setVirologist(null);
    }
    
    /**
     * gombot keszit a fejszehez es visszater vele
     */
    public JAxe getView() {
    	return new JAxe(this);
    }

}
