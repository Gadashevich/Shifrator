import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() throws Exception {
        System.out.println();
        System.out.println("~~~~~~ Главное меню ~~~~~~\n" +
                "1. Шифр Цезаря\n" +
                "2. Шифр по другому\n" +
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

    public void menuCipherCeaser() throws Exception {
        Encrypted encrypted = new Encrypted();
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
                    encrypted.encryptedFile();
                    mainMenu();
                    break;
                case 2:
                    encrypted.encryptedText();
                    mainMenu();
                    break;
                case 3:
                    encrypted.unEncryptedFile();
                    mainMenu();
                    break;
                case 4:
                    encrypted.unEncryptedText();
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
}
