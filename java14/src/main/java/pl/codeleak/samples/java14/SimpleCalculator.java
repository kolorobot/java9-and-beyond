package pl.codeleak.samples.java14;

class SimpleCalculator {
    static double calculate(String operator, double x, double y) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> {
                if (y == 0) {
                    throw new IllegalArgumentException("Can't divide by 0");
                }
                yield x / y;
            }
            default -> throw new IllegalArgumentException("Unknown operator '%s'".formatted(operator));
        };
    }
}
