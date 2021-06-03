/**
 * <h1>Interleaving Strings</h1>
 * https://leetcode.com/problems/interleaving-string/
 *
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-2
 * */
public class LCInterleavingString {

    public static boolean solution(String s1, int i, String s2, int j, String sol, String s3) {
        if(sol.equals(s3) && i == s1.length() && j == s2.length()) return true;

        boolean answer = false;
        if(i < s1.length()) {
            answer |= solution(s1, i + 1, s2, j, sol + s1.charAt(i), s3);
        }
        if(j < s2.length()) {
            answer |= solution(s1, i, s2, j + 1, sol + s2.charAt(j), s3);
        }
        return answer;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return solution(s1, 0, s2, 0, "", s3);

    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1,s2,s3));
    }
}