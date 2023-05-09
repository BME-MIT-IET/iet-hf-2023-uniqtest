package main.java.iet.AnointedBehaviours;

import java.io.Serializable;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Virologist;

/**
 * A felkent viselkedesi format megvalosito osztaly
 */
public abstract class AnointedBehaviour implements Serializable {

    /**
     * Prioritas. Azert van ra szukseg, mert kulonbozo effektek ugyanazon a teruleten hatasosak, es nemelyik erosebb hatasu, mint a masik
     */
    private int priority;


    /**
     * Fuggveny, ami a felkenest vegzi
     * @param by Aki felken
     * @param to Akit felkennek
     * @param with Amivel felkenik
     */
    public abstract boolean Anointed(Virologist by, Virologist to, Agent with);


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
     * determinisztikussagot kikapcsolja vagy be
     */
    public void setDet(String s) {}

}