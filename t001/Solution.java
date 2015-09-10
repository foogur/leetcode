package t001;
import java.util.Arrays;

public class Solution
{

    private static int find_mid(int[] arr, int value)
    {
        int p = 0;
        while (arr[p] < value)
        {
            ++p;
        }
        if (arr[p] == value)
            return p + 1;
        else
            return p;
    }

    private static int find_index(int[] arr, int value, int start)
    {
        int p = start;
        while (arr[p] != value)
        {
            ++p;
        }
        return p;
    }

    public int[] twoSum(int[] numbers, int target)
    {
        int[] cp_of_arr = numbers.clone();
        Arrays.sort(cp_of_arr);

        int r_p = find_mid(cp_of_arr, target / 2);
        int l_p = r_p - 1;

        int r, l;

        while (true)
        {

            r = cp_of_arr[r_p];
            l = cp_of_arr[l_p];
            int sum = r + l;
            if (target == sum)
            {
                break;
            }
            else if (sum > target)
            {
                --l_p;
            }
            else
            {
                ++r_p;
            }
        }

        int index1 = find_index(numbers, r, 0);
        int index2 = find_index(numbers, l, 0);

        if (index2 == index1)
        {
            index2 = find_index(numbers, l, index1 + 1);
        }

        int min = Math.min(index1, index2) + 1;
        int max = Math.max(index1, index2) + 1;

        int[] ret = { min, max };

        return ret;
    }

    public static void main(String[] args)
    {

        Solution s = new Solution();
        int[] numbers = { 1, 2, 3, 4, 5 };
        int[] ret = s.twoSum(numbers, 6);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}

