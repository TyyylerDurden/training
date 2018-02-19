import java.text.Collator;
import java.util.*;

//We have got a string which consists of the words. They are separated with space. You must transform this string into a data structure, which groups
//words by the first letter in it.

//Then you must print out only those groups which contain more than 1 element.
//Groups must be sorted alphabetically considering every single character.

//Words inside each group must be sorted in decreasing order(by the length). If the lenght is equal, then sort alphabetically.
//Characters also must be printed out alphabetically

//For e.g. String s = "house home brake fly flower fox";
//Result: [f=["flower", "fox", "fly"], h=["house", "home"]]

public class task1 {
    private static Locale ruLocale = new Locale.Builder().setLanguage("ru").build();
    private static final Locale TEST_LOCALE = ruLocale;

    public static void main(String[] args) {
        String s = "плебей п пенал лес лимбо ламас ларавел дом древо печка пинок паж";
        TreeMap<Character, List<String>> data = new TreeMap<>();
        String result = "[";

        for (String str : s.split(" ")) {
            Character ch = str.charAt(0);

            if (data.containsKey(ch)) {
                List<String> tempList = data.get(ch);
                tempList.add(str);

                data.put(ch, tempList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);

                data.put(ch, newList);
            }
        }

        Iterator it = data.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            char ch = (char) pair.getKey();
            List<String> temp = (List<String>) pair.getValue();
            Collator collator = Collator.getInstance(TEST_LOCALE);

            if (temp.size() > 1) {
                Collections.sort(temp, new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        if (o2.length() != o1.length()) {
                            return o2.length() - o1.length();
                        }
                        return collator.compare(o1, o2);
                    }
                });

                result += ch + "=" + temp + (it.hasNext() ? ", " : "");
            }
        }
        result += "]";
        System.out.println(result);
    }
}