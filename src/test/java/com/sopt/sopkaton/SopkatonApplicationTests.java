package com.sopt.sopkaton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SopkatonApplicationTests {
    @Test
    void contextLoads() {
        String answer = happinessContent(4);
        assertEquals("4", answer);
    }

    private String happinessContent(Integer emotion) {
        return switch (emotion) {
            case 0 -> "0";
            case 1 -> "1";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            default -> "7";
        };
    }
}
