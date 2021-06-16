package com.challenge;

import com.challenge.desafio.CalculadorDeClasses;
import com.challenge.interfaces.Calculavel;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Calculavel obj = new CalculadorDeClasses();
        Testador t = new Testador(new BigDecimal(10), new BigDecimal(2));
//        System.out.println(obj.somar(t));
//        System.out.println(obj.subtrair(t));
//        System.out.println(obj.totalizar(t));

        Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
//        BigDecimal result = this.execute("somar", salario);
//        System.out.println(obj.somar(salario));
    }
}
