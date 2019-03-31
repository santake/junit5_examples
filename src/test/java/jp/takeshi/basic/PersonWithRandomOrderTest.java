package jp.takeshi.basic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import jp.takeshi.Person;


/**
 * https://blog.codeleak.pl/2019/03/test-execution-order-in-junit-5.html
 * @author santake
 *
 */
@TestMethodOrder(MethodOrderer.Random.class)
class PersonWithRandomOrderTest {

    @Test
    void testZZZZ() {
	System.out.println("Test #Z");
	Person p = new Person();
	assertNotNull(p);
    }

    @Test
    void testYYYYYY() {
	System.out.println("Test #Y");
	Person p = new Person();
	assertNotNull(p);
    }

    @Test
    void testXXXXX() {
	System.out.println("Test #X");
	Person p = new Person();
	assertNotNull(p);
    }

}
