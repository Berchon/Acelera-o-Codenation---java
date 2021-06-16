package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

/*
 ***************************************************************************************************
 ***  REFERÊNCIAS                                                                                ***
 ***  1. Conteúdo da Codenation                                                                  ***
 ***                                                                                             ***
 ***  DATA DE INÍCIO                     DATA DE TÉRMINO                                         ***
 ***  14/02/2021                         14/02/2021                                              ***
 ***                                                                                             ***
 ***  DIFICULDADES                                                                               ***
 ***  Adaptaćão à linguagem, mas nada de mais                                                    ***
 ***************************************************************************************************
 */

public class DesafioApplication {

	public static List<Integer> fibonacciMethod(List<Integer> fibonacciSequence, Integer escape) {
		fibonacciSequence.add(
			fibonacciSequence.get(fibonacciSequence.size() - 1) +
			fibonacciSequence.get(fibonacciSequence.size() - 2)
		);
		if (fibonacciSequence.get(fibonacciSequence.size() - 1) <= escape) {
			fibonacciSequence = fibonacciMethod(fibonacciSequence, escape);
		}
		return fibonacciSequence;
	}

	public static List<Integer> newList() {
		List<Integer> listNumber = new ArrayList<Integer>();
		listNumber.add(0);
		listNumber.add(1);
		return (listNumber);
	}

	public static List<Integer> fibonacci() {
		return fibonacciMethod(newList(), 350);
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacciMethod(newList(), a).contains(a);
	}

//	public static void main(String[] args) {
//		List<Integer> fibonacciSequence = fibonacci();
//		System.out.println(fibonacciSequence);
//		System.out.println(isFibonacci(987));
//	}
}