package main.java.iet.AnointedBehaviours;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Virologist;

/**
 * A blokkolo felkent viselkedesi format megvalosito osztaly
 */
public class BlockAnoint extends AnointedBehaviour {

    /**
     * A konstruktor beallitja a viselkedesi forma prioritasat
     */
    public BlockAnoint() {
    	setPriority(4);
    }

    /**
     * Fuggveny, ami a felkenest vegzi
     * @param by Aki felken
     * @param to Akit felkennek
     * @param with Amivel felkenik
     */
    public boolean Anointed(Virologist by, Virologist to, Agent with) {
    	return false;
    }

}