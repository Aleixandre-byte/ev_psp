package EV1;

import java.util.Scanner;

public class EV7 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nombre = teclado.next();
		System.out.println("Años de trabajo: ");
		int anyos = teclado.nextInt();
		
		if(anyos < 1) {
			System.out.println(nombre+": Desarrollador Junior L1 – 15000-18000");
		}
		if(anyos >= 1 && anyos <= 2 ) {
			System.out.println(nombre+": Desarrollador Junior L2 – 18000-22000");
		}
		if(anyos >= 3 && anyos <= 5 ) {
			System.out.println(nombre+": Desarrollador Senior L1 – 22000-28000");
		}
		if(anyos > 5 && anyos <= 8 ) {
			System.out.println(nombre+": Desarrollador Senior L2 – 28000-36000");
		}
		if(anyos > 8) {
			System.out.println(nombre+": Analista / Arquitecto. Salario a convenir en base a rol");
		}
		teclado.close();

	}

}
