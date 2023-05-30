package main.java.iet.VirologistBehaviours;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;

import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Equipment;

/**
 * A virologus normal viselkedesi formajat megvalosito osztaly.
 */
public class Normal implements VirologistBehaviour, Serializable {

    /**
     * Default constructor
     */
    public Normal() {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    }

    /** 
     * Visszater anelkul, hogy eltavolitana a felszerelest a virologustol.
     * @param e A felszereles, amit torolni kell.
     * @param v1 Aki elveszi a felszerelest.
     * @param v2 Akitol torolni kene a felszerelest.
     */
    public void RemoveEquipment(Equipment e, Virologist v1, Virologist v2) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
    }

    /**
     * Visszater anelkul, hogy eltavolitana anyagot a virologustol.
     * @param a Lopni kivant amino mennyiseg.
     * @param n Lopni kivant nucleotid mennyiseg.
     * @param v Virologus, akitol lopni kivan valaki.
     */
    public void RemoveSubstance(int a, int n, Virologist v) {
    	//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    	//System.out.println("Method name: "+ stackTraceElements[1]+ "   Called by: "  + stackTraceElements[2]);
        
    }

    /**
     * Kezeli az adott virologus koret es az EndTurn gomb lenyomasat
     * @param v a virologus, akinek a kore tart, az EndTurn gomb lenyomasaig
     */
    public void YourTurn(Virologist v) {
    	EndButton eb = new EndButton();
    	v.getGame().getGF().getInfoPanel().add(eb);
    	eb.setBackground(v.getGame().getGF().getInfoPanel().getBackground());
    	v.getGame().RefreshFrame();
    	while (!eb.ended) {
    		try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
    	}
    	v.getGame().getGF().getInfoPanel().remove(eb);
    	
    }

    /**
     * Az EndTurn gomb esemenyeit kezeli
     */
    private class EndButton extends JButton implements ActionListener {
    	boolean ended;

        /**
         * EndTurn gomb konstruktora
         */
    	public EndButton() {
    		super("End Turn");  
    		ended = false;
    		this.addActionListener(this);
    		}
    	
        /**
         * Ha a jatekos befejezte cselekveseit, akkor allitodik
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			ended=true;
		}
    	
    }

}