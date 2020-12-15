package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    // 4.1 - Failure
    @Test
    public void test1() {
        assertEquals(5,1);
    }

    // 4.1 - Error
    @Test
    public void test2() throws NumberFormatException {
        throw new NumberFormatException ();
    }
    // 4.2 - czeka na AssertionFailedError
    @Test
    public void test3() throws Throwable {
        try {
            assertEquals(5,1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


}