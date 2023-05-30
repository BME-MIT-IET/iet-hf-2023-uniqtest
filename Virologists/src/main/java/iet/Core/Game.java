package main.java.iet.Core;

import java.io.Serializable;
import java.util.ArrayList;

import main.java.iet.Fields.Field;
import main.java.iet.Fields.LaboratoryField;
import main.java.iet.Gencodes.DancerGencode;
import main.java.iet.Graphics.GameFrame;

/**
 * Az osztaly feladata a jatek menedzselese.
 * Gondoskodik a jatekosokrol, a mezokrol, a timerrol es meg sok masrol.
 */
public final class Game implements Serializable {

    /**
     * Default constructor. A megadott jatekos szammal hozzuk letre a jatekot.
     * @param = playerNumber
     */
    public Game(int playerNumber) {
    	PlayerNumber = playerNumber;
    	NooneHasWonYet=true;
    	round=1;
		Game.theGame=this;
    	movingInThisRound = false;
    }
    

    /**
     * True, ha meg senki nem gyozott.
     */
    private boolean NooneHasWonYet;

    /**
     * Megadja, hany jatekos van a jatekban.
     */
    private int PlayerNumber;
    
    /**
     * A virologusokat tartalmazo lista.
     */
    private ArrayList<Virologist> virologists = new ArrayList<>();

    /**
     * A jatekhoz tartozo idozito.
     */
    private Timer timer = new Timer();

    /**
     * A jatekpalya mezoi.
     */
    private ArrayList<Field> fields = new ArrayList<>();
    
    /**
     * Eppen soron levo Virologist
     */
    public Virologist activeVirologist;
    
    /**
     * A jatekhoz ablak.
     */
	public GameFrame gf;
    
    public static Game theGame;
    
    private int round;
    
    /**
     * Deserializalaskor a statikus változónak erteket kell adni
     */
    public static void SetTheGame(Game g) {
    	theGame = g; }
    
    /**
     * A soron levo jatekos tevevekenysegeit rogziti es szabajozza
     */
    private boolean movingInThisRound;
    

    /**
     * visszadaja hogy a virologus lepett e mar ebben a korben
     * @return
     */
    public boolean GetMovengInThisRound() { return movingInThisRound; }
    
    /**
     * beallitja hogy a virologus lepett mar ebben a korben
     * @return
     */
    public void SetMovengInThisRound() { movingInThisRound = true; }
    
    /**
     * Jatek inditasa, inicializalasa.
     */
    public void StartGame() {
    	int i =0;
    	activeVirologist=virologists.get(i);
    	gf = new GameFrame(this);
    	
    	while (NooneHasWonYet) {
    		activeVirologist=virologists.get(i++);
    		gf.Refresh();
    		activeVirologist.UseYourTurn();
    		timer.Tick();
    		if (i>=virologists.size()) {
    			i=0;
    			NextTurn();
    		}
    		movingInThisRound = false;
    	}
    }

    /**
     * Ha valaki nyert, a jatek veget er, es a nyertes neve kiirodik.
     */
    public void EndGame() {
    }

    /**
     * A jatek inicializalasa: virologusok letrehozasa, a jatek koreinek levezetese.
     */
    public void InitGame() {
    	/*
    	 * 		PALYA LETREHOZASA
    	 * 				!
    	 * 				!
    	 * 				!
    	 * 				!
    	 * 				!
    	 * 				!
    	 */
    	
    	LaboratoryField lf = new LaboratoryField(new DancerGencode());
    	
    	for (int i = 0; i < PlayerNumber; i++) {
    		new Virologist(this, lf); 
    	}
    	
    	
    	
    }

    /**
     * Ha a jatekos kore veget er, ez a fuggveny elinditja a kovetkezoet.
     */
    public void NextTurn() {
    	round++;
    	
    }

    /**
     * Hozzaadja parameterkent kapott leptetheto dolgot a timerhez.
     * @param s Leptetheto dolog.
     */
    public void AddSteppableToTimer(Steppable s) {
    	timer.AddSteppable(s);
    }

    /**
     * Ellenorzi, hogy valaki megnyerte-e a jatekot
     * @return true, ha valaki megnyeri a jatekot, azaz valakinel minden gencode megvan, false maskor
     */
    public boolean CheckWinCondition() {
        if(!NooneHasWonYet ) {
        	EndGame();
        	return true;
        }
        return false;
    }

	/**
	 * NooneHasWonYet lekerdezese.
	 * @return the nooneHasWonYet
	 */
	public boolean isNooneHasWonYet() {
		return NooneHasWonYet;
	}

	/**Setter a nooneHasWonYet-nek.
	 * @param nooneHasWonYet the nooneHasWonYet to set
	 */
	public void setNooneHasWonYet(boolean nooneHasWonYet) {
		NooneHasWonYet = nooneHasWonYet;
	}

	/**
	 * Getter a virologusokhoz.
	 * @return the virologists
	 */
	public ArrayList<Virologist> getVirologists() {
		return virologists;
	}

	/**
	 * Getter a Timerhez.
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Setter a Timer-hez.
	 * @param timer the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * Getter a jatekmezokhoz.
	 * @return the fields
	 */
	public ArrayList<Field> getFields() {
		return fields;
	}
	
	/**
	 * Add a jatekmezokhoz.
	 */
	public void AddField(Field f) {
		fields.add(f);
	}
	
	/**
	 * Add a jatekmezokhoz.
	 */
	public void AddVirologist(Virologist v) {
		virologists.add(v);
	}
	
	
	public Virologist getActiveVirologist() {
		return activeVirologist;
	}
	
	public GameFrame getGF() {
		return gf;
	}
	

    /**
     * Jatek ablak frissitese
     */
    public void RefreshFrame() {
    	gf.Refresh();
    }
    
    /**
     * getter a round-hoz
     * @return round
     */
    public int GetRound() {
    	return round;
    }
    
    
}