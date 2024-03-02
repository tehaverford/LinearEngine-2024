package Engine;

public class Sectors {
    public int ID;
    public int Index;
    public int WallCount;
    public double FloorLevel;
    public double CeilingLevel;

    public Sectors(int ID, int Index, int WallCount, double FloorLevel, double CeilingLevel) {
        this.ID = ID;
        this.Index = Index;
        this.WallCount = WallCount;
        this.FloorLevel = FloorLevel;
        this.CeilingLevel = CeilingLevel;
    }
}