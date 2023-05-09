package iet.Gencodes;

import iet.Agents.DancerAgent;
import iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a veletlenszeru lepest okozo agens kesziteshez szukseges vitustanc kodot megvalosito osztaly. 
 */
public class DancerGencode extends Gencode {

    /**
     * Default constructor
     */
    public DancerGencode() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setAminoCost(4);
    	setNucleotidCost(3);
       	setName("DancerGencode");
    }

    /**
     * Tancot okozo kodbol vitustancagens keszitese.
     * @param v Virologus, aki kesziti.
     * @return vitustanc agens
     */
    public DancerAgent Craft(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
    		DancerAgent da = new DancerAgent();
    		return da;
    	}
    	
    	
    	return null;
    }
    
    public String getType() {
		return "danCode";
	}
}