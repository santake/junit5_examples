package jp.takeshi.basic;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assumptions.*;

import jp.takeshi.Person;

/**
 * NOTE: assertThat() is not available on JUnit5. You should use Hamcrest
 * Matcher's assertThat() instead if you want.
 *
 */
@DisplayName("Unit Tests by using JUnit5")
class PersonTest {

    @BeforeAll
    static void initAll() {
	// do something
    }

    @AfterAll
    static void tearDownAll() {
	// do something
    }

    private Person p_ = null;

    @BeforeEach
    void init() {
	this.p_ = new Person();
	this.p_.setId("JTK");
	this.p_.setFirstName("James");
	this.p_.setLastName("Kirk");
	this.p_.setNickName("Captain");
	this.p_.setEmail("james.t.kirk@enterprise.uss");
    }

    @AfterEach
    void tearDown() {
	this.p_.clear();
	this.p_ = null;
    }

    @Test
    @DisplayName("Test basic assertNotNull()")
    void testNotNull() {
	assertNotNull(this.p_);
    }
    
    @Test
    @DisplayName("Test using Hamcrest MatcherAssert.assertThat()")
    void testAssertThat() {
	// Hamcrest: MatcherAssert.assertThat
	assertThat(this.p_, notNullValue());
    }
    
    @Test
    @DisplayName("Test assertAll()")
    void testAssertAll() {
	assertAll("all values should not be empty",
		() -> assertNotNull(this.p_.getId()), 
		() -> assertNotNull(this.p_.getFirstName()),
		() -> assertNotNull(this.p_.getLastName()),
		() -> assertNotNull(this.p_.getEmail())
		);
    }
    
    @Test
    @DisplayName("Test expecting runtime exceptions")
    void testRuntimeException() {
	Throwable t = assertThrows(IllegalArgumentException.class,
		() -> this.p_.throwingRuntimeException() );
	assertEquals("error", t.getMessage());
    }
    
    @Test
    @DisplayName("Test expecting exceptions")
    void testException() {
	Throwable t = assertThrows(Exception.class,
		() -> {
		    this.p_.throwingException();   
		});
	assertEquals("error", t.getMessage());
    }
    
    @Test
    @DisplayName("Test expecting NOT timeout")
    void testTimeoutSimple() {
	String result = assertTimeout(Duration.ofSeconds(5),
		()-> {
		    return this.p_.getId();
		});
	assertNotNull(result);
    }
    
    @Test
    @DisplayName("Test timeout = this will wait for the sleep.")
    void testTimeoutExceeded() {
        assertTimeout(Duration.ofMillis(10), () -> {
            // JUnit will wait for the below process finishes.
            Thread.sleep(3000);
        });
    }

    @Test
    @DisplayName("Test timeout = this will IMMEDIATELY abort if the expected time comes")
    void testTimeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            // JUnit will abort right after the above duration comes
            Thread.sleep(3000);
        });
    }

    
    // ----- assume ---------
    @Test
    @DisplayName("Test assumingThat()")
    void testAssumingThat() {
	String OS = System.getProperty("os.name").toLowerCase();
	assumingThat(OS.startsWith("mac"), () -> {
	    assertEquals("James", this.p_.getFirstName());
	    assertEquals("Kirk", this.p_.getLastName());
	    assertEquals("james.t.kirk@enterprise.uss", this.p_.getEmail());
	});
    }
    
    
    // ----- run on specific OS --------
    
    @Test
    @DisplayName("Test on only specific OS = Mac")
    @EnabledOnOs(OS.MAC)
    void testOnMac() {
	assertNotNull(this.p_);
    }
    @Test
    @DisplayName("Test on only specific OS = Win")
    @EnabledOnOs(OS.WINDOWS)
    void testOnWin() {
	assertNotNull(this.p_);
    }
    @Test
    @DisplayName("Test on only specific OS = UNIXs")
    @EnabledOnOs({OS.AIX, OS.LINUX, OS.SOLARIS})
    void testOnUnix() {
	assertNotNull(this.p_);
    }
    // ------ run on specific JRE ---------
    @Test
    @DisplayName("Test on Java8")
    @EnabledOnJre(JRE.JAVA_8)
    void testOnJava8() {
	assertNotNull(this.p_);
    }
    @Test
    @DisplayName("Test on Java9,10")
    @EnabledOnJre({JRE.JAVA_9, JRE.JAVA_10})
    void testOnJava9or10() {
	assertNotNull(this.p_);
    }
    @Test
    @DisplayName("Test on Java11")
    @EnabledOnJre(JRE.JAVA_11)
    void testOnJava11() {
	assertNotNull(this.p_);
    }
    
    
    // ----- run conditions ---------------
    @Test
    @DisplayName("Test enabled if condition")
    @EnabledIf(" 2 * 3 == 6")
    void testEnabledIf() {
	assertNotNull(this.p_);
    }
    
    // ----- repeating test ---------
    @RepeatedTest(5)
    @DisplayName("Running test repeatedly")
    void testRepeat() {
	assertNotNull(this.p_);
    }
    
    
    @Disabled
    @Test
    @DisplayName("Test disabled")
    void testDisabled() {
	assertNotNull(this.p_);
    }
}
