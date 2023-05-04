package Graphics;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Core.Game;
import FileManagement.Serializer;
import ProtoInterface.GameTestInterfaceCommandFunction;

/**
 * startmenu megjelenitese es kezelese
 */
public class StartMenu extends JFrame implements ActionListener {

	private SpinnerModel numOfPlayer;
	/**
	 * Start gomb es File-bol valo betoltes gombja
	 */
	private JButton start_button, load_button;
	
	private boolean ready = false;
	
	private Game game;
	
	/**
	 * Constructor
	 */
	public StartMenu() {
		super("Start menu");
		ready=false;
		setLayout(new BorderLayout());
		setSize(500,80);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		start_button = new JButton("Start");
		start_button.addActionListener(this);
		load_button = new JButton("Load from file");
		load_button.addActionListener(this);
		numOfPlayer = new SpinnerNumberModel(3,1, 100, 1);     
		JSpinner spinner = new JSpinner(numOfPlayer);
		JLabel label = new JLabel("Jatekosok Szama:");
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(spinner);
		panel.add(start_button);
		panel.add(load_button);
		add(panel,BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	/**
	 * Megadja keszen all-e a program a szimulaciora
	 * @return reeady
	 */
	public boolean isReady() {return ready;}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==start_button) {
			game= new Game((int)numOfPlayer.getValue());
			//game.InitGame();
			//	IDEIGLENESEN KIVEVE, AMIG NINCS KIRAJZOLAS
			GameTestInterfaceCommandFunction v = new GameTestInterfaceCommandFunction();
			v.Main_Init((int)numOfPlayer.getValue(), game);
			v.PlayerPlace((int)numOfPlayer.getValue(), game);
			
		} else if (e.getSource()==load_button) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				game = new Serializer().deserialize(file.getAbsolutePath());
				game.theGame.SetTheGame(game);
				if (game == null) {
					JOptionPane.showMessageDialog(this, "File is not valid");
					System.exit(0);
				}
			}
		}
		ready=true;
		this.dispose();
	}

    /**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}



}