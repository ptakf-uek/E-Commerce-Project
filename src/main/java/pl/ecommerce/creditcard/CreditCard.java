package pl.ecommerce.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance = BigDecimal.valueOf(0);
    private BigDecimal creditLimit;
    public CreditCard(String cardNumber) {
    }

    public void assignLimit(BigDecimal creditAmount) {
        if (isLimitAlreadyAssinged()) {
            throw new CreditLimitAlreadyAssignedException();
        }

        if (isCreditCardBelowThreshold(creditAmount)) {
            throw new CreditLimitBelowTresholdException();
        }

        this.creditLimit = creditAmount;
    }

    private boolean isLimitAlreadyAssinged() {
        return creditLimit != null;
    }

    private static boolean isCreditCardBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void deposit(BigDecimal creditAmount) {
        this.balance = balance.add(creditAmount);
    }

    public void withdraw(BigDecimal creditAmount) {
        if (creditAmount.compareTo(balance) > 0) {
            throw new WihtdrawingAmountLargerThanBalanceException();
        }

        if (creditAmount.compareTo(creditLimit) > 0) {
            throw new WihtdrawingAmountOverCreditLimitException();
        }

        this.balance = balance.subtract(creditAmount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
