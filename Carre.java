package tracable;

public class Carre {
    private int cote;

    public Carre(int cote) {
        this.cote = cote;
    }

    public int getCote() {
        return cote;
    }

    public int surface() {
        return cote*cote;
    }
}