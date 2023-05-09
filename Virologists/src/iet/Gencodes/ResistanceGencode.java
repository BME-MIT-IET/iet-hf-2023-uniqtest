package iet.Gencodes;

import iet.Agents.ResistanceAgent;
import iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a vedettseget biztosito agens kesziteshez szukseges kodot megvalosito osztaly. 
 */
public class ResistanceGencode extends Gencode {

    /**
     * Default constructor
     */
    public ResistanceGencode() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
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
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
    		ResistanceAgent ra = new ResistanceAgent();
    		return ra;
    	}
    	
    	
    	return null;
    }
    
    public String getType() {
		return "resCode";
	}
    
}