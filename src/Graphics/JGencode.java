package Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Core.Game;
import Core.Virologist;
import Gencodes.Gencode;

/**
 * 
 */
public class JGencode extends JButton implements ActionListener {

	
    /**
     * Default constructor
     */
    public JGencode(Gencode gencode) {
    	addActionListener(this);
    	this.gencode = gencode;
		setBackground(Color.WHITE);
    	setIcon(new ImageIcon("icons/genkod.png"));
    	setBorderPainted(false);
    }

    /**
     * hozzatartozo genetikai kod
     */
    private Gencode gencode;

    /**
     * Kattintas erkezesere a genetikai kodot a soron levo jatekos megtanulja
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		activeVirologist.TakeGencode(gencode);		
	}

	/**
	 * @return the gencode
	 */
	public Gencode getGencode() {
		return gencode;
	}

	/**
	 * @param gencode the gencode to set
	 */
	public void setGencode(Gencode gencode) {
		this.gencode = gencode;
	}

}