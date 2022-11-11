import java.util.Scanner;

public class CardConvRev {

    static int cardConvR (int x, int r, char[] d) {
        // 10進数の数字を入力し、変換したい進数を入力すると、結果を表示するプログラム
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);
        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no; // 変換する基数
        int cd; // 基数
        int dno; // 변환 후의 자릿수
        int retry; // もう一回プログラムを実行するか確認
        char[] cno = new char[32]; // 変換後、各桁数に入れる数字

        System.out.println("10進数を基数変換します。");
        do {
            do {
                System.out.println("変換するマイナスではない正の数 : ");
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                System.out.println("変換する基数を入力してください (2~36) : ");
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConvR(no, cd, cno);

            System.out.println(cd + "進数では ");
            for (int i = dno - 1; i >= 0; i--) {
                System.out.print(cno[i]);
            }
            System.out.println("です。");

            System.out.println(cno);

            System.out.println("もう一回しますか? (1.はい / 0.いいえ) : ");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}
