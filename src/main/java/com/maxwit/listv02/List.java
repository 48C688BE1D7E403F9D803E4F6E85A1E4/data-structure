package com.maxwit.listv02;

import java.util.function.Consumer;

public interface List<T> {
    public Boolean insert(T data);
    public void traversal(Consumer<T> visit);
}
