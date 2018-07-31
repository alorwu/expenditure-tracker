package org.az20.expendituretracker.home;

public class CategoryStub {
    private String name;
    private String actualBudget;
    private String spentBudget;

    public CategoryStub() {}

    public CategoryStub(String name, String actualBudget, String spentBudget) {
        this.setName(name);
        this.setActualBudget(actualBudget);
        this.setSpentBudget(spentBudget);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActualBudget() {
        return actualBudget;
    }

    public void setActualBudget(String actualBudget) {
        this.actualBudget = actualBudget;
    }

    public String getSpentBudget() {
        return spentBudget;
    }

    public void setSpentBudget(String spentBudget) {
        this.spentBudget = spentBudget;
    }
}
