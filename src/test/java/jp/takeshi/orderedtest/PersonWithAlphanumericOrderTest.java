package jp.takeshi.orderedtest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import jp.takeshi.Person;

/**
 * Test running with 'alphanumeric' order
 * https://blog.codeleak.pl/2019/03/test-execution-order-in-junit-5.html
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class PersonWithAlphanumericOrderTest {

    @Test
    void testZZZZ() {
	System.out.println("Test #3");
	Person p = new Person();
	assertNotNull(p);
    }

    
    @Test
    void testYYYYYY() {
	System.out.println("Test #2");
	Person p = new Person();
	assertNotNull(p);
    }

    @Test
    void testXXXXX() {
	System.out.println("Test #1");
	Person p = new Person();
	assertNotNull(p);
    }


}
