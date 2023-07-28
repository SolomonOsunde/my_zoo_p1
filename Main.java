public class Main {
    public static void main(String[] args) {
        MyZoo zoo = new MyZoo("UI Zooo");
        zoo.printAllAnimals();
        System.out.println();
        zoo.readDataFromFile();
        zoo.printAllAnimals();
    }
}
