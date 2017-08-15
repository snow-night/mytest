package dailytest.exception;

import java.io.IOException;

import com.google.common.base.Throwables;
import org.junit.Test;

public class ThrowableTest {

    @Test
    public void testThrowables(){
        try {
            throw new Exception();

        } catch (Throwable t) {
            String ss = Throwables.getStackTraceAsString(t);
            System.out.println("ss:"+ss);
            Throwables.propagate(t);
        }
    }

    @Test
    public void call() throws IOException {
        try {
            throw new IOException();
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            throw Throwables.propagate(t);
        }
    }
}

