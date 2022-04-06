import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Shifrator {
    String text="";
    int key ;
    char[] chars;
    Scanner scanner = new Scanner(System.in);

    public void shifratorMenu() throws Exception {
        System.out.println();
        System.out.println("~~~~~~ Зашифровка текста ~~~~~~\n1. Зашифровать содержимое файла\n2. Зашифровать введенный текст\n3. Вернутся в главное меню\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (scanner.hasNextInt()) {
            int number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    //Зашифровать содержимое файла
                    System.out.println("Введите путь к файлу: ");
                    Path path = Path.of(scanner.nextLine());
                    List<String> list = Files.readAllLines(path);
                    text = list.toString();
                    chars = text.toCharArray();
                    System.out.println("Введи ключ - ");
                    if(scanner.hasNextInt()){
                    key = Integer.parseInt(scanner.nextLine());
                    }
                    shifrator(chars, key);
                    Files.delete(Path.of("C:\\\\Users\\\\Computer\\\\IdeaProjects\\\\Shifrator\\\\src\\\\shifrator.txt"));
                    Files.createFile(Path.of("C:\\\\Users\\\\Computer\\\\IdeaProjects\\\\Shifrator\\\\src\\\\shifrator.txt"));
                    BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("C:\\\\Users\\\\Computer\\\\IdeaProjects\\\\Shifrator\\\\src\\\\shifrator.txt"));
                    bufferedWriter.write(shifrator(chars,key));
                    System.out.println("Ваш зашифрованный текст лежит  - C:\\Users\\Computer\\IdeaProjects\\Shifrator\\src\\shifrator.txt");
                    Menu.mainMenu();
                    bufferedWriter.close();
                    break;
                case 2:
                    //Зашифровать введенный текст
                    System.out.println("Введите текст: ");
                    text = scanner.nextLine();
                    chars = text.toCharArray();
                    System.out.println("Введи ключ - ");
                    if(scanner.hasNextInt()){
                        key = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.println( "Ваш зашифрованный текст - " + shifrator(chars, key));
                    Menu.mainMenu();
                    break;
                case 3:
                    Menu.mainMenu();
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    shifratorMenu();
                    break;
            }
        }
    }

    public String shifrator(char[] chars, int key) throws Exception {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i] != ' ') {
                newText.append((char) (chars[i] + key));
            } else {
                newText.append(' ');
            }
        }
        return newText.toString();
    }
}