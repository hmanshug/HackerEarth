package he;

import java.math.BigInteger;
import java.util.*;

class Greedy1 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] ss= new String[N], cs=new String[N];
        ss= sc.nextLine().split(" ");
        cs= sc.nextLine().split(" ");
        sc.close();
        
        int[] s = Arrays.stream(ss).mapToInt(Integer::parseInt).toArray();
        int[] c = Arrays.stream(cs).mapToInt(Integer::parseInt).toArray();
        
        
        Arrays.sort(s);
        Arrays.sort(c);
        
        BigInteger sum=BigInteger.valueOf(0);
        for(int i=0; i<N; i++) {
        	sum= sum.add(BigInteger.valueOf((s[i]) * (c[i])));
        }
        System.out.println(sum);
        
    }
}
