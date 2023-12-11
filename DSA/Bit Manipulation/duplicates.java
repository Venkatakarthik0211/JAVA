import java.util.*;
class duplicates
{
public static void main(String args[])
{
Scanner in = new Scanner(System.in);
int n = in.nextInt();
int a[] = new int[n];
for(int i=0; i<n; i++) a[i] = in.nextInt();
int res = 0;
for(int i = 0; i<n; i++)
{
res = res ^ a[i];
}
System.out.println(res);
in.close();
}
}

