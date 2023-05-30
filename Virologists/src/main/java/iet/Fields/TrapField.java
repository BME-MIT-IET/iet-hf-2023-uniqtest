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
    @Override
    public void AddVirologist(Virologist v) {
    	getVirologists().add(v);
    	v.UseAnointed(v, new BearAgent());
    }
}
