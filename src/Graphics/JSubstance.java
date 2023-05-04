package Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Core.Game;
import Core.Virologist;
import Fields.StorageField;

/**
 * a mezon levo anyag megjelenitese
 */
public class JSubstance extends JButton implements ActionListener{

	
    /**
     * Default constructor
     */
    public JSubstance(StorageField sf) {
    	addActionListener(this);
    	this.sf = sf;
		setBackground(Color.WHITE);
    	setIcon(new ImageIcon("icons/anyag.png"));
    	this.setText("<html> amino: " + sf.getAmino() 
    				+ "<br> nucleotid: " +sf.getNucleotid() + "<html>");
    	setBorderPainted(false);
    }

    /**
     * A mezo amin az anyag van
     */
    private StorageField sf;

    /**
     * Kattintas erkezesere az anyagot a soron levo jatekos felveszi
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		activeVirologist.TakeSubstance();
	}

	/**
	 * @return the sf (storage field)
	 */
	public StorageField getSf() {
		return sf;
	}

	/**
	 * @param sf the sf to set
	 */
	public void setSf(StorageField sf) {
		this.sf = sf;
	}

}