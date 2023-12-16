//The below solution is a brute force solution to the minimum change problem and no

import java.util.*;
public class minchange {
    public static void main(String agrsp[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        int amount = in.nextInt();
        System.out.println("Enter the number of coins: ");
        int n = in.nextInt();
        System.out.println("Enter the coins: ");
        List<Integer> coins = new ArrayList<>();    
        for(int i=0;i<n;++i){
            coins.add(in.nextInt());
        }
        System.out.println("Brute Force: ");
        System.out.println(minchangeBrute(coins, amount));
        in.close();
    }
    public static int minchangeBrute(List<Integer> coins, int amount){
        return minchangeBrute(coins, amount, new HashMap<>());
    }
    public static int minchangeBrute(List<Integer> coins, int amount, HashMap<Integer, Integer> map){
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(map.containsKey(amount)) return map.get(amount);
        int min = -1;
        for(int coin : coins){
            int total = amount - coin;
            int res = minchangeBrute(coins, total, map);
            if(res!=-1){
                int num = res + 1; // 1 for the coin
                if(num<min || min==-1) // if the current number is less than the min or min is -1
                min = num; // update the min
            }
        }
        map.put(amount, min);
        return min;
    }
}
