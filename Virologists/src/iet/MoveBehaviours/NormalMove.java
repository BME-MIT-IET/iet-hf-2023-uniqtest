package iet.MoveBehaviours;

import iet.Core.Virologist;
import iet.Fields.Field;

/**
 * A normalis mozgast megvalosito osztaly.
 */
public class NormalMove extends MoveBehaviour {

    /**
     * Default constructor
     */
    public NormalMove() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setPriority(0);
    }

    /**
     * A normalis mozgas.
     * A parameterben megadott virologus a szinten parameterben megadott mezore lep.
     * @param i A szomszedos mezo sorszamat megado szam.
     * @param v A virologus, aki lep.
     */
    public void Move(int i, Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        Field actualField = v.getField();
        Field nextField = actualField.GetNeighbour(i);
        actualField.RemoveVirologist(v);
        nextField.AddVirologist(v);
        v.setField(nextField);
    }
}