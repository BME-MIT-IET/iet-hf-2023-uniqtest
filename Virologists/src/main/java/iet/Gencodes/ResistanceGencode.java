package main.java.iet.Gencodes;

import main.java.iet.Agents.ResistanceAgent;
import main.java.iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a vedettseget biztosito agens kesziteshez szukseges kodot megvalosito osztaly. 
 */
public class ResistanceGencode extends Gencode {

    /**
     * Default constructor
     */
    public ResistanceGencode() {
    	setAminoCost(5);
    	setNucleotidCost(5);
       	setName("ResistanceGencode");
    }

    /**
     * Kodbol agenst vedo agenst keszit.
     * @param v Virologus, aki kesziti.
     * @return ra vedo agens
     */
    public ResistanceAgent Craft(Virologist v) {

    	if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
			return new ResistanceAgent();
    	}
    	
    	
    	return null;
    }
    
    public String getType() {
		return "resCode";
	}
    
}