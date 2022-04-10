import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CipherCeaser {
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();

    static String alfphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQSTUVWXYZ";

    List<String> list;
    static String text="";
    static int key = 0;

    public void ceaserMenu() throws  Exception {
        System.out.println();
        System.out.println("~~~~~~ Шифровка текста методом Цезаря ~~~\n" +
                "1. Зашифровать содержимое файла\n" +
                "2. Зашифровать введенный текст\n" +
                "3. Расшифровать файл\n" +
                "4. Расшифровать введенный текст\n" +
                "5. Вернутся в главное меню\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (scanner.hasNextInt()) {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    String encrypt = encrypt(enterFile(), enterKey());
                    writeTextToFile(encrypt(enterFile(), enterKey()));
                    break;
                case 2:
                    System.out.println(encrypt(enterText(), enterKey()));
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println(unEncrypt(enterText(), enterKey()));
                    break;
                case 5:
                    menu.mainMenu();
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    menu.mainMenu();
            }
        }
    }


    public void writeTextToFile(String name) throws Exception {  //Запись текста в файл
        Path path = createPathFile();
        BufferedWriter bufferedWriter = Files.newBufferedWriter( path);
        bufferedWriter.write(name);
        System.out.println("Файл сохранен в папке "+ path.toAbsolutePath());

    }

//нельзя проосто вернуть лист<стринг>
        public List<String> enterText()  throws  IOException {  //Вводим текс который нужно зашифровать/расшифровать
            System.out.println("Введите текст: ");
            list = Collections.singletonList(reader.readLine());  //нужно вызвать singletonList, лист становится неизменным
            return list;
        }

        public int enterKey() {                         //Вводим ключ шифра
            System.out.println("Введи ключ - ");
            if (scanner.hasNextInt()) {
               key = Integer.parseInt(scanner.nextLine());
            }
            return key;
        }

    public List<String> enterFile() throws IOException {    //Указываем путь до файла, и считываем содержимое
        System.out.println("Введите путь к файлу: ");
        Path path = Path.of(reader.readLine());
        List<String> list = Files.readAllLines(path);
        return list;
    }

    public Path createPathFile() throws Exception {    //Указываем путь файла куда сохраняем результат
            System.out.println("Введите путь для сохранения файла: ");
            Path file = Path.of(scanner.nextLine());
            if (Files.exists(file)) {
                Files.delete(file);
            }
        return Files.createFile(file);
    }

    public String encrypt(List<String> list, int key) throws IOException {  //Шифруем данные
        text =list.toString();
        for (char aChar : text.toCharArray()) {
            int tmp = alfphabet.indexOf(aChar);
            int index = tmp + key;
            char charAt = alfphabet.charAt(index);
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    public String unEncrypt(List<String> list, int key) throws IOException {    //Расшифровываем данные
        text =list.toString();
        for (char aChar : text.toCharArray()) {
            int tmp = alfphabet.indexOf(aChar);
            int index = tmp - key;
            char charAt = alfphabet.charAt(index);
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }
}
