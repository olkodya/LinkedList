package com.list;


import org.jetbrains.annotations.Nullable;

public class Node {
    @Nullable
    private Node next;

    public Node(@Nullable Node next, Object data) {
        this.next = next;
        this.data = data;
    }

    public void setNext(@Nullable Node next) {
        this.next = next;
    }

    public @Nullable Node getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
}
