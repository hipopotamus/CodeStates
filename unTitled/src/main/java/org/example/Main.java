package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.ToIntBiFunction;

public class Main {
    public static void main(String[] args) {
        IntFunction<Integer> test = SectionTest::test;
        List<ToIntBiFunction<SectionTest, Integer>> list = new ArrayList<>();
    }
}