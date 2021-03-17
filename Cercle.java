package tracable;
public class Cercle {
    int rayon;
    public Cercle(int rayon) {
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }
   double circonference() {
        return 2 * Math.PI * rayon;
    }
}