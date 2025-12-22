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
        int zeroCount = 0;
        for (String command : commands) {
            String direction = command.substring(0,1);
            int rotationAmount = Integer.parseInt(command.substring(1));
            pos = rotate(pos, direction, rotationAmount);
            System.out.println(pos);
        }

    }

    public static int rotate(int pos, String direction, int rotationAmount) {
        if (direction.equals("L")) {
            pos = pos - rotationAmount;
            if (pos < 0) {
                pos = 100 + pos;
            }
        } else {
            pos = pos + rotationAmount;
            if (pos > 99) {
                pos = pos - 100;
            }
        }
        return pos;
    }
}