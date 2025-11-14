package assignments;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BusTicketSystemGUI {
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

    // GUI components
    private JFrame frame;
    private JTextField nameField, ageField, genderField, routeField, dateField, ticketIdField;
    private JTextArea outputArea;

    public BusTicketSystemGUI() {
        frame = new JFrame("🚌 Tamil Nadu Bus Ticket Booking System");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nameField = new JTextField(20);
        ageField = new JTextField(20);
        genderField = new JTextField(20);
        routeField = new JTextField(20);
        dateField = new JTextField(20);
        ticketIdField = new JTextField(20);

        int row = 0;
        gbc.gridx = 0; gbc.gridy = row; inputPanel.add(new JLabel("👤 Passenger Name:"), gbc);
        gbc.gridx = 1; inputPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = ++row; inputPanel.add(new JLabel("🎂 Age:"), gbc);
        gbc.gridx = 1; inputPanel.add(ageField, gbc);

        gbc.gridx = 0; gbc.gridy = ++row; inputPanel.add(new JLabel("🚻 Gender:"), gbc);
        gbc.gridx = 1; inputPanel.add(genderField, gbc);

        gbc.gridx = 0; gbc.gridy = ++row; inputPanel.add(new JLabel("🗺 Route:"), gbc);
        gbc.gridx = 1; inputPanel.add(routeField, gbc);

        gbc.gridx = 0; gbc.gridy = ++row; inputPanel.add(new JLabel("📅 Travel Date:"), gbc);
        gbc.gridx = 1; inputPanel.add(dateField, gbc);

        gbc.gridx = 0; gbc.gridy = ++row; inputPanel.add(new JLabel("🔢 Ticket ID (for cancel/view):"), gbc);
        gbc.gridx = 1; inputPanel.add(ticketIdField, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton bookButton = new JButton("Book Ticket");
        JButton cancelButton = new JButton("Cancel Ticket");
        JButton viewButton = new JButton("View Ticket");
        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(viewButton);

        // Output Panel
        outputArea = new JTextArea(15, 50);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add panels to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Button actions
        bookButton.addActionListener(e -> bookTicket());
        cancelButton.addActionListener(e -> cancelTicket());
        viewButton.addActionListener(e -> viewTicket());

        frame.setVisible(true);
    }

    private void bookTicket() {
        try {
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String gender = genderField.getText().trim();
            String route = routeField.getText().trim();
            String date = dateField.getText().trim();

            int seat = random.nextInt(40) + 1;
            Ticket ticket = new Ticket(name, age, gender, seat, route, date);
            tickets.put(ticketCounter, ticket);

            outputArea.setText("🎫 Ticket Booked Successfully!\n\n" +
                    "Ticket ID: " + ticketCounter +
                    "\nPassenger: " + name + " | Age: " + age + " | Gender: " + gender +
                    "\nSeat No: " + seat +
                    "\nRoute: " + route +
                    "\nTravel Date: " + date);

            ticketCounter++;
        } catch (Exception ex) {
            outputArea.setText("⚠ Please enter valid details.");
        }
    }

    private void cancelTicket() {
        try {
            int id = Integer.parseInt(ticketIdField.getText().trim());
            if (tickets.containsKey(id)) {
                tickets.remove(id);
                outputArea.setText("❌ Ticket ID " + id + " has been cancelled.");
            } else {
                outputArea.setText("⚠ Ticket ID not found.");
            }
        } catch (Exception ex) {
            outputArea.setText("⚠ Invalid Ticket ID.");
        }
    }

    private void viewTicket() {
        try {
            int id = Integer.parseInt(ticketIdField.getText().trim());
            if (tickets.containsKey(id)) {
                Ticket t = tickets.get(id);
                outputArea.setText("✅ Ticket Details:\n\n" +
                        "Passenger: " + t.passengerName + " | Age: " + t.age + " | Gender: " + t.gender +
                        "\nSeat No: " + t.seatNumber +
                        "\nRoute: " + t.route +
                        "\nTravel Date: " + t.travelDate);
            } else {
                outputArea.setText("🔍 Ticket ID not found.");
            }
        } catch (Exception ex) {
            outputArea.setText("⚠ Invalid Ticket ID.");
        }
    }

    public static void main(String[] args) {
        new BusTicketSystemGUI();
    }
}