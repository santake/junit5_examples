package jp.takeshi.parameterized;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValueProvider {
    
    public static IntStream getInts() {
	return IntStream.range(0, 30).skip(10);
    }
    

    public static Stream<String> getStrings() {
        return Stream.of(".", "oo", "OOO");
    }

}
