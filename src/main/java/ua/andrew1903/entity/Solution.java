package ua.andrew1903.entity;

public class Solution {
    private final int time;
    private final boolean success;

    public Solution(int time, boolean success) {
        this.time = time;
        this.success = success;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("Solution #%d - %b", time, success);
    }

    public boolean isCorrect() {
        return success;
    }
}
