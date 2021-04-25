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

class Display { // Function classes for all display related functions
    public static void menu() {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t      WELCOME TO PLM PIZZAZERIA     ");
            System.out.println("\t\t\t\t        [1] New Order                        ");
            System.out.println("\t\t\t\t        [2] Transaction History         ");
            System.out.println("\t\t\t\t        [3] Exit                        ");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void order(int t_orderNumber) {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t      ORDER NO. " + t_orderNumber);
            System.out.println("\t\t\t\t        [1] Add Food                        ");
            System.out.println("\t\t\t\t        [2] Pay and Finish Order         ");
            System.out.println("\t\t\t\t        [3] Cancel Order                        ");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public static void food() {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t          MENU                   ");
            System.out.println("\t\t\t\t        [1] Pizza                 ");
            System.out.println("\t\t\t\t        [2] Pasta                 ");
            System.out.println("\t\t\t\t        [3] Chicken               ");
            System.out.println("\t\t\t\t        [4] Beverage              ");
            System.out.println("\t\t\t\t        [5] CANCEL                ");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public static void pay() {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t          PAYMENT METHOD                   ");
            System.out.println("\t\t\t\t        [1] Cash                 ");
            System.out.println("\t\t\t\t        [2] Credit Card                 ");
            System.out.println("\t\t\t\t        [3] Debit Card               ");
            System.out.println("\t\t\t\t        [4] PayMaya              ");
            System.out.println("\t\t\t\t        [5] GCash                ");
            System.out.println("\t\t\t\t        [6] CANCEL ORDER");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void PizzaOrder() {
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t        Pizza Menu               ");
        System.out.println("\t\t\t\t        	Name			REGULAR [R]			LARGE [L]			PARTY[P]");
        System.out.println("\t\t\t\t        [1] Pepperoni        		   349				  599				  799");
        System.out.println("\t\t\t\t        [2] Hawaiian           		   349				  599				  799");
        System.out.println("\t\t\t\t        [3] 4 Cheese           		   349			 	  599				  799");
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void PastaOrder() {
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t        Pasta Menu               ");
        System.out.println("\t\t\t\t        	Name			Solo [S]			Pan [P]");
        System.out.println("\t\t\t\t        [1] Spaghetti        		   99				  249");
        System.out.println("\t\t\t\t        [2] Carbonara           	   99				  249");
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void ChickenOrder() {
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t        Bucket of Chicken Menu               ");
        System.out.println("\t\t\t\t        	Name					Price");
        System.out.println("\t\t\t\t        [1] Small Bucket       		   299");
        System.out.println("\t\t\t\t        [2] Medium Bucket	           549");
        System.out.println("\t\t\t\t        [3] Large Bucket	           799");
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public static void BeverageOrder() {
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t        Beverages Menu               ");
        System.out.println("\t\t\t\t        	Name			Tin Can [T]			Pitcher [P]");
        System.out.println("\t\t\t\t        [1] Pepsi       		   49				  99");
        System.out.println("\t\t\t\t        [2] Coke	          	   49				  99");
        System.out.println("\t\t\t\t        [3] Sprite	          	   49				  99");
        System.out.println("\t\t\t\t        [4] Royal	          	   49				  99");
        System.out.println("\t\t\t\t        [5] Root Beer         	   49				  99"); 
        System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}

class Transaction {
    // Base class for payments, etc
    // TODO: Payments class, etc etc

    private int transactionNumber;        

    // Constructor overloads, an example of pmorphism
    public Transaction(int t_transactionNumber) {
        super();
        this.transactionNumber = t_transactionNumber;
    }
}

class Purchase extends Transaction {
    private double subtotal;
    public double amountPaid;
    public double amountChange;
    private final double VAT = 1.12; // multiply this to subtotal to get subtotal+12% VAT
    private ArrayList<Menu> orderList = new ArrayList(); // ArrayList in Java are just dynamic arrays
    
    public Purchase(int t_transactionNumber) {
        super(t_transactionNumber);
    }

    public void addOrder(Menu t_item) {
        this.orderList.add(t_item);
    }

    public double getSubtotal() {
        for (int i=0; i < orderList.size(); i++) {
            subtotal = subtotal + orderList.get(i).price; // Get price of every item in orderList
        }
        return subtotal;
    }

    public double getTotal() {
        return getSubtotal() * VAT;
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
    
    private String method; // Method can be "cash", "credit", "debit", "gcash", "paymaya"
    double amount;
    private String cardNumber;
    private String pin;
    private String accountHolder;

    // Constructor overloads, an example of pmorphism
    public Payment(String t_method, double t_amount) {
        this.method = t_method;
        this.amount = t_amount;
    }

    public Payment(String t_method,
                    double t_amount,
                    String t_cardNumber,
                    String t_pin,
                    String t_accountHolder) {
        this.method = t_method;
        this.amount = t_amount;
        this.cardNumber = t_cardNumber;
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
          case "R"://regular
                this.price = 349;
                break;
          case "L"://large
                this.price = 599;
                break;
          case "P"://party
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
  public double getPizzaPrice () {
	  return price;
}
  public String getFlavor() {
	  return flavors;
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
              case "S": //solo
                    this.price = 99;
                    break;
              case "P": //pan
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
  public double getPastaPrice () {
	  return price;
}
  public String getPasta() {
	  return typeofPasta;
  }
}

class Beverage extends Menu{
    public String size;
    public String drinks;
    
    public Beverage() {
        super();
    }
    
  public Beverage(String size, String drinks){
        this.size  = size;
        if (null != size)
            switch (size) {
              case "T": //tin can
                    this.price = 49;
                    break;
              case "P"://pitcher
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
                 this.drinks = "RootBeer";
                   break;
                default:
                    System.out.println("Invalid option.");
            }
    } 
  public double getBeveragePrice () {
	  return price;
}
  public String getDrinks() {
	  return drinks;
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
          case "SmallBucket":
                this.price = 299;
                break;
          case "MediumBucket":
                this.price = 549;
                break;
          case "LargeBucket":
                this.price = 799;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    public double getChickenPrice () {
	  return price;
    }
}

public class NewMain {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menuChoice;
        int orderChoice;
        int foodChoice;
        int paymentChoice;
        int count =0;
        int trans =0;
        int qty = 0;
        double totalAmt1 = 0.0;
        double totalAmt2 = 0.0;
        double totalAmt3 = 0.0;
        double totalAmt4 = 0.0;
        String pizzaSize;
        String pastaServing;
        String drinkSize;
        String pizzaFlavor;
        String pastaType;
        String bucketPlan;
        String DrinkNum;
        
        boolean exit = false; // Exit flag, if true, get out of loop
        while (!exit) {
            Display.menu(); // Display main menu
            System.out.print("\t\t\t\t\tYour Input:" );
            menuChoice = input.nextInt();
            if(menuChoice == 1){
                boolean exitOrder = false;
                while (!exitOrder) {
                    Purchase currentPurchase = new Purchase(1); // TODO: Make util function that generates trans numbers
                    Display.order(1);
                    System.out.println("\t\t\t\t\tYour Input:");
                    orderChoice = input.nextInt();
                    if (orderChoice == 1) {
                        Display.food();
                        System.out.print("\t\t\t\t\tYour Input:");
                        foodChoice = input.nextInt();
                        count = 0;
                        if(foodChoice == 1) {
                            Display.PizzaOrder();
                            Pizza pizzaPurchase = new Pizza();
                            System.out.println("\n\t\t\t\t\tSelect Flavor" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: Pepperoni - for Pepperoni ; Hawaiian - for Hawaiian; 4Cheese - for 4 Cheese");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            pizzaPurchase.flavors =input.next();    
                            System.out.println("\n\t\t\t\t\tSelect Size" );
                            System.out.println("\t\t\t\t\tInputs should be: R - for regular ; L - for Large; P - for Party" );
                            System.out.println("\t\t\t\t\tYour Input:" );
                            pizzaPurchase.size = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qty = input.nextInt(); // TODO handle quantities
        //                    totalAmt1 = pz.getPizzaPrice() * qty; // and prices
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ pz.getFlavor()+" Pizza x"+ qty + " for "+ totalAmt1);
                            currentPurchase.addOrder(pizzaPurchase);
                            count = 0;
                            trans++;
                        } else if(foodChoice == 2) {
                            Display.PastaOrder();
                            Pasta pastaPurchase = new Pasta();
                            System.out.println("\n\t\t\t\t\tSelect Type of Pasta" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: Spagehetti - for Spaghetti ; Carbonara - for Carbonara");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            pastaPurchase.typeofPasta = input.next();
                            System.out.println("\n\t\t\t\t\tEnter Serving" );
                            System.out.println("\t\t\t\t\tInputs should be: S - for solo ; P - for Pan" );
                            System.out.println("\t\t\t\t\tYour Input:" );
                            pastaPurchase.serving = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qty = input.nextInt();
        //                    totalAmt2 = ps.getPastaPrice() * qty;
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ ps.getPasta()+" x"+ qty + " for "+ totalAmt2);
                            currentPurchase.addOrder(pastaPurchase);
                            count = 0;
                            trans++;
                        } else if(foodChoice == 3) {
                            Display.ChickenOrder();
                            Chicken chickenPurchase = new Chicken();
                            System.out.println("\n\t\t\t\t\tSelect Bucket Plan" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: SmallBucket - for Small Bucket ; MediumBucket - for Medium Bucket; LargeBucket - for Large Bucket");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            chickenPurchase.size = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qty = input.nextInt();
        //                    totalAmt4 = ck.getChickenPrice() * qty;
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ qty +" BucketPlan"+ ck.getChickenPrice()+ " each for "+ totalAmt4);
                            currentPurchase.addOrder(chickenPurchase);
                            count = 0;
                            trans++;
                        } else if(foodChoice == 4) {
                            Display.BeverageOrder();
                            Beverage beveragePurchase = new Beverage();
                            System.out.println("\n\t\t\t\t\tSelect Drink" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: 1 - for Pepsi ; 2 - for Coke; 3 - for Sprite; 4 - for Royal; 5 - for Root Beer");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            beveragePurchase.drinks = input.next();
                            System.out.println("\n\t\t\t\t\tEnter Size" );
                            System.out.println("\t\t\t\t\tInputs should be: T - for Tin Can ; P - for Pitcher" );
                            System.out.println("\t\t\t\t\tYour Input:" );
                            beveragePurchase.size = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qty = input.nextInt();
        //                    totalAmt4 = bv.getBeveragePrice() * qty;
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ bv.getDrinks()+" x"+ qty + " for "+ totalAmt4);
                            count = 0;
                            trans++;
                        } else if(foodChoice ==5) {
                            count = 0;
                        } else {
                            System.out.println("Pick from Pizza, Pasta, Chicken, or Beverage only!");
                            Display.food();
                        }
                    } else if (orderChoice == 2) {
                        Display.pay();
                        System.out.println("Amount due: "+ currentPurchase.getTotal());
                        System.out.println("\t\t\t\t\tYour Input:" );
                        paymentChoice = input.nextInt();
                        double amountPaid; 
                        String method;
                        if (paymentChoice == 1) {
                            method = "Cash";
                            amountPaid = input.nextDouble();
                            Payment currentPayment = new Payment(method, amountPaid);
                            exitOrder = true;
                        } else if (paymentChoice == 2 ||
                                paymentChoice == 3 ||
                                paymentChoice == 4 ||
                                paymentChoice == 5) {
                            // Debit/Credit/Online Payment
                            System.out.println("Please let the customer fill out the following details");
                            System.out.println("====================🔐");
                            System.out.print("Account name: ");
                            String inputName = input.nextLine();
                            System.out.print("Account/Card number: ");
                            String inputNum = input.nextLine();
                            System.out.print("PIN: ");
                            String inputPin = input.nextLine();
                            Payment currentPayment = new Payment("test", currentPurchase.getTotal(), inputNum, inputPin, inputName);
                            exitOrder = true;
                        } else if (paymentChoice == 6) {
                            // Cancel Payment
                        } else {
                            System.out.println("Invalid option");
                        }
                    } else if (orderChoice == 3) {
                        // Cancel Order
                    }
                }
                
            } else if(menuChoice == 2) {
                if (trans==0) {
                    System.out.println("You currently don't have any orders ");
                } else {
                    System.out.println("Total of transactions " + trans);
                }
                count = 0;
            } else if(menuChoice == 3) {
                exit = true;
                count = 0;
            } else {
                System.out.println("Invalid Entry");
                System.out.println("Choose 1, 2 or 3 only!");
                Display.menu();
                count = 0;
            }
        }
    }
}





