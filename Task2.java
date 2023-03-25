import java.util.TreeMap;
import java.util.Map.Entry;

public class Task2 {

    public static void main(String[] args) {

        TreeMap<String, String> personal = new TreeMap<>();

        personal.put("Иванов", "Иван");
        personal.put("Петрова", "Светлана");
        personal.put("Белова", "Кристина");
        personal.put("Мусина", "Анна");
        personal.put("Крутова", "Анна");
        personal.put("Юрин", "Иван");
        personal.put("Лыков", "Петр");
        personal.put("Чернов", "Павел");
        personal.put("Чернышов", "Петр");
        personal.put("Федорова", "Мария");
        personal.put("Светлова", "Марина");
        personal.put("Савина", "Мария");
        personal.put("Рыкова", "Мария");
        personal.put("Лугова", "Марина");
        personal.put("Владимирова", "Анна");
        personal.put("Мечников", "Иван");
        personal.put("Петин", "Петр");
        personal.put("Ежов", "Иван");
        personal.put("Шарипов", "Данис");

        int count = 0;

        TreeMap<String, Integer> result = new TreeMap<>();

        for (String value : personal.values()) {
            for (String sameValue : personal.values()) {
                if (value.equals(sameValue)) {
                    count++;
                }
            }
            result.put(value, count);
            count = 0;
        }
        
        count = 4;
        System.out.println("Сортированный список: ");

        for(int i = 0; i < 4; i++){
            for (Entry<String, Integer> name: result.entrySet()){
                if (name.getValue() == count){
                    System.out.println(" | " + name.getKey() + " = " + name.getValue() + " | ");
                }
            }
            count = count - 1;
        }
        System.out.println();
    }
}