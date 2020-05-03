module java9.jpms.module1 {
    requires java.base; // optional
    requires transitive java.logging;
    exports pl.codeleak.samples.jpms.module1.api;
}