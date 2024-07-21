package com.keyin.hynes.braden.qap2dsa.interfaces;
public interface Retrieve<T> {
    void list();
    boolean search(T query);
}