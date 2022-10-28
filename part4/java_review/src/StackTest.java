public class StackTest {
    private int max; // Stackの容量
    private int ptr; // Stackのポインタ
    private int[] stk; //Stack

    // Stackが空っぽの時、データを出すと発生するエラー
    public class EmptyStackTestException extends RuntimeException {
        public EmptyStackTestException() {}
    }

    //　Stackにデータがつまり、空き場所がないとき、データを入れると発生するエラー
    public class OverflowStackTestException extends RuntimeException {
        public OverflowStackTestException() {}
    }

    // StackのConstructor
    public StackTest (int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // データを入れるメソッド
    public int push(int x) throws OverflowStackTestException {
        if (ptr >= max)
            throw new OverflowStackTestException();
        return stk[ptr++] = x;
    }

    // データを出すメソッド
    public int pop() throws EmptyStackTestException {
        if (ptr <= 0)
            throw new EmptyStackTestException();
        return stk[--ptr];
    }

    // 一番最後に入ったデータを確認するメソッド
    public int peek() throws EmptyStackTestException {
        if (ptr <= 0)
            throw new EmptyStackTestException();
        return stk[ptr - 1];
    }

    // Stackにパラメーターと一致するデータがあるか確認し、どこにあるかreturn、無ければ-1をreturn
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    // Stackを初期化
    public void clear() {
        ptr = 0;
    }

    // Stackの容量を確認
    public int capacity() {
        return max;
    }

    // Stackに入っているデータの数をreturn
    public int size() {
        return ptr;
    }

    // Stackが空っぽなのか確認
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // Stackの容量いっぱいまでデータが積まれているかを確認
    public boolean isFull() {
        return ptr >= max;
    }

    // Stackに入っているデータをBottomからTopの順で表示します。
    public void dump() {
        if (ptr <= 0)
            System.out.println("Stackが空っぽです。");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
