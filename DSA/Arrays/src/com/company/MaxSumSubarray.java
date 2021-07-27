package com.company;

public class MaxSumSubarray {
    /**
     * KADANE'S ALGO
     * A train goes on of numbers and they keep adding up as we go forward
     * the next number decides if it should join the train and add up to it
     * OR start it's own train
     * basically see if the number is bigger than all the numbers added up together
     *
     * we'll maintain a currentSum and originlSum integers
     * currentSum if it is positive we'll keep adding the further indexes
     * else if the index itself is greater than currentSum, it'll start it's own subarray
     * or if current Sum is negetive and the index is larger we'll start a new subarray
     *
     * after every traversal we'll compare if the current sum is greater than the original sum if yes then it's our new answer
     * @param a
     * @param n
     * @return
     */
    public static int kadanes(int[] a, int n) {
        int osum = a[0];
        int csum = a[0];
        for(int i = 0; i<n; i++) {
            //agar peeche se sum positive aa rha hai toh a[i] decides to join the csum
            if(csum > 0) csum += a[i];

            //agar peeche se sum ghate main aa rha hai toh a[i] decides to start to make their own sum
            //jaha ham khade hote hai whi se line shuru ho jati hai
            else csum = a[i];

            if(csum > osum) osum = csum;
        }
        return osum;
    }

    public static int optimize(int[] a, int n) {
        int osum = a[0];
        int csum = a[0];
        for(int i: a) {
            csum = Math.max(csum,csum+i);
            osum = Math.max(csum,osum);
        }
        return osum;
    }
}
