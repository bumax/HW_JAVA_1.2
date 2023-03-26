package exercises;

import java.util.regex.*;

//Дана строка json:
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод, который распарсит этот текст и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет]. Например:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.


public class Ex2 {
    public static String ParseJSON(String inStr) {
        Pattern pattern = Pattern.compile("\\{[\\\"а-яА-Яa-zA-Z0-9\\,\\:]+\\}"); // парсим строку на отдельные блоки данных
        Matcher matcher = pattern.matcher(inStr);
        StringBuilder outStr = new StringBuilder();
        while (matcher.find()) {
            String dataStr = matcher.group();
            outStr.append("Студент ");
            outStr.append(GetParam("фамилия", dataStr));
            outStr.append(" получил ");
            outStr.append(GetParam("оценка", dataStr));
            outStr.append(" по предмету ");
            outStr.append(GetParam("предмет", dataStr));
            outStr.append(".\n");
        }
        return outStr.toString();
    }

    private static String GetParam(String param, String inStr) {
        Pattern pattern = Pattern.compile("\\\"" + param + "\\\":\\\"[a-zA-Zа-яА-Я0-9\\s\\-]+\\\"");
        Matcher matcher = pattern.matcher(inStr);
        if (matcher.find()) {
            String[] arr = matcher.group().split(":");
            return arr[1].replace("\"", ""); // удаляем кавычки из результата
        } else return ""; // если ничего не найдено по ключу, возвращаем пустую строку
    }
}
