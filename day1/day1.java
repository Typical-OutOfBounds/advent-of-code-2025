import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        String part = args[0];
        if (part.equals("part1")) {
            part1(args);
        } else if (part.equals("part2")) {
            part2(args);
        }
    }

    public static void part1(String[] args) {
        String filename = args[1];
        List<String> commands = readCommands(filename);

        int pos = 50;
        int zeroCount = 0;
        for (String command : commands) {
            String direction = command.substring(0,1);
            int rotationAmount = Integer.parseInt(command.substring(1));
            pos = rotate(pos, direction, rotationAmount);
            if (pos == 0) {
                zeroCount = zeroCount + 1;
            }
        }
        
        System.out.println(zeroCount);
    }

    public static List<String> readCommands(String filename) {
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
        return commands;
    }

    public static int rotate(int pos, String direction, int rotationAmount) {
        if (rotationAmount > 99) {
            rotationAmount = rotationAmount % 100;
        }
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

    public static void part2(String[] args) {
        String filename = args[1];
        List<String> commands = readCommands(filename);

        int pos = 50;
        int zeroCount = 0;
        for (String command : commands) {
            String direction = command.substring(0,1);
            int rotationAmount = Integer.parseInt(command.substring(1));
            pos = rotate(pos, direction, rotationAmount);
            if (pos == 0) {
                zeroCount = zeroCount + 1;
            }
        }
        
        System.out.println(zeroCount);
    }
}