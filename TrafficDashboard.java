import java.util.ArrayList;
import java.util.Scanner;

class Traffic {
    String location;
    int vehicles;

    Traffic(String location, int vehicles) {
        this.location = location;
        this.vehicles = vehicles;
    }

    void display() {
        String level;

        if (vehicles < 20) {
            level = "LOW";
        } else if (vehicles < 50) {
            level = "MEDIUM";
        } else {
            level = "HIGH";
        }

        System.out.println("Location: " + location);
        System.out.println("Vehicles: " + vehicles);
        System.out.println("Traffic Level: " + level);
        System.out.println("----------------------");
    }
}

public class TrafficDashboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Traffic> data = new ArrayList<>();

        while (true) {
            System.out.println("\nTRAFFIC MONITORING DASHBOARD");
            System.out.println("1. Add Traffic Data");
            System.out.println("2. View Dashboard");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter vehicle count: ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    if (count < 0) {
                        System.out.println("Invalid vehicle count.");
                        break;
                    }

                    data.add(new Traffic(location, count));
                    System.out.println("Traffic data added!");
                    break;

                case 2:
                    if (data.isEmpty()) {
                        System.out.println("No traffic data available.");
                    } else {
                        for (Traffic t : data) {
                            t.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Dashboard closed.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}