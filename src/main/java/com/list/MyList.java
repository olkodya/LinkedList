package com.list;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class MyList {

    public void add(Object ob) {
        Node cur = head;
        if (head == null) {
            head = new Node(null, ob);
            size++;
            return;
        }
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        Node node = new Node(null, ob);
        size++;
        cur.setNext(node);
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    public void add(Object ob, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node cur = head;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.getNext();
        }
        Node node = new Node(null, ob);
        if (prev == cur) {
            head = node;
            node.setNext(cur);
            size++;
            return;
        }
        size++;
        prev.setNext(node);
        node.setNext(cur);
    }


    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node cur = head;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.getNext();
        }
        if (cur == prev)
            head = head.getNext();
        Object ob = cur.getData();
        prev.setNext(cur.getNext());
        size--;
        return ob;
    }

    public int getSize() {
        return size;
    }

    int partition(int start, int end) {
        System.out.println("End: " + end);
        Node pivot = get(end);
        Node prev;
        Node pPrev;
        Node pivotPrev;
        if (end - 1 < 0)
            pivotPrev = null;
        else
            pivotPrev = get(end - 1);
        if (start - 1 < 0)
            pPrev = null;
        else
            pPrev = get(start - 1);
        Node cur = get(start);
        int pIndex = start;
        Node p = get(pIndex);
        if (start - 1 < 0)
            prev = null;
        else
            prev = get(start - 1);
        System.out.println(pivot.getData());
        if (pivot.getData() instanceof Integer) {
            System.out.println("pivot = " + pivot.getData());
            while (cur != pivot) {
                System.out.println("cur = " + cur.getData());
                System.out.println("p = " + p.getData());
                if ((Integer) cur.getData() <= (Integer) pivot.getData()) {
                    Node tmp;
                    if (p.getNext() != cur) {
                        tmp = p.getNext();
                        p.setNext(cur.getNext());
                        cur.setNext(tmp);
                        if (pPrev != null)
                            pPrev.setNext(cur);
                        else head = cur;
                        if (prev != null)
                            prev.setNext(p);
                    } else {
                        p.setNext(cur.getNext());
                        cur.setNext(p);
                        if (pPrev != null)
                            pPrev.setNext(cur);
                        else head = cur;
                    }
                    Node tmp2 = cur;
                    cur = p;
                    p = tmp2;
                    pPrev = p;
                    p = p.getNext();
                    pIndex++;
                }
                prev = cur;
                cur = cur.getNext();
                printList();
            }
            pPrev = get(pIndex - 1);
            p = pPrev.getNext();
            Node tmp;
            if (p.getNext() != pivot) {
                tmp = p.getNext();
                p.setNext(pivot.getNext());
                pivot.setNext(tmp);
                if (pPrev != null)
                    pPrev.setNext(pivot);
                if (pivotPrev != null)
                    pivotPrev.setNext(p);
            } else {
                p.setNext(pivot.getNext());
                pivot.setNext(p);
                pPrev.setNext(pivot);
            }
        }
        printList();
        return pIndex;
    }

    public void quickSort(int start, int end) {
        if (start >= end)
            return;
        int pivot = partition(start, end);
        System.out.println("pivot = " + pivot);
        quickSort(start, pivot - 1);
        printList();
        quickSort(pivot + 1, end);
        printList();

    }


    public void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public void serializeToXML() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("my_list.xml");
        Node cur = head;
        while (cur != null) {
            xmlMapper.writeValue(new File("my_list.xml"), cur);
            cur = cur.getNext();
            // assertNotNull(file);
        }
    }

    @Nullable
    private Node head = null;
    private int size = 0;
}
