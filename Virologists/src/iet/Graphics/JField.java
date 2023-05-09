package iet.Graphics;


import java.awt.Color;
import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import iet.Core.Game;
import iet.Fields.Field;

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
    	
    	/*
    	//VIROLOGUSOK
    	JPanel vs = new JPanel();
    	vs.setLayout(new BoxLayout(vs, BoxLayout.Y_AXIS));
  	
    	for (Virologist v : field.getVirologists())
    		vs.add(new JVirologist(v));
   		
    	this.add(vs);
    	
    	
    	//MEZOK
    	JPanel fs = new JPanel();
    	fs.setLayout(new BoxLayout(fs, BoxLayout.Y_AXIS));
  	
    	int size = field.GetNeighbourFieldNum();
    	for (int i=0; i< size; i++)
    		fs.add(new JNeighbourField(field.GetNeighbour(i), i));
   	
    	this.add(fs);
    	
    	
    	//GENKOD
    	if (field.getGencode()!=null)
    		this.add( new JGencode(field.getGencode()));
 
    	//ANYAG
    	if(field.getAmino()!=0 || field.getNucleotid()!= 0)
    		this.add(new JSubstance((StorageField)field));
    	
    	
    	//FELSZERELESEK
    	JPanel es = new JPanel();
    	es.setLayout(new BoxLayout(es, BoxLayout.Y_AXIS));
 	

    	for (Equipment e : field.getEquipments()) {
    		if(e.getName().equals("Axe")) {
    			es.add(new JAxe((Axe) e));
    		}
    		if(e.getName().equals("Bag")) {
    			es.add(new JBag((Bag) e));
    		}
    		if(e.getName().equals("Cape")) {
    			es.add(new JCape((Cape) e));
    		}
    		if(e.getName().equals("Glove")) {
    			es.add(new JGlove((Glove) e));
    		}	
    	}
    	this.add(es); */
    		
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