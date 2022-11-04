package dataStructure;

import java.util.Comparator;

public class LinkedList<E> {

    // node
    class Node<E> {
        private E data; // データ
        private Node<E> next; // 次のnodeを指すポインター

        // Constructor
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // 最初のnode
    private Node<E> crnt; // 特定のnodeを検索、削除する時に必要なnode


    // Constructor
    public LinkedList() {
        head = crnt = null;
    }

    // nodeの検索
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head; // 現在、調べているnode

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) { // 検索成功
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; // 次のnodeを選択（調べるために）
        }
        return null; // 検索失敗
    }


    // リストに最初(頭)のNodeを入れる
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    // リストの一番後ろ（尻尾）にNodeを入れる
    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 頭のNodeを削除
    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    // 尻尾のNodeを削除
    public void removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();  // リストにデータが一つしか無ければ、頭を削除
            else {
                Node<E> ptr = head; // scan中のNode
                Node<E> pre = head; // scan中のNodeの前のNode

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }


    // 特定のNode、pを削除
    public void remove(Node p) {
        if (head != null) {
            if (p == head)
                removeFirst();
            else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return; // 削除したいNodeがリストに無い
                }
                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }


    // 現在、選択中のNode（crnt）を削除
    public void removeCurrentNode() {
        remove(crnt);
    }


    // 全てのNodeを削除
    public void clear() {
        while (head != null)
            removeFirst();
        crnt = null;
    }


    // 選択中のNodeの後ろに移動
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false; // 移動できない
        crnt = crnt.next;
        return true;
    }


    // 選択中のNodeをプリント
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }


    // 全てのNodeをプリント
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

}
