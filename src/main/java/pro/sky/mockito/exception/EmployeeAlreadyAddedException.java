package pro.sky.mockito.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String employeeAlreadyAdded) {
        super(employeeAlreadyAdded);
    }
}
