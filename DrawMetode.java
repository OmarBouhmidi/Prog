
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Oppg 1.1 draw() metode burde være abstrakt fordi alle formene skal ha den,
og fordi bare konkrte former kan lage den.*/

abstract class Shape {
    public abstract void draw();

    //Oppg 3.2 skriv metoden programmet bruker for å skrive ut alle formene i listen med former.
    /*Man oppretter et interface av Observer som representerer en observator. Shape klassen inneholder
    *en liste av Observer og kjører draw() metoden for hver observatør når den skal tegne en figur.
    * */
    public static void skrivUt (List <Shape> list){
        list.forEach(shape->shape.draw());
    }
}

class Firkant extends Shape {
    @Override
    public void draw() {
        System.out.println("Tegna en firkant");
    }
}

class Sirkel extends Shape {
    @Override
    public void draw() {
        System.out.println("Tegna en sirkel");
    }
}

//Oppg 3.3 bruk composite-designmønsteret til å framstille en gruppe former som en form
class GroupShape extends Shape {
    private List<Shape> Shapes;
    public GroupShape(Shape ... shape){
        Shapes= Arrays.asList(shape);
    }
    @Override
    public void draw() {
        Shapes.forEach(shape -> shape.draw());
    }
}

//Oppg 3.4 Hvilket designmønster kan du bruke til å tegne en rammen rundt noen av formene?
// Jeg velger å bruke decorator, da kan jeg legge til en metode(som tegner rammer) under kjøretid

class RammeShape extends Shape{
    private Shape wrapper;
    public RammeShape(Shape wrapper){
        this.wrapper=wrapper;
    }

    //legger til linjeskift i draw funksjonen så det skal være tydlig at objektet er i en ramme
    @Override
    public void draw() {
        System.out.println("\n");
        wrapper.draw();
        System.out.println("\n");
    }
}

public class DrawMetode {
    public static void main(String[] args) {


        List<Shape> former= new ArrayList<>();
        former.add(new Sirkel());
        former.add(new Firkant());
        former.add(new RammeShape(new Sirkel()));
        former.add(new GroupShape(new Sirkel(),new Sirkel(), new Sirkel()));


        Shape.skrivUt(former);

    }
}
