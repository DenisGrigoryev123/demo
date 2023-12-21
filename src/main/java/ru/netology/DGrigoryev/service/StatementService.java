package ru.netology.DGrigoryev.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.netology.DGrigoryev.domain.operation.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    @PostConstruct
    public void initStorage() {
        this.saveOperation(new Operation(0, 0, 100, "Euro", "eBay"));
        this.saveOperation(new Operation(1, 1, 100, "Euro", "Amazon"));
    }

    public List<Operation> deleteOperation(int opID) {
        List<Operation> needValue = null;
        for (List<Operation> operations : storage.values()) {
            for (Operation operation : operations) {
                if (operation.getOperationID() == opID) {
                    needValue = operations;
                    break;
                }
            }
        }
        if (needValue != null ) {
            needValue.remove(opID);
            return needValue;
        }
        return new ArrayList<>();
    }

    public String getAllOperations() {
        return storage.toString();
    }

    public List<Operation> getOperationsByCustomerId(int custID) {
        if (storage.get(custID) == null)
            return createListInMapForNewCustomer(custID);
        return storage.get(custID);
    }

    private List<Operation> createListInMapForNewCustomer(int custID) {
        List<Operation> customerOperations = new ArrayList<>();
        storage.put(custID, customerOperations);
        return customerOperations;
    }

    public List<Operation> saveOperation(Operation op) {
        if (!storage.containsKey(op.getCustomerID()))
            createListInMapForNewCustomer(op.getCustomerID());
        List<Operation> operations = storage.get(op.getCustomerID());
        operations.add(op);
        return storage.get(op.getCustomerID());
    }
}