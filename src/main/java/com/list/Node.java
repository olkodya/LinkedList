package com.list;


import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class Node implements Serializable {
    @Nullable
    private Node next;

    public Node(@Nullable Node next, UserType data) {
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

    public void setData(UserType data) {
        this.data = data;
    }

    private UserType data;
}
