package scaler.two_pointers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnotherCountRectangles {

    public int solve(List<Integer> A, int B) {
        long ans = 0;
        for (int i = 0; i < A.size(); i++) {
            long multiply = (long) A.get(i) * A.get(i);
            if (multiply < (long) B) {
                ans++;
            }
        }

        int i = 0, j = A.size() - 1;
        while (i < j) {
            long multiply = (long) A.get(i) * A.get(j);
            if (multiply < (long) B) {
                ans = ans + 2L * (j - i);
                i++;
            } else {
                j--;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\arshi\\Downloads\\natural_numbers.txt"; // Change this to your file path
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma or whitespace
                String[] parts = line.split(",\\s*|\\s+");
                for (String part : parts) {
                    numbers.add(Integer.parseInt(part.trim())); // Convert to integer
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        AnotherCountRectangles sortedInsertPosition = new AnotherCountRectangles();
        System.out.println(sortedInsertPosition.solve(numbers, 2000));
    }

}
