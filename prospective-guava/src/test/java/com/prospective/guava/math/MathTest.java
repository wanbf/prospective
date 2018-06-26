package com.prospective.guava.math;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.math.RoundingMode;


public class MathTest extends TestCase {
    public void test() {
        assertEquals(2, LongMath.log2(4, RoundingMode.FLOOR));
        assertEquals(6, IntMath.checkedMultiply(2, 3));
        assertEquals(3, LongMath.divide(9, 3, RoundingMode.UNNECESSARY));
        assertEquals(new BigInteger("3"), BigIntegerMath.sqrt(new BigInteger("12"), RoundingMode.FLOOR));
    }
}
