package main.java.iet.Gencodes;

import main.java.iet.Agents.ParalyzingAgent;
import main.java.iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a benulast okozo agens kesziteshez szukseges kodot megvalosito osztaly. 
 */
public class ParalyzingGencode extends Gencode {

    /**
     * Default constructor
     */
    public ParalyzingGencode() {
    	setAminoCost(5);
    	setNucleotidCost(6);
       	setName("ParalyzingGencode");
    }

    /**
     * Kodbol benulas agenst keszit.
     * @param v Virologus, aki kesziti.
     * @return benulas agens
     */
    public ParalyzingAgent Craft(Virologist v) {

    	if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
			return new ParalyzingAgent();
    	}
    	
    	
    	return null;
    }
    
    public String getType() {
		return "parCode";
	}

}