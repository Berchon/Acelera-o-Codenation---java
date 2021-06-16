package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    public BigDecimal Somador(Object objeto, Class nomeAnotacao) throws IllegalAccessException {
        BigDecimal soma = new BigDecimal(0);
        for(Field atributo : objeto.getClass().getDeclaredFields()){
            atributo.setAccessible(true);
            for (Annotation anotacao: atributo.getDeclaredAnnotations()) {
                if (anotacao.toString().contains(nomeAnotacao.getName()) && (atributo.getType().toString().contains("BigDecimal"))) {
                    soma = soma.add((BigDecimal) atributo.get(objeto));
                }
            }
        }
        return soma;
    }

    @Override
    public BigDecimal somar(Object objeto) throws IllegalAccessException {
        return Somador(objeto, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object objeto) throws IllegalAccessException {
        return Somador(objeto, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object objeto) throws IllegalAccessException {
        return (Somador(objeto, Somar.class)).subtract(Somador(objeto, Subtrair.class));
    }

/*
********************************************************************************************************
*** Código que desenvolvi para fazer os testes do conteúdo necessário ao desenvolvimento do Desafio  ***
********************************************************************************************************
* */
//    @Override
//    public BigDecimal Somar(Object objeto) throws IllegalAccessException {
//        BigDecimal sum = new BigDecimal(0);
//        System.out.println("Nome da Classe: " + objeto.getClass().getSimpleName());
//        System.out.println("Tipo da Classe: " + objeto.getClass().getTypeName());
//
//
//        for(Field atributo : objeto.getClass().getDeclaredFields()){
//            Class tipo = atributo.getType();
//            String nome = atributo.getName();
//            BigDecimal valor = (BigDecimal) atributo.get(objeto);
//            Annotation[] anotacoes = atributo.getDeclaredAnnotations();
//            if (anotacoes.toString().isEmpty()) {
//                return BigDecimal.ZERO;
//            }
//            System.out.println("========");
//            System.out.println("Tipo do Atributo: " + tipo);
//            System.out.println("Nome do atributo: " + nome);
//            System.out.println("valor do atributo: " + valor);
//
//            for (Annotation anotacao: anotacoes) {
//                System.out.println("Anotacao do Atributo: " + anotacao);
//                if (anotacao.toString().contains("Somar")) {
//                    if (!tipo.toString().contains("BigDecimal")) {
//                        return BigDecimal.ZERO;
//                    }
//                    sum = sum.add((BigDecimal) atributo.get(objeto));
//                }
//            }
//        }
//
//        System.out.println(sum);
//
//        return null;
//    }
}
