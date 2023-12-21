package ru.netology.DGrigoryev.domain.operation;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class LoanOperation extends Operation {
    private int loadId;

    public void printToConsole() {
        System.out.printf("[loadId = %d]", loadId);
        System.out.println();
    }

    public LoanOperation(int opID, int custID, int sum, String cur, String merch, int loadId) {
        super(opID, custID, sum, cur, merch);
        this.loadId = loadId;
    }
}
