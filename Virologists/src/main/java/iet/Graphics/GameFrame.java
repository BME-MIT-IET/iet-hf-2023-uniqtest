package main.java.iet.Graphics;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;

import main.java.iet.Core.Game;

/**
 * 
 */
public class GameFrame extends JFrame {
	
	JInfoPanel infoPanel;
	JMenuBar menuBar;
	JField field;
	Game game;
	
	

    /**
     * Default constructor
     */
    public GameFrame(Game game) {
    	super("Vilagtalan virologusok");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		this.game = game;
		infoPanel=new JInfoPanel();
		menuBar=new OurJMenuBar();
		field=new JField(game.getActiveVirologist().getField());
		setJMenuBar(menuBar);
		add(infoPanel,BorderLayout.LINE_END);
		add(field,BorderLayout.CENTER);
		this.setVisible(true);
    }




    /**
     * A jatek ablak frissitese: infopanel, menu, mezok
     */
    public void Refresh() {
    	
        infoPanel.Refresh();
        field.Refresh();
        this.repaint();
		this.setVisible(true);
    }
    
    /**
     * visszater a megjelenitendo infopanellel
     * @return JInfoPanel
     */
    public JInfoPanel getInfoPanel()  {
    	return infoPanel;
    }

}