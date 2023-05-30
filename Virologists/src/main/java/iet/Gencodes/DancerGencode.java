package main.java.iet.Gencodes;

import main.java.iet.Agents.DancerAgent;
import main.java.iet.Core.Virologist;

/**
 * A genetikai kodok egyik fajtajat, a veletlenszeru lepest okozo agens kesziteshez szukseges vitustanc kodot megvalosito osztaly. 
 */
public class DancerGencode extends Gencode {

    /**
     * Default constructor
     */
    public DancerGencode() {
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

    	if (v.getAmino()>=aminoCost && v.getNucleotid()>=nucleotidCost) {
        	v.setAmino(v.getAmino()-aminoCost);
        	v.setNucleotid(v.getNucleotid()-nucleotidCost);
			return new DancerAgent();
    	}
    	
    	
    	return null;
    }
    
    public String getType() {
		return "danCode";
	}
}