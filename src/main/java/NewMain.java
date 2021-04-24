/*
Cruz, James Laurence A.
Dela Cruz, Rica V.
Lenizo, Jackilyn O.
Paz, Kristel Erica D.
Sacayanan, Christian John P.
BS CpE 2-3 - Software Design

Week 5 - Laboratory Exercise
Group yourselves into 5 members. Create a POS program that apply the concepts of
OOP (Inheritance, Polymorphism, Abstraction, and Encapsulation), with the following
conditions:
    - Create a main class, 1 superclass and atleast 2 sub-class
    - Simulate a purchase of a customer
 */

/**
 *
 * @author LENIZO
 */

import java.util.ArrayList;
import java.util.Scanner;

class Display {
    // Laman ng class na to every attribute or method na may kinalaman sa pag
    // output ng text sa terminal
}

class Product {
    public String productName;
    public int productCode;
    public double itemPrice;
}

class Transaction {
    // Base class for payments, etc
    // TODO: Payments class, etc etc

    private int transactionNumber;        

    // Constructor overloads, an example of pmorphism
    public Transaction() {
        super();
    }
}

class Purchase extends Transaction {
    public double subtotal;
    public double amountPaid;
    public double amountChange;
    private final double VAT = 1.12; // multiply this to subtotal to get subtotal+12% VAT
    private ArrayList<Product> cart; // ArrayList in Java are just dynamic arrays
    
    public Purchase() {
        super();
    }

    public void addToCart(Product t_item) {
        this.cart.add(t_item);
    }

    public double getSubtotal() {
        for (int i=0; i < cart.size(); i++) {
            subtotal = subtotal + cart.get(i).itemPrice; // Get price of every item in cart
        }
        return subtotal;
    }

    public int pay(Payment t_payment) {
        // If you're wondering why this needs to return an int, pay() needs to return
        // something if ever an error occurs. i.e. return 1 if everything is OK, return 2
        // if kulang pera etc etc, that way mahahandle ng program in if ever magka problem
        if (t_payment.amount >= subtotal*VAT) {
            // Pag tama amount ng pera nung bumili, ibig sabihin proceed, else return an error code
            this.amountPaid = t_payment.amount;
            this.amountChange = t_payment.amount - subtotal*VAT;
            return 1;
        } else {
            // Hindi q na dito ilalagay yung print not enough funds keme,
            // sa UI part niyo nalang ihandle basta 2 ang return code neto pag ganun
            return 2;
        }
    }
}

class Payment {
    
    String method; // Method can be "cash", "credit", "debit", "gcash", "paymaya"
    double amount;
    String cardNumber;
    String expDate; // Ideally this should be a datetime or equivalent datatype
    String pin;
    String accountHolder;

    // Constructor overloads, an example of pmorphism
    public Payment(String t_method, double t_amount) {
        this.method = t_method;
        this.amount = t_amount;
    }

    public Payment(String t_method,
                    double t_amount,
                    String t_cardNumber,
                    String t_expDate, String t_pin, String t_accountHolder) {
        this.method = t_method;
        this.amount = t_amount;
        this.cardNumber = t_cardNumber;
        this.expDate = t_expDate;
        this.pin = t_pin;
        this.accountHolder = t_accountHolder;
    }
}

class Utils {
    // Ang laman ng utils class na to, puro mga functions na extra lang
    // Yung mga functions na feeling niyo hindi fit ilagay sa ibang class
    public static double getTotalPrice(double [] arr) {
        // Must return the total price of array of items
        return 3.14; // Change this later
    }
}

//Superclass
class Menu{
    public String name;
    public double price;
    
    public Menu(){
        super();
    }
    
    public Menu(String t_name, double t_price){
        this.name = t_name;
        this.price = t_price;
    }
}

class Pizza extends Menu{
    public String size;
    public String flavors;
    
    public Pizza(){
        super();
    }
    
