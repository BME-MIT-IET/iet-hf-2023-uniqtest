package Graphics;





import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Agents.Agent;
import Core.Game;
import Core.Virologist;
import Equipments.Equipment;


/**
 * 
 */
public class InteractVirologist implements ActionListener {
	
	//a valaszto box
	private JComboBox c;
	//A virologus akire kattintav jon letre az ablak
	private Virologist selectedVirologist;
	
    /**
     * Default constructor
     */
    public InteractVirologist(JFrame frame, String frameName, Virologist selectedVirologist) {
    	this.selectedVirologist = selectedVirologist;
    	
    	JDialog d = new JDialog(frame, frameName);
    	d.setLayout(new FlowLayout());
    	
    	JLabel l = new JLabel("change from option:");
    	d.add(l);
        d.setSize(300, 100);
        d.setLocation(200, 200);
        
        
        String s[] = options(selectedVirologist);
        c = new JComboBox<String>(s);
        d.add(c);
        
        JButton b = new JButton("do it");
        b.addActionListener(this);
        d.add(b);

        
        d.setVisible(true);    	
    }
    
    /**
     * vissza adja hogy a virologusal mit csinalhatunk a panelbol kivalasztva
     * @param v
     * @return
     */
    private String[] options(Virologist v) {
    	ArrayList<String> s = new ArrayList<>();
    	s.add("Steal substance");
    	
    	ArrayList<Equipment> equipments = v.getEquipments();
    	for (Equipment e : equipments) if (e.getName().equals("Axe")) s.add("attack with " + e.getName());
    	for (Equipment e : equipments) s.add("Steal " + e.getName());
    	
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
			Equipment equipment = null;
			ArrayList<Equipment> equipments = selectedVirologist.getEquipments();
			switch (selectedItem) {
			case "Axe":
				selectedVirologist.UseKill(Game.theGame.getActiveVirologist());
				break;
			case "Steal substance":
				Game.theGame.getActiveVirologist().StealSubstance(selectedVirologist);
				break;
			case "Steal Bag":
				for (Equipment eq : equipments) if (eq.getName().equals("Bag")) equipment = eq;
				Game.theGame.getActiveVirologist().StealEquipment(selectedVirologist, equipment);
				break;
			case "Steal Axe":
				for (Equipment eq : equipments) if (eq.getName().equals("Axe")) equipment = eq;
				Game.theGame.getActiveVirologist().StealEquipment(selectedVirologist, equipment);
				break;
			case "Steal Cape":
				for (Equipment eq : equipments) if (eq.getName().equals("Cape")) equipment = eq;
				Game.theGame.getActiveVirologist().StealEquipment(selectedVirologist, equipment);
				break;
			case "Steal Glove":
				for (Equipment eq : equipments) if (eq.getName().equals("Glove")) equipment = eq;
				Game.theGame.getActiveVirologist().StealEquipment(selectedVirologist, equipment);
				break;
			}
		}
	}

	

    
    
    
    
}