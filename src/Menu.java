import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() throws Exception {
        System.out.println();
        System.out.println("~~~~~~ Главное меню ~~~~~~\n" +
                "1. Шифр Цезаря\n" +
                "2. Расшифровать методом БрутФорс\n" +
                "3. Завершить программу\n" +
                "9. О программе\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (scanner.hasNextInt()) {
            int numberMenu = Integer.parseInt(scanner.nextLine());
            switch (numberMenu) {
                case 1:
                    menuCipherCeaser();
                    break;
                case 2:
                    menuBruteForceText();
                    break;
                case 3:
                    System.out.println("Спасибо что воспользовались нашей программой\n" +
                            "Программа завершена");
                    break;
                case 9:
                    System.out.println("Программа разработана для быстрого шифрования и расшифрования текста с целью " +
                            "безопасной передачи данных\nЖалобы и предложения - java@gmail.com\n" +
                            "Для оперативного решения ваших проблем напишите в телеграмм @telega\n" +
                            "Версия программы 1.0");
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    mainMenu();
            }
        } else {
            System.out.println("Введите число");
            mainMenu();
        }
    }

    private void menuCipherCeaser() throws Exception {
        EncryptedFile encryptedFile = new EncryptedFile();
        EncryptedText encryptedText = new EncryptedText();
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
                    encryptedFile.encryptedFile();
                    mainMenu();
                    break;
                case 2:
                    encryptedText.encryptedText();
                    mainMenu();
                    break;
                case 3:
                    encryptedFile.unEncryptedFile();
                    mainMenu();
                    break;
                case 4:
                    encryptedText.unEncryptedText();
                    mainMenu();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    mainMenu();
            }
        } else {
            System.out.println("Введите число");
            mainMenu();
        }
    }

    private void menuBruteForceText() throws Exception {
        BruteForceFile bruteForceFile = new BruteForceFile();
        BruteForceText bruteForceText = new BruteForceText();
        System.out.println();
        System.out.println("~~~~~~ Расшифровка методом БрутФорс ~~~\n" +
                "1. Расшифровать файл\n" +
                "2. Расшифровать текст\n" +
                "3. Вернутся в главное меню\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (scanner.hasNextInt()) {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    bruteForceFile.bruteForceFile();
                    mainMenu();
                    break;
                case 2:
                    bruteForceText.bruteForceText();
                    mainMenu();
                    break;
                case 3:
                    mainMenu();
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    mainMenu();
            }
        } else {
            System.out.println("Введите число");
            mainMenu();
        }
    }
}

