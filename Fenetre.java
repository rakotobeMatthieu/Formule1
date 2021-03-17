package fenetre;
import tracable.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
// import java.sql.Timestamp;

public class Fenetre extends JFrame{
	
	private Piste piste;
	private int id;
	// private FenetreStat fenetreStat;
	// private Timestamp tempsdebut;
	// private FenetreAct fenetreAct;

	// public FenetreAct getfenetreAct(){
	// 	return fenetreAct;
	// }

	public int getId(){
		return id;
	}
	public void setId(int q){
		this.id = q;
	}
	public Piste getPiste(){
		return piste;
	}
	// public FenetreStat getFenetreStat(){
	// 	return fenetreStat;
	// }
	// public Timestamp getTempsDebut(){
	// 	return tempsdebut;
	// }
	// public void setFenetreStat(FenetreStat f){
	// 	this.fenetreStat = f;
	// }
	// public void setTempsDebut(Timestamp time){
	// 	this.tempsdebut = time;
	// }
	// public void setFenetreAct(FenetreAct fAct){
	// 	this.fenetreAct = fAct;
	// }
	public Fenetre(){
		this.piste = new Piste(this);
		this.setContentPane(piste);
		this.setSize(1250,700);
		this.setTitle("Formule 1");
		this.setLayout(null);
        // this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}