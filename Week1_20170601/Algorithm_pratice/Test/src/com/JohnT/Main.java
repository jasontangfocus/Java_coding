package com.JohnT;

import sun.jvm.hotspot.utilities.Interval;

import java.sql.Time;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        long starTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                for(int k = 0; k < 1000; k++) {
                    if (i + j + k == 1000 && i * i + j * j == k * k) {
                        System.out.println("a:" + i + " b:" + j + " c:" + k);
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - starTime;

        Duration duration = Duration.ofNanos(totalTime);

        System.out.println(duration);

    }


}
