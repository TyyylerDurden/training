
//Given a string, find the length of the longest substring without repeating characters.
//
//Examples:
//Given "abcabcbb", the answer is "abc", which the length is 3.
//Given "bbbbb", the answer is "b", with the length of 1.
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        String[] strArr = str.split("");
        String leader = "";

        String candidate = "";

        for (int i = 0; i < strArr.length;) {
            if (!candidate.contains(strArr[i])) {
                candidate = candidate + strArr[i];
                i++;
            } else {
               if (candidate.length() > leader.length()) {
                   leader = candidate;
                   candidate = "";
               } else {
                   i++;
               }
            }
        }

        System.out.println(leader);
    }
}
