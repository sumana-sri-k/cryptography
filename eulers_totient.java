import java.util.Scanner;
public class EulerTotient {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        } 
        return a;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n value: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = 1;
            for (int j = 2; j < i; j++) {
                if (gcd(j, n) == 1) {
                    x++;
                }
            }
            System.out.println(x);
        }
        sc.close();
    }
}
