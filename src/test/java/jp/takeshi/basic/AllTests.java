package jp.takeshi.basic;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * NOTE: Eclipse + JUnit Jupiter Test suites is still "Work in progress"
 * (You will see strange 'Unrooted Tests' results after running your tests...)
 * 
 *
 */
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Run all under jp.takeshi.basic")
@SelectPackages({
    "jp.takeshi.basic"
})
public class AllTests {
//run all
}
