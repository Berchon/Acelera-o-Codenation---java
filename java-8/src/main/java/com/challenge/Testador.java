package com.challenge;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Testador {

    @Somar
    public BigDecimal soma1;

    @Subtrair
    public BigDecimal soma2;

    public Testador(BigDecimal soma1, BigDecimal soma2) {
        this.soma1 = soma1;
        this.soma2 = soma2;
    }

    public BigDecimal getSoma1() {
        return soma1;
    }

    public void setSoma1(BigDecimal soma1) {
        this.soma1 = soma1;
    }

    public BigDecimal getSoma2() {
        return soma2;
    }

    public void setSoma2(BigDecimal soma2) {
        this.soma2 = soma2;
    }
}