    public Pizza(String size, String flavors){
        this.size = size;
        if (null != size)
            switch (size) {
            case "Regular":
                this.price = 349;
                break;
            case "Large":
                this.price = 599;
                break;
            case "Party":
                this.price = 799;
                break;
            default:
                System.out.println("Invalid option.");
        }
        if (null != flavors)
            switch (flavors) {
            case "Pepperoni":
                this.flavors = "Pepperoni";
                break;
            case "Hawaiian":
                this.flavors = "Hawaiian";
                break;
            case "4 Cheese":
                this.flavors = "4 Cheese";
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}


class Pasta extends Menu{
    public String serving;
    public String typeofPasta;
    
    public Pasta(){
        super();
    }
    
    public Pasta (String serving, String typeofPasta){
        this.serving = serving;
        if (null != serving)
            switch (serving) {
                case "Solo":
                    this.price = 99;
                    break;
                case "Pan":
                    this.price = 249;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        if (null != typeofPasta)
            switch (typeofPasta) {
                case "Spaghetti":
                    this.typeofPasta = "Spaghetti";
                    break;
                case "Carbonara":
                    this.typeofPasta = "Carbonara";
                    break;
                default:
                    System.out.println("Invalid option.");
            }
    } 
}

class Beverages extends Menu{
    public String size;
    public String drinks;
    
    public Beverages() {
        super();
    }
    
    public Beverages(String size){
        this.size  = size;
        if (null != size)
            switch (size) {
                case "Tin Can":
                    this.price = 49;
                    break;
                case "Pitcher":
                   this.price = 99;
                   break;
                default:
                    System.out.println("Invalid option.");
            }
        if (null != drinks)
            switch (drinks) {
                case "Pepsi":
                    this.drinks = "Pepsi";
                    break;
                case "Coke":
                   this.drinks = "Coke";
                   break;
                case "Sprite":
                   this.drinks = "Sprite";
                   break;
                case "Royal":
                   this.drinks = "Royal";
                   break;
                case "Root beer":
                   this.drinks = "Root beer";
                   break;
                default:
                    System.out.println("Invalid option.");
            }
    } 
}

class Chicken extends Menu {
    public String size;
    
    public Chicken(){
        super();
    }
    
    public Chicken(String size){
        this.size = size;
        if (null != size)
            switch (size) {
            case "Small Bucket":
                this.price = 299;
                break;
            case "Medium Bucket":
                this.price = 549;
                break;
            case "Large Bucket":
                this.price = 799;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}

public class NewMain {
    
      static void menu() {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t      WELCOME TO PLM PIZZAZERIA     ");
            System.out.println("\t\t\t\t        1. Menu                        ");
            System.out.println("\t\t\t\t        2. Transaction History         ");
            System.out.println("\t\t\t\t        3. Exit                        ");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void order() {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t          MENU                   ");
            System.out.println("\t\t\t\t        1. Pizza                 ");
            System.out.println("\t\t\t\t        2. Pasta                 ");
            System.out.println("\t\t\t\t        3. Chicken               ");
            System.out.println("\t\t\t\t        4. Beverage              ");
            System.out.println("\t\t\t\t        5. CANCEL                ");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

        public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int choice;
        int pick;
        int count =0;
        int trans =0;
      
do {
      menu();
      choice = input.nextInt();
      if(choice == 1){
          order();
          pick = input.nextInt();
          count=0;
          
  
      if(pick == 1){
          System.out.println("PIZZA");
          count = 0;
          trans++;
      }

      else if(pick == 2){
          System.out.println("PASTA");   
          count = 0;
          trans++;
      }

      else if(pick == 3){
          System.out.println("CHICKEN");   
          count = 0;
          trans++;
      }

      else if(pick == 4){
          System.out.println("BEVERAGE");    
          count = 0;
          trans++;
      }
      else if(pick ==5){
           count = 0;
      }
      else{
          System.out.println("Pick from Pizza, Pasta, Chicken, or Beverage only!");
          order ();
      }
  }


      else if(choice == 2){
          System.out.println("Total of transactions " + trans);
          System.exit(0);
          count = 0;
      }
      else if(choice == 3) {
          System.exit(0);
          count = 0;
      }

      else {
          System.out.println("Invalid Entry");
          System.out.println("Choose 1, 2 or 3 only!");
          menu();
          count = 0;
      }
  }
while(count == 0);
}
}
