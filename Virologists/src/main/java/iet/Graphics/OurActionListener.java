package main.java.iet.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JFrame;

import main.java.iet.Agents.Agent;
import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Gencodes.Gencode;

public class OurActionListener  implements ActionListener {
	private static final String ANOINT_VIROLOGIST = "Anoint virologist";

	public OurActionListener(Virologist vi) {
		virologist = vi;
	}
	
	
	private Virologist virologist;

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//EQUIPMENTS
        if(Objects.equals(e.getActionCommand(), "Axe")) {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Axe"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        if(Objects.equals(e.getActionCommand(), "Bag")) {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Bag"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        if(Objects.equals(e.getActionCommand(), "Cape")) {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Cape"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        if(Objects.equals(e.getActionCommand(), "Glove")) {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Glove"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        
		//AGENTS
        JFrame frame = Game.theGame.getGF();
        if(Objects.equals(e.getActionCommand(), "AlzheimerAgent")) {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("AlzheimerAgent")) new InteractAgent(frame, ANOINT_VIROLOGIST, a);  //ide kene egy dialogusablak, hogy kit kenunk
        }
        if(Objects.equals(e.getActionCommand(), "DancerAgent")) {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("DancerAgent")) new InteractAgent(frame, ANOINT_VIROLOGIST, a);  //ide kene egy dialogusablak, hogy kit kenunk
        }
        if(Objects.equals(e.getActionCommand(), "ParalyzingAgent")) {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("ParalyzingAgent")) new InteractAgent(frame, ANOINT_VIROLOGIST, a);  //ide kene egy dialogusablak, hogy kit kenunk
        }
        if(Objects.equals(e.getActionCommand(), "ResistanceAgent")) {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("ResistanceAgent")) new InteractAgent(frame, ANOINT_VIROLOGIST, a);  //ide kene egy dialogusablak, hogy kit kenunk
        }
        
        //GENCODES
        if(Objects.equals(e.getActionCommand(), "AlzheimerGencode")) {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("AlzheimerGencode"))
        			virologist.CraftAgent(g);
        }
        if(Objects.equals(e.getActionCommand(), "DancerGencode")) {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("DancerGencode"))
        			virologist.CraftAgent(g);
        }
        if(Objects.equals(e.getActionCommand(), "ParalyzingGencode")) {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("ParalyzingGencode"))
        			virologist.CraftAgent(g);
        }
        if(Objects.equals(e.getActionCommand(), "ResistanceGencode")) {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("ResistanceGencode"))
        			virologist.CraftAgent(g);
        }
	
	}

}
