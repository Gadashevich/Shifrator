import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BruteForceText {

    CipherCeaser cipherCeaser = new CipherCeaser();
    Scanner scanner = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void bruteForceText() throws Exception {
        System.out.println("Введите текст: ");
        String message = reader.readLine();
        for (int i = 0; i < cipherCeaser.alphabetSize; i++) {
            String unEncryptedText = cipherCeaser.unEncrypt(message, i);
            if (proverkaText(unEncryptedText)) {
                System.out.println(unEncryptedText);
                System.out.println("Текст расшифровался, ключ = " + i);
                break;
            }
        }
    }

    private boolean proverkaText(String strings) {
        boolean flag = false;
        String[] message = strings.split(" ");
        for (int i = 0; i < message.length; i++) {
            if (message[i].length() > 24) {
                return false;
            }
        }
        if (strings.contains(". ") || strings.contains(".") || strings.contains(", ") || strings.contains("! ") || strings.contains("? ")) {
            flag = true;
        }
        if (flag) {
            System.out.println(strings);
            System.out.println("Текст читаемый? Да / Нет");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Да")) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }



}
