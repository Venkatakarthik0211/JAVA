//calculate a^b

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = in.nextInt();
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * b;
            }
            b *= b;
            n = n >> 1;
        }
        System.out.println(ans);
        in.close();
    }

}
