import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Deshifrator {
    String text="";
    int key ;
    char[] chars;
    Scanner scanner = new Scanner(System.in);

    public void deshifratorMenu() throws Exception {
        System.out.println();
        System.out.println("~~~~~~ Расшифровка текста ~~~~~~\n1. Расшифровать содержимое файла\n2. Расшифровать введенный текст\n3. Вернутся в главное меню\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (scanner.hasNextInt()) {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    //Расшифровать содержимое файла
                    System.out.println("Введите путь к файлу: ");
                    Path path = Path.of(scanner.nextLine());
                    List<String> list = Files.readAllLines(path);
                    text = list.toString();
                    chars = text.toCharArray();
                    System.out.println("Введи ключ - ");
                    key = Integer.parseInt(scanner.nextLine());
                    deshifrator(chars, key);
                    Files.delete(Path.of("C:\\\\Users\\\\Computer\\\\IdeaProjects\\\\Shifrator\\\\src\\\\Deshifrator.txt"));
                    Files.createFile(Path.of("C:\\\\Users\\\\Computer\\\\IdeaProjects\\\\Shifrator\\\\src\\\\Deshifrator.txt"));
                    BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("C:\\\\Users\\\\Computer\\\\IdeaProjects\\\\Shifrator\\\\src\\\\Deshifrator.txt"));
                    bufferedWriter.write(deshifrator(chars,key));
                    System.out.println("Ваш расшифрованный текст лежит  - C:\\Users\\Computer\\IdeaProjects\\Shifrator\\src\\Deshifrator.txt");
                    Menu.mainMenu();
                    break;
                case 2:
                    System.out.println("Введите текст: ");
                    text = scanner.nextLine();
                    chars = text.toCharArray();
                    System.out.println("Введи ключ - ");
                    key = Integer.parseInt(scanner.nextLine());
                    System.out.println( "Ваш расшифрованный текст - " + deshifrator(chars, key));
                    Menu.mainMenu();
                    break;
                case 3:
                    Menu.mainMenu();
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    deshifratorMenu();
                    break;
            }
        }
    }

    public String deshifrator(char[] chars, int key) throws Exception {
         StringBuilder newText = new StringBuilder();
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] != ' ') {
               newText.append((char) (chars[i] - key));
            } else {
                newText.append(' ');
            }
        }
        return newText.toString();
    }
}