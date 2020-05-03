package pl.codeleak.samples.java14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Java14InstanceOfTests {
    @Test
    void name() {
        CarManufacturer cm1 = new BavariaMotors();
        CarManufacturer cm2 = new VAG();

        if (cm1 instanceof BavariaMotors bmw) {
            assertThat(bmw).isInstanceOf(BavariaMotors.class);
        } else {
            Assertions.fail("Expecting cm1 to be instance of BavariaMotors");
        }

        if (cm2 instanceof VAG vag) {
            assertThat(vag).isInstanceOf(VAG.class);
        } else {
            Assertions.fail("Expecting cm2 to be instance of VAG");
        }
    }
}

interface CarManufacturer {
}

class BavariaMotors implements CarManufacturer {
}

class VAG implements CarManufacturer {
}