package main.java.iet.Gencodes;

import main.java.iet.Agents.AlzheimerAgent;
import main.java.iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a memoriakiesest okozo agens kesziteshez szukseges alzheimer kodot megvalosito osztaly. 
 */
public class AlzheimerGencode extends Gencode {

    /**
     * Default constructor
     */
    public AlzheimerGencode() {
    	setAminoCost(4);
    	setNucleotidCost(6);
    	setName("AlzheimerGencode");
    }

    /**
     * Alzheimer kodbol alzheimer agens keszitese.
     * @param v Virologus, aki kesziti.
     * @return alzheimer agens
     */
    public AlzheimerAgent Craft(Virologist v) {
        if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
        	return new AlzheimerAgent();
        }
        	
        	
        return null;
    }
    
    public String getType() {
		return "alzCode";
	}

}