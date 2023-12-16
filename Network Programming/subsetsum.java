//leetcode 90
import java.util.*;  
import java.io.*;
public class subsetsum 
{
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i =0; i<n; i++)
        {
            a[i] = in.nextInt();
        }
        subsetsWithDup(a);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        helper(0, nums, subset, list);
        Object[] objects = list.toArray();
        for(Object obj : objects)
        {
            System.out.print(obj + " ");   
        }
        return list;
    }

    public static void helper(int start, int[] nums, List<Integer> subset, List<List<Integer>> list){
        list.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i - 1]){  
                continue;
            }
            subset.add(nums[i]);
            helper(i + 1, nums, subset, list);
            subset.remove(subset.size() - 1);
        }
    }
}