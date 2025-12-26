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
        
        int totalCount = 0;
        for (Integer[] range: ranges) {
            totalCount = totalCount + checkRange(range[0], range[1]);
        }

        // totalCount = totalCount + checkRange(ranges.get(1)[0], ranges.get(1)[1]);

        System.out.println(totalCount);
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

    public static Integer checkRange(int start, int end) {
        int count = 0;

        String startStr = String.valueOf(start);
        String currStr = startStr;

        int testCount = 0;
        while (Integer.parseInt(currStr) <= end) {
            System.out.println(currStr);
            if (currStr.length() % 2 == 0) {
                String firstHalf = currStr.substring(0, currStr.length() / 2);
                System.out.println("First Half: " + firstHalf);
                String firstHalfDouble = firstHalf + firstHalf;
                Integer firstHalfDoubleValue = Integer.parseInt(firstHalfDouble);
                if (firstHalfDoubleValue >= start && firstHalfDoubleValue <= end) {
                    count = count + firstHalfDoubleValue;
                }
                currStr = String.valueOf(Integer.parseInt(firstHalf) + 1) + firstHalf;
            } else {
                currStr = "1" + "0".repeat(currStr.length());
            }
            testCount = testCount + 1;
        }
        
        return count;
    }
}