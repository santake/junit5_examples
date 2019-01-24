package jp.takeshi.parameterized;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

import jp.takeshi.Rank;

class ParameterEnumSourceTest {

    
    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void test01(TimeUnit tu) {
	assertNotNull(tu);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"CAPTAIN", "CHIEF_MATE"})
    void test02(Rank rank) {
	assertNotNull(rank);
	assertTrue(rank == Rank.CAPTAIN || rank == Rank.CHIEF_MATE);
    }
    
    

}
