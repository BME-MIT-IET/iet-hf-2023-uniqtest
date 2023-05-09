package iet.Agents;

import java.util.HashSet;
import java.util.Set;

import iet.Core.Virologist;
import iet.Gencodes.Gencode;

/**
 * Alzheimer tipusu Agenseket megvalosito osztaly
 */
public class AlzheimerAgent extends Agent {

    /**
     * Default constructor
     */
    public AlzheimerAgent() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
		setName("AlzheimerAgent");
    }

    /**
     * Ismetlodes nelkuli tarolo azokhoz a genetikai kodokhoz, amiket "elfelejt" a virologus
     */
    private Set<Gencode> memory = new HashSet<>();

    
	/**
	 * Akivalja az agens hatasat
	 * Elmenti a parameterkent kapott virologus memoriajat, majd torli a virologus genetikai kodjait
     * @param v a virologus, akin aktivalodik a hatasa
     */
    public void Activate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	setMemory(v.getGencodes());
    	v.setGencodes(new HashSet<Gencode>());
    	setVirologist(v);
    }

	/**
	 * Dekivalja az agens hatasat
	 * Visszatolti a parameterkent kapott virologus genetikai kodjait, majd torli a memoriat
     * @param v a virologus, akin deaktivalodik a hatasa
     */
    public void Deactivate(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        for (Gencode g: memory) {
        	v.AddGencode(g);
        }
    }

	/**
	 * @return a memoriat
	 */
	public Set<Gencode> getMemory() {
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
		return memory;
	}

	/**
	 * @param beallitja a memoriat
	 */
	public void setMemory(Set<Gencode> memory) {
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
		this.memory = memory;
	}
	
	public String getId() {
 		return "AlzAg";
 	}
	
}