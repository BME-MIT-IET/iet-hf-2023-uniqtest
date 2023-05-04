package MoveBehaviours;

import java.util.Random;

import Core.Virologist;
import Fields.Field;

/**
 * A kiszamithatatlan mozgast megvalosito osztaly.
 */
public class DanceMove extends MoveBehaviour {

    /**
     * Default constructor
     */
    public DanceMove() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	setPriority(1);
    }

    /**
     * A megadott virologus nem a megadott, hanem egy random szomszedos mezore lep.
     * @param i A szomszedos mezo sorszamat megado szam.
     * @param v A virologus, aki lep.
     */
    public void Move(int i, Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    	
        Field actualField = v.getField();
        int neighboursNumber = actualField.GetNeighbourFieldNum();        
        Random random = new Random();
        Field nextField = actualField.GetNeighbour(random.nextInt(neighboursNumber));
        actualField.RemoveVirologist(v);
        nextField.AddVirologist(v);
        v.setField(nextField);
    }

}