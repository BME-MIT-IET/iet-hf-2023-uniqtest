package iet.MoveBehaviours;

import java.io.Serializable;

import iet.Core.Virologist;
import iet.Graphics.JVirologist;

/**
 * A mozgasi viselkedesi format tartalmazo absztakt osztaly.
 */
public abstract class MoveBehaviour implements Serializable {

    /**
     * Prioritas. Azert van ra szukseg, mert kulonbozo effektek ugyanazon a teruleten hatasosak, es nemelyik erosebb hatasu, mint a masik
     */
    private int priority;

	
    /**
     * Mozgas fuggvenye
     * @param i A szomszedos mezo sorszamat megado szam.
     * @param v A virologus, aki lep.
     */
    public void Move(int i, Virologist v) {
	}

    
	/**
	 * @return a prioritast
	 */
	public int getPriority() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
		
		return priority;
	}


	/**
	 * @param beallitja a prioritast
	 */
	public void setPriority(int priority) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
		this.priority = priority;
	}
	
	/**
	 * olesi kiserlet
	 * @param v1 gyilkolasi szandeku virologus
	 * @param v2 aldozat
	 */
	public boolean Die(Virologist v1, Virologist v2) {
		return false;
	}
	
	/**
	 * virologus grafikus megjelenitese
	 * @param v virologus, akinek a gombja kell
	 * @return virologushoz keszult gomb
	 */
	public JVirologist getView(Virologist v) {
		return new JVirologist(v, false);
	}
	
}