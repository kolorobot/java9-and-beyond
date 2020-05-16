package pl.codeleak.samples.java11;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Java11TimeUnitConvertTests {

    public static final long DAYS_IN_A_YEAR = 365L;
    public static final long HOURS_IN_A_DAY = 24L;
    public static final long MINUTES_IN_AN_HOUR = 60L;
    public static final long SECONDS_IN_A_MINUTE = 60L;
    public static final long MILLISECONDS_IN_A_SECOND = 1000L;

    @Test
    @Order(1)
    void aYearInMillis() {

        // A year in milliseconds
        long yearInMillis = TimeUnit.MILLISECONDS.convert(Duration.ofDays(365)); // since Java 11

        assertThat(yearInMillis)
                .isEqualTo(DAYS_IN_A_YEAR * HOURS_IN_A_DAY * MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE * MILLISECONDS_IN_A_SECOND)
                .isEqualTo(TimeUnit.DAYS.toMillis(365))
                .isEqualTo(TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS))
                .isEqualTo(TimeUnit.MILLISECONDS.convert(Duration.of(365, TimeUnit.DAYS.toChronoUnit()))); // since Java 11

    }

    @Test
    @Order(2)
    void anHourInMillis() {

        long hourInMillis = TimeUnit.MILLISECONDS.convert(Duration.ofHours(1)); // since Java 11

        assertThat(hourInMillis)
                .isEqualTo(MINUTES_IN_AN_HOUR * SECONDS_IN_A_MINUTE * MILLISECONDS_IN_A_SECOND)
                .isEqualTo(TimeUnit.HOURS.toMillis(1))
                .isEqualTo(TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS))
                .isEqualTo(TimeUnit.MILLISECONDS.convert(Duration.of(1, TimeUnit.HOURS.toChronoUnit()))); // since Java 11
    }

    @Test
    @Order(3)
    void aMinuteInMillis() {

        long minuteInMillis = TimeUnit.MILLISECONDS.convert(Duration.ofMinutes(1)); // since Java 11

        assertThat(minuteInMillis)
                .isEqualTo(SECONDS_IN_A_MINUTE * MILLISECONDS_IN_A_SECOND)
                .isEqualTo(TimeUnit.MINUTES.toMillis(1))
                .isEqualTo(TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES))
                .isEqualTo(TimeUnit.MILLISECONDS.convert(Duration.of(1, TimeUnit.MINUTES.toChronoUnit()))); // since Java 11
    }

    @ParameterizedTest
    @MethodSource("timeUnitToDuration")
    @Order(4)
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
                Arguments.of(TimeUnit.MILLISECONDS, Duration.ofSeconds(11), 11000),  // 1s = 11000ms
                Arguments.of(TimeUnit.SECONDS, Duration.ofHours(1), 3600),  // 1h = 3600s
                Arguments.of(TimeUnit.HOURS, Duration.ofSeconds(4_000), 1),  // 4000s = 1h
                Arguments.of(TimeUnit.HOURS, Duration.ofSeconds(1_0000), 2)  // 10000s = 2h
        );
    }
}
