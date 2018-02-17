import java.text.Collator;
import java.util.*;

//���� ������, ��������� �� ����. ��� ����� � ��� ��������� ����� ��������. ����� ������������� ������ � ����� ��������� ������, ������� ���������� ����� �� ������ ����� � �����.
//
//����� ������� ������ ������, ���������� ����� ������ ��������. ������ ������ ���� ������������� � ���������� ������� �� ���� ������ � �����.
//����� ������ ������ ����� ����������� �� �������� (�� ���������� ��������); ���� ����� �������� ������, �� ����������� � ���������� �������.
//������ ������: String s = "����� ����� ����� ���� ���� �����"
//��������������� ������: [�=[�����, ����, ����], c=[ca���, �����]]

public class task1 {
    private static Locale ruLocale = new Locale.Builder().setLanguage("ru").build();
    private static final Locale TEST_LOCALE = ruLocale;

    public static void main(String[] args) {
        String s = "� ��� ��� ����� ���� ���������� ����� ���������� ������ ���� ������ ���� ����� ��� �� ����� ����� ������ ���";
        TreeMap<Character, List<String>> data = new TreeMap<>();

        for (String str : Arrays.asList(s.split(" "))) {
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
        TreeMap<Character, List<String>> forMoreThanOne = new TreeMap<>();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Character charKey = (Character) pair.getKey();
            List<String> pairVal = (List<String>) pair.getValue();

            int length = 0;
            int index = 0;

            Collator collator = Collator.getInstance(TEST_LOCALE);

            for (int i = 0; i < pairVal.size(); i++) {
                length = pairVal.get(i).length();
                index = pairVal.indexOf(pairVal.get(i));

                for (int a = i + 1; a < pairVal.size(); a++) {
                    if (pairVal.get(a).length() > length) {
                        String temp = pairVal.get(a);
                        pairVal.set(a, pairVal.get(index));
                        pairVal.set(index, temp);
                        length = temp.length();
                    } else if (pairVal.get(a).length() == length) {
                        if (collator.compare(pairVal.get(a), pairVal.get(index)) == -1) {
                            String temp = pairVal.get(a);
                            pairVal.set(a, pairVal.get(index));
                            pairVal.set(index, temp);
                        }
                    }
                }
            }

            if (pairVal.size() > 1) {
                forMoreThanOne.put(charKey, pairVal);
            }
        }

        System.out.println(forMoreThanOne.toString().replaceAll("\\{", "[").replaceAll("\\}", "]"));
    }
}