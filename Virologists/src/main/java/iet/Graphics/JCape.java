package main.java.iet.Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Cape;

/**
 * 
 */
public class JCape extends JButton implements ActionListener {

	
    /**
     * Default constructor
     */
    public JCape(Cape cape) {
    	addActionListener(this);
    	this.cape = cape;
		setBackground(Color.WHITE);
    	setIcon(new ImageIcon("icons/kopeny.png"));
    	setBorderPainted(false);
    }

    /**
     * kopeny, amihez a gomb tartozik
     */
    private Cape cape;

    /**
     * Kattintas erkezesere a kopenyt a soron levo jatekos felveszi
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		activeVirologist.TakeEquipment(cape);
	}

	/**
	 * @return the cape
	 */
	public Cape getCape() {
		return cape;
	}

	/**
	 * @param cape the cape to set
	 */
	public void setCape(Cape cape) {
		this.cape = cape;
	}

}