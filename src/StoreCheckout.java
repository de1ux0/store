import java.util.Scanner;

public class StoreCheckout {
    public static void main(String[] args) {

        Scanner store = new Scanner(System.in);

        // Counters: how many units of each product were bought
        int mouse = 0;
        int keyboard = 0;
        int headphones = 0;
        int laptopStand = 0;

        // Accumulator: running total of the cart
        int total = 0;
        int discount = 0;
        int finalTotal = 0;

        // ===== Shopping loop: repeats until the customer chooses Checkout =====
        while (true) {
            System.out.println("===== SIMPLE STORE =====");
            System.out.println("1. Mouse - $20");
            System.out.println("2. Keyboard - $40");
            System.out.println("3. Headphones - $50");
            System.out.println("4. Laptop Stand - $30");
            System.out.println("5. Checkout");
            System.out.print("Choose a product: ");
            int opt = store.nextInt();

            if (opt == 5) {
                break; // go to checkout
            }

            // Validate the product choice
            if (opt < 1 || opt > 5) {
                System.out.println("Invalid option.\nPlease choose a number from 1 to 5.\n");
                continue; // show the menu again, total is unchanged
            }

            // Pick the name and price of the selected product
            String name;
            int price;
            if (opt == 1) {
                name = "Mouse";
                price = 20;
            } else if (opt == 2) {
                name = "Keyboard";
                price = 40;
            } else if (opt == 3) {
                name = "Headphones";
                price = 50;
            } else {
                name = "Laptop Stand";
                price = 30;
            }

            System.out.println("You selected: " + name);
            System.out.println("Price: $" + price);
            System.out.print("Enter quantity: ");
            int quantity = store.nextInt();

            // Validate the quantity
            if (quantity <= 0) {
                System.out.println("Invalid quantity.\nQuantity must be greater than 0.\n");
                continue; // nothing is added to the total
            }

            // Add the item cost to the running total
            int cost = quantity * price;
            total += cost;
            System.out.println(quantity + " x $" + price + " = $" + cost);
            System.out.println("Added to cart!");
            System.out.println("Current total: $" + total + "\n");

            // Update the counter of the selected product
            if (opt == 1) {
                mouse += quantity;
            } else if (opt == 2) {
                keyboard += quantity;
            } else if (opt == 3) {
                headphones += quantity;
            } else {
                laptopStand += quantity;
            }
        }

        // ===== Checkout =====
        int itemsQuantity = mouse + keyboard + headphones + laptopStand;

        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Items purchased: " + itemsQuantity);
        System.out.println("Subtotal: $" + total);

        // 10% discount if the subtotal is $100 or more
        if (total >= 100) {
            discount = total / 10;
            System.out.println("You received a 10% discount!");
        }
        finalTotal = total - discount;

        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);

        // ===== Payment loop: repeats until the payment is enough =====
        int payment;
        while (true) {
            System.out.print("Enter payment amount: $");
            payment = store.nextInt();

            if (payment < finalTotal) {
                System.out.println("Insufficient payment.");
                System.out.println("You still need to pay: $" + (finalTotal - payment));
            } else {
                break; // payment is enough
            }
        }

        // ===== Receipt =====
        System.out.println("Payment successful!");
        System.out.println("========================");
        System.out.println("       SIMPLE STORE");
        System.out.println("========================");
        System.out.println("Items purchased: " + itemsQuantity);
        System.out.println("Subtotal: $" + total);
        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);
        System.out.println("Payment: $" + payment);
        System.out.println("Change: $" + (payment - finalTotal));
        System.out.println("========================");
        System.out.println("Thank you for shopping!");
        System.out.println("========================");
    }
}