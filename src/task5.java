import java.util.ArrayList;
import java.util.List;

//Given an array of integers, 1 ? a[i] ? n (n = size of array),
// some elements appear twice and others appear once.
//
//Find all the elements that appear twice in this array.
//Example:
//Input:
//[4,3,2,7,8,2,3,1]
//Output:
//[2,3]
public class task5 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1,4,8,9,9};
        List<Integer> duplicates = new ArrayList<>();

        first: for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            second: for (int a = i + 1; a < arr.length; a++) {
                int temp2 = arr[a];

                if (temp == temp2) {
                    duplicates.add(temp);
                    break second;
                }
            }
        }

        System.out.println(duplicates);
    }
}
