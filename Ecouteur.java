package ecouteur;
import fenetre.*;
import tracable.*;
import threadrna.*;
import fonction.*;
import erreur.*;

// import allfunction.*;
// import function.*;
// import accueil.*;
// import match.*;
// import java.util.*;
// import fenetre.*;
// import javax.swing.JButton; 
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.text.SimpleDateFormat;
// import java.sql.Timestamp;

public class Ecouteur implements ActionListener{
	private Fenetre f;
    ThreadRna t;
    // private String idEquipe1;
    // private String idEquipe2;
    // private String[] listeJoueur1;
    // private String[] listeJoueur2;
	
    public Ecouteur(Fenetre f,ThreadRna t){
		this.f = f;
        this.t = t;
	}

    // public Ecouteur(Fenetre f,String[] liste1, String[] liste2){
    //     this.f = f;
    //     this.listeJoueur1 = liste1;
    //     this.listeJoueur2 = liste2;
    // }

    public Ecouteur(){}

    // public String[] getlj1(){
    //     return listeJoueur1;
    // }
    
    // public String[] getlj2(){
    //     return listeJoueur2;
    // }

    // public String getidEquipe1(){
    //     return idEquipe1;
    // }

    // public String getidEquipe2(){
    //     return idEquipe2;
    // }

	public void actionPerformed(ActionEvent a){
        try{
            if(a.getSource()==f.getPiste().getDemarrer()){
                Fonction fonc = new Fonction();
                int taille = fonc.getTailleF1();
                for(int i=0; i<taille;i++){
                    int vit = Integer.parseInt(f.getPiste().getTabText()[i].getText());
                    if(vit<0) {
                        throw new VitesseException();
                    }                    
                    vit = vit/10;
                    f.getPiste().getF1()[i].setVitesse(vit);
                }
                t.play();
            }
            
        }
        catch(NumberFormatException n){
            JOptionPane.showMessageDialog(f,"Inserer des nombres sur toutes les cases vitesses");
        }
        catch(VitesseException n){
            JOptionPane.showMessageDialog(f,"Etes vous sur ?");
                        if(a.getSource()==f.getPiste().getDemarrer()){
                Fonction fonc = new Fonction();
                int taille = fonc.getTailleF1();
                for(int i=0; i<taille;i++){
                    int vit = Integer.parseInt(f.getPiste().getTabText()[i].getText());                  
                    vit = vit/10;
                    f.getPiste().getF1()[i].setVitesse(vit);
                }
                t.play();
            }
        }      
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}