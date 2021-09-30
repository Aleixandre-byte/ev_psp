package EV1;

import java.util.Scanner;

public class EV6 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int[] numeros = new int[5];
		int suma = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce el número "+(i+1)+": ");
			numeros[i] = teclado.nextInt();
			suma += numeros[i];
		}

		int m = 4;
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Número: "+(i+1)+" = "+numeros[m]);
			m--;
		}
		
		System.out.println("Suma de números: "+suma);
		
		teclado.close();

	}

}

