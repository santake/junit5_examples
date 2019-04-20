package jp.takeshi.parallel;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * Note you have to set the parameter
 * 'junit.jupiter.execution.parallel.enabled' to 'true'
 * in "junit-platform.properties" before running this test
 * 
 * @author santake
 *
 */
@Execution(ExecutionMode.CONCURRENT)
class ParallelTest {

    private static List<String> NAMES = Collections.synchronizedList(new ArrayList<>());

    @AfterAll
    static void afterAll() {
        //Assumptions.assumeTrue(isParallelExecutionEnable());  
        long count = NAMES.stream()
        	.distinct()
        	.count();
        assertEquals(2, count);
        System.out.println(NAMES);
    }
    
    @Test
    void test01() throws InterruptedException {
	Thread.sleep(10000);
	NAMES.add(Thread.currentThread().getName());
    }

    @Test
    void test02() throws InterruptedException {
	Thread.sleep(10000);
	NAMES.add(Thread.currentThread().getName());
    }

}
