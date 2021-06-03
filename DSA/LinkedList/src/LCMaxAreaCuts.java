import java.util.Arrays;

/**
 * <h1>Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts</h1>
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 *
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts
 * where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut
 * and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 *
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided
 * in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-3
 * */
public class LCMaxAreaCuts {

    public static int maxArea(int h, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);
        int diff;
        int maxH = Math.max(hc[0],(h-hc[hc.length - 1]));
        int maxW = Math.max(vc[0],(w-vc[vc.length - 1]));
        for(int i = 0; i < hc.length - 1; i++) {
            diff = (hc[i+1] - hc[i]);
            maxH = Math.max(maxH,diff);
        }
        for(int j = 0; j < vc.length - 1; j++) {
            diff = (vc[j+1] - vc[j]);
            maxW = Math.max(maxW,diff);
        }

        return (int)((long)maxH*maxW%1000000007);
    }

    public static void main(String[] args) {
        int h = 5, w = 4;
        int[] hc = {1,2,4};
        int[] vc = {1,3};
        System.out.println(maxArea(h,w,hc,vc));
    }

}
