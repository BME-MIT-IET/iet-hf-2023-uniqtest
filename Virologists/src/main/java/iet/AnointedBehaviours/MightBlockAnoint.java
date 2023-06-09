package main.java.iet.AnointedBehaviours;

import java.security.SecureRandom;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Virologist;

/**
 * A talan blokkolo felkent viselkedesi format megvalosito osztaly
 */
public class MightBlockAnoint extends AnointedBehaviour {

    /**
     * A konstruktor beallitja a viselkedesi forma prioritasat
     */
    public MightBlockAnoint() {
    	setPriority(3);
    }

    /**
     * Fuggveny, ami a felkenest vegzi
     * @param by Aki felken
     * @param to Akit felkennek
     * @param with Amivel felkenik
     */
    public boolean Anointed(Virologist by, Virologist to, Agent with) {
    	double r;
    	if(det==1) r = 0;
    	else if(det==-1) r = 1;
    	else r = rand.nextDouble();
    	 
    	if( r <= 0.832 ) {
    			return false;
    	}
    	to.AddEffect(with);
    	return true;
    }
    
    /**
     * determinisztikussagot kikapcsolja vagy be
     */
    @Override
    public void setDet(String s) {
    	if(s.equals("on")) det = 1;
    	else if(s.equals("random")) det = 0;
    	else if(s.equals("off")) det = -1;
	}
    
    private int det = 0;
	private SecureRandom rand = new SecureRandom();
}