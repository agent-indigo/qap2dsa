package com.keyin.hynes.braden.qap2dsa.classes;
import java.util.Scanner;;
public class App {
    private D2array<Integer> seats;
    private int row;
    private int column;
    private int selection;
    private String selectionPromptMessage;
    private String invalidInputMessage;
    private Scanner scanner;
    private App() {
        this.seats = new D2array<Integer>(12, 12);
        this.selection = 0;
        this.selectionPromptMessage = "\nEnter selection:\n";
        this.invalidInputMessage = "\nInvalid input.\n";
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
        App app = new App();
        try {
            app.mainMenu();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        } finally {
            if (app.scanner != null) app.scanner.close();
        }
    }
    public void mainMenu() {
        while (selection != 3) {
            System.out.println("\nMain Menu\n");
            System.out.println("1: Display seating chart");
            System.out.println("2: Reserve seat");
            System.out.println("3: Exit");
            System.out.println(selectionPromptMessage);
            try {
                this.selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1: {
                        this.selection = 0;
                        seats.list();
                        break;
                    } case 2: {
                        this.selection = 0;
                        reserveSeat();
                        break;
                    } case 3: {
                        System.exit(0);
                    } default: {
                        this.selection = 0;
                        System.err.println(invalidInputMessage);
                        break;
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                System.err.println(invalidInputMessage);
            }
        }
    }
    public void reserveSeat() {
        while (row == Integer.MIN_VALUE | column == Integer.MIN_VALUE) {
            System.out.println("\nReserve Seat\n");
            System.out.println("\nEnter row:\n");
            this.row = Integer.parseInt(scanner.nextLine());
            System.out.println("\nEnter column:\n");
            this.column = Integer.parseInt(scanner.nextLine());
            if (seats.add(row, column, 1)) {
                System.out.println("Seat successfully reserved.");
            } else {
                System.err.println("Seat already reserved.");
            }
        }
    }
}