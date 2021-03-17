package tracable;

import fenetre.*;
import fonction.*;

public class F1 extends Cercle implements Tracable { 
    String id;
    private int x, y;                   // x et y : coordonnees du centre du cercle 
    private java.awt.Color couleur;     // couleur : la couleur du cercle 
    int vitesse, tour, tourRestant;
    String num, couleur2;
    Fenetre f;
    boolean testTour = false;

    public String getId(){
        return id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public java.awt.Color getCouleur(){
        return couleur;
    }
    public String getCouleur2(){
        return couleur2;
    }
    public int getVitesse(){
        return vitesse;
    }
    public int getTour(){
        return tour;
    }
    public int getTourRestant(){
        return tourRestant;
    }
    public String getNum(){
        return num;
    }

    public void setId(String n){
        id = n;
    }
    public void setX(int n){
        x = n;
    }
    public void setY(int n){
        y = n;
    }
    public void setCouleur(java.awt.Color n){
        couleur = n;
    }
    public void setVitesse(int n){
        vitesse = n;
    }
    public void setTour(int n){
        tour = n;
    }
    public void setTourRestant(int n){
        tourRestant = n;
    }
    public void setNum(String n){
        num = n;
    }

    public F1(Fenetre f, int rayon, int x, int y, java.awt.Color couleur,int vitesse,String id, int tour, int tourRestant, String num) { 
        super(rayon); 
        this.f = f;
        this.x = x; 
        this.y = y; 
        this.couleur = couleur; 
        this.vitesse = vitesse;
        this.id = id;
        this.tour = tour;
        this.tourRestant = tourRestant;
        this.num = num;
    } 

    public F1(int rayon, int x, int y, String couleur2,int vitesse,String id, int tour, int tourRestant, String num) { 
        super(rayon); 
        this.x = x; 
        this.y = y; 
        this.couleur2 = couleur2; 
        this.vitesse = vitesse;
        this.id = id;
        this.tour = tour;
        this.tourRestant = tourRestant;
        this.num = num;
    }

    public void dessiner(java.awt.Graphics g) {
        int rayon = getRayon();
        if (rayon < DIM_MAX) { 
            g.setColor(couleur);
            g.fillOval(x - rayon, y - rayon, 2*rayon, 2*rayon); 
        } 
    } 


    int tourTotal = 50;

    public void deplacer(){
        System.out.println("x: "+getX());
        System.out.println("y: "+getY());
        if(getX()<255 && getY()<=101){
            if(testTour == true){
                if(getY()==100 && getX()>=90 && getX()<=110){
                    Integer tour = 0, tourRestant = 0;
                    if(getNum().compareTo("25")==0){
                        tour = Integer.parseInt(f.getPiste().getTab()[3].getText());
                    } 
                     if(getNum().compareTo("13")==0){
                        tour = Integer.parseInt(f.getPiste().getTab()[9].getText());
                    }
                     if(getNum().compareTo("12")==0){
                        tour = Integer.parseInt(f.getPiste().getTab()[15].getText());
                    }
                    tour++;
                    tourRestant = tourTotal - tour;
                    String tourStr = tour.toString();
                    String tourResteStr = tourRestant.toString();
                    if(getNum().compareTo("25")==0){
                        f.getPiste().getTab()[3].setText(tourStr);
                        f.getPiste().getTab()[4].setText(tourResteStr);
                    } 
                    if(getNum().compareTo("13")==0){
                        f.getPiste().getTab()[9].setText(tourStr);
                        f.getPiste().getTab()[10].setText(tourResteStr);
                    } 
                    if(getNum().compareTo("12")==0){
                        f.getPiste().getTab()[15].setText(tourStr);
                        f.getPiste().getTab()[16].setText(tourResteStr);
                    }
                    setX(111);
                }
            }
            System.out.println("deplace1");
            setX(getX()+vitesse);
            setY(100);
        }
         if((getX()>=255 && getX()<390) && (getY()>=100 || getY()<147) && getY()!=300){
            System.out.println("deplace2");
            setX(getX()+5);
            setY(getY()+2);
            testTour = true;
        }
         if(getX()>=390 && (getY()>=148 || getY()<=169)){
            System.out.println("deplace3");
            setY(getY()+vitesse);
            setX(390);
        }
        if(getX()>=167 && getX()<=390 && getY()>=300){
            System.out.println("deplace4");
            setX(getX()-vitesse);
            setY(300);
        }
         if((getY()>=200 && getY()<=300) && (getX()<=166 && getX()>=10)){
            System.out.println("deplace5");
            setX(getX()-5);
            setY(getY()-2);
        }
        if(getY()>=102 && getY()<=300 && getX()<=50){
            System.out.println("deplace6");
            setY(getY()-vitesse);
        }

        //position
        Fonction fonc = new Fonction();
        int j = 6, k = 0, l = 0, taille3 = fonc.getTailleF1();
        int taille2 = j * taille3;
        while(j<=taille2 && k<taille3){
            f.getPiste().getTab()[j-1].setText("x: "+f.getPiste().getF1()[k].getX()+"; y: "+f.getPiste().getF1()[k].getY());
            j += 6;
            k++;
        }  
    }
}