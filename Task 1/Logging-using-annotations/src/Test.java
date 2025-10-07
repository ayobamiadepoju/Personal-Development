import annotations.LogLevel;
import annotations.Loggable;

public class Test {

    @Loggable
    @LogLevel(LogLevel.Level.INFO)
    public int add(int a, int b) {
        return a + b;
    }

    @Loggable
    @LogLevel(LogLevel.Level.DEBUG)
    public int multiply(int a, int b) {
        return a * b;
    }

    @Loggable
    @LogLevel(LogLevel.Level.ERROR)
    public void riskyOperation() {
        throw new RuntimeException("Something went wrong!");
    }
}