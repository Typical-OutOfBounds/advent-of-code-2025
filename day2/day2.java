import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        String filename = args[0];
        List<Integer[]> ranges = readRanges(filename);
        System.out.println(Arrays.toString(ranges.get(0)));
    }

    public static List<Integer[]> readRanges(String filename) {
        File myFile = new File(filename);
        List<Integer[]> rangeList = new ArrayList<>();
        
        try (Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().strip();
                String[] ranges = line.split(",");
                for (String range : ranges) {
                    String[] limits = range.split("-");
                    rangeList.add(new Integer[]{Integer.parseInt(limits[0]), Integer.parseInt(limits[1])});
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not able to find file");
            e.printStackTrace();
        }
        return rangeList;
    }
}