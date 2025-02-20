package euler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./phoneNumber_premium.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                map.put(line, line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map.size());

        try {
            File myObj = new File("unique_premium.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                myObj.delete();
                myObj.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("unique_premium.txt");
            map.keySet().stream().sorted().forEach(phone -> {
                try {
                    myWriter.write(phone + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
