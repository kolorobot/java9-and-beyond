package pl.codeleak.samples.java14.records;

import java.time.LocalDate;
import java.util.Objects;

record Owner(String name, String address, String city, String telephone) {
    /* Static initializer */
    static {
        NONE = "N/A";
    }
    /* Static fields are allowed, both private and public */
    private static String NONE;

    /* Records may have static methods */
    public static Owner anOwner(String name) {
        return new Owner(name, NONE, NONE, NONE);
    }
}

record PetType(String name) {
}

record Pet(LocalDate birthDate, PetType type, Owner owner) {
    /* `Compact` constructor */
    public Pet {
        requiresNotNull("birthDate", birthDate);
        requiresNotNull("type", type);
        requiresNotNull("owner", owner);
    }

    public Pet(LocalDate birthDate, PetType type) {
        this(birthDate, type, null);
    }

    /* Records may have instance methods */
    private void requiresNotNull(String name, Object obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException(name + " can't be null");
        }
    }
}
