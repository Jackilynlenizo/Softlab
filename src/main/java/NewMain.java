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

class Display {
    // Laman ng class na to every attribute or method na may kinalaman sa pag
    // output ng text sa terminal
}

class Transaction {
    // Base class for payments, etc
    // TODO: Payments class, etc etc

    // transactionTypes can be "purchase", "history", "printRecord"
    // NOTE: Maybe this can be implemented better using multiple inheritance
    private String transactionType;
    private int transactionNumber;        

    // Constructor overloads, an example of pmorphism
    public Transaction() {
        super();
    }
    
    public Transaction(String t_transactionType) {
        this.transactionType = t_transactionType;
    }
}

class Payment extends Transaction {
    private final double VAT = 1.12; // multiply this to subtotal to get subtotal+12% VAT
    public double amountPaid;
    public double subtotal;
    public double amountChange;
    
    String method; // Method can be "cash", "credit", "debit", "gcash", "paymaya"

    // Constructor overloads, an example of pmorphism
    public Payment() {
         super();   
    }
    
    public Payment(String t_transactionType, String t_method, double t_subtotal) {
        super(t_transactionType);
        this.method = t_method;
        this.subtotal = t_subtotal;
    }

    public int pay(double t_amount) {
        // If you're wondering why this needs to return an int, pay() needs to return
        // something if ever an error occurs. i.e. return 1 if everything is OK, return 2
        // if kulang pera etc etc, that way mahahandle ng program in if ever magka problem
        if (t_amount >= subtotal*VAT) {
            // Pag tama amount ng pera nung bumili, ibig sabihin proceed, else return an error code
            this.amountPaid = t_amount;
            this.amountChange = t_amount - subtotal*VAT;
            return 1;
        } else {
            // Hindi q na dito ilalagay yung print not enough funds keme,
            // sa UI part niyo nalang ihandle basta 2 ang return code neto pag ganun
            return 2;
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

public class NewMain {
    public static void main(String[] args) {
        
        
    }
}
