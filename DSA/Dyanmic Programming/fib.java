import java.util.*;
public class fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibarray(n);
        System.out.println("Dyanmic Programming using HashMap: "+fibhash(n)); 
        tribhash(n);
        sc.close();
    }
    public static void tribhash(int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Tribonacci using HashMap: "+tribhash(n, map));
    }
    public static int tribhash(int n, HashMap<Integer, Integer> map){
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        if(map.containsKey(n)) return map.get(n);
        int ans = tribhash(n-1, map) + tribhash(n-2, map) + tribhash(n-3, map);
        map.put(n, ans);
        return ans;
    }
    public static int fibhash(int n){
        return fibhash(n, new HashMap<>());
    }
    public static int fibhash(int n, HashMap<Integer, Integer> map){
        if(n==0 || n==1) return n;
        if(map.containsKey(n)) return map.get(n);
        int ans = fibhash(n-1, map) + fibhash(n-2, map);
        map.put(n, ans);
        return ans;
    }
    public static void fibarray(int n){
        int[] dp = new int[n+1];
        if(n==0 || n==1) System.out.println(n);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println("Dyanmic Programming using Array: "+dp[n]);
    }
}
