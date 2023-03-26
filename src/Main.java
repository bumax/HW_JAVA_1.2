import exercises.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int ex = scan.nextInt();
        switch (ex) {
            case 1:
                Ex1.BubbleSort(10);
                break;
            case 2:
                String inStr = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                System.out.println(Ex2.ParseJSON(inStr));
                break;
        }
    }
}