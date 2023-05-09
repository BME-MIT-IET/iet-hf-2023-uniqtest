package iet.Graphics;


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
import iet.Core.Game;
import iet.Core.Virologist;

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
				JLabel lab = new JLabel("<html>A jobb panelen l�tsz�dik hanyadik k�r van, �s hogy �ppen h�nyas sz�m� "+
										"j�t�kos van soron. L�tsz�dik m�g a soron l�v� j�t�kos amino �s nukleotid mennyis�ge. "+
										"A soron l�v� j�t�kos virol�gusa mellett mindig megjelenik a YOU felirat. "+
										"<br><br>A fels� men�sorban meg lehet n�zni, milyen felszerel�seket gy�jt�tt az adott virol�gus, "+
										"milyen k�dokat tanult m�r meg, �s milyen �genseket k�sz�tett. "+
										"<br><br>Egy k�rben a k�vetkez� dolgokat lehet tenni: mez�n l�v� dolgokat felvenni/ megtanulni, fels� men�ben l�v� dolgokat haszn�lni. " +
										"Lehet kattintani egy �gensre, majd egy virol�gusra, aki ez�ltal meg fog ken�dni, hacsak nincs valamije, ami megv�den�."+
										" Fontos, hogy minden k�rben csak egyszer lehet mez�t v�ltani, a k�r v�g�t az EndTurn gombbal lehet jelezni. "+
										"<br>A r�zsasz�n mez�k a szomsz�dos mez�k, �tl�p�shez r� kell kattintani. (Egy kis seg�ts�g az �tl�that�s�ghoz: ST=storage, SH=shelter, F=(normal) field, L=lab, T=trap, de ezt nem tudni, mert vakok a virol�gusok.)" +
										"<br>Ha medv�v� v�ltozol, akkor is lehet felszedni felszerel�seket, de csak az�rt, hogy elvedd m�sok el�l, haszn�lni nem tudod. " +
										"Medv�n�l is kell szomsz�dos mez�re kattintani, ha el szeretn�l l�pni, azonban mindegy melyikre kattintasz, v�letlenszer�en fog valamelyikre l�pni." +
										"(T�ncv�rus hat�sa alatt szint�n.)" + 
										"<br><br>Az ikonok: <br> feh�rk�penyes ember: virol�gus <br>medve: medv�v� v�lt virol�gus <br>k�mcs�vek: amino �s nukleotid" +
										"<br>zs�k/k�peny/keszty�/balta: felszerel�sek <br>DNS: genetikai k�d<br><br>" +
										"Ha a list�dban fel�l r�kattintasz egy felszerel�sre, azt ledobod a mez�re. " +
										"Amennyiben GenCode-ra kattintasz, olyan �genst k�sz�l (ha van el�g amino/nukleotid), �s ez megjelenik az �gensek men�pont alatt." +
										"�gensre kattintva azt haszn�lhatod valakin. " +
										"Fejsz�vel csak medv�t lehet �lni, mert a virol�gusok aranyosak �s nem �lik egym�st, max megb�n�tj�k a m�sikat.");
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