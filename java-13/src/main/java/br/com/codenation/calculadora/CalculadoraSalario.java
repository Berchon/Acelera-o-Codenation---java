package br.com.codenation.calculadora;

/*
 ***************************************************************************************************
 ***  REFERÊNCIAS                                                                                ***
 ***  1. Conteúdo da Codenation                                                                  ***
 ***  2.  																	                     ***
 ***                                                                                             ***
 ***  DATA DE INÍCIO                     DATA DE TÉRMINO                                         ***
 ***  16/02/2021                         16/02/2021                                              ***
 ***                                                                                             ***
 ***  DIFICULDADES                                                                               ***
 ***  Sem grandes dificuldades										                             ***
 ***************************************************************************************************
 */

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < 1039.00) return Math.round(0.0);

		double descontoINSS = calcularInss(salarioBase);
		double descontoIR = calcularIR(salarioBase - descontoINSS);
		return Math.round(salarioBase - descontoINSS - descontoIR);
	}

	private static double calcularIR(double salarioBase) {
		double percent;
		if (salarioBase <= 3000) {
			percent = 0.00;
		} else if (salarioBase <= 6000.0) {
			percent = 0.075;
		} else {
			percent = 0.15;
		}
		return (salarioBase * percent);
	}

	private static double calcularInss(double salarioBase) {
		double percent;
		if (salarioBase <= 1500) {
			percent = 0.08;
		} else if (salarioBase <= 4000.0) {
			percent = 0.09;
		} else {
			percent = 0.11;
		}
		return (salarioBase * percent);
	}
}

//	public static void  main(String[] args) {
//		double salarioBase  = 1500.01;
//		double descontoINSS = calcularInss(salarioBase);
//		double descontoIR = calcularIR(salarioBase);
//		long salarioLiquido = calcularSalarioLiquido(salarioBase);
//	}

/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/