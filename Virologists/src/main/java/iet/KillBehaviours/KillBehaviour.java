package main.java.iet.KillBehaviours;

import main.java.iet.Core.Virologist;

import java.io.Serializable;

/**
 * A virologus olesi viselkedeset valosita meg (csak medvet szabad olnie)
 */
public interface KillBehaviour extends Serializable {
	
	/**
	 * gyilkossag megprobalasa
	 * @param v1 gyilkolo
	 * @param v2 gyilkolando
	 */
	public void Kill(Virologist v1, Virologist v2);
}
