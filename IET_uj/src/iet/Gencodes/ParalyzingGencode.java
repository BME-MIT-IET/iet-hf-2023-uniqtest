package iet.Gencodes;

import iet.Agents.ParalyzingAgent;
import iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a benulast okozo agens kesziteshez szukseges kodot megvalosito osztaly. 
 */
public class ParalyzingGencode extends Gencode {

    /**
     * Default constructor
     */
    public ParalyzingGencode() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
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
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
    		ParalyzingAgent pa = new ParalyzingAgent();
    		return pa;
    	}
    	
    	
    	return null;
    }
    
    public String getType() {
		return "parCode";
	}

}