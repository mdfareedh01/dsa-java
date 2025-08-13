package linkedlist;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new TestLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        list.reverse();
        System.out.println(list.getKthNode(1));
    }

}
