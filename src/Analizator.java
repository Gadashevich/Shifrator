import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Analizator {
    Scanner scanner = new Scanner(System.in);

    public void analize() throws IOException {
        HashMap<Character, Integer> closeFile = new HashMap<>();
        HashMap<Character, Integer> openFile = new HashMap<>();

        System.out.println("Введите путь к файлу: ");
        String pathClose = scanner.nextLine();
        List<Map.Entry<Character, Integer>> listCloseText = fillMapValues(closeFile, pathClose);

        System.out.println("Для анализа необходимо предоставить схожий текст");
        System.out.println("Введите путь к файлу: ");
        List<Map.Entry<Character, Integer>> listOpenText = fillMapValues(openFile, scanner.nextLine());

        HashMap<Character, Character> unEncryptedMap = new HashMap<>();
        System.out.println("Куда сохранить файл?");
        String saveFile = scanner.nextLine();

        if(listCloseText.size() <= listOpenText.size()) {
            for (int i = 0; i <listCloseText.size(); i++) {
                unEncryptedMap.put(listCloseText.get(i).getKey(), listOpenText.get(i).getKey());
            }
            try(BufferedReader reader = Files.newBufferedReader(Paths.get(pathClose));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(saveFile)))
            {
                while(reader.ready()){
                    String string = reader.readLine();
                    StringBuilder stringBuilder =new StringBuilder();
                    for (int i = 0; i <string.length() ; i++) {
                        char charAt = string.charAt(i);
                        Character unCharacter = unEncryptedMap.get(charAt);
                        stringBuilder.append(unCharacter);
                    }
                    writer.write(stringBuilder + System.lineSeparator());
                }
            }
            System.out.println("Содержимое расшифрованно успешно");
        } else {
            System.out.println("Данный текст слишком мал. Введите другой текст");
        }
    }

     private  List<Map.Entry<Character, Integer>> fillMapValues(Map<Character, Integer> map,String path) throws  IOException {
         try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
             while (reader.ready()) {
                 String strings = reader.readLine();
                 for ( int i = 0; i < strings.length(); i++ ) {
                     char charAt = strings.charAt(i);
                        if(!map.containsKey(charAt)){
                            map.put(charAt, 1);
                        } else {
                            map.put(charAt, map.get(charAt) + 1);
                        }
                 }
             }
         }
         List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
         Comparator<Map.Entry<Character, Integer>> comparator = Map.Entry.comparingByValue();
         list.sort(comparator.reversed());
         return list;
     }
/* 2 вариант посчитать кол-во чаров
        for ( int i = 0; i < messageOpen.length(); i++ ) {
        Integer n = openFile.get( messageOpen.charAt(i) );
        if ( n == null ) openFile.put( messageOpen.charAt(i), 1 );
        else openFile.put( messageOpen.charAt(i), ++n );
    }
*/
}
