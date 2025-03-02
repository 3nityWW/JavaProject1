package com.example;

public class Main {
    public static void main(String[] args) {
        Container<String> container = new Container<>();
        container.add("12345");
        container.add("aboba");
        container.add("you");

        System.out.println("Container: " + container);
        System.out.println("Element at index 1: " + container.get(1));

        container.remove(1);
        System.out.println("Container after removal: " + container);
    }
}