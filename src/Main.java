import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println();
            System.out.println("~~~~~~ Главное меню ~~~~~~\n" +
                    "1. Зашифровать содержимое файла по ключу\n" +
                    "2. Зашифровать введенный текст по ключу\n" +
                    "3. Расшифровать файл по ключу\n" +
                    "4. Расшифровать введенный текст по ключу\n" +
                    "5. Найти ключ шифра у файла\n" +
                    "6. найти ключ шифра у текста\n" +
                    "7. Сделать анализ файла\n" +
                    "9. О программе\n" +
                    "Для выхода из программы нажмите \"exit\"\n"+
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String nextLine = scanner.nextLine();
            switch(nextLine) {
                case ("1") ->  new EncryptedFile().encryptedFile();
                case ("2") -> new EncryptedText().encryptedText();
                case ("3") -> new EncryptedFile().unEncryptedFile();
                case ("4") -> new EncryptedText().unEncryptedText();
                case ("5") -> new BruteForceFile().bruteForceFile();
                case ("6") -> new BruteForceText().bruteForceText();
                case ("7") -> new Analizator().analize();
                case ("9") ->     System.out.println("Программа разработана для быстрого шифрования и расшифрования текста" +
                        " с целью безопасной передачи данных\nЖалобы и предложения - java@gmail.com\n" +
                        "Для оперативного решения ваших проблем напишите в телеграмм @telega\n" +
                        "Версия программы 1.0");
            }
            if(nextLine.equalsIgnoreCase("exit")){
                break;
            }
        }
    }
}
