import java.util.ArrayList;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
//        Note: The solution set must not contain duplicate triplets.
//
//        For example, given array S = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]
public class task4 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4, 5, 2, 4, 9, 5, 3, 0, -2};
        List<List<Integer>> candidates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr.length > 1) {
                int firstTemp = arr[i];

                if (arr.length > 2) {
                    for (int a = i + 1; a < arr.length; a++) {
                        int secondTemp = arr[a];

                        for (int b = a + 1; b < arr.length; b++) {
                            int thirdTemp = arr[b];

                            if (firstTemp + secondTemp + thirdTemp == 0) {
                                List<Integer> tempArr = new ArrayList<>();
                                tempArr.add(firstTemp);
                                tempArr.add(secondTemp);
                                tempArr.add(thirdTemp);

                                candidates.add(tempArr);
                            }
                        }
                    }
                } else {
                    System.out.println("Too short arr");
                }
            } else {
                System.out.println("Too short arr");
            }
        }

        candidates.forEach(v -> {
            System.out.println(v);
        });
    }
}
