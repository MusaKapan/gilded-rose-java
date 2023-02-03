package com.gildedrose;

public class Util {

    public static void repeat(int times, Runnable r) {
        for (int i = 0; i < times; i++) r.run();
    }

    public static int clamp(int min, int max, int value) {
        return Math.max(min, Math.min(max, value));
    }
}
