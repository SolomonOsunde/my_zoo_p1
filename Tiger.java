public class Tiger extends Mammal{

    private int numofStripes;
    public Tiger(String species, String name, MyZoo owner,int numofStripes) {
        super(species, name, owner);
        this.numofStripes = numofStripes;

    }

    public int getNumofStripes() {
        return numofStripes;
    }
}
