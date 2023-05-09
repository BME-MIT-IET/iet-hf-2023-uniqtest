package main.java.iet.Fields;

import main.java.iet.Agents.BearAgent;
import main.java.iet.Core.Virologist;

public class TrapField extends LaboratoryField{
    
	/**
     * Default constructor
     */
    public TrapField() {
    }
    
    /**
     * A parmeterben megadott virologus hozzaadasa a mezohoz.
     * @param v Hozzaadando virologus.
     */
    public void AddVirologist(Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
    	getVirologists().add(v);
    	v.UseAnointed(v, new BearAgent());
    }
}
