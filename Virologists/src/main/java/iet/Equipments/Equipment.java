package main.java.iet.Equipments;

import java.io.Serializable;

import javax.swing.JButton;

import main.java.iet.Core.Effect;
import main.java.iet.Core.Virologist;

/**
 * A felszereleseket megvalosito absztrakt osztaly.
 */
public abstract class Equipment implements Effect, Serializable{

    /**
     * Default constructor
     */
    protected Equipment(Virologist v) {
    	setVirologist(v);
    }
    
    private String name;
    
    private Virologist virologist;
    
    /**
     * ideiglenes id hogy a proton barmit be lehessen kezzel allitani
     */
     String id;
     
     /**
 	 * getter
 	 * @return effectId
 	 */
 	public String getId() {
 		return id;
 	}
 	
 	/**
 	 * setter
 	 */
 	public void setId(String name) {
 		id = name;
 	}
    
    /**
	 * @return the numberOfUse
	 */
	public int getNumberOfUse() {
		return numberOfUse;
	}

	/**
	 * @param numberOfUse the numberOfUse to set
	 */
	public void setNumberOfUse(int numberOfUse) {
		this.numberOfUse = numberOfUse;
	}

	/**
	 * @return the virologist
	 */
	public Virologist getVirologist() {
		return virologist;
	}

	/**
	 * @param virologist the virologist to set
	 */
	public void setVirologist(Virologist virologist) {
		this.virologist = virologist;
	}

	/**
	 * ha meg nem hasznaljak
	 */
	private int numberOfUse = -1;
	
	public abstract JButton getView();

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