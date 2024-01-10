package DSA.Arrays;

public class smallestletter {
    public static void main(String[] args) {
        char[] a = {'z','a','b','c','d','e','f','g','h','i','j','k','l','m','n'};
        char c = 'l';
        System.out.println(smallestlette(a,c,0,a.length-1));
    }
    private static char smallestlette(char[] a, char c, int i, int j) {
        if(i>j) return a[0];
        int mid = (i+j)/2;
        if(a[mid]<=c) return smallestlette(a,c,mid+1,j);
        else return smallestlette(a,c,i,mid-1);
    }
    
}
