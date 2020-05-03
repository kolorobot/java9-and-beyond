package pl.codeleak.samples.java14.records;

import java.time.LocalDate;
import java.util.Objects;

public record Pet(LocalDate birthDate, PetType type, Owner owner) {

    /* Optional `compact` constructor */
    public Pet {
        requiresNotNull("birthDate", birthDate);
        requiresNotNull("type", type);
        requiresNotNull("owner", owner);
    }

    /* Records may have private methods */
    private void requiresNotNull(String name, Object obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException(name + " can't be null");
        }
    }
}
