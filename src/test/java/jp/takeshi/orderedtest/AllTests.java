package jp.takeshi.orderedtest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Run all under jp.takeshi.orderedtest")
@SelectPackages({
    "jp.takeshi.orderedtest"
})
public class AllTests {

}
