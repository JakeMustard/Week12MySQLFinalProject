// TestDemo.java
import java.util.Random;

public class TestDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    public int addPositive(int a, int b) {
        // Check if both parameters are positive
        if (a > 0 && b > 0) {
            // If both are positive, return their sum
            return a + b;
        } else {
            // If either parameter is zero or negative, throw an IllegalArgumentException
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }

    public int addPositive1(int a, int b) {
        // Incorrect implementation that returns 0
        return 0;
    }

    int getRandomInt() {
        // Generate a random integer between 1 and 10
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public int randomNumberSquared() {
        // Get a random integer and return its square
        int randomInt = getRandomInt();
        return randomInt * randomInt;
    }
}
