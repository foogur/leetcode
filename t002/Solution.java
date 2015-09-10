package t002;

import java.util.HashMap;
import java.util.HashSet;

public class Solution
{

    private static int index(int[] arr, int value, int start)
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
        HashSet<Integer> arr = new HashSet<Integer>(numbers.length * 2);
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>(numbers.length * 2);
        for (int i : numbers)
        {
            arr.add(i);
            if(count.containsKey(i))
            {
                count.put(i, 1 + count.get(i));
            }
            else
            {
                count.put(i, 1);
            }
        }

        int ret[] = new int[2];

        int index1, index2;

        for (int i : numbers)
        {
            int j = target - i;
            if (arr.contains(j))
            {
                if(i != j)
                {
                    index1 = index(numbers, i, 0);
                    index2 = index(numbers, j, 0);
                    ret[0] = Math.min(index1, index2) + 1;
                    ret[1] = Math.max(index1, index2) + 1;
                    break;
                }
                else if (i == j && count.get(i) >= 2)
                {
                    index1 = index(numbers, i, 0);
                    index2 = index(numbers, j, index1 + 1);
                    ret[0] = index1 + 1;
                    ret[1] = index2 + 1;
                    break;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args)
    {

        Solution s = new Solution();
        int[] numbers = { 1, 2, 0, 3, 5 };
        int[] ret = s.twoSum(numbers, 2);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}

