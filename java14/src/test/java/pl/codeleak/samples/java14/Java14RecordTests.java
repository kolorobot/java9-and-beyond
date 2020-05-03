package pl.codeleak.samples.java14;

import org.junit.jupiter.api.Test;
import pl.codeleak.samples.java14.records.Owner;
import pl.codeleak.samples.java14.records.Pet;
import pl.codeleak.samples.java14.records.PetType;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class Java14RecordTests {

    @Test
    void recordGetters() {

        var owner = new Owner("John Doe", "110 W. Liberty St.", "Madison", "6085551023");

        assertThat(owner.name()).isEqualTo("John Doe");
        assertThat(owner.address()).isEqualTo("110 W. Liberty St.");
        assertThat(owner.city()).isEqualTo("Madison");
        assertThat(owner.telephone()).isEqualTo("6085551023");

    }

    @Test
    void recordEqualsAndHashCode() {

        var pet1 = new Pet(LocalDate.of(2019, 1, 1), new PetType("dog"), Owner.anOwner("John Doe"));
        var pet2 = new Pet(LocalDate.of(2019, 1, 1), new PetType("dog"), Owner.anOwner("John Doe"));

        assertThat(pet1).isEqualTo(pet2);
        assertThat(pet1.hashCode()).isEqualTo(pet2.hashCode());

    }

    @Test
    void recordToString() {
        var pet = new PetType("dog");

        assertThat(pet.toString()).isEqualTo("PetType[name=dog]");
    }
}