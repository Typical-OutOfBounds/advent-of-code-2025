import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        String filename = args[0];
        List<Long[]> ranges = readRanges(filename);
        
        Long totalCount = 0L;
        for (Long[] range: ranges) {
            totalCount = totalCount + checkRange(range[0], range[1]);
        }

        // totalCount = totalCount + checkRange(ranges.get(1)[0], ranges.get(1)[1]);

        System.out.println(totalCount);
    }

    public static List<Long[]> readRanges(String filename) {
        File myFile = new File(filename);
        List<Long[]> rangeList = new ArrayList<>();
        
        try (Scanner myReader = new Scanner(myFile)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().strip();
                String[] ranges = line.split(",");
                for (String range : ranges) {
                    String[] limits = range.split("-");
                    rangeList.add(new Long[]{Long.parseLong(limits[0]), Long.parseLong(limits[1])});
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not able to find file");
            e.printStackTrace();
        }
        return rangeList;
    }

    public static Long checkRange(Long start, Long end) {
        Long count = 0L;

        String startStr = String.valueOf(start);
        String currStr = startStr;

        Long testCount = 0L;
        while (Long.parseLong(currStr) <= end) {
            if (currStr.length() % 2 == 0) {
                String firstHalf = currStr.substring(0, currStr.length() / 2);
                String firstHalfDouble = firstHalf + firstHalf;
                Long firstHalfDoubleValue = Long.parseLong(firstHalfDouble);
                if (firstHalfDoubleValue >= start && firstHalfDoubleValue <= end) {
                    count = count + firstHalfDoubleValue;
                }
                currStr = String.valueOf(Long.parseLong(firstHalf) + 1) + firstHalf;
            } else {
                currStr = "1" + "0".repeat(currStr.length());
            }
            testCount = testCount + 1;
        }
        
        return count;
    }
}