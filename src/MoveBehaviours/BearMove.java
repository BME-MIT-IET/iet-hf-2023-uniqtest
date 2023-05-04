package MoveBehaviours;

import java.util.Random;

import Agents.BearAgent;
import Core.Game;
import Core.Virologist;
import Fields.Field;
import Graphics.JVirologist;

/**
 * medve veletlenszeru mozgasat biztosito osztaly
 *
 */
public class BearMove extends MoveBehaviour {

	/**
     * Default constructor
     */
	public BearMove() {
		setPriority(2);
	}
    /**
     * A megadott virologus nem a megadott, hanem egy random szomszedos mezore lep, amin aztan vegigfertoz medveagenssel mindenkit.
     * @param i A szomszedos mezo sorszamat megado szam.
     * @param v A virologus, aki lep.
     */
	public void Move(int i, Virologist v) {
        Field actualField = v.getField();
        int neighboursNumber = actualField.GetNeighbourFieldNum();        
        Random random = new Random();
        Field nextField = actualField.GetNeighbour(random.nextInt(neighboursNumber));
        actualField.RemoveVirologist(v);
        nextField.AddVirologist(v);
        
        v.setField(nextField);
        
        for (Virologist vi : nextField.getVirologists()) {
        	if (!vi.equals(v))
        		vi.UseAnointed(v, new BearAgent());
        }
        
        nextField.setAmino(0);
        nextField.setNucleotid(0);
		
	}

	/**
	 * medve olesenek megprobalasa
	 * @param v1 gyilkolo
	 * @param v2 gyilkolando
	 */
	public boolean Die(Virologist v1, Virologist v2) { 
		v2.getGame().getVirologists().remove(v2);
		v2.getField().getVirologists().remove(v2);
		return true;
	}
	
	/**
	 * medve gombjaval ter vissza
	 */
	public JVirologist getView(Virologist v) {
		return new JVirologist(v, true);
	}
	
}
