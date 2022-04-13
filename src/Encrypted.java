import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypted {
    Scanner scanner = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    CipherCeaser cipherCeaser = new CipherCeaser();


    public void encryptedFile() throws Exception {
        System.out.println("Введите путь к файлу: ");
        String pathNotEncrypted = scanner.nextLine();
        System.out.println("Введи ключ - ");
        int key = Integer.parseInt(scanner.nextLine());
        boolean saveFile = true;
        Path pathSaveCryptedText = null;
        while (saveFile) {
            System.out.println("Введите путь для сохранения файла: ");
            pathSaveCryptedText = Path.of(scanner.nextLine());
            if (Files.exists(pathSaveCryptedText)) {
                System.out.println("По данному пути уже есть файл, перезаписать? Да / Нет");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("Да")) {
                    Files.delete(pathSaveCryptedText);
                    Files.createFile(pathSaveCryptedText);
                    saveFile = false;
                } else {
                    saveFile = true;
                }
            } else {
                Files.createFile(pathSaveCryptedText);
                saveFile = false;
            }
        }
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathNotEncrypted));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.valueOf(pathSaveCryptedText)))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = cipherCeaser.encrypt(string, key);
                writer.write(encrypt + System.lineSeparator());
            }
            System.out.println("Содержимое файла успешно зашифрованно");
            System.out.println("Файл сохранен в папке " + pathSaveCryptedText.toAbsolutePath());
        }
    }

// C:\Users\Computer\IdeaProjects\Shifrator\src\test1.txt

    public void unEncryptedFile() throws Exception {
        System.out.println("Введите путь к файлу: ");
        String pathNotEncrypted = scanner.nextLine();
        System.out.println("Введи ключ - ");
        int key = Integer.parseInt(scanner.nextLine());
        boolean saveFile = true;
        Path pathSaveCryptedText = null;
        while (saveFile) {
            System.out.println("Введите путь для сохранения файла: ");
            pathSaveCryptedText = Path.of(scanner.nextLine());
            if (Files.exists(pathSaveCryptedText)) {
                System.out.println("По данному пути уже есть файл, перезаписать? Да / Нет");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("Да")) {
                    Files.delete(pathSaveCryptedText);
                    Files.createFile(pathSaveCryptedText);
                    saveFile = false;
                } else {
                    saveFile = true;
                }
            } else {
                Files.createFile(pathSaveCryptedText);
                saveFile = false;
            }
        }
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathNotEncrypted));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.valueOf(pathSaveCryptedText)))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = cipherCeaser.unEncrypt(string, key );
                writer.write(encrypt + System.lineSeparator());
            }
            System.out.println("Содержимое файла успешно зашифрованно");
            System.out.println("Файл сохранен в папке " + pathSaveCryptedText.toAbsolutePath());
        }
    }

    public void encryptedText() throws IOException {
        int key = 0;
        System.out.println("Введите текст: ");
        String message = reader.readLine();
        System.out.println("Введи ключ - ");
            key = Integer.parseInt(reader.readLine());
        System.out.println("Ваш зашифрованный текст - ");
        System.out.println(cipherCeaser.encrypt(message, key));

    }

    public void unEncryptedText() throws IOException {
        int key = 0;
        System.out.println("Введите текст: ");
        String message = reader.readLine();
        System.out.println("Введи ключ - ");
        key = Integer.parseInt(reader.readLine());
        System.out.println("Ваш зашифрованный текст - ");
        System.out.println(cipherCeaser.unEncrypt(message, key));
    }
}
