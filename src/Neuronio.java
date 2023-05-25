import java.util.Arrays;

public class Neuronio {
	// Neuronio para 2 entradas

	private double w0; // pesos
	private double w1;
	private double w2;

	public double getW0() {
		return w0;
	}

	public double getW1() {
		return w1;
	}

	public double getW2() {
		return w2;
	}

	public double calculaV(double x1, double x2) {
		return w0 + w1 * x1 + w2 * x2;
	} // calcula o campo local induzido

	public double calculaY(double x1, double x2) { // aplica a funcao
		double v = calculaV(x1, x2);

		if (v >= 0)
			return 1;
		return 0;
	}

	public double encontraMaiorValor(double entradas[])
	{
		double maiorValor = entradas[0];

		for(int i = 0; i < entradas.length; i++)
		{
			if(entradas[i] > maiorValor)
			{
				maiorValor = entradas[i];
			}
		}

		return maiorValor;
	}

	public double[] normalizaEntrada(double entradas[])
	{
		double maiorValor = this.encontraMaiorValor(entradas);
		double entradaNormalizada[] = new double[14];

		for(int i = 0; i < entradas.length; i++)
		{
			entradaNormalizada[i] = entradas[i] / maiorValor;
		}

		return entradaNormalizada;
	}

	public double[] populaRenda()
	{
		double renda[] = new double[14];

		renda[0] = 2800;
		renda[1] = 1300;
		renda[2] = 1400;
		renda[3] = 500;
		renda[4] = 1100;
		renda[5] = 1800;
		renda[6] = 2400;
		renda[7] = 1950;
		renda[8] = 450;
		renda[9] = 2750;
		renda[10] = 850;
		renda[11] = 1300;
		renda[12] = 2100;
		renda[13] = 900;

		return renda;
	}

	public double[] populaDivida()
	{
		double divida[] = new double[14];

		divida[0] = 550;
		divida[1] = 500;
		divida[2] = 80;
		divida[3] = 200;
		divida[4] = 270;
		divida[5] = 450;
		divida[6] = 650;
		divida[7] = 600;
		divida[8] = 70;
		divida[9] = 730;
		divida[10] = 90;
		divida[11] = 200;
		divida[12] = 750;
		divida[13] = 300;

		return divida;
	}
	public int[] pupulaClasse()
	{
		int classe[] = new int[14];

		classe[0] = 1;
		classe[1] = 0;
		classe[2] = 1;
		classe[3] = 0;
		classe[4] = 0;
		classe[5] = 1;
		classe[6] = 1;
		classe[7] = 1;
		classe[8] = 0;
		classe[9] = 1;
		classe[10] = 0;
		classe[11] = 0;
		classe[12] = 1;
		classe[13] = 0;

		return classe;
	}
	public void setW0(double w0) {
		this.w0 = w0;
	}

	public void setW1(double w1) {
		this.w1 = w1;
	}

	public void setW2(double w2) {
		this.w2 = w2;
	}

	public String toString() {
		return "w0 = " + w0 + " w1= " + w1 + " w2= " + w2;
	}
}
