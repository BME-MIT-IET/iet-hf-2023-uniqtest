package main.java.iet.KillBehaviours;

import main.java.iet.Core.Virologist;

/**
 * A virologus olesi viselkedeset valosita meg (csak medvet szabad olnie)
 */
public interface KillBehaviour {
	
	/**
	 * gyilkossag megprobalasa
	 * @param v1 gyilkolo
	 * @param v2 gyilkolando
	 */
	public void Kill(Virologist v1, Virologist v2);
}
