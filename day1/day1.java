import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        String filename = args[0];
        File myFile = new File(filename);
        List<String> commands = new ArrayList<>();
        
        try (Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                commands.add(myReader.nextLine().strip());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not able to find file");
            e.printStackTrace();
        }
        System.out.println(commands);

        int pos = 50;

    }

    public static void roate(int pos, String direction, int rotationAmount) {

    }
}