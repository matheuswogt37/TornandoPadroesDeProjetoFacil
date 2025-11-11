//Implementor
interface Color {
 void applyColor();
}

//ConcreteImplementors
class RedColor implements Color {
 public void applyColor() {
     System.out.println("Coloring with red color");
 }
}

class BlueColor implements Color {
 public void applyColor() {
     System.out.println("Coloring with blue color");
 }
}

class GreenColor implements Color {
	 public void applyColor() {
	     System.out.println("Coloring with green color");
	 }
	}

//Abstraction
abstract class Shape {
 protected Color color;

 public Shape(Color color) {
     this.color = color;
 }

 abstract void applyColor();
}

//RefinedAbstractions
class Circle extends Shape {
 public Circle(Color color) {
     super(color);
 }

 void applyColor() {
     System.out.print("Circle filled with ");
     color.applyColor();
 }
}

class Square extends Shape {
 public Square(Color color) {
     super(color);
 }

 void applyColor() {
     System.out.print("Square filled with ");
     color.applyColor();
 }
}

public class Main {
    public static void main(String[] args) {

        Color red = new RedColor();
        Color green = new GreenColor();

        Shape circle = new Circle(red);
        Shape square = new Square(green);

        circle.applyColor();
        square.applyColor();
    }
}