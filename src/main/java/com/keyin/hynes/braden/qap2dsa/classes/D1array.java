package com.keyin.hynes.braden.qap2dsa.classes;
import com.keyin.hynes.braden.qap2dsa.interfaces.Retrieve;
public final class D1array<T> implements Retrieve<T> {
    private Object[] d1array;
    private boolean success;
    private Object value;
    private String invalidIndexMessage;
    public D1array(int size) {
        this.d1array = new Object[size];
        this.success = false;
        this.invalidIndexMessage = "Invalid index.";
        for (int i = 0; i < d1array.length; i++) d1array[i] = null;
    }
    public boolean add(
        int position,
        int value
    ) {
        try {
            if (d1array[position] == null) {
                d1array[position] = value;
                System.out.println("Value successfully added.");
                this.success = true;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(invalidIndexMessage);
        }
        return success;
    }
    @Override
    public void list() {
        for (int i = 0; i < d1array.length; i++) System.out.printf("%d\n", d1array[i]);
    }
    @Override
    public boolean search(T query) {
        for (int i = 0; i < d1array.length; i++) if (d1array[i] == query) {
            System.out.printf("Position: %d", i);
            this.success = true;
        } else {
            System.err.println("Not found.");
        }
        return success;
    }
    public Object get(int position) {
        try {
            this.value = d1array[position];
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(invalidIndexMessage);
        }
        return value;
    }
    public boolean delete(int position) {
        try {
            d1array[position] = null;
            System.out.println("Value successfully deleted.");
            this.success = true;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(invalidIndexMessage);
        }
        return success;
    }
}