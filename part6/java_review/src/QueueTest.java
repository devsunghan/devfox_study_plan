import java.util.Queue;

public class QueueTest {
    private int max; // Queueの容量
    private int front; // 最初に入ったデータを指すカーソル
    private int rear; // 最後に入ったデータを指すカーソル
    private int num; // Queueに入っているデータの数
    private int[] que; //　Queue

    //　Queueが空っぽの時、データを出すと発生するエラー
    public class EmptyQueueTestException extends RuntimeException {
        public EmptyQueueTestException() {}
    }

    //　Queueにデータがつまり、空き場所がないとき、データを入れると発生するエラー
    public class OverflowQueueTestException extends RuntimeException {
        public OverflowQueueTestException () {}
    }

    // Constructor
    public QueueTest(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // Queueにデータを入れるメソッド
    public int enque(int x) throws OverflowQueueTestException {
        if (num >= max)
            throw new OverflowQueueTestException();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    // Queueからデータを取り出すメソッド
    public int deque() throws EmptyQueueTestException {
        if (num <= 0)
            throw new EmptyQueueTestException();
        int x = que[front++];
        if (front == max)
            front = 0;
        return x;
    }

    // 現在、入っているデータの中で一番最初に入ったデータを確認するメソッド
    public int peek() throws EmptyQueueTestException {
        if (num <= 0)
            throw new EmptyQueueTestException();
        return que[front];
    }

    // パラメータのデータがQueueの中にあるか確認するメソッド
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // Queueを初期化
    public void clear() {
        num = front = rear = 0;
    }

    // Queueの容量を確認
    public int capacity() {
        return max;
    }

    // Queueに入っているデータの数を確認
    public int size() {
        return num;
    }

    // Queueに入っているデータがあるか確認
    public boolean isEmpty() {
        return num <= 0;
    }

    // Queueの容量いっぱいまでデータが積まれているかを確認
    public boolean isFull() {
        return num >= max;
    }

    // Queueに入っているデータをBottomからTopの順で表示します。
    public void dump() {
        if (num <= 0)
            System.out.println("Queueが空っぽです。");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
