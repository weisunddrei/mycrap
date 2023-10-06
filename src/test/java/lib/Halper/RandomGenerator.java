package lib.Halper;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class RandomGenerator {
    private static final String CONSTANT_PART = "Tickets title";
    private static final SecureRandom random = new SecureRandom();

    private RandomGenerator() {
        // Private constructor to prevent instantiation
    }

    public static String generateRandomTicketName() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH:mm:ss");
        String timestamp = now.format(formatter);

        return CONSTANT_PART + "_" + timestamp;
    }

    public static String generateRandomPhoneNumber() {
        int areaCode = random.nextInt(900) + 100; // Generates a random 3-digit area code (100-999)
        int firstPart = random.nextInt(900) + 100; // Generates a random 3-digit number (100-999)
        int secondPart = random.nextInt(900) + 100; // Generates a random 3-digit number (100-999)

        return String.format("89%03d%03d%03d", areaCode, firstPart, secondPart);
    }

    public static String generateLongRandomPhoneNumber() {
        int areaCode = random.nextInt(900) + 100; // Generates a random 3-digit area code (100-999)
        int firstPart = random.nextInt(900) + 100; // Generates a random 3-digit number (100-999)
        int secondPart = random.nextInt(900) + 100; // Generates a random 3-digit number (100-999)

        return String.format("8999%03d%03d%03d", areaCode, firstPart, secondPart);
    }

    public static String generateShortRandomPhoneNumber() {
        int areaCode = random.nextInt(90) + 10; // Generates a random 2-digit area code (10-99)
        int firstPart = random.nextInt(90) + 10; // Generates a random 2-digit number (10-99)
        int secondPart = random.nextInt(90) + 10; // Generates a random 2-digit number (10-99)

        return String.format("8999%03d%03d%03d", areaCode, firstPart, secondPart);
    }
}
