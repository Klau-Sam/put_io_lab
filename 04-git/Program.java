package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        var list = new ArrayList<String>(
                List.of("Coff","CAPPU","latte"));

        list.forEach((item)->
        {
            list.remove(item);
        });
        System.out.println(list);
    }
}