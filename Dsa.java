import java.util.Arrays;

public class Dsa {
    public static void main(String[] args) {
        Array Array = new Array(3);
        Array.insert(10);
        Array.insert(20);
        Array.insert(30);
        Array.insert(40);
        Array.insert(50);
        Array.print();
        Array.removeAt(2);
        Array.print();
        System.out.println(Array.indexOf(40));        
    }
}