package Graphics;


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
import Core.Game;
import Core.Virologist;

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
				JLabel lab = new JLabel("<html>A jobb panelen látszódik hanyadik kör van, és hogy éppen hányas számú "+
										"játékos van soron. Látszódik még a soron lévõ játékos amino és nukleotid mennyisége. "+
										"A soron lévõ játékos virológusa mellett mindig megjelenik a YOU felirat. "+
										"<br><br>A felsõ menüsorban meg lehet nézni, milyen felszereléseket gyûjtött az adott virológus, "+
										"milyen kódokat tanult már meg, és milyen ágenseket készített. "+
										"<br><br>Egy körben a következõ dolgokat lehet tenni: mezõn lévõ dolgokat felvenni/ megtanulni, felsõ menüben lévõ dolgokat használni. " +
										"Lehet kattintani egy ágensre, majd egy virológusra, aki ezáltal meg fog kenõdni, hacsak nincs valamije, ami megvédené."+
										" Fontos, hogy minden körben csak egyszer lehet mezõt váltani, a kör végét az EndTurn gombbal lehet jelezni. "+
										"<br>A rózsaszín mezõk a szomszédos mezõk, átlépéshez rá kell kattintani. (Egy kis segítség az átláthatósághoz: ST=storage, SH=shelter, F=(normal) field, L=lab, T=trap, de ezt nem tudni, mert vakok a virológusok.)" +
										"<br>Ha medvévé változol, akkor is lehet felszedni felszereléseket, de csak azért, hogy elvedd mások elõl, használni nem tudod. " +
										"Medvénél is kell szomszédos mezõre kattintani, ha el szeretnél lépni, azonban mindegy melyikre kattintasz, véletlenszerûen fog valamelyikre lépni." +
										"(Táncvírus hatása alatt szintén.)" + 
										"<br><br>Az ikonok: <br> fehérköpenyes ember: virológus <br>medve: medvévé vált virológus <br>kémcsövek: amino és nukleotid" +
										"<br>zsák/köpeny/kesztyû/balta: felszerelések <br>DNS: genetikai kód<br><br>" +
										"Ha a listádban felül rákattintasz egy felszerelésre, azt ledobod a mezõre. " +
										"Amennyiben GenCode-ra kattintasz, olyan ágenst készül (ha van elég amino/nukleotid), és ez megjelenik az ágensek menüpont alatt." +
										"Ágensre kattintva azt használhatod valakin. " +
										"Fejszével csak medvét lehet ölni, mert a virológusok aranyosak és nem ölik egymást, max megbénítják a másikat.");
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