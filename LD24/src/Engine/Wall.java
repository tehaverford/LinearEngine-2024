package Engine;

public class Wall {
    public double X;
    public double Y;
    public double X1;
    public double Y1;

    public int ID; // ID of the sector wall is in.

    public Wall(double X, double Y, double X1, double Y1, double ID) {
        this.X = X;
        this.Y = Y;
        this.X1 = X1;
        this.Y1 = Y1;
    }
}
