package dataStructure;

import java.util.Comparator;
import java.util.Scanner;

public class LinkedListTester {
    static Scanner stdIn = new Scanner(System.in);

    // データ（会員番号＋名前）
    static class Data {
        static final int NO = 1; // 番号で操作する
        static final int NAME = 2; // 名前で操作する

        private Integer no;
        private String name;

        // 文字列で情報を確認
        public String toString() {
            return "(" + no + ") " + name;
        }


        // データを入力
        void scanData(String guide, int sw) {
            System.out.println(guide + "するデータを入力してください。");

            if ((sw & NO) == NO) {
                System.out.print("番号 : ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("名前 ： ");
                name = stdIn.next();
            }
        }


        // 会員番号で整列するComparator
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }


        // 名前で整列するComparator
        public static final Comparator<Data> NAME_ORDER = new NoOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }
    }


    // Menu
    enum Menu {
        ADD_FIRST("頭にNode挿入"),
        ADD_LAST("尻尾にNode挿入"),
        RMV_FIRST("頭のNodeを削除"),
        RMV_LAST("尻尾のNodeを削除"),
        RMV_CRNT("選択中のNodeを削除"),
        CLEAR("全てのNodeを削除"),
        SEARCH_NO("会員番号で検索"),
        SEARCH_NAME("名前で検索"),
        NEXT("選択中のNodeに移動"),
        PRINT_CRNT("選択中のNodeをプリント"),
        DUMP("全てのNodeをプリント"),
        TERMINATE("終了");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }


    // Menu選択
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;  //　追加用のデータ
        Data ptr;   //  検索用のデータ
        Data temp = new Data(); // 入力用のデータ

        LinkedList<Data> list = new LinkedList<Data>();

        do {
            switch (menu = SelectMenu()) {

                case ADD_FIRST:
                    data = new Data();
                    data.scanData("頭に挿入", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST:
                    data = new Data();
                    data.scanData("尻尾に挿入", Data.NO | Data.NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST:
                    list.removeFirst();
                    break;

                case RMV_LAST:
                    list.removeLast();
                    break;

                case RMV_CRNT:
                    list.removeCurrentNode();
                    break;

                case SEARCH_NO:
                    temp.scanData("検索", Data.NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("当てはまる番号のデータがありません。");
                    else
                        System.out.println("検索成功 : " + ptr);
                    break;

                case SEARCH_NAME:
                    temp.scanData("検索", Data.NAME);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("当てはまる名前のデータがありません。");
                    else
                        System.out.println("検索成功 : " + ptr);
                    break;

                case NEXT:
                    list.next();
                    break;

                case PRINT_CRNT:
                    list.printCurrentNode();
                    break;

                case DUMP:
                    list.dump();
                    break;

                case CLEAR:
                    list.clear();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}