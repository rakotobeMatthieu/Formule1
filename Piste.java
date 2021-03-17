package tracable;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.util.*;
import fenetre.*;
import ecouteur.*;
import threadrna.*;
import fonction.*;

public class Piste extends JPanel {
    Fenetre f;
    JButton demarrer;
    Tracable[] desFormes = new Tracable[365];
    F1[] f1 = new F1[3];
    Ecouteur e;
    ThreadRna threadRna;
    JLabel num, couleur, vitesse, tour, tourRestant,position;
    JLabel[] tab;
    JTextField[] tabText;

    public JLabel getPosition(){
        return position;
    }
    public JLabel[] getTab(){
        return tab;
    }
    public JTextField[] getTabText(){
        return tabText;
    }
    public Ecouteur getE(){
        return e;
    }
    public F1[] getF1(){
        return f1;
    }
    public Tracable[] getDesFormes(){
        return desFormes;
    }
    public Fenetre getF(){
        return f;
    }
    public JButton getDemarrer(){
        return demarrer;
    }

    int taille = desFormes.length;
    int tailleF1 = f1.length;

    public Piste(Fenetre f) {
        this.f = f;
        
        try{
            //piste
            int dX = 0, dY = 0, dX2 = 0, dY2 = 0;
            for (int i = 0; i<taille;i++){
                if(i>=50 && i<=75){
                    desFormes[i] = new CercleGraphique(3, 10+dX, 100+dY, Color.BLACK);
                    dX += 5;
                    dY += 2;
                }
                else if(i>75 && i<=105){
                    desFormes[i] = new CercleGraphique(3, 10+dX, 100+dY, Color.BLACK);
                    dY += 5;
                }
                else if(i>105 && i<=150){
                    desFormes[i] = new CercleGraphique(3, 10+dX, 300, Color.BLACK);
                    dX -= 5;
                }
                else if(i>150 && i<=183){
                    desFormes[i] = new CercleGraphique(3, 10+dX, 97+dY, Color.BLACK);
                    dX -= 5;
                    dY -= 2;
                }
                else if(i>183 && i<=250){
                    desFormes[i] = new CercleGraphique(3, 5, 94+dY, Color.BLACK);
                    dY -= 2;
                }
                else if(i>250 && i<=330){
                    desFormes[i] = new CercleGraphique(2, 166+dX2, 302, Color.RED);
                    dX2 -= 2;
                }
                else if(i>330 && i<=364){
                    desFormes[i] = new CercleGraphique(2, 6, 302+dY2, Color.RED);
                    dY2 -= 2;
                }
                else{
                    desFormes[i] = new CercleGraphique(3, 10+dX, 100, Color.BLACK);
                    dX += 5;
                }
            }        
            desFormes[364] = new CarreGraphique(12, 100, 100, Color.WHITE);

            // 25 max 18 20 24
            f1[0] = new F1(f,5, 100, 100, Color.GREEN,0,"F1",0,0,"25");
            f1[1] = new F1(f,5, 100, 100, Color.ORANGE,0,"F2",0,0,"13");
            f1[2] = new F1(f,5, 100, 100, Color.BLUE,0,"F3",0,0,"12");
        
            demarrer= new JButton("Demarrer");
            demarrer.setBounds(100,350,100,25);
            threadRna = new ThreadRna(f);
            e = new Ecouteur(f,threadRna);
            demarrer.addActionListener(e);
            this.add(demarrer);

            // Num, cpuleur, vitesse, tour, tour restant
            num  = new JLabel("Num");
            num.setBounds(500,75,100,25);
            add(num);

            couleur  = new JLabel("Couleur");
            couleur.setBounds(600,75,100,25);
            add(couleur);

            vitesse  = new JLabel("Vitesse");
            vitesse.setBounds(700,75,100,25);
            add(vitesse);

            tour  = new JLabel("Tours");
            tour.setBounds(800,75,100,25);
            add(tour);

            tourRestant  = new JLabel("Tours restants");
            tourRestant.setBounds(900,75,100,25);
            add(tourRestant);

            position  = new JLabel("Position");
            position.setBounds(1050,75,100,25);
            add(position);

            // contenu table
            Fonction fonc = new Fonction();
            int taille2 = fonc.getTailleF1();
            Vector<F1> listeF1 = fonc.getAllF1();
            // 8 in 1
            tab = new JLabel[24];
            tabText = new JTextField[taille2];
            int taille = tab.length;
            int n = 0, ind = 0, yTab = 0;
            
            while(n<taille && ind<taille2){
                String num = listeF1.elementAt(ind).getNum();
                String couleur = listeF1.elementAt(ind).getCouleur2().toString();
                Integer vitesse1 = listeF1.elementAt(ind).getVitesse();
                String vitesse2 = vitesse1.toString();
                Integer tour1 = listeF1.elementAt(ind).getTour();
                String tour2 = tour1.toString();
                Integer tourRestant1 = listeF1.elementAt(ind).getTourRestant();
                String tourRestant2 = tourRestant1.toString();
                // Integer x1 = listeF1.elementAt(ind).getX();
                // String x2 = x1.toString();
                // Integer y1 = listeF1.elementAt(ind).getY();
                // String y2 = y1.toString();

                tab[n]  = new JLabel(num);
                tab[n].setBounds(500,100+yTab,100,25);
                tab[n+1]  = new JLabel(couleur);
                tab[n+1].setBounds(600,100+yTab,100,25);
                
                // vitesse
                tab[n+2]  = new JLabel();
                tab[n+2].setBounds(700,100+yTab,100,25);
                tabText[ind]  = new JTextField();
                tabText[ind].setBounds(700,100+yTab,75,25);


                tab[n+3]  = new JLabel(tour2);
                tab[n+3].setBounds(800,100+yTab,100,25);
                tab[n+4]  = new JLabel("50");
                tab[n+4].setBounds(900,100+yTab,100,25);
                tab[n+5]  = new JLabel("x: "+f1[ind].getX()+"; y: "+f1[ind].getY());
                tab[n+5].setBounds(1050,100+yTab,100,25);
                
                add(tab[n]);
                add(tab[n+1]);
                // add(tab[n+2]);
                add(tab[n+3]);
                add(tab[n+4]);
                add(tab[n+5]);
                add(tabText[ind]);
                n += 6;
                ind++;
                yTab += 25;
                //nullpointer
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i<taille;i++){
            desFormes[i].dessiner(g);
        }
        for (int j = 0; j<tailleF1;j++){
            f1[j].dessiner(g);
        }
    }

    
}