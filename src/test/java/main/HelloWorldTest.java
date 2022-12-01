package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloWorldTest {

    @Test
    public void HelloWorldNormalNumbers() {

        Main hw = new Main();
        Assertions.assertEquals("1", hw.convert(1));
        Assertions.assertEquals("2", hw.convert(2));
    }

    @Test
    public void HelloWorldThreeNumbers() {

        Main fb = new Main();
        Assertions.assertEquals("Hello", fb.convert(3));
    }

    @Test
    public void HelloWorldFiveNumbers() {

        Main hw = new Main();
        Assertions.assertEquals("World", hw.convert(5));
    }

    @Test
    public void HelloWorldThreeAndFiveNumbers() {

        Main hw = new Main();
        Assertions.assertEquals("World", hw.convert(5));
    }
}