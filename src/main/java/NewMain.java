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

    public static void order(Purchase t_purchase) {
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t\t\t      ORDER NO. " + t_purchase.getNumber());
            System.out.println("\t\t\t\t        [1] Add Food                        ");
            System.out.println("\t\t\t\t        [2] Pay and Finish Order         ");
            System.out.println("\t\t\t\t        [3] Cancel Order                        ");
            System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Orders: ");
            t_purchase.listOrders();
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

    public int getNumber() {
        return transactionNumber;
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
    
    public void listOrders() {
        System.out.println("===================");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).getName() + " - " + orderList.get(i).getPrice());
        }
        System.out.println("===================");
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
        if (t_payment.getAmount() >= subtotal*VAT && t_payment.isValid()) {
////////////            // Pag tama amount ng pera nung bumili, ibig sabihin proceed, else return an error code
            this.amountPaid = t_payment.getAmount();
            this.amountChange = t_payment.getAmount() - subtotal*VAT;
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
    private double amount;
    // cardNumber, pin, accountHolder are private and can only be written through constructor for security. no getters and setters for these three
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
    
    // Amount only has a getter and no setter because it's read only for security reasons
    public double getAmount() {
        return this.amount;    
    }
    
    public boolean isValid() {
        // To be a valid cash payment, only non-zero amt is needed
        // To be a valid online/card payment, check lengths of details
        // There are legitimate algorithms to determine if card numbers are legitmate, but we will not implement them to reduce complexity
        if (method.equals("cash") && amount != 0) {
            return true;
        } else if (method.equals("test")) {
            if (!(cardNumber.isEmpty() && pin.isEmpty() && accountHolder.isEmpty())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
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
    protected String name;
    protected double price;
    
    public Menu(){
        super();
    }
    
    public Menu(String t_name, double t_price){
        this.name = t_name;
        this.price = t_price;
    }

    public void setName(String t_name) {
        this.name = t_name;
    }

    public void setPrice(double t_price) {
        this.price = t_price;
    }
    
    public String getName() {
        return name;        
    }

    public double getPrice() {
        return price;        
    }
}

class Pizza extends Menu{
    public String size;
    public String flavor;
    
    public Pizza(){
        super();
    }
    
    public Pizza(String t_size, String t_flavor){
        if (null != t_size) {
            switch (t_size) {
            case "R"://regular
                this.setPrice(349);
                this.size = "Regular";
                break;
            case "L"://large
                this.setPrice(599);
                this.size = "Large";
                break;
            case "P"://party
                this.setPrice(799);
                this.size = "Party";
                break;
            default:
                System.out.println("Invalid option.");
            }
        }
        if (null != t_flavor) {
            switch (t_flavor) {
            case "P":
                this.flavor = "Pepperoni";
                break;
            case "H":
                this.flavor = "Hawaiian";
                break;
            case "4":
                this.flavor = "4 Cheese";
                break;
            default:
                System.out.println("Invalid option.");
            }
        }
        this.name = this.flavor + " " + this.size;
    }
}


class Pasta extends Menu{
    public String serving;
    public String typeofPasta;
    
    public Pasta(){
        super();
    }
    
    public Pasta (String t_serving, String t_typeofPasta){
        this.serving = serving;
        if (null != t_serving) {
            switch (t_serving) {
              case "S": //solo
                    this.price = 99;
                    this.serving = "Solo";
                    break;
              case "P": //pan
                    this.price = 249;
                    this.serving = "Pan";
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        if (null != t_typeofPasta) {
            switch (t_typeofPasta) {
                case "S":
                    this.typeofPasta = "Spaghetti";
                    break;
                case "C":
                    this.typeofPasta = "Carbonara";
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        this.name = this.serving + " " + this.typeofPasta;
    } 
}

class Beverage extends Menu{
    public String size;
    public String drink;
    
    public Beverage() {
        super();
    }
    
  public Beverage(String t_size, String t_drink){
        if (null != t_size) {
            switch (t_size) {
                case "T": //tin can
                    this.size = "Tin Can";
                    this.price = 49;
                    break;
              case "P"://pitcher
                    this.size = "Tin Can";
                    this.price = 99;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        if (null != t_drink) {
            switch (t_drink) {
                case "P":
                    this.drink = "Pepsi";
                    break;
                case "C":
                   this.drink = "Coke";
                   break;
                case "S":
                   this.drink = "Sprite";
                   break;
                case "Ro":
                   this.drink = "Royal";
                   break;
                case "RB":
                 this.drink = "Root Beer";
                   break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        this.name = this.size + " " + this.drink;
    } 
}

class Chicken extends Menu {
    public String size;
    
    public Chicken(){
        super();
    }
    
    public Chicken(String t_size){
        if (null != t_size) {
            switch (t_size) {
            case "S":
                this.size = "Small Bucket";
                this.price = 299;
                break;
            case "M":
                this.size = "Medium Bucket";
                this.price = 549;
                break;
            case "L":
                this.size = "Large Bucket";
                this.price = 799;
                break;
            default:
                System.out.println("Invalid option.");
            }
        }
        this.name = this.size + " Chicken";
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
        int qtyInput;
        String nameInput;
        String sizeInput;
        
        
        boolean exit = false; // Exit flag, if true, get out of loop
        while (!exit) {
            Display.menu(); // Display main menu
            System.out.print("\t\t\t\t\tYour Input:" );
            menuChoice = input.nextInt();
            if(menuChoice == 1){
                boolean exitOrder = false;
                Purchase currentPurchase = new Purchase(1); // TODO: Make util function that generates trans numbers
                while (!exitOrder) {
                    Display.order(currentPurchase);
                    System.out.println("\t\t\t\t\tYour Input:");
                    orderChoice = input.nextInt();
                    if (orderChoice == 1) {
                        Display.food();
                        System.out.print("\t\t\t\t\tYour Input:");
                        foodChoice = input.nextInt();
                        count = 0;
                        if(foodChoice == 1) {
                            Display.PizzaOrder();
                            System.out.println("\n\t\t\t\t\tSelect Flavor" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: Pepperoni - for Pepperoni ; Hawaiian - for Hawaiian; 4Cheese - for 4 Cheese");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            nameInput = input.next();    
                            System.out.println("\n\t\t\t\t\tSelect Size" );
                            System.out.println("\t\t\t\t\tInputs should be: R - for regular ; L - for Large; P - for Party" );
                            System.out.println("\t\t\t\t\tYour Input:" );
                            sizeInput = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qtyInput = input.nextInt(); // TODO handle quantities
        //                    totalAmt1 = pz.getPizzaPrice() * qty; // and prices
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ pz.getFlavor()+" Pizza x"+ qty + " for "+ totalAmt1);
//                            pizzaPurchase.setName("test name");
                            Pizza pizzaPurchase = new Pizza(sizeInput, nameInput);
                            currentPurchase.addOrder(pizzaPurchase);
                            count = 0;
                            trans++;
                        } else if(foodChoice == 2) {
                            Display.PastaOrder();
                            System.out.println("\n\t\t\t\t\tSelect Type of Pasta" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: Spagehetti - for Spaghetti ; Carbonara - for Carbonara");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            nameInput = input.next();
                            System.out.println("\n\t\t\t\t\tEnter Serving" );
                            System.out.println("\t\t\t\t\tInputs should be: S - for solo ; P - for Pan" );
                            System.out.println("\t\t\t\t\tYour Input:" );
                            sizeInput = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qtyInput = input.nextInt();
        //                    totalAmt2 = ps.getPastaPrice() * qty;
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ ps.getPasta()+" x"+ qty + " for "+ totalAmt2);
                            Pasta pastaPurchase = new Pasta(sizeInput, nameInput);
                            currentPurchase.addOrder(pastaPurchase);
                            count = 0;
                            trans++;
                        } else if(foodChoice == 3) {
                            Display.ChickenOrder();
                            System.out.println("\n\t\t\t\t\tSelect Bucket Plan" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: SmallBucket - for Small Bucket ; MediumBucket - for Medium Bucket; LargeBucket - for Large Bucket");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            sizeInput = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qtyInput = input.nextInt();
        //                    totalAmt4 = ck.getChickenPrice() * qty;
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ qty +" BucketPlan"+ ck.getChickenPrice()+ " each for "+ totalAmt4);
                            Chicken chickenPurchase = new Chicken(sizeInput);
                            currentPurchase.addOrder(chickenPurchase);
                            count = 0;
                            trans++;
                        } else if(foodChoice == 4) {
                            Display.BeverageOrder();
                            System.out.println("\n\t\t\t\t\tSelect Drink" );
                            System.out.println("\t\t\t\t\tInputs should corresponds to options: 1 - for Pepsi ; 2 - for Coke; 3 - for Sprite; 4 - for Royal; 5 - for Root Beer");
                            System.out.println("\t\t\t\t\tYour Input:" );
                            nameInput = input.next();
                            System.out.println("\n\t\t\t\t\tEnter Size" );
                            System.out.println("\t\t\t\t\tInputs should be: T - for Tin Can ; P - for Pitcher" );
                            System.out.println("\t\t\t\t\tYour Input:" );
                            sizeInput = input.next();
                            System.out.println("\t\t\t\t\tEnter Quantity: " );
                            qtyInput = input.nextInt();
        //                    totalAmt4 = bv.getBeveragePrice() * qty;
        //                    System.out.println("\t\t\t\t\tYou have purchased "+ bv.getDrinks()+" x"+ qty + " for "+ totalAmt4);
                            Beverage beveragePurchase = new Beverage(sizeInput, nameInput);
                            currentPurchase.addOrder(beveragePurchase);
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
                            method = "cash";
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
                        exitOrder = true;
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





