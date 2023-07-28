/**
 * This class simulates an animal and stores the species, name and identifier.
 *
 * @author D.Newton
 * @version Version 1
 */

public class Animal
{
   // unique identifier for animal
   private String id;
   // species of animal
   private String species;
   // pet name of animal
   private String name;

   /**
    * Create an animal of the specified species and with the specified pet name.  A
    * unique identifier, computed by the static method allocateId() of the MyZoo class,
    * will be assigned to the field id.
    *
    * @param  species, a String specifying the type of animal
    * @param  name, a String specifying the pet name of the animal
    */
   public Animal(String species, String name, MyZoo owner)
   {
      id = owner.allocateId();
      this.species = species;
      this.name  = name;
   }

   /**
    * Returns the (unique) identifier for the Animal object
    *
    * @return the id of animal, as a String
    */
   public String getId()
   {
      return id;
   }

   /**
    * Returns the (pet) name for the Animal object
    *
    * @return the name of animal, as a String
    */
   public String getName()
   {
      return name;
   }

   /**
    * Returns the species of the Animal object
    *
    * @return the species of animal, as a String
    */
   public String getSpecies()
   {
      return species;
   }

   /**
    * Returns a string representation of the Animal object.
    *
    * @return   a string representation of the Animal object.
    */
   public String toString()
   {
      return id + "  " + name + ": a " + species;
   }
}