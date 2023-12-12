import java.util.*;
public class sumpossible {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sum: ");
        int sum = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        System.out.println("Enter the number of elements: ");
        int n = in.nextInt();
        for(int i=0;i<n;++i){
            arr.add(in.nextInt());
        }
        System.out.println("Brute Force: "); // remove Hashmap from the function call to see the difference
        System.out.println(sumpossBrute(arr, sum));  
        in.close();
    }
    public static boolean sumpossBrute(List<Integer> arr, int sum){
        return sumpossBrute(arr, sum, new HashMap<>());
    }
    public static boolean sumpossBrute(List<Integer> arr, int sum, HashMap<Integer, Boolean> map){
        if(sum==0) return true;
        if(sum<0) return false;
        if(map.containsKey(sum)) return map.get(sum);
        for(int num : arr){
            int total = sum - num;
            if(sumpossBrute(arr, total, map)) 
            {
                map.put(sum, true);
                return true;
            }
        }
        map.put(sum, false);
        return false;
    }
}