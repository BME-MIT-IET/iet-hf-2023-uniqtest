package main.java.iet.AnointedBehaviours;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Virologist;

/**
 * A normal felkent viselkedesi format megvalosito osztaly
 */
public class TakeAnoint extends AnointedBehaviour {

    /**
     * A konstruktor beallitja a viselkedesi forma prioritasat
     */
    public TakeAnoint() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	setPriority(1);
    }

    /**
     * Fuggveny, ami a felkenest vegzi
     * @param by Aki felken
     * @param to Akit felkennek
     * @param with Amivel felkenik
     */
    public boolean Anointed(Virologist by, Virologist to, Agent with) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	to.AddEffect(with);
    	return true;
    }

}