import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hair {
    public static void main(String[] args) {
        int sum = 0;
        String daysStr = "", numberOfDays = "";
        String[] daysStrArray;
        int[] daysArray;
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            numberOfDays = input.readLine();
            daysStr = input.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        daysStrArray = daysStr.split(" ");

        // Это условие только для того, чтобы numberOfDays не чувствовала себя бесполезной
        if (daysStrArray.length != Integer.parseInt(numberOfDays)) {
            System.out.println("Кто-то здесь врёт");
        }

        daysArray = new int[daysStrArray.length];
        for (int i = 0; i < daysStrArray.length; i++) {
            daysArray[i] = Integer.parseInt(daysStrArray[i]);
        }

        for (int i = 0; i < daysArray.length; i++) {
            int indexMax = i;
            for (int j = i + 1; j < daysArray.length; j++) {
                if (daysArray[j] > daysArray[indexMax]) {
                    indexMax = j;
                }
            }
            sum += daysArray[indexMax] * (indexMax - i + 1);
            i = indexMax;
        }

        try(FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(sum));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}