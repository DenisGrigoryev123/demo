package ru.netology.DGrigoryev.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.DGrigoryev.domain.ConsolePrintable;

@Data
@AllArgsConstructor
public class Operation implements ConsolePrintable {
    private int operationID;
    public void printToConsole() {
        System.out.printf("[operationID = %d, customerID = %d sum = %d currency = %s merchant = %s]", operationID, customerID, sum, currency, merchant);
        System.out.println();
    }
    private int customerID;
    private int sum;
    private String currency;
    private String merchant;
}
