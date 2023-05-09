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
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setAminoCost(4);
    	setNucleotidCost(6);
    	setName("AlzheimerGencode");
    	//setType("alzCode");
    }

    /**
     * Alzheimer kodbol alzheimer agens keszitese.
     * @param v Virologus, aki kesziti.
     * @return alzheimer agens
     */
    public AlzheimerAgent Craft(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
        	AlzheimerAgent aa = new AlzheimerAgent();
        	return aa;
        }
        	
        	
        return null;
    }
    
    public String getType() {
		return "alzCode";
	}

}