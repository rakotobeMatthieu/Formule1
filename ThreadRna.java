package threadrna;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.Color;
import fenetre.*;
import fonction.*;
// import ecouteur.*;
// import accueil.*;
// import rempl.*;
// import java.awt.event.*;
public class ThreadRna implements Runnable{
    Fenetre f;
    Thread t;

    public void play(){
        t = new Thread(this);
        t.start();
    }

    // public void pause(){
    //     t.suspend();
    // }

    public void run(){
        int taille = f.getPiste().getF1().length;
        while(true){
            try{
                for(int i =0;i<taille;i++){
                    f.getPiste().getF1()[i].deplacer();
                }    
                
                f.getPiste().repaint();
                Thread.sleep(50);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
       
    public ThreadRna(Fenetre f){
        this.f = f;
    }     
}
