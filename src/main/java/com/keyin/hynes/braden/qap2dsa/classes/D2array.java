package com.keyin.hynes.braden.qap2dsa.classes;
import com.keyin.hynes.braden.qap2dsa.interfaces.Retrieve;
public final class D2array<T> implements Retrieve<T> {
    private Object[][] d2array;
    private boolean success;
    private Object value;
    private String invalidIndexMessage;
    public D2array(
        int rows,
        int cols
    ) {
        this.d2array = new Object[rows][cols];
        this.success = false;
        this.invalidIndexMessage = "Invalid index.";
        for (int row = 0; row < d2array.length; row++) for(int col = 0; col < d2array[0].length; col++) d2array[row][col] = null;
    }
    public boolean add(
        int row,
        int col,
        int value
    ) {
        try {
            if (d2array[row][col] == null) {
                d2array[row][col] = value;
                System.out.println("Value successfully added.");
                this.success = true;
            } else {
                System.err.println("Cell already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(invalidIndexMessage);
        }
        return success;
    }
    @Override
    public void list() {
        for (int row = 0; row < d2array.length; row++) for (int col = 0; col < d2array[0].length; col++) System.out.println(d2array[row][col].toString());
    }
    @Override
    public boolean search(T query) {
        for (int row = 0; row < d2array.length; row++) for (int col = 0; col < d2array[0].length; col++) if (d2array[row][col] == query) {
            System.out.printf("Row   : %d\nColumn: %d", row, col);
            this.success = true;
        } else {
            System.err.println("Not found.");
        }
        return success;
    }
    public Object get(
        int row,
        int col
    ) {
        try {
            this.value = d2array[row][col];
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(invalidIndexMessage);
        }
        return value;
    }
    public boolean delete(
        int row,
        int col
    ) {
        try {
            d2array[row][col] = null;
            System.out.println("Value successfully deleted.");
            this.success = true;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println(invalidIndexMessage);
        }
        return success;
    }
}