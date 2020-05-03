package pl.codeleak.samples.java9;

interface StringProcessor {

    static String name() {
        return "The String Processor";
    }

    String parse(String string);

    default String parseAndCapitalize(String string) {
        return doProcessAndCapitalize(string);
    }

    /* Private methods are now allowed in interfaces in Java */
    private String doProcessAndCapitalize(String string) {
        return parse(string).toUpperCase();
    }
}
