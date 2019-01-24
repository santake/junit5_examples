package jp.takeshi.parameterized;

import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedMethodSourceTest {

    /*
     * Get value from internal static method:
     */
    @ParameterizedTest
    @MethodSource("getRange")
    void test01MethodSource(int val) {
	assertNotEquals(9, val);
    }
    
    /*
     * invoke method outside of this class (Calling ValueProvider#getInts())
     */
    @ParameterizedTest
    @MethodSource("jp.takeshi.pm.ValueProvider#getInts")
    void test02MethodSource(int val) {
	assertNotEquals(9, val);
    }
    
    /*
     * invoke method outside of this class (Calling ValueProvider#getStrings())
     */
    @ParameterizedTest
    @MethodSource("jp.takeshi.pm.ValueProvider#getStrings")
    void test03MethodSoure(String val) {
	assertTrue(val.length()< 4);
    }
    
    
    
    // --------- for method source ---------------------

    private static IntStream getRange() {
	return IntStream.range(0, 30).skip(10);
    }
}
