package jp.takeshi.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ParameterizedCsvSourceTest {

    @ParameterizedTest
    @CsvSource({ 
	"foo,1", 
	"bar,2", 
	"baz,3" })
    void test01FromLine(String first, String second) {
	assertNotNull(first);
	assertNotNull(second);
    }
    
    
    /*
     * NOTE: the file path is FROM class path.
     */
    @ParameterizedTest
    @CsvFileSource(resources="/testdata.csv", numLinesToSkip=1)
    void test02FromFile(String country, int ref) {
	assertNotNull(country);
	assertTrue(ref >= 0);
    }

}
