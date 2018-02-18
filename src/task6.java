import java.util.*;

//Given a string, sort it in decreasing order based on the frequency of characters.
//Example 1:
//
//Input:
//"tree"
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
public class task6 {
    public static void main(String[] args) {
        String word = "dfwerdsfsfsdfffff";

        Map<String, Integer> frequency = new HashMap<>();
        List<String> characters = new ArrayList<>();

        for (String str : word.split("")) {
            if (frequency.containsKey(str)) {
                frequency.put(str, frequency.get(str) + 1);
            } else {
                frequency.put(str, 1);
            }
        }

        for (String str : frequency.keySet()) {
            String tempKey = str;
            int tempValue = frequency.get(str);
            boolean inserted = false;

            String characterCounted = "";

            for (int i = 0; i < tempValue; i++) {
                characterCounted = characterCounted + tempKey;
            }

            if (!characters.isEmpty()) {
                for (int i = 0; i < characters.size(); i++) {
                    if (characters.get(i).length() < characterCounted.length()) {
                        characters.add(i, characterCounted);
                        inserted = true;
                        break;
                    } else if (characters.get(i).length() == characterCounted.length()) {
                        characters.add(i + 1, characterCounted);
                        inserted = true;
                        break;
                    }
                }

                if (!inserted) characters.add(characterCounted);
            } else {
                characters.add(characterCounted);
            }
        }

        characters.forEach(v -> {
            System.out.print(v);
        });
    }
}
