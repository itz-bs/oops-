package assignments;

import java.util.*;

public class BusTicketSystem {
    // Ticket class to hold passenger details
    private static class Ticket {
        String passengerName;
        int age;
        String gender;
        int seatNumber;
        String route;
        String travelDate;

        Ticket(String name, int age, String gender, int seat, String route, String date) {
            this.passengerName = name;
            this.age = age;
            this.gender = gender;
            this.seatNumber = seat;
            this.route = route;
            this.travelDate = date;
        }
    }

    private HashMap<Integer, Ticket> tickets = new HashMap<>();
    private int ticketCounter = 1001;
    private Random random = new Random();

    // Book a ticket
    public int bookTicket(String name, int age, String gender, String route, String date) {
        int seat = random.nextInt(40) + 1;
        Ticket ticket = new Ticket(name, age, gender, seat, route, date);
        tickets.put(ticketCounter, ticket);
        System.out.println("\n🎫 Ticket Booked!");
        System.out.println("Ticket ID: " + ticketCounter);
        System.out.println("Passenger: " + name + " | Age: " + age + " | Gender: " + gender);
        System.out.println("Seat No: " + seat);
        System.out.println("Route: " + route);
        System.out.println("Travel Date: " + date);
        return ticketCounter++;
    }

    // Cancel a ticket
    public void cancelTicket(int ticketId) {
        if (tickets.containsKey(ticketId)) {
            tickets.remove(ticketId);
            System.out.println("\n❌ Ticket ID " + ticketId + " cancelled.");
        } else {
            System.out.println("\n⚠ Ticket ID not found.");
        }
    }

    // View ticket status
    public void viewTicketStatus(int ticketId) {
        if (tickets.containsKey(ticketId)) {
            Ticket t = tickets.get(ticketId);
            System.out.println("\n✅ Ticket Details:");
            System.out.println("Passenger: " + t.passengerName + " | Age: " + t.age + " | Gender: " + t.gender);
            System.out.println("Seat No: " + t.seatNumber);
            System.out.println("Route: " + t.route);
            System.out.println("Travel Date: " + t.travelDate);
        } else {
            System.out.println("\n🔍 Ticket ID not found.");
        }
    }

    // Main method for user interaction
    public static void main(String[] args) {
        BusTicketSystem system = new BusTicketSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🚌 Welcome to Tamil Nadu Bus Ticket Booking!");

        while (true) {
            System.out.println("\n📋 Menu:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Ticket Status");
            System.out.println("4. Exit");
            System.out.print("👉 Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("👤 Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.print("🎂 Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("🚻 Enter gender (Male/Female/Other): ");
                    String gender = scanner.nextLine();
                    System.out.print("🗺 Enter your route (e.g. Chennai to Coimbatore): ");
                    String route = scanner.nextLine();
                    System.out.print("📅 Enter travel date (e.g. 2025-10-15): ");
                    String date = scanner.nextLine();
                    system.bookTicket(name, age, gender, route, date);
                    break;
                case "2":
                    System.out.print("🔢 Enter Ticket ID to cancel: ");
                    int cancelId = Integer.parseInt(scanner.nextLine());
                    system.cancelTicket(cancelId);
                    break;
                case "3":
                    System.out.print("🔍 Enter Ticket ID to view: ");
                    int viewId = Integer.parseInt(scanner.nextLine());
                    system.viewTicketStatus(viewId);
                    break;
                case "4":
                    System.out.println("\n👋 Thank you! Safe journey!");
                    return;
                default:
                    System.out.println("⚠ Invalid choice. Try again.");
            }
        }
    }
}