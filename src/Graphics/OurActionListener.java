package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Agents.Agent;
import Core.Game;
import Core.Virologist;
import Equipments.Equipment;
import Gencodes.Gencode;
import Graphics.InteractAgent;

public class OurActionListener  implements ActionListener {
	
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
        if(e.getActionCommand() == "Axe") {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Axe"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        if(e.getActionCommand() == "Bag") {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Bag"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        if(e.getActionCommand() == "Cape") {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Cape"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        if(e.getActionCommand() == "Glove") {
        	for (int i=0; i<virologist.getEquipments().size(); i++)
        		if (virologist.getEquipments().get(i).getName().equals("Glove"))
        			virologist.DropEquipment((virologist.getEquipments().get(i)));
        }
        
		//AGENTS
        InteractAgent interactAgent;
        JFrame frame = Game.theGame.getGF();
        if(e.getActionCommand() == "AlzheimerAgent") {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("AlzheimerAgent")) interactAgent = new InteractAgent(frame, "Anoint virologist", a);  //ide kene egy dialogusablak, hogy kit kenunk
        }
        if(e.getActionCommand() == "DancerAgent") {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("DancerAgent")) interactAgent = new InteractAgent(frame, "Anoint virologist", a);;  //ide kene egy dialogusablak, hogy kit kenunk
        }
        if(e.getActionCommand() == "ParalyzingAgent") {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("ParalyzingAgent")) interactAgent = new InteractAgent(frame, "Anoint virologist", a);;  //ide kene egy dialogusablak, hogy kit kenunk
        }
        if(e.getActionCommand() == "ResistanceAgent") {
        	for (Agent a : virologist.getAgents())
        		if (a.getName().equals("ResistanceAgent")) interactAgent = new InteractAgent(frame, "Anoint virologist", a);;  //ide kene egy dialogusablak, hogy kit kenunk
        }
        
        //GENCODES
        if(e.getActionCommand() == "AlzheimerGencode") {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("AlzheimerGencode"))
        			virologist.CraftAgent(g);
        }
        if(e.getActionCommand() == "DancerGencode") {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("DancerGencode"))
        			virologist.CraftAgent(g);
        }
        if(e.getActionCommand() == "ParalyzingGencode") {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("ParalyzingGencode"))
        			virologist.CraftAgent(g);
        }
        if(e.getActionCommand() == "ResistanceGencode") {
        	for (Gencode g : virologist.getGencodes())
        		if (g.getName().equals("ResistanceGencode"))
        			virologist.CraftAgent(g);
        }
	
	}

}
