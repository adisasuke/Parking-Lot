package org.example.models;

public class Gate extends BaseModel {

    Operator currentOperator;
    public Gate(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }
}
