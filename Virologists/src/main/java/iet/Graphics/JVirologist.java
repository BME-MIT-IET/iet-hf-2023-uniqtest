package main.java.iet.Graphics;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import main.java.iet.Core.Virologist;
import main.java.iet.Core.Game;

/**
 * virologus grafikus megjelenitesere szolgalo osztaly
 */
public class JVirologist extends JButton implements ActionListener {

    /**
     * Default constructor
     */
    public JVirologist(Virologist virologist, Boolean bear) {
    	addActionListener(this);
    	this.virologist = virologist;
		setBackground(Color.WHITE);
		if(Boolean.TRUE.equals(bear)) setIcon(new ImageIcon("icons/medve.png"));
		else setIcon(new ImageIcon("icons/virologus.png"));
    	setBorderPainted(false);
    }

    /**
     * virologus, akit megjelenitunk
     */
    private Virologist virologist;

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = Game.theGame.getGF();
		new InteractVirologist(frame, "interact with virologist", virologist);
	}

	/**
	 * @return the virologist
	 */
	public Virologist getVirologist() {
		return virologist;
	}

	/**
	 * @param virologist the virologist to set
	 */
	public void setVirologist(Virologist virologist) {
		this.virologist = virologist;
	}

}