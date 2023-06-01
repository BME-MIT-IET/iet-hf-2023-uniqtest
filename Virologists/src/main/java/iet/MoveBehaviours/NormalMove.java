package main.java.iet.MoveBehaviours;

import main.java.iet.Core.Virologist;
import main.java.iet.Fields.Field;

/**
 * A normalis mozgast megvalosito osztaly.
 */
public class NormalMove extends MoveBehaviour {

    /**
     * Default constructor
     */
    public NormalMove() {
    	setPriority(0);
    }

    /**
     * A normalis mozgas.
     * A parameterben megadott virologus a szinten parameterben megadott mezore lep.
     * @param i A szomszedos mezo sorszamat megado szam.
     * @param v A virologus, aki lep.
     */
    @Override
    public void Move(int i, Virologist v) {
        Field actualField = v.getField();
        Field nextField = actualField.GetNeighbour(i);
        actualField.RemoveVirologist(v);
        nextField.AddVirologist(v);
        v.setField(nextField);
    }
}