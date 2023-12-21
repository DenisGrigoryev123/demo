package ru.netology.DGrigoryev.exception;


public class CustomerOperationOutOfBoundException extends OperationRuntimeException {

    public CustomerOperationOutOfBoundException(int custId, int opId) {
        super();
        this.customerId = custId;
        this.operationId = opId;
    }
    public static final String MESSAGE = "Exception while trying to save operation %s for customer %s";
    private int customerId;
    private int operationId;

    @Override
    public String getMessage() {
        return MESSAGE.formatted(operationId, customerId);
    }
}
