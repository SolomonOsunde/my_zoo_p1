public class Parrot extends Bird{
    private int iq;


    public Parrot(String species, String name, MyZoo owner,int iq) {
        super(species, name, owner);
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }
}
