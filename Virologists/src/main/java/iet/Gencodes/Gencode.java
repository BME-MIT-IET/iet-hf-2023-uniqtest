package main.java.iet.Gencodes;

import java.io.Serializable;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Virologist;
import main.java.iet.Graphics.JGencode;

/**
 * Laborok falan levo genetikai kodokat megvalosito absztrakt osztaly.
 */
public abstract class Gencode implements Serializable {

    /**
     * Default constructor
     */
    public Gencode() {
    }
    
    private String name;
    
    /**
     * Mennyi aminoba kerul az adott kodbol agenst csinalni.
     */
    protected int aminoCost;

    /**
     * Mennyi nukleotidba kerul az adott kodbol agenst csinalni.
     */
    protected int nucleotidCost;

    /**
     * Leiras, hogy milyen tipusu agenshez valo a kod.
     */
    private String type;

    /**
     * Kodbol agens keszitese.
     * @param v Virologus, aki kesziti.
     * @return null
     */
    public Agent Craft(Virologist v) {
        
        return null;
    }

	/**
	 * Getter a aminoCost-hoz.
	 * @return aminoCost
	 */
	public int getAminoCost() {
		return aminoCost;
	}

	/**
	 * Setter a aminoCost-hoz.
	 * @param aminoCost Beallitando koltseg.
	 */
	public void setAminoCost(int aminoCost) {
		this.aminoCost = aminoCost;
	}

	/**
	 * Getter a nucleotidCost-hoz.
	 * @return nucleotidCost
	 */
	public int getNucleotidCost() {
		return nucleotidCost;
	}

	/**
	 * Setter a nucleotidCost-hoz.
	 * @param nucleotidCost Beallitando koltseg.
	 */
	public void setNucleotidCost(int nucleotidCost) {
		this.nucleotidCost = nucleotidCost;
	}

	/**
	 * Getter  type-hoz.
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter a type-hoz.
	 * @param type Beallitando tipus.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	 public JGencode getView() {
		 return new JGencode(this);
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