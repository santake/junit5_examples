package jp.takeshi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Nested tests give you more capabilities to express the relationship 
 * among several group of tests. 
 * 
 *
 */
@DisplayName("Nested tests")
class PersonNestedTest {
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
    @DisplayName("Normal test")
    void testNormal() {
	assertNotNull(this.p_);
    }


    // ----------------- NESTED TEST CLASS -----------------------
    
    @Nested
    @DisplayName("Nested test class")
    class PersonTestInternal {
	private Person pi_ = null;
	@BeforeEach
	    void init() {
		this.pi_ = new Person();
		this.pi_.setId("LM");
		this.pi_.setFirstName("Leonard");
		this.pi_.setLastName("McCoy");
		this.pi_.setNickName("Bones");
		this.pi_.setEmail("bones@enterprise.uss");
	    }

	    @AfterEach
	    void tearDown() {
		this.pi_.clear();
		this.pi_ = null;
	    }
	    
	    @Test
	    @DisplayName("Nested: test middle name")
	    void testAssertMiddleName() {
		assertEquals("Bones", this.pi_.getNickName());
	    }
    }
}
