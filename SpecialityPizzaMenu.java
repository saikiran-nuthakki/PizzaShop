/*
Author: Saikiran Nuthakki
E-mail: sqn5261@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 2
Due date: 2/14/2019
File: SpecialityPizzaMenu.java
Purpose: Java application that implements an online specialty pizza shop
Compiler/IDE: IntelliJ IDEA
Operating system: Mac OS Sierra
Reference(s): Java 8 API - Oracle Documentation
//https://stackoverflow.com/questions/12524243/how-do-i-make-java-register-a-string-input-with-spaces/12524285
*/

package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class SpecialityPizzaMenu {
    static ArrayList<OrderItem> item = new ArrayList<OrderItem>();
    static Scanner check = new Scanner(System.in);
    static float total;

    public static void main(String[] args) {
        System.out.println("\nWelcome to Sike's Pizza of San Francisco!");
        System.out.println("\n*******************************************************");
        boolean boo = true;
        while (boo != false) {
            Menu();
            boo = Order();
            if (boo == false) {
                Summary();
            }
        }
        payment();
        System.out.println("\nThank you for using Sike's Pizza of San Francisco's online ordering system. Please visit us again!\n");
        System.out.println("*******************************************************");
    }

    public static void Menu() {
        System.out.println("\nSpeciality Pizza Menu");
        System.out.println("1) Meat Lovers");
        System.out.println("2) Vegetarian");
        System.out.println("3) Hawaiian");
        System.out.println("4) Mozzarella");
        System.out.println("5) BBQ Chicken");
        System.out.println("6) Exit Menu");
    }

    public static void Size() {
        System.out.println("\n*******************************************************");
        System.out.println("\nAvailable Sizes and Prices");
        System.out.println("1) 10\" Personal    - $10.00");
        System.out.println("2) 14\" Medium      - $14.50");
        System.out.println("3) 16\" Large       - $19.00");
        System.out.println("4) 18\" Extra Large - $23.50");
        System.out.println("Your choice (1-4)?");
    }

    public static boolean Order() { //Takes the order from the user
        System.out.println("Your choice (1-6)?");
        int input = check.nextInt();
        String type = getType(input);
        if (type == "")
            return false;
        Size();
        input = check.nextInt();
        int size = getSize(input);
        double  price = getPrice(size);
        int num = getQuantity(size, type);
        calculate(num, price);
        OrderItem pizza = new OrderItem(type, size, num, price);
        item.add(pizza);

        return true;
    }

    public static void payment() { //Obtains the type of payment from the user, prompting cash or card

        System.out.println("\nHow would you like to pay for your order?");
        System.out.println("(Please enter 1 for cash 2 for credit:)");
        int user = check.nextInt();
        while (user < 1 || user > 2) {
            System.out.println("Enter a valid choice either 1 or 2");
            user = check.nextInt();
        }
        if(user ==1) {
            System.out.println("\nCash payment summary: \n");
            System.out.println("Payment amount: $ " + total);
            System.out.println("\n*******************************************************");
        }else if(user == 2) {
            credit();
        }

    }



    public static void credit(){ //Obtains credit card information from user for payment method 2
        Scanner cardOwn = new Scanner(System.in);
        Scanner cardTyp = new Scanner(System.in);
        Scanner cardNum = new Scanner(System.in);
        Scanner expi = new Scanner(System.in);
        System.out.println("\nPlease enter the prompted information correctly.\n");

        System.out.println("Card holder name: ");
        String cardOwner = cardOwn.nextLine();


        System.out.println("Credit Card Type (ex. American Express): ");
        String cardType = cardTyp.nextLine();


        System.out.println("Credit Card Number (ex. 123456789102395-should be 15 numbers): ");
        long cardNumber;
        cardNumber = cardNum.nextLong();


        System.out.println("Expiration Date (ex: 11/2019): ");
        String expiration = expi.next();


        System.out.println("\n*******************************************************");
        System.out.println("Credit Card Payment Summary: \n");
        System.out.format("Payment Amount: " + "%.2f%n",total );
        System.out.println("Customer Name: " + cardOwner);
        System.out.println("Card Type: " + cardType);
        System.out.println("Credit Card Number: " + "***********" + cardNumber % 10000);
        System.out.println("Expiration Date: " + expiration);
        System.out.println("\n*******************************************************");
    }

    public static void Summary() { // Displays order summary
        System.out.println("\n****************************************************\n");
        System.out.println("Order Summary: ");
        System.out.println("Type               " + "" + "Size      " + "" + "Quantity         " + "" + "Price");
        System.out.println("----------------------------------------------------------------------------------");
        for (int x = 0; x < item.size(); x++) {
            System.out.println(item.get(x));
        }
        System.out.format("\nOrder Total: $" + "%.2f%n", total);
        System.out.print("\n");
        System.out.println("*******************************************************");
    }


    public static void calculate(int num, double price) { // Calculates the order's total price
        total += num * price;

        System.out.format("\nYour current total is $ " + "%.2f%n", total);
        System.out.println("\n*******************************************************");
    }

    public static double getPrice(int size) { // Obtains size, and returns the price of pizza
        if (size == 10)
            return 10;
        else if (size == 14)
            return 14.50;
        else if (size == 16)
            return 19.00;
        else if (size == 18)
            return 23.50;
        return 0;
    }

    public static int getQuantity(int size, String type) { // Gets the amount of pizzas
        System.out.println("\n*******************************************************");
        System.out.println("\nHow many " + type + " " + size + " inch pizzas would you like?");
        int num = check.nextInt();
        while ((num >= 1) != true) {
            System.out.println("Please enter number greater than or equal to 1");
            num = check.nextInt();
        }
        System.out.println("\n*******************************************************");
        return num;

    }

    public static String getType(int input) { // checks to see if choices are valid or not
        while ((input >= 1 && input <= 6) != true) {
            System.out.println("\n*******************************************************");
            System.out.println("Invalid choice! Choose again 1-6.");
            input = check.nextInt();
            System.out.println("\n*******************************************************");
        }
        String type;
        if (input == 1)
            return type = "Meat Lover";
        else if (input == 2)
            return type = "Vegetarian";
        else if (input == 3)
            return type = "Hawaiian";
        else if (input == 4)
            return type = "Mozzarella";
        else if (input == 5)
            return type = "BBQ Chicken";

        return type = "";

    }

    public static int getSize(int input) { // Checks to see if user input is valid
        while ((input >= 1 && input <= 4) != true) {
            System.out.println("\n*******************************************************");
            System.out.println("Invalid choice! Choose again 1-4.");
            input = check.nextInt();
            System.out.println("\n*******************************************************");
        }
        int size;
        if (input == 1)
            return size = 10;

        else if (input == 2)
            return size = 14;

        else if (input == 3)

            return size = 16;

        return size = 18;
    }
}
