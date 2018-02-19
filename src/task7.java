//Given an array of non-negative integers,
// you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//        For example:
//        A = [2,3,1,1,4], return true.
//
//        A = [3,2,1,0,4], return false.

public class task7 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4,2,3,1,1,4};
        int index = 0;

        while (true) {
            try {
                index += arr[index];

                if (index == arr.length - 1) {
                    System.out.println("TRUE");
                    break;
                } else if (arr[index] == 0) {
                    System.out.println("FALSE");
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("FALSE");
                break;
            }
        }
    }
}
