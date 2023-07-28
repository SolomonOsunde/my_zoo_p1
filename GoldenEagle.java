public class GoldenEagle extends Bird{

    private boolean canFly;
    private boolean hasPartner;
    public GoldenEagle(String species, String name, MyZoo owner, boolean canFly, boolean hasPartner) {
        super(species, name, owner);
        this.canFly = canFly;
        this.hasPartner = hasPartner;
    }

    public boolean canFly() {
        return canFly;
    }
    public boolean hasPartner() {
        return hasPartner;
    }

    public void setPartner(boolean hasPartner) {
        this.hasPartner = hasPartner;
    }
}
