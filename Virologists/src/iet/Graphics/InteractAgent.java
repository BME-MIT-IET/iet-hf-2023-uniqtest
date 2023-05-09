package iet.Graphics;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import iet.Agents.Agent;
import iet.Core.Game;
import iet.Core.Virologist;
import iet.Equipments.Equipment;


public class InteractAgent implements ActionListener{
	//a valaszto box
	private JComboBox c;
	//a kivalasztott agens
	private Agent selectedAgent;
	
    /**
     * Default constructor
     */
    public InteractAgent(JFrame frame, String frameName, Agent selectedAgent) {
    	this.selectedAgent = selectedAgent;
    	
    	JDialog d = new JDialog(frame, frameName);
    	d.setLayout(new FlowLayout());
    	
    	JLabel l = new JLabel("change virologist:");
    	d.add(l);
        d.setSize(300, 100);
        d.setLocation(200, 200);
        
        
        String s[] = options();
        c = new JComboBox<String>(s);
        d.add(c);
        
        JButton b = new JButton("do it");
        b.addActionListener(this);
        d.add(b);

        
        d.setVisible(true);    	
    }
    
    /**
     * vissza adja hogy melyik virologusokat kenhetjuk
     * @param v
     * @return
     */
    private String[] options() {
    	ArrayList<String> s = new ArrayList<>();
    	
    	Virologist activeVirologist = Game.theGame.getActiveVirologist();
    	ArrayList<Virologist> allVirologist = Game.theGame.getVirologists();
    	for (Virologist virologist : activeVirologist.getField().getVirologists()) {
    		int index = allVirologist.indexOf(virologist);
    		if (virologist != activeVirologist) s.add("Virologist " + index);
    		else s.add("Virologist " + index + " (me)");
    	}
    	
    	String[] out = new String[s.size()];
    	 
        for (int i = 0; i < s.size(); i++) {
            out[i] = s.get(i);
        }
    	return out;
    }

    /**
     * A "do it" gombra nyomva hivodik. Es a comboboxban valasztott item szerinti metodus fut le.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (c.getItemCount() > 0) {
			String selectedItem = (String)c.getSelectedItem();
			int index = Integer.parseInt((selectedItem.split(" ", 3))[1]);
			Equipment equipment = null;
			ArrayList<Virologist> allVirologist = Game.theGame.getVirologists();
			Virologist selectedVirologist = allVirologist.get(index);
			Game.theGame.getActiveVirologist().Anoint(selectedVirologist, selectedAgent);
		}
	}
}



	
