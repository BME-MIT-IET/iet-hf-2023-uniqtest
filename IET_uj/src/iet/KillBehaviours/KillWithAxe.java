package iet.KillBehaviours;

import java.io.Serializable;

import iet.Core.Virologist;
import iet.Equipments.Axe;

public class KillWithAxe implements KillBehaviour, Serializable {
	
	/**
	 * a fejsze, amivel olnek
	 */
	private Axe axe;
	
	/**
	 * Beallitja a fejszet
	 * @param a fejsze, amivel olnek
	 */
	public KillWithAxe(Axe a) {
		setAxe(a);
	}

	/**
	 * gyilkossagi kiserlet (itt sikeres, fejsze eltorik es hatasa megszunik)
	 * @param v1 gyilkolo
	 * @param v2 gyilkolando
	 */
	public void Kill(Virologist v1, Virologist v2) { 
		if (v2.UseDie(v1)) {
			axe.setNumberOfUse(axe.getNumberOfUse()-1);
			if (axe.getNumberOfUse()==0)
				axe.Deactivate(v1);
		}	
	}

	/**
	 * @return the axe
	 */
	public Axe getAxe() {
		return axe;
	}

	/**
	 * @param axe the axe to set
	 */
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

}
