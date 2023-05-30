package main.java.iet.Agents;

import java.io.Serializable;

import main.java.iet.Core.Effect;
import main.java.iet.Core.Steppable;
import main.java.iet.Core.Virologist;


/**
 * Agenseket megvalosito osztaly
 */
public abstract class Agent implements Effect, Steppable, Serializable {

    /**
     * A konstruktor beallitja az agensek duration-jet
     */
    protected Agent() {
    	setDuration(3);
    }
    
    /**
     * ideiglenes id hogy a proton barmit be lehessen kezzel allitani
     */
     String id;
     
     /**
 	 * getter
 	 * @return effectId
 	 */
 	public abstract String getId();
 	
 	
    private String name;
    
    /**
     * Eddig tart az agens hatasa
     */
    protected int duration;

    /**
     * Virologus, akire fel van kenve az agens
     */
    protected Virologist virologist;

    /**
     * Lepteto fuggveny, ami minden korben csokkenti a durationt
     */
    public int Step() {
    	setDuration(duration-1);
    	if (duration == 0) {
    		virologist.RemoveEffect(this);
    	}
    	return duration;
    }

	/**Getter a duration-hoz
	 * @return a durationt
	 */
	public int getDuration() {
		return duration;
	}

	/**Setter a duration-hoz
	 * @param beallitja a durationt
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**Getter a virologushoz
	 * @return a virologust, akin van az agens hatasa
	 */
	public Virologist getVirologist() {
		return virologist;
	}

	/**Setter a virologushoz
	 * @param beallitja a virologust, akin lesz az agens hatasa
	 */
	public void setVirologist(Virologist virologist) {
		this.virologist = virologist;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}