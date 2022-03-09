package com.patangoma.patangoma;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private static final AtomicInteger skuCounter = new AtomicInteger(1000);

    public static int getNextId(){
        return idCounter.incrementAndGet();
    }

    public static int getNextSku(){
        return skuCounter.incrementAndGet();
    }
}
