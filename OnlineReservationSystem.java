import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Reservation {
    private String pnr;
    private String trainNumber;
    private String classType;
    private String dateOfJourney;
    private String departure;
    private String destination;

    public Reservation(String pnr, String trainNumber, String classType, String dateOfJourney, String departure,
            String destination) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.departure = departure;
        this.destination = destination;
    }

    // Getters and setters for reservation fields
}

public class OnlineReservationSystem {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Reservation> reservations = new HashMap<>();

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        users.put(username, user);
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void makeReservation(String pnr, String trainNumber, String classType, String dateOfJourney,
            String departure, String destination) {
        Reservation reservation = new Reservation(pnr, trainNumber, classType, dateOfJourney, departure, destination);
        reservations.put(pnr, reservation);
    }

    public Reservation getReservation(String pnr) {
        return reservations.get(pnr);
    }

    public void cancelReservation(String pnr) {
        reservations.remove(pnr);
    }

    public static void main(String[] args) {
        OnlineReservationSystem reservationSystem = new OnlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Reservation System!");

        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (reservationSystem.login(username, password)) {
                System.out.println("Login successful!");
                // Implement the reservation and cancellation logic here
                break;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        scanner.close();
    }
}
