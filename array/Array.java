package array;

public class Array {
    private int[] elements;
    public int count = 0;

    public Array(int size) {
        elements = new int[size];
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }    

    public void insert(int value) {
        if(elements.length  == count){
            int[] newElements = new int[count * 2];
            for(int i = 0; i < count; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[count] = value;
        count++;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();
        
        for(int i = index; i < count; i++) {
            elements[i] = elements[i+1];
        }

        count--;
    }

    public int indexOf(int value) {
        for(int i = 0; i< count; i++){
            if(elements[i]==value)
                return i;
        }
        return -1;
    }
}
