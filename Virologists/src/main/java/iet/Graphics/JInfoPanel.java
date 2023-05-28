package main.java.iet.Graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;

/**
 * panel, ahol a jatek infoi latszodnak
 */
public class JInfoPanel extends JPanel {

    /**
     * Default constructor
     */
	JLabel round;
	JLabel playnum;
	JLabel amino;
	JLabel nucleotid;
	
    public JInfoPanel() {
    	this.setBackground(Color.LIGHT_GRAY);
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
    	//ROUND
    	round = new JLabel("ROUND "+Game.theGame.GetRound());
    	this.add(round);
    	
    	
    	//PLAYER
    	ArrayList<Virologist> vs= Game.theGame.getVirologists();
    	int index = vs.indexOf(Game.theGame.getActiveVirologist());
    	playnum = new JLabel("PLAYER "+(index+1));
    	this.add(playnum);
    	
    	
    	//AMINO
    	int a =0;
    	a = Game.theGame.getActiveVirologist().getAmino();
    	amino = new JLabel("AminoAcid: "+(a));
    	this.add(amino);
    	
    	//NUCLEOTID
    	int n = 0;
    	n = Game.theGame.getActiveVirologist().getNucleotid();
    	nucleotid = new JLabel("Nucleotid: "+(n));
    	this.add(nucleotid);	
    	
    	JButton help = new JButton("?");
    	help.setBackground(getBackground());
    	help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				JLabel lab = new JLabel("<html>A jobb panelen latszodik hanyadik kor van, es hogy eppen hanyas szamu "+
										"jatekos van soron. Latszodik mag a soron levo jatekos amino es nukleotid mennyisege. "+
										"A soron levo jatekos virologusa mellett mindig megjelenik a YOU felirat. "+
										"<br><br>A felso menusorban meg lehet nezni, milyen felszereleseket gyujtott az adott virologus, "+
										"milyen kodokat tanult mar meg, es milyen agenseket keszitett. "+
										"<br><br>Egy korben a kovetkezo dolgokat lehet tenni: mezon levo dolgokat felvenni/ megtanulni, felso menuben levo dolgokat hasznalni. " +
										"Lehet kattintani egy agensre, majd egy virologusra, aki ezaltal meg fog kenodni, hacsak nincs valamije, ami megvedeni."+
										" Fontos, hogy minden korben csak egyszer lehet mezot valtani, a kor veget az EndTurn gombbal lehet jelezni. "+
										"<br>A rozsaszin mezok a szomszedos mezok, atlepeshez ra kell kattintani. (Egy kis segitseg az atlathatosaghoz: ST=storage, SH=shelter, F=(normal) field, L=lab, T=trap, de ezt nem tudni, mert vakok a virologusok.)" +
										"<br>Ha medveve valtozol, akkor is lehet felszedni felszereleseket, de csak azert, hogy elvedd masok elol, hasznalni nem tudod. " +
										"Medvenel is kell szomszedos mezore kattintani, ha el szeretnel lepni, azonban mindegy melyikre kattintasz, veletlenszeruen fog valamelyikre lepni." +
										"(Tancvirus hatasa alatt szinten.)" +
										"<br><br>Az ikonok: <br> feherkopenyes ember: virologus <br>medve: medveve valt virologus <br>kemcsovek: amino es nukleotid" +
										"<br>zsak/kopeny/kesztyu/balta: felszerelesek <br>DNS: genetikai kod<br><br>" +
										"Ha a listadban felul rakattintasz egy felszerelesre, azt ledobod a mezore. " +
										"Amennyiben GenCode-ra kattintasz, olyan agenst keszul (ha van eleg amino/nukleotid), es ez megjelenik az agensek menupont alatt." +
										"agensre kattintva azt hasznalhatod valakin. " +
										"Fejszevel csak medvet lehet olni, mert a virologusok aranyosak es nem olik egymast, max megbenitjak a masikat.");
				dialog.add(lab);
				dialog.setSize(540, 550);
				dialog.setVisible(true);
			}
    		
    	});
    	this.add(help);
    	
    	this.setPreferredSize(new Dimension(150, 600));
    	
    }
    



    /**
     * frissiti a panelen levo dolgokat
     */
    public void Refresh() {
    	round.setText("ROUND: "+Game.theGame.GetRound());
    	
    	ArrayList<Virologist> vs= Game.theGame.getVirologists();
    	int index = vs.indexOf(Game.theGame.getActiveVirologist());
    	
    	playnum.setText("PLAYER: "+(index+1));
    	amino.setText("AminoAcid: "+ Game.theGame.getActiveVirologist().getAmino());
    	nucleotid.setText("Nucelotid: "+ Game.theGame.getActiveVirologist().getNucleotid());
    	
    	this.repaint();
    }

}