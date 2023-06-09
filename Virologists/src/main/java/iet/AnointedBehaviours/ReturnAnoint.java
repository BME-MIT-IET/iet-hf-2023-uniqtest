package main.java.iet.AnointedBehaviours;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Glove;

/**
 * A visszadobo felkent viselkedesi format megvalosito osztaly
 */
public class ReturnAnoint extends AnointedBehaviour {
	
	private Glove glove;

    /**
     * A konstruktor beallitja a viselkedesi forma prioritasat
     */
    public ReturnAnoint(Glove g) {
    	setPriority(2);
    	setGlove(g);
    }

    /**
     * Fuggveny, ami a felkenest vegzi
     * @param by Aki felken
     * @param to Akit felkennek
     * @param with Amivel felkenik
     */
    public boolean Anointed(Virologist by, Virologist to, Agent with) {
    	if (by.equals(to)) {
    		to.AddEffect(with);
    		return true;
    	}
    	glove.setNumberOfUse(glove.getNumberOfUse()-1);
    	to.setAnointedBehaviour(new BlockAnoint());
    	by.UseAnointed(to, with);
    	to.setAnointedBehaviour(this);
    	
    	if (glove.getNumberOfUse()==0)
    		to.RemoveEquipment(glove);
    	return false;
    }

	/**
	 * @return the glove
	 */
	public Glove getGlove() {
		return glove;
	}

	/**
	 * @param glove the glove to set
	 */
	public void setGlove(Glove glove) {
		this.glove = glove;
	}

}