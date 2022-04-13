public class CipherCeaser {

    private static final String ALPHABET_PART_ONE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,\":-!? +-*/\\@#$%^&(){}[];'|`~=_©«»'—0123456789";
    private static final String ALPHABET_PART_TWO = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщъыьэюя" +
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,\":-!? +-*/\\@#$%^&(){}[];'|`~=_©«»'—0123456789";


    private static final String ALPHABET = ALPHABET_PART_ONE + ALPHABET_PART_TWO;
    private int alphabetSize = ALPHABET.length() / 2;

    public String encrypt(String message, int key) {  //Шифруем данные
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int originalIndexAlfphabet = ALPHABET.indexOf(aChar);
            int newIndexAlfphabet;
            char charAt = 0;
            if (originalIndexAlfphabet >= 0) {
                if (key >= 0) {
                    newIndexAlfphabet = (originalIndexAlfphabet + key) % (ALPHABET.length() / 2);
                } else {
                    int newKey = key % (ALPHABET.length() / 2);
                    newIndexAlfphabet = (originalIndexAlfphabet + (ALPHABET.length() / 2) + newKey) % ALPHABET.length();
                }
                charAt = ALPHABET.charAt(newIndexAlfphabet);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    public String unEncrypt(String message, int key) {  //Расшифровываем данные
        return encrypt(message, key * (-1));
    }

}
