package main.java.iet.Core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A jatek idozitett dolgainak (agensek hatasanak) leteleset biztosito osztaly.
 */
public class Timer implements Serializable {

    /**
     * Default constructor
     */
    public Timer() {
    }

    /**
     * A jatek, amelyhez tartozik az idozito.
     */
    private Game game;

    /**
     * Azon objektumok listaja, amelyek megvalositjak a Steppable interfacet, es oregiteni kell oket.
     */
    private ArrayList<Steppable> steppables = new ArrayList<>();

    /**
     * A tick fuggvenyhivasra a tarolt oregbitendo objektumok oregednek.
     * Ha az elettartamuk lejar (egyenlo nulla) akkor eltavolitjuk oket a listabol.
     */
    public void Tick() {
    	ArrayList<Steppable> temp = new ArrayList<>();
        
    	for (int i = 0; i < steppables.size(); i++) {
        	int duration = steppables.get(i).Step();
        	if (duration == 0) temp.add(steppables.get(i));
        }
    	if (temp.isEmpty()) return;
        for (Steppable z : temp) {
        	this.RemoveSteppable(z);
        }
    }

    /**Adott steppable elem (agens) listahoz adasa.
     * @param s A Steppable intefeszu elem, amit listahoz akarunk adni.
     */
    public void AddSteppable(Steppable s) {
    	steppables.add(s);
    }

    /**
     * Adott steppable elem listabol valo eltavolitasa.
     * @param s A Steppable interfeszu elem, amit el szeretnenk tavolitani a listabol.
     */
    public void RemoveSteppable(Steppable s) {
    	steppables.remove(s);
    }

	/**
	 * Getter a jatekhoz, amihez tartozik a Timer.
	 * @return A jatekot, amihez a Timer tartozik.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Setter a jatekhoz, amihez tartozik a Timer.
	 * @param game A jatek, amihez adjuk az idozitot.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Getter a Steppable elemek listajahoz.
	 * @return A Steppable elemek listaja.
	 */
	public ArrayList<Steppable> getSteppables() {
		return steppables;
	}


}