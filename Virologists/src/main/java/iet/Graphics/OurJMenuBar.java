package main.java.iet.Graphics;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.*;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Effect;
import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Equipment;
import main.java.iet.Gencodes.Gencode;
import main.java.iet.FileManagement.Serializer;

/**
 * menubar, ahol a koron levo jatekos adatai latszodnak
 */
public class OurJMenuBar extends JMenuBar{
	
	
	JMenu equipments;
	JMenu agents;
	JMenu gencodes;
	JMenu effects;

    /**
     * Default constructor
     */
    public OurJMenuBar() {
    	setVirologist(Game.theGame.getActiveVirologist());
    	this.setBackground(Color.GRAY);
    
    	
    	
    	//SAVE
    	JMenuItem save = new JMenuItem("Save Game");
    	save.setBackground(getBackground());
    	save.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ev) {
    			Serializer s = new Serializer();
    			s.serialize(Game.theGame, "save");
    			
    			
    			//System.exit(0);
    		}
    	});
    	this.add(save);
    	
    	this.add(Box.createHorizontalGlue());
    	//EQUIPMENTS
    	equipments = new JMenu("Equipments");
    	equipments.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
            	equipments.removeAll();
            	virologist = Game.theGame.getActiveVirologist();
            	
            	JMenuItem m;
            	if(virologist.getEquipments().size()==0 || virologist.getEquipments()==null) { 
            		m = new JMenuItem("no equipments yet");
            		equipments.add(m);
            	}
            	else{ 
	            	for (Equipment e : virologist.getEquipments()) {
	            		JMenuItem mi = new JMenuItem(e.getName());
	            		mi.setActionCommand(e.getName());
	            		mi.addActionListener(new OurActionListener(virologist));
	            		equipments.add(mi);
	            	}
            	}

                equipments.revalidate();
                equipments.repaint();
                equipments.doClick();

            }

            @Override
            public void menuDeselected(MenuEvent me) {
            }

            @Override
            public void menuCanceled(MenuEvent me) {
            }
        });
    	this.add(equipments);

    	
  	
    	
    	//AGENTS
    	agents = new JMenu("Agents");
    	agents.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
            	agents.removeAll();
            	virologist = Game.theGame.getActiveVirologist();
            	
            	JMenuItem m;
            	if(virologist.getAgents().size()==0 || virologist.getAgents()==null) { 
            		m = new JMenuItem("no agents yet");
            		agents.add(m);
            	}
            	else{ 
	            	for (Agent a : virologist.getAgents()) {
	            		JMenuItem mi = new JMenuItem(a.getName());
	            		mi.setActionCommand(a.getName());
	            		mi.addActionListener(new OurActionListener(virologist));
	            		agents.add(mi);
	            	}
            	}
            	
            	agents.revalidate();
            	agents.repaint();
            	agents.doClick();
            }

            @Override
            public void menuDeselected(MenuEvent me) {
            }

            @Override
            public void menuCanceled(MenuEvent me) {
            }
        });
    	this.add(agents);
    	
    	
    	//GENCODES
    	gencodes = new JMenu("Gencodes");
    	gencodes.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
            	gencodes.removeAll();
            	virologist = Game.theGame.getActiveVirologist();
            	
            	
            	JMenuItem m;
            	if(virologist.getGencodes().size()==0 || virologist.getGencodes()==null) { 
            		m = new JMenuItem("no gencodes yet");
            		gencodes.add(m);
            	}
            	else{ 
	            	for (Gencode g : virologist.getGencodes()) {
	            		JMenuItem mi = new JMenuItem(g.getName());
	            		mi.setActionCommand(g.getName());
	            		mi.addActionListener(new OurActionListener(virologist));
	            		gencodes.add(mi);
	            	}
            	}

            	gencodes.revalidate();
            	gencodes.repaint();
            	gencodes.doClick();
            }

            @Override
            public void menuDeselected(MenuEvent me) {
            }

            @Override
            public void menuCanceled(MenuEvent me) {
            }
        });
    	this.add(gencodes);
    	
    	
    	//EFFECTS
    	effects = new JMenu("Effects");
    	effects.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
            	effects.removeAll();
            	virologist = Game.theGame.getActiveVirologist();
            	
            	
            	JMenuItem m;
            	if(virologist.getEffects().size()==0 || virologist.getEffects()==null) { 
            		m = new JMenuItem("no effects on you");
            		effects.add(m);
            	}
            	else{ 
	            	for (Effect e : virologist.getEffects()) {
	            		effects.add(new JMenuItem(e.getName()));
	            	}
            	}
            	
            	effects.revalidate();
            	effects.repaint();
            	effects.doClick();
            }

            @Override
            public void menuDeselected(MenuEvent me) {
            }

            @Override
            public void menuCanceled(MenuEvent me) {
            }
        });
    	this.add(effects);

    }

    /**
     * virologus, akinek az adatai latszodnak a menuben
     */
    private Virologist virologist;



    /**
     * a menu frissitese valtozas eseten
     */
    public void Refresh() {
    	this.repaint();
    	
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