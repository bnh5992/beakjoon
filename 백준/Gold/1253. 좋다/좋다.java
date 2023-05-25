import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int count = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int sum = nums[i];
                int target = sum - nums[j];

                result = BinarySearch(target, nums, 0, n - 1, i, j);


                if (result != Integer.MAX_VALUE) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    static int BinarySearch(int value, int[] arr, int start, int end, int i, int j) {
        int start1 = start;
        int end1 = end;
        int mid;
        while (start1 <= end1) {
            mid = (start1 + end1) / 2;
            if (arr[mid] < value) {
                start1 = mid + 1;
            } else if (arr[mid] > value) {
                end1 = mid - 1;
            } else {

                if (end1 == i) {
                    end1 = i - 1;
                    continue;
                }
                if (end1 == j) {
                    end1 = j - 1;
                    continue;
                }
                if (start1 == i) {
                    start1 = i + 1;
                    continue;
                }
                if (start1 == j) {
                    start1 = j + 1;
                    continue;
                }
                if (mid == i || mid == j) {
                    start1 = mid + 1;
                    end1 = end;
                    continue;
                }

                return mid;
            }
        }

        return Integer.MAX_VALUE;
    }
}