package fibonacci;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class FibonacciWithoutRecursionTest {

    private static Fibonacci fibonacci;

    @BeforeClass
    public static void signUp() {
        fibonacci = new FibonacciWithoutRecursion(5);
    }

    @Test
    public void getMember_whenRequestZeroMember_return1() {
        int result = fibonacci.getMember(0);
        assertEquals(1, result);
    }

    @Test
    public void getMember_whenRequestLastMember_return5() {
        int result = fibonacci.getMember(4);
        assertEquals(5, result);
    }

    @Test
    public void getMember_whenRequestThirdMember_return3() {
        int result = fibonacci.getMember(3);
        assertEquals(3, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMember_whenGenerateException_returnException() {
        int result = fibonacci.getMember(5);
    }

    @Test
    public void getLastMember() {
        int result = fibonacci.getLastMember();
        assertEquals(5, result);
    }

    @Test
    public void iterator_whenIterateToThirdElement_return2() {
        int result = 0;
        Iterator iterator = fibonacci.iterator();
        for (int i = 0; i < 3; i++) {
            if (iterator.hasNext()) {
                result = (int) iterator.next();
            }
        }
        assertEquals(2, result);
    }

    @Test
    public void iterator_whenIterateToOutsizeElement_returnNull() {
        int result = 0;
        Iterator iterator = fibonacci.iterator();
        for (int i = 0; i < 6; i++) {
            if (iterator.hasNext()) {
                result = (int) iterator.next();
            }
        }
        assertEquals(5, result);
    }
}