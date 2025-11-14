package assignments ;
class Car {
    String model;
    String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.println("model ="+model);
        System.out.println("Color ="+color);
    }

    public void start() {
        System.out.println("Car started");
        System.out.println(" ");
    }

    public void stop() {
        System.out.println("Car stopped");
        System.out.println(" ");
    }
    public class car6{
    public static void main(String[] args) {
    	
    	System.out.println("Test case 1 : Car (Tesla , Red) -> output : car started ");
        Car car1 = new Car("Tesla", "Red");
        car1.start();
        
        System.out.println("Test case 2 : Car (BMW , Black) -> output : car started ");
        Car car2 = new Car("BMW", "Black");
        car2.start();
        
        System.out.println("Test case 3 : Car ( ***, Red) -> output : car started (model is empty)");
        Car car3 = new Car("", "white");
        car3.start();

        System.out.println("Test case 4 : start method not called -> output : nothing  ");
        Car car4 = new Car("Ford", "Blue");
        System.out.println(" ");

        System.out.println("Test case 5 : call stop method only -> output : car stoped  ");
        Car car5 = new Car("Tata punch", "Green");
        car5.stop();
   
    System.out.println("Bhavani Sankar M");
    System.out.println("2117240040015");
}}}