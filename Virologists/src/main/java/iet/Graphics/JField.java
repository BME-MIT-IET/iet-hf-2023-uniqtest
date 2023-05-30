package main.java.iet.Graphics;


import java.awt.Color;
import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.java.iet.Core.Game;
import main.java.iet.Fields.Field;

/**
 * mezo panel
 */
public class JField extends JPanel {

    /**
     * Default constructor
     */
    public JField(Field field) {
    	this.field =field;
    	this.setBackground(Color.WHITE);
    	this.setLayout(new FlowLayout());
    	ArrayList<JButton> items = field.getJItems();
    	for (JButton jb : items) {
    		this.add(jb);
    	}
    }

    /**
     * a mezo, amit mutat
     */
    private Field field;



    /**
     * ujratolti a mezon levo dolgokat valtozas utan
     */
    public void Refresh() {
    	this.removeAll();
        field = Game.theGame.getActiveVirologist().getField();
        ArrayList<JButton> items = field.getJItems();
    	for (JButton jb : items) {
    		this.add(jb);
    	}
    	this.repaint();
    }


	/**
	 * @return the field
	 */
	public Field getField() {
		return field;
	}



	/**
	 * @param field the field to set
	 */
	public void setField(Field field) {
		this.field = field;
	}


	

}