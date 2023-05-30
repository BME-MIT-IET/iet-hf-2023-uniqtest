package main.java.iet.Graphics;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import main.java.iet.Core.Game;
import main.java.iet.FileManagement.Serializer;
import main.java.iet.ProtoInterface.GameTestInterfaceCommandFunction;

/**
 * startmenu megjelenitese es kezelese
 */
public class StartMenu extends JFrame implements ActionListener {

	private SpinnerModel numOfPlayer;
	/**
	 * Start gomb es File-bol valo betoltes gombja
	 */
	private JButton startButton;
	private JButton loadButton;
	
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		loadButton = new JButton("Load from file");
		loadButton.addActionListener(this);
		numOfPlayer = new SpinnerNumberModel(3,1, 100, 1);     
		JSpinner spinner = new JSpinner(numOfPlayer);
		JLabel label = new JLabel("Jatekosok Szama:");
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(spinner);
		panel.add(startButton);
		panel.add(loadButton);
		add(panel,BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	/**
	 * Megadja keszen all-e a program a szimulaciora
	 * @return reeady
	 */
	public boolean isReady() {return ready;}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== startButton) {
			game= new Game((int)numOfPlayer.getValue());
			//game.InitGame();
			//	IDEIGLENESEN KIVEVE, AMIG NINCS KIRAJZOLAS
			GameTestInterfaceCommandFunction v = new GameTestInterfaceCommandFunction();
			v.mainInit((int)numOfPlayer.getValue(), game);
			v.playerPlace((int)numOfPlayer.getValue(), game);
			
		} else if (e.getSource()== loadButton) {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				game = new Serializer().deserialize(file.getAbsolutePath());
				if (game == null) {
					JOptionPane.showMessageDialog(this, "File is not valid");
					System.exit(0);
				}
				game.theGame.SetTheGame(game);
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