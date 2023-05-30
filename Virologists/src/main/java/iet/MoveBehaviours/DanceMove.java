package main.java.iet.MoveBehaviours;

import java.util.Random;

import main.java.iet.Core.Virologist;
import main.java.iet.Fields.Field;

/**
 * A kiszamithatatlan mozgast megvalosito osztaly.
 */
public class DanceMove extends MoveBehaviour {
    private Random random = new Random();

    /**
     * Default constructor
     */
    public DanceMove() {
    	setPriority(1);
    }

    /**
     * A megadott virologus nem a megadott, hanem egy random szomszedos mezore lep.
     * @param i A szomszedos mezo sorszamat megado szam.
     * @param v A virologus, aki lep.
     */
    public void Move(int i, Virologist v) {
        Field actualField = v.getField();
        int neighboursNumber = actualField.GetNeighbourFieldNum();        
        Field nextField = actualField.GetNeighbour(random.nextInt(neighboursNumber));
        actualField.RemoveVirologist(v);
        nextField.AddVirologist(v);
        v.setField(nextField);
    }

}