package tracable;

import java.awt.Color;
import java.awt.Graphics;

public class CarreGraphique extends Carre implements Tracable { 
	private int x, y; //coordonnees du centre
	private Color couleur = Color.BLACK; // couleur par défaut du carre
	
	public CarreGraphique(int cote, int x, int y) {
		super(cote);
		this.x = x;
		this.y = y;
	}

	public CarreGraphique(int cote, int x, int y, Color couleur) {
		this(cote, x, y);
		this.couleur = couleur;
	}

	public void dessiner(Graphics g) {
		int cote = getCote();
		if (cote < DIM_MAX) {
		g.setColor(couleur);
		g.fillRect(x - cote/2, y - cote/2, cote, cote);
	}
   }
}