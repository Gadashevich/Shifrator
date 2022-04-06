import java.util.Scanner;

public class Menu {

    public static void mainMenu() throws  Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("~~~~~~ Главное меню ~~~~~~\n1. Зашифровать текст\n2. Расшифровать текст\n3. Завершить программу\n9. О программе\n~~~~~~~~~~~~~~~~~~~~~~~~~~");


        if (scanner.hasNextInt()) {
            int number = Integer.valueOf(scanner.nextLine());
            switch (number) {
                case 1:
                    Shifrator shifrator = new Shifrator();
                    shifrator.shifratorMenu();
                    break;
                case 2:
                    Deshifrator deshifrator = new Deshifrator();
                    deshifrator.deshifratorMenu();
                    break;
                case 3:
                    System.out.println("Спасибо что воспользовались нашей программой\nПрограмма завершена");
                    break;
                case 9:
                    System.out.println("Программа разработана для быстрого шифрования и расшифрования текста с целью безопасной передачи данных\nЖалобы и предложения - java@gmail.com\nДля оперативного решения ваших проблем напишите в телеграмм @telega\nВерсия программы 1.0");
                    break;
                default :
                    System.out.println("Такого пункта меню нет");
                    mainMenu();
            }
        } else {
            System.out.println("Введите число");
            mainMenu();
        }


    }

}
