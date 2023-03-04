import java.util.Scanner;

public class HIMANSHU_POY2013 {

    public static void main(String[] args) {

// CODING START HERE

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Players");
        int n = sc.nextInt();

        System.out.println("\nEnter Your Values");
        int m, l;
        String a[][] = new String[n][n];
        for (m = 0; m < n; m++) {
            for (l = 0; l <= m; l++) {
                a[m][l] = sc.next();
            }
            System.out.println("\n");
        }
        int b[] = new int[n];


        for (m = 0; m < n; m++) {
            b[m] = 0;
            for (l = 0; l <= m; l++) {
                if ("+".equals(a[m][l])) {

                    b[m] = b[m] + 1;
                }


            }
        }


        for (l = 0; l < n; l++) {
            for (m = n - 1; m >= l; m--) {
                if ("-".equals(a[m][l])) {
                    b[l] = b[l] + 1;
                }
            }
        }


        System.out.println("Final Result is= ");


        int i = n - 1;
        for (; i != -1; i--) {
            for (m = 0; m < n; m++) {
                if (b[m] == i) {

                    for (int j = m + 1; j < n; j++) {
                        int ja = j + 1, ma = m + 1;
                        if (b[j] == i) {


                            if ("+".equals(a[j][m])) {

                                System.out.print(" " + ja);
                                b[j] = -1;
                                j = m + 1;


                            } else if ("-".equals(a[j][m])) {
                                System.out.print(" " + ma);
                                m = j;


                            } else if (j == n - 1) {

                                System.out.print(" " + ma);

                                break;
                            }
                        } else if (j == n - 1) {
                            System.out.print(" " + ma);
                        }


                    }




                }






            }



        }

    }
}
