import java.io.*;

public class FeedbackPortal {

    static String[] names = new String[100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];

    static int count = 0;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        loadFeedback();

        boolean running = true;

        while (running) {
            showMenu();

            try {
                System.out.print("Choose: ");
                int choice = Integer.parseInt(input.readLine());

                switch (choice) {
                    case 1:
                        addFeedback();
                        break;

                    case 2:
                        showAll();
                        break;

                    case 3:
                        showAverage();
                        break;

                    case 4:
                        searchByRating();
                        break;

                    case 5:
                        deleteFeedback();
                        break;

                    case 6:
                        saveFeedback();
                        break;

                    case 7:
                        saveFeedback();
                        System.out.println("Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Choose 1-7.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (IOException e) {
                System.out.println("Input error: " + e.getMessage());
            }
        }
    }

    static void showMenu() {
        System.out.println("\n===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add feedback");
        System.out.println("2. Show all feedback");
        System.out.println("3. Show average rating");
        System.out.println("4. Search by rating");
        System.out.println("5. Delete feedback");
        System.out.println("6. Save to file");
        System.out.println("7. Save and exit");
    }

    static void addFeedback() throws IOException {

        if (count >= names.length) {
            System.out.println("Feedback list is full.");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = input.readLine();

        if (name == null || name.trim().isEmpty() || name.contains("|")) {
            System.out.println("Name cannot be empty or contain |.");
            return;
        }

        int rating;

        while (true) {
            try {
                System.out.print("Enter rating (1-5): ");
                rating = Integer.parseInt(input.readLine());

                if (rating >= 1 && rating <= 5) {
                    break;
                } else {
                    System.out.println("Rating only between 1 and 5.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.print("Enter comment: ");
        String comment = input.readLine();

        if (comment == null || comment.trim().isEmpty() || comment.contains("|")) {
            System.out.println("Comment cannot be empty or contain |.");
            return;
        }

        names[count] = name.trim();
        ratings[count] = rating;
        comments[count] = comment.trim();

        count++;

        System.out.println("Feedback added successfully.");
    }

    static void showAll() {

        if (count == 0) {
            System.out.println("No feedback available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\nFeedback #" + (i + 1));
            System.out.println("Name: " + names[i]);
            System.out.println("Rating: " + ratings[i]);
            System.out.println("Comment: " + comments[i]);
        }
    }

    static void showAverage() {

        if (count == 0) {
            System.out.println("No feedback available.");
            return;
        }

        int total = 0;

        for (int i = 0; i < count; i++) {
            total += ratings[i];
        }

        double average = (double) total / count;

        System.out.printf("Average rating: %.2f%n", average);
    }

    static void searchByRating() throws IOException {

        System.out.print("Enter rating to search (1-5): ");

        try {
            int rating = Integer.parseInt(input.readLine());

            if (rating < 1 || rating > 5) {
                System.out.println("Rating only between 1 and 5.");
                return;
            }

            boolean found = false;

            for (int i = 0; i < count; i++) {
                if (ratings[i] == rating) {
                    System.out.println("\nName: " + names[i]);
                    System.out.println("Rating: " + ratings[i]);
                    System.out.println("Comment: " + comments[i]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No feedback found for this rating.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    static void deleteFeedback() throws IOException {

        if (count == 0) {
            System.out.println("No feedback available to delete.");
            return;
        }

        showAll();

        System.out.print("Enter feedback number to delete: ");

        try {
            int number = Integer.parseInt(input.readLine());

            if (number < 1 || number > count) {
                System.out.println("Invalid feedback number.");
                return;
            }

            int index = number - 1;

            for (int i = index; i < count - 1; i++) {
                names[i] = names[i + 1];
                ratings[i] = ratings[i + 1];
                comments[i] = comments[i + 1];
            }

            count--;

            names[count] = null;
            comments[count] = null;
            ratings[count] = 0;

            System.out.println("Feedback deleted successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    static void saveFeedback() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("feedback.txt"))) {

            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }

            System.out.println("Feedback saved successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void loadFeedback() {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("feedback.txt"))) {

            String line;

            while ((line = reader.readLine()) != null && count < names.length) {

                String[] parts = line.split("\\|", 3);

                if (parts.length == 3) {
                    try {
                        int rating = Integer.parseInt(parts[1]);

                        if (rating >= 1 && rating <= 5
                                && !parts[0].trim().isEmpty()
                                && !parts[2].trim().isEmpty()) {

                            names[count] = parts[0];
                            ratings[count] = rating;
                            comments[count] = parts[2];

                            count++;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid feedback record.");
                    }
                }
            }

            System.out.println(count + " feedback record(s) loaded.");

        } catch (IOException e) {
            System.out.println("No saved feedback found.");
        }
    }
}
