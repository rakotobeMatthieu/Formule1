package tracable;
public class CercleGraphique extends Cercle implements Tracable { 
    private int x, y;                   // x et y : coordonnees du centre du cercle 
    private java.awt.Color couleur;     // couleur : la couleur du cercle 

    public CercleGraphique(int rayon, int x, int y, java.awt.Color couleur) { 
        super(rayon); 
        this.x = x; 
        this.y = y; 
        this.couleur = couleur; 
    } 

    public void dessiner(java.awt.Graphics g) {
        int rayon = getRayon();
        if (rayon < DIM_MAX) { 
            g.setColor(couleur);
            g.fillOval(x - rayon, y - rayon, 2*rayon, 2*rayon); 
        } 
    } 
}