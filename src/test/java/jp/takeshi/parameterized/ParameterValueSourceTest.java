package jp.takeshi.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void testInts(int val) {
	assertTrue(val < 10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1,2,3,4,5,6})
    void testDoubles(double val) {
	assertTrue(val < 10.0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4"})
    void testStrs(String val) {
	assertTrue(Integer.parseInt(val) < 10);
    }

}
