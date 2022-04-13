import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EncryptedText {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    CipherCeaser cipherCeaser = new CipherCeaser();

    int key = 0;
    String message;

    private void inputText() throws Exception {
        System.out.println("Введите текст: ");
        message = reader.readLine();
        System.out.println("Введи ключ - ");
        key = Integer.parseInt(reader.readLine());
        System.out.println("Ваш зашифрованный текст - ");
    }

    public void encryptedText() throws Exception {
        inputText();
        System.out.println(cipherCeaser.encrypt(message, key));
    }

    public void unEncryptedText() throws Exception {
        inputText();
        System.out.println(cipherCeaser.unEncrypt(message, key));
    }
}
