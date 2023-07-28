public class Lion extends Mammal{

    protected int maneLength;

    /**
     * Create an animal of the specified species and with the specified pet name.  A
     * unique identifier, computed by the static method allocateId() of the MyZoo class,
     * will be assigned to the field id.
     *
     * @param species
     * @param name
     * @param owner
     */
    public Lion(String species, String name, MyZoo owner,int maneLength) {
        super(species, name, owner);
        this.maneLength = maneLength;
    }


}
