package ru.netology.DGrigoryev.domain.operation;

import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class CashbackOperation extends Operation {
    private int cashbackAmount;

    @Override
   public void printToConsole() {
        System.out.printf("[cashbackAmount = %d]", cashbackAmount);
        System.out.println();
   }

    public CashbackOperation(int OperationID, int CustomerID, int sum, String currency, String merchant, int cashbackAmount) {
        super(OperationID, CustomerID, sum, currency, merchant);
        this.cashbackAmount = cashbackAmount;
    }
}
