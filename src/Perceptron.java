//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class Perceptron {
	public static void main(String args[]) {
		Neuronio neuronio = new Neuronio();
		// Conjunto treinamento
		double conjuntoRenda[] = neuronio.populaRenda();
		double conjuntoDivia[] = neuronio.populaDivida();
		double renda[] = neuronio.normalizaEntrada(conjuntoRenda);
		double divida[] = neuronio.normalizaEntrada(conjuntoDivia);
		int classe[] = neuronio.pupulaClasse();

		// Treinamento
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 0.5d;
		// eta e a constante (taxa) de aprendizagem

		System.out.println("--- TREINAMENTO");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);
			for (i = 0; i < renda.length; i++) {
				// propagacao
				y = neuronio.calculaY(renda[i], divida[i]);

				// calcula do erro
				erro = classe[i] - y;
				
				// ajuste dos pesos
				if (erro != 0) {
					neuronio.setW0(neuronio.getW0() + eta * erro);
					neuronio.setW1(neuronio.getW1() + eta * erro * renda[i]);
					neuronio.setW2(neuronio.getW2() + eta * erro * divida[i]);
				}
				System.out.println("Neuronio - pesos: " + neuronio);
				erroGeral = erroGeral + abs(erro);
			}
			
			// para quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

		// Generalizacao - Teste da rede
		double entrada1, entrada2;
		double maiorRenda, maiorDivida;
		maiorRenda = neuronio.encontraMaiorValor(conjuntoRenda);
		maiorDivida = neuronio.encontraMaiorValor(conjuntoDivia);

		Scanner dados = new Scanner(System.in);
		System.out.println("\n--- GENERALIZACAO");

		while (true) {
			// digita novas entradas
			System.out.println("Digite -100 para encerrar");
			System.out.print("Digite a entrada (renda): ");
			entrada1 = dados.nextDouble();
			if (entrada1 == -100)
				break;

			System.out.print("Digite a entrada (dívida): ");
			entrada2 = dados.nextDouble();
			if (entrada2 == -100)
				break;

			// propagacao
			double valor1 = entrada1 / maiorRenda;
			double valor2 = entrada2 / maiorDivida;
			//System.out.println("valor1: " + valor1 + " - maiorRenda: " + maiorRenda);
			//System.out.println("valor2: " + valor2 + " - maiorDivida: " + maiorDivida);
			System.out.println("Saida Gerada pela rede: "
					+ neuronio.calculaY(valor1, valor2));
		}
	}
}
