package org.az20.expendituretracker.home;


public class IncomeStub {
    private String name;
    private String amount;

    public IncomeStub(String name, String amount){
        this.name = name;
        this.amount = amount;
    }

    public IncomeStub() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
