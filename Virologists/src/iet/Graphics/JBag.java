package iet.Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import iet.Core.Game;
import iet.Core.Virologist;
import iet.Equipments.Bag;

/**
 * 
 */
public class JBag extends JButton implements ActionListener {
	
	/**
     * Default constructor
     */
    public JBag(Bag bag) {
    	addActionListener(this);
    	this.bag = bag;
		setBackground(Color.WHITE);
    	setIcon(new ImageIcon("icons/zsak.png"));
    	setBorderPainted(false);
    	
    }

    /**
     * A zsak amihez a gomb tartozik.
     */
    private Bag bag;

    /**
     * Kattintas erkezesere a zsakot a soron levo jatekos felveszi
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		activeVirologist.TakeEquipment(bag);
	}

	/**
	 * @return the bag
	 */
	public Bag getBag() {
		return bag;
	}

	/**
	 * @param bag the bag to set
	 */
	public void setBag(Bag bag) {
		this.bag = bag;
	}

}