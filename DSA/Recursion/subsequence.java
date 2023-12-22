import java.util.*;
public class subsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string for subsequences");
        String str = in.nextLine();
        System.out.println("Subsequences are: ");
        System.out.println(subseq("",str,new ArrayList<String>()));
        System.out.println("Enter the number of elements in the array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        List<List<Integer>> list = iterativesubseq(arr);
        System.out.println("Subsequences are: ");
        System.out.println(list);
        System.out.println("After removing duplicates, Subsequences are: ");
        list = removeduplicates(arr);
        System.out.println(list);
        in.close();
    }
    public static List<List<Integer>> removeduplicates(int[] arr)
    {
        int start = 0, end = 0;
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
         for(int i = 0; i<arr.length; i++)
         {
            start = 0;
            if(i>0 && arr[i]==arr[i-1])
            {
                start = end+1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for(int j = start; j<n; j++)
            {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal); 
            }
         }
         return outer;    

    }
    public static List<List<Integer>> iterativesubseq(int[] arr)
    {
         List<List<Integer>> outer = new ArrayList<>();
         outer.add(new ArrayList<>());
         for(int num: arr)
         {
            int n = outer.size();
            for(int i = 0; i<n; i++)
            {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal); 
            }
         }
         return outer;
    }
    public static ArrayList<String> subseq(String newString, String original, ArrayList<String> s)
    {
        if(original.isEmpty())
        {
            s.add(newString);
            return s;
        }
        
        char c = original.charAt(0);
        subseq(newString+c, original.substring(1), s);
        subseq(newString, original.substring(1), s);
        return s;
    }
}

