package main.java.iet.Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Fields.Field;

/**
 * 
 */
public class JNeighbourField extends JButton implements ActionListener {

    /**
     * Default constructor
     */
    public JNeighbourField(Field field) {
    	addActionListener(this);
    	this.field = field;
		setBackground(Color.PINK);
    	this.setText("neighbourfield <" + field.getId() + ">");
    	setBorderPainted(false);
    }

    /**
     * a megjelenitendo mezo
     */
    private Field field;
    
    /**
     * mozgas szomszedos mezore
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		Virologist activeVirologist = Game.theGame.getActiveVirologist();
		int neighbourFieldNum = activeVirologist.getField().GetNeighbourFieldNum();
		for (int i = 0; i < neighbourFieldNum; i++) {
			if (activeVirologist.getField().GetNeighbour(i) == field) {
				activeVirologist.UseMove(i);
				return;
			}
		}
		
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