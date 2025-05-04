class Animal{
    String name;

    public Animal(String name){
        this.name = name;
    }
    public void makeSound(){
        System.out.println("The Animal Name is: " + name);
    }
}
class Dog extends Animal{
    public Dog(String name){
        super(name);
    }

    @Override
    public void makeSound(){
        System.out.println("The Dog Barks");
    }
}
public class UseOverRide{
    public static void main(String[] args) {
        Dog dog = new Dog("jimmy");
        dog.makeSound();
    }
}