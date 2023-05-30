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
    	setPriority(1);
    }

    /**
     * Fuggveny, ami a felkenest vegzi
     * @param by Aki felken
     * @param to Akit felkennek
     * @param with Amivel felkenik
     */
    public boolean Anointed(Virologist by, Virologist to, Agent with) {
    	to.AddEffect(with);
    	return true;
    }

}