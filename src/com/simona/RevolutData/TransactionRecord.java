package com.simona.RevolutData;

import java.util.Date;

enum TransactionType {
    TRANSFER,
    CARD_PAYMENT,
    TOPUP
}

public class TransactionRecord {
    public Date transactionDate;
    public String accountName;
    public float amount;
    public TransactionType transactionType;
    public String description;
    public String currency;
}
