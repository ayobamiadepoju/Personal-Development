import logger.MethodLogger;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

        Test test = new Test();

        MethodLogger.log(test, "add", 5, 3);
        MethodLogger.log(test, "multiply", 2, 4);
        MethodLogger.log(test, "riskyOperation");
    }
}