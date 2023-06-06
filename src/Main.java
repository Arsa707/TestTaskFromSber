import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Инициализируем переменную для проверки на количество столбцов в таблице
        int wordsCount = 6;

        /*Выбираем вариант сортировки
        OPTION1 - Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра;
        OPTION2 - Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра.
        */
        SortOption sortOption = SortOption.OPTION2;


        //Создаем список для сортировки
        ArrayList<City>list = new ArrayList<>();
        //Перехватываем ошибки
        try (FileInputStream fileInputStream = new FileInputStream(".\\src\\resources\\Задача ВС Java Сбер.csv");
             Scanner scanner = new Scanner(fileInputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lines = line.split(";");

                //Выбрасываем исключение, если в таблице столбцов больше, чем мы рассчитывали
                if (wordsCount < lines.length) throw new RuntimeException("The count of word in table is different!");

                //Первый столб - номер строки, его пропускаем
                String tableName = lines[1];
                String tableRegion = lines[2];
                String tableDistrict = lines[3];
                String tablePopulation = lines[4];

                //Дополнительно делаем проверки на поле даты, т.к. имеют место быть нетипичные значения
                String tableFoundation = "";
                try {
                    if (lines.length == wordsCount) {
                        tableFoundation = lines[5];
                        if (tableFoundation.length() > 4) {
                            if (tableFoundation.indexOf("век") > 0) {
                                tableFoundation = tableFoundation.replaceAll(" век", "00");
                                int correctYears = Integer.parseInt(tableFoundation) - 100;
                                tableFoundation = String.valueOf(correctYears);
                            } else tableFoundation = tableFoundation.substring(0, 3);
                        }
                    }
                } catch (Exception e) {
                    new RuntimeException(e);
                    tableFoundation = "";
                }

                City city = new City(tableName,tableRegion,tableDistrict,tablePopulation,tableFoundation);

                //Больше не актуально после Part1
                //System.out.println(line);
                list.add(city);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Сортируем
        if(sortOption==SortOption.OPTION1){
            list.sort((o1, o2) -> o2.getTableName().compareToIgnoreCase(o1.getTableName()));
        } else if (sortOption==SortOption.OPTION2) {
            list.sort(Comparator.comparing(City::getTableDistrict).thenComparing(City::getTableName).reversed());
        }

        list.forEach(System.out::println);
    }
}