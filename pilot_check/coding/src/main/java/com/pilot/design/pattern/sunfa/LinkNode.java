package com.pilot.design.pattern.sunfa;


/**
 * LinkNod class
 *
 * @author yuanyuanding
 * @date 2019/06/06
 */
public class LinkNode {
    private int val;

    private LinkNode pre;

    private LinkNode next;

    private LinkNode(int val) {
        this.val = val;
    }

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public static void main(String[] args) {

        int[] array = {5, 7, 3, 8, 4};

        LinkNode linkNode = new LinkNode(5);
        LinkNode linkNode1 = new LinkNode(7);
        LinkNode linkNode2 = new LinkNode(3);
        LinkNode linkNode3 = new LinkNode(8);
        LinkNode linkNode4 = new LinkNode(4);

        linkNode.pre = null;
        linkNode.next = linkNode1;

        linkNode1.pre = linkNode;
        linkNode1.next = linkNode2;

        linkNode2.pre = linkNode1;
        linkNode2.next = linkNode3;

        linkNode3.pre = linkNode2;
        linkNode3.next = linkNode4;

        linkNode4.pre = linkNode3;
        linkNode4.next = null;

        sort(linkNode, linkNode4);

        while (linkNode != null) {
            System.out.print(linkNode.val);
            linkNode = linkNode.next;
        }

        quickSort(array, 0, array.length - 1);
        System.out.println("======");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    /**
     * 双向链表快速排序
     *
     * @param first
     * @param tail
     */
    public static void sort(LinkNode first, LinkNode tail) {
        if (first == null || tail == null || first == tail) {
            return;
        }

        if (first != tail) {
            LinkNode mid = getMid(first, tail);
            sort(first, mid);
            sort(mid.next, tail);
        }

    }

    public static LinkNode getMid(LinkNode first, LinkNode tail) {
        int value = first.val;
        while (first != tail) {
            while (first != tail && tail.val > value) {
                tail = tail.pre;
            }
            first.val = tail.val;
            while (first != tail && first.val <= value) {
                first = first.next;
            }
            tail.val = first.val;
        }
        first.val = value;
        return first;
    }

    /**
     * 快速排序
     *
     * @param array
     * @param i
     * @param j
     */
    public static void quickSort(int []array, int i, int j) {
        if (i < j) {

            int mid = getMid(array, i, j);
            quickSort(array, i, mid - 1);
            quickSort(array, mid + 1, j);
        }
    }

    public static int getMid(int []array, int low, int heigh) {
        int value = array[low];
        while (low < heigh) {
            while (low < heigh && array[heigh] > value) {
                heigh--;
            }
            array[low] = array[heigh];

            while (low < heigh && array[low] <= value) {
                low++;
            }
            array[heigh] = array[low];
        }

        array[low] = value;

        return low;
    }
}
