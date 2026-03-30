package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    //Dodanie keyword final do niemutowalnych atrybutów klasy
    public static final int TOTAL = -1;
    public static final int ARRAY_LENGTH = 12;
    private int[] numbers = new int[ARRAY_LENGTH];

    public int total = TOTAL;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == TOTAL;
    }

    public boolean isFull() {
        return total == 11;
    }

    protected int peekaboo() {
        if (callCheck())
            return TOTAL;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return TOTAL;
        return numbers[total--];
    }

}
