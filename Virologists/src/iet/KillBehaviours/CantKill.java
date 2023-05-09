package iet.KillBehaviours;

import java.io.Serializable;

import iet.Core.Virologist;

public class CantKill implements KillBehaviour, Serializable {

	/**
	 * amikor nem medve a masik, nem szabad olni, ezert olesi kiserletnel semmi sem tortenik
	 * @param v1 gyilkossagi kiserlet tevo
	 * @param v2 a virologus, aki ellen gyilkossagi kiserletet tesznek
	 */
	public void Kill(Virologist v1, Virologist v2) {
		
	}

}
