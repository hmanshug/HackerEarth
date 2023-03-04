package he;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


class floating {
    public static void main(String args[] ) throws Exception {
       
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int A[]=new int[N];
        double d=1.0;
        for(int i=0; i<N; i++) {
            A[i]=s.nextInt();
            d*=Math.pow(A[i], 1.0/N);
        }
        if(Math.round(d)==Math.round(Math.floor(d)))
            System.out.println(Math.round(d+1));
        else
            System.out.println(Math.round(d));
        
         s.close();
        
    }
}
