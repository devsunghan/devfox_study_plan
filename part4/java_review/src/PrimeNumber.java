public class PrimeNumber {
    public static void main(String[] args) {
        //　10000以下の素数を全て確認し、確認した素数の合計を表すプログラム
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[2000];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n <= 10000; n += 2) {
            boolean flag = false;
            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prime[ptr++] = n;
                counter++;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.println(counter);
    }
}
