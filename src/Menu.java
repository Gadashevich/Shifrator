import java.util.Scanner;

public class Menu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("~~~~~~ Главное меню ~~~~~~");
        System.out.println("1. Расшифровать текст");
        System.out.println("2. Зашифровать текст");
        System.out.println("3. Завершить программу");
        System.out.println("9. О программе");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if(scanner.hasNextInt()) {
            int number = Integer.valueOf(scanner.nextLine());
            switch (number) {
                case 1:
                    Deshifrator deshifrator = new Deshifrator();
                    deshifrator.deshifratorMenu();
                    break;

                case 2:
                    Shifrator shifrator = new Shifrator();
                    shifrator.shifratorMenu();
                    break;
                case 3:
                    System.out.println("Спасибо что воспользовались нашей программой");
                    System.out.println("Программа завершена");
                    break;

                case 9:
                    System.out.println("Программа разработана для быстрого шифрования и расшифрования текста с целью безопасной передачи данных");
                    System.out.println("Жалобы и предложения - java@gmail.com");
                    System.out.println("Для оперативного решения ваших проблем напишите в телеграмм @telega");
                    System.out.println("Версия программы 1.0");
                    break;
            }


        } else {
            System.out.println("Введите число");
            menu();
        }


    }

}
