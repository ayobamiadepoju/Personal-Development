package logger;

import annotations.LogLevel;
import annotations.Loggable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodLogger {

    public static Object log(Object object, String methodName, Object... value) throws NoSuchMethodException {

        Class<?> c = object.getClass();
        Method targetMethod = null;

        for (Method method : c.getDeclaredMethods()) {
            if (method.getName().equals(methodName) && method.getParameterCount() == value.length) {
                targetMethod = method;
                targetMethod.setAccessible(true);
                break;
            }
        }
        if (targetMethod == null) {
            throw new NoSuchMethodException("Method not found: " + methodName);
        }

            try {
                if (targetMethod.isAnnotationPresent(Loggable.class)) {
                    LogLevel.Level level = LogLevel.Level.INFO;

                    if (targetMethod.isAnnotationPresent(LogLevel.class)) {
                        level = targetMethod.getAnnotation(LogLevel.class).value();
                    }

                    SimpleLogger.log(level, "→ Calling " + targetMethod.getName());
                    if (value.length > 0) {
                        SimpleLogger.log(level, "  Parameters: ");
                        for (int i = 0; i < value.length; i++) {
                            SimpleLogger.log(level, "    arg" + (i + 1) + ": " + value[i]);
                        }
                    }

                    long startTime = System.currentTimeMillis();
                    Object result = targetMethod.invoke(object, value);
                    long duration = System.currentTimeMillis() - startTime;
                    SimpleLogger.log(level, "← Finished " + targetMethod.getName() + " in " + duration + " ms");
                    return result;
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                SimpleLogger.error("Error invoking method: " + e.getMessage());
        }
        return object;
    }
}
