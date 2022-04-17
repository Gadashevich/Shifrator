import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.*;
import java.util.*;

public class BruteForceFile {
    Scanner scanner = new Scanner(System.in);

    private String pathNotEncrypted;
    private Path pathSaveCryptedText = null;

    public void bruteForceFile() throws Exception {
        System.out.println("Введите путь к файлу: ");
        pathNotEncrypted = scanner.nextLine();
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
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathNotEncrypted));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.valueOf(pathSaveCryptedText))))
        {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                String string = reader.readLine();
                stringBuilder.append(string);
                list.add(string);
            }
            CipherCeaser cipherCeaser = new CipherCeaser();
            for (int key = 0; key < cipherCeaser.alphabetSize; key++) {
                String unEncryptedFile = cipherCeaser.unEncrypt(stringBuilder.toString(), key);
                if (proverkaFile(unEncryptedFile)) {
                    for (String s : list) {
                        String unEncrypt = cipherCeaser.unEncrypt(s, key);
                        writer.write(unEncrypt + System.lineSeparator());
                    }
                    System.out.println("Текст расшифровался, ключ = " + key);
                    break;
                }
            }
        }
    }

    private boolean proverkaFile(String strings) {
        boolean flag = false;
        int start = new Random().nextInt(strings.length() / 2);
        int finish = start + (int) Math.sqrt(strings.length());
        String partStrings = strings.substring(start, finish);

        String[] message = partStrings.split(" ");
        for (int i = 0; i < message.length; i++) {
            if (message[i].length() > 24) {
                return false;
            }
        }
        if (partStrings.contains(". ") || partStrings.contains(".") || partStrings.contains(", ") || partStrings.contains("! ") || partStrings.contains("? ")) {
            flag = true;
        }
        if (flag) {
            System.out.println(partStrings);
            System.out.println("Текст читаемый? Да / Нет");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Да")) {
                flag = true;
            } else if (answer.equalsIgnoreCase("Нет")) {
                flag = false;
            }
        }
        return flag;
    }
}