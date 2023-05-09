package main.java.iet.Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Axe;

/**
 * 
 */
public class JAxe extends JButton implements ActionListener {
	
    /**
     * Default constructor
     */
    public JAxe(Axe axe) {
    	addActionListener(this);
    	this.axe = axe;
		setBackground(Color.WHITE);
    	setIcon(new ImageIcon("icons/balta.png"));
    	setBorderPainted(false);
    }

    /**
     * hozzatartozo fejsze
     */
    private Axe axe;

    /**
     * Kattintas erkezesere a baltat a soron levo jatekos felveszi
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		activeVirologist.TakeEquipment(axe);
	}

	/**
	 * @return the axe
	 */
	public Axe getAxe() {
		return axe;
	}

	/**
	 * @param axe the axe to set
	 */
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

}