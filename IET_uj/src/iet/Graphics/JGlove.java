package iet.Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import iet.Core.Game;
import iet.Core.Virologist;
import iet.Equipments.Glove;

/**
 * 
 */
public class JGlove extends JButton implements ActionListener {

	
    /**
     * Default constructor
     */
    public JGlove(Glove glove) {
    	addActionListener(this);
    	this.glove = glove;
		setBackground(Color.WHITE);
    	setIcon(new ImageIcon("icons/kesztyu.png"));
    	setBorderPainted(false);
    }

    /**
     * a kesztyu, amit megjelenit
     */
    private Glove glove;

    /**
     * Kattintas erkezesere a kesztyut a soron levo jatekos felveszi
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		activeVirologist.TakeEquipment(glove);
	}

	/**
	 * @return the glove
	 */
	public Glove getGlove() {
		return glove;
	}

	/**
	 * @param glove the glove to set
	 */
	public void setGlove(Glove glove) {
		this.glove = glove;
	}

}