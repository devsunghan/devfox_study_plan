import java.util.Scanner;

public class Tower_of_hanoi {
    static int count = 0;

    static void move (int no, int x, int y, int z, char[] hano) {
        count++;

        if (no > 1)
            move (no - 1, x, z - x - y, z, hano);

        System.out.println(no + "番目の円盤を " + hano[x - 1] + "杭から " + hano[y - 1] + "杭に移動します。");

        if (no > 1)
            move (no - 1, z - x - y, y, z, hano);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("ハノイの塔");
        System.out.println("円盤の数 : ");
        int n = stdIn.nextInt();

        char[] hanoi = new char[n];

            for (int i = 0; i < n; i++) {
                int in = 65 + i;
                hanoi[i] = (char) in;
            }

        int num = 6;


        move(n,1, 3, num, hanoi);
        System.out.println(count);
    }
}
