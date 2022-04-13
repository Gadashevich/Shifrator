import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncryptedFile {
    Scanner scanner = new Scanner(System.in);
    CipherCeaser cipherCeaser = new CipherCeaser();

    String pathNotEncrypted;
    Path pathSaveCryptedText = null;
    int key = 0;

    private void inputFile() throws Exception {
        System.out.println("Введите путь к файлу: ");
        pathNotEncrypted = scanner.nextLine();
        System.out.println("Введи ключ - ");
        key = Integer.parseInt(scanner.nextLine());
        boolean saveFile = true;
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
    }

    public void encryptedFile() throws Exception {
        inputFile();
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

    public void unEncryptedFile() throws Exception {
        inputFile();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathNotEncrypted));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.valueOf(pathSaveCryptedText)))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encrypt = cipherCeaser.unEncrypt(string, key);
                writer.write(encrypt + System.lineSeparator());
            }
            System.out.println("Содержимое файла успешно расшифрованно");
            System.out.println("Файл сохранен в папке " + pathSaveCryptedText.toAbsolutePath());
        }
    }
}