package main.java.iet.MoveBehaviours;

import java.security.SecureRandom;

import main.java.iet.Agents.BearAgent;
import main.java.iet.Core.Virologist;
import main.java.iet.Fields.Field;
import main.java.iet.Graphics.JVirologist;

/**
 * medve veletlenszeru mozgasat biztosito osztaly
 *
 */
public class BearMove extends MoveBehaviour {
	private SecureRandom random = new SecureRandom();

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
	@Override
	public void Move(int i, Virologist v) {
        Field actualField = v.getField();
        int neighboursNumber = actualField.GetNeighbourFieldNum();        
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
	@Override
	public boolean Die(Virologist v1, Virologist v2) {
		v2.getGame().getVirologists().remove(v2);
		v2.getField().getVirologists().remove(v2);
		return true;
	}

	@Override
	/**
	 * medve gombjaval ter vissza
	 */
	public JVirologist getView(Virologist v) {
		return new JVirologist(v, true);
	}
	
}
