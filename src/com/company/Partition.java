package com.company;

public class Partition {
    String name;
    int size;
    public boolean fragmented=false;
    public boolean empty=true;

    public Partition(String name, int size) {
        this.name = name;
        this.size = size;

    }
}
