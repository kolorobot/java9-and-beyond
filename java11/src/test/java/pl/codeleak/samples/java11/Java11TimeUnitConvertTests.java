package pl.codeleak.samples.java11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Java11TimeUnitConvertTests {

    @ParameterizedTest
    @MethodSource("timeUnitToDuration")
    void convertTimeUnitToDuration(TimeUnit unit, Duration duration, long expectedResult) {
        long actualResult = unit.convert(duration);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> timeUnitToDuration() {
        return Stream.of(
                Arguments.of(TimeUnit.DAYS, Duration.ofHours(24), 1), // 24h = 1d
                Arguments.of(TimeUnit.DAYS, Duration.ofHours(40), 1), // 40h = 1d
                Arguments.of(TimeUnit.DAYS, Duration.ofHours(48), 2), // 48h = 2d
                Arguments.of(TimeUnit.DAYS, Duration.ofHours(50), 2),  // 50h = 2d
                Arguments.of(TimeUnit.MILLISECONDS, Duration.ofSeconds(1), 1000),  // 1s = 1000ms
                Arguments.of(TimeUnit.SECONDS, Duration.ofHours(1), 3600),  // 1h = 3600s
                Arguments.of(TimeUnit.HOURS, Duration.ofSeconds(4_000), 1),  // 4000s = 1h
                Arguments.of(TimeUnit.HOURS, Duration.ofSeconds(1_0000), 2)  // 10000s = 2h
        );
    }
}
