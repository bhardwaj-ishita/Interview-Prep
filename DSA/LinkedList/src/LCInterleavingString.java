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
/*
if(s3.length() != (s1.length() + s2.length())) return false;
        if(s1.length() == 0 && s2.length() == 0) return true;


        int p1 = 0, p2 = 0, p3 = 0;
        boolean space = true;
        while(p3 != s3.length()) {
            //System.out.println("s1: " + s1 + " s2: " + s2 + " s3: " + s3);
            if(p1 < s1.length() && s3.charAt(p3) == s1.charAt(p1)) {
                while(p1 < s1.length() && s3.charAt(p3) == s1.charAt(p1)) {
                    //System.out.println("s1: " + p1);
                    p1++;
                    p3++;
                }
            }
            else if(p2 < s2.length() && s3.charAt(p3) == s2.charAt(p2)) {
                while(p2 < s2.length() && s3.charAt(p3) == s2.charAt(p2)) {
                    //System.out.println("s2: " + p2);
                    p2++;
                    p3++;
                }

            }
            else{
                space = false;
                break;
            }
        }
        if(!space) return false;
        return true;
 */