package pro.sky.mockito.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
    super(message);
    }
}