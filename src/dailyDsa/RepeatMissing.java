package dailyDsa;

import java.util.Arrays;

public class RepeatMissing {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,4,5};
        System.out.println(Arrays.toString(repeatedNumber1(arr)));
    }
    static public int[] repeatedNumber(final int[] A) {
        int n = A.length;
        int[] res = new int[2];
        Arrays.sort(A);
        for (int i = 0; i < n-1; i++) {
            if (A[i] == A[i+1]) {
                res[0] = A[i];
                break;
            }
        }
        int sum = n*(n+1)/2;
        int arrSum = 0;
        for (int j : A) {
            arrSum += j;
        }

        res[1] = sum - arrSum + res[0];

        return res;
    }

//    Optimised O(n)
    static public int[] missingRepeated(final int[] arr) {
        int[] res = new int[2];

        // cycle or swap sort
        int i = 0;
        int correct = arr[i] - 1; // nos. are from 1 to n
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1 && arr[i] != arr[correct]) {
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;

            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                res[0] = arr[i];
                res[1] = i + 1;
                break;
            }
        }


        return res;
    }
//    static void swap(int firstNo, int secondNo) {
//        int temp = firstNo;
//        firstNo = secondNo;
//        secondNo = temp;
//    }

    static public int[] repeatedNumber1(final int[] A) {
        int[] res = new int[2];
        int i = 0;

        //swap sort
        for(i=0; i<A.length; i++) {
            if(A[i] != i+1 && A[A[i]-1] != A[i]) {
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }

        }
        //find repeating and missing
        for(i=0; i<A.length; i++) {
            if(A[i] != i+1) {
                res[0] = A[i]; //repeating
                res[1] = i+1;  //missing
                break;
            }
        }
        return res;
    }

}
