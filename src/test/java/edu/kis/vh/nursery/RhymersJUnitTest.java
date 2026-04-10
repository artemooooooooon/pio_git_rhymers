package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testFifoOrder() {
        FIFORhymer fifo = new FIFORhymer();
        fifo.countIn(1);
        fifo.countIn(2);
        fifo.countIn(3);

        Assert.assertEquals(1, fifo.countOut());
        Assert.assertEquals(2, fifo.countOut());
        Assert.assertEquals(3, fifo.countOut());
    }

    @Test
    public void testFifoEmptyReturnsMinusOne() {
        FIFORhymer fifo = new FIFORhymer();
        Assert.assertEquals(-1, fifo.countOut());
    }

    @Test
    public void testFifoIsEmptyAfterDrain() {
        FIFORhymer fifo = new FIFORhymer();
        fifo.countIn(7);
        fifo.countOut();
        Assert.assertTrue(fifo.callCheck());
    }

    @Test
    public void testHanoiRejectsLargerNumbers() {
        HanoiRhymer hanoi = new HanoiRhymer();
        hanoi.countIn(5);
        hanoi.countIn(10);

        Assert.assertEquals(1, hanoi.reportRejected());
        Assert.assertEquals(5, hanoi.peekaboo());
    }

    @Test
    public void testHanoiAcceptsSmallerOrEqualNumbers() {
        HanoiRhymer hanoi = new HanoiRhymer();
        hanoi.countIn(10);
        hanoi.countIn(5); // 5 <= 10 – should be accepted

        Assert.assertEquals(0, hanoi.reportRejected());
        Assert.assertEquals(5, hanoi.peekaboo());
    }

    @Test
    public void testHanoiReportRejectedInitiallyZero() {
        HanoiRhymer hanoi = new HanoiRhymer();
        Assert.assertEquals(0, hanoi.reportRejected());
    }

    @Test
    public void testHanoiFirstElementAlwaysAccepted() {
        HanoiRhymer hanoi = new HanoiRhymer();
        hanoi.countIn(99);
        Assert.assertEquals(0, hanoi.reportRejected());
        Assert.assertFalse(hanoi.callCheck());
    }

}
