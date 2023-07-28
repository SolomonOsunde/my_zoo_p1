import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * This class models a zoo.  It allows a single animal to be added to the zoo, a
 * batch of animals to be "imported" by reading data from a text file and for all
 * the animals to be listed in a terminal window.  It also ensures that all animals
 * in the zoo have a unique identifier.
 *
 * @author D.Newton
 * @version Version 1
 */
public class MyZoo
{
   // zoo identifier
   private String zooId;
   // a number used in generating a unique identifier for the next animal to be added to the zoo
   private int nextAnimalIdNumber;
   // storage for the Animal objects
   private TreeMap<String, Animal> animals;

   /**
    * Create an "empty" zoo.
    *
    * @param zooId an identifier for the zoo, at least three characters long.
    */
   public MyZoo(String zooId)
   {
      this.zooId = zooId.trim().substring(0,3).toUpperCase();
      nextAnimalIdNumber = 0;
      animals = new TreeMap<String, Animal>();
   }

   /**
    * Returns a unique identifier, for an <tt>Animal</tt> object, based on the
    * zoo identifier and the field <tt>nextAnimalIdNumber</tt> which is incremented
    * ready for next time the method is called.
    *
    * @return a unique identifier.
    */
   public String allocateId()
   {
      // increment nextAnimalIdNumber and then construct a six digit string from it
      nextAnimalIdNumber++;
      String s = Integer.toString(nextAnimalIdNumber);
      while ( s.length()<6 )
         s = "0" + s;
      return zooId + "_" +  s;
   }

   /**
    * Adds an animal to the zoo.
    *
    * @param animal the Animal object to be added.
    */
   public void addAnimal(Animal animal)
   {
      animals.put(animal.getName(), animal);

   }

   /**
    * Reads <tt>Animal</tt> data from a text file and adds them to the zoo.  The
    * format of the data is specified in the MyZoo coursework assignment.
    *
    */
   public void readDataFromFile()
   {
      int noOfAnimalsRead = 0;

      String fileName = null;
      JFrame mainWindow = new JFrame();
      // use a Filedialog to select a file to read from
      FileDialog fileDialogBox = new FileDialog(mainWindow, "Open", FileDialog.LOAD);
      fileDialogBox.setDirectory("import003.txt"); // set project folder as current folder
      fileDialogBox.setVisible(true);

      fileName = fileDialogBox.getFile();
      String directoryPath = fileDialogBox.getDirectory();

      File dataFile = new File(directoryPath, fileName);

      System.out.println("The selected file is " + fileName);

      // now need to "build" on this code to read the actual data
      if (dataFile != null) {
         try {
            FileReader fileReader = new FileReader(dataFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            boolean isFirstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
               if (isFirstLine) {
                  System.out.println(line); // Print the first line
                  isFirstLine = false;
               } else if (!line.trim().startsWith("#")) {
                  String[] parts = line.trim().split("\t");
                  if (parts.length >= 3) {
                     String species = parts[0];
                     String name = parts[1];

                     Animal animal = new Animal(species, name, this);
                     addAnimal(animal);
                  }
               }
            }

            bufferedReader.close();
         } catch (IOException e) {
            e.printStackTrace();
         }

      }


      // The following code is provided so that you have a "working" program that imports some animals
      // into the zoo when you first start.  It should be deleted and replaced.
      addAnimal( new Animal("lion", "Leo", this) );               //
      addAnimal( new Animal("tiger", "Tommy", this) );            // this
      addAnimal( new Animal("elephant", "Ollie", this) );         //
      addAnimal( new Animal("rat", "Roland", this) );             // code
      addAnimal( new Animal("reindeer", "Rudolph", this) );       //
      addAnimal( new Animal("Lion", "Lenny", this) );             // to
      addAnimal( new Animal("Elephant", "Nellie", this) );        //
      addAnimal( new Animal("tiger", "Tessa", this) );            // be
      addAnimal( new Animal("eLephant", "Hetty", this) );         //
      addAnimal( new Animal("LION", "Leslie", this) );            // replaced !
      noOfAnimalsRead = 10;                                       //

      // this next line should be retained
      System.out.println("no of animals read from file was " + noOfAnimalsRead + "\n");
   }

   /**
    * Prints out details of all animal in the zoo.
    *
    */
   public void printAllAnimals()
   {
      System.out.println("\nDetails for all animals in Zoo " + zooId);
      System.out.println(  "==================================");

      Collection<Animal> c = animals.values();
      for (Animal animal : c) {
         System.out.println(animal);
      }
   }
}