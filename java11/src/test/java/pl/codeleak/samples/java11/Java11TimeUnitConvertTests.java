package pl.codeleak.samples.java11;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class Java11TimeUnitConvertTests {

    @Test
    void timeUnitConvertDuration() {
        TimeUnit unit = TimeUnit.DAYS;

        long result = unit.convert(Duration.ofHours(48));

        assertThat(result).isEqualTo(2);
    }
}
