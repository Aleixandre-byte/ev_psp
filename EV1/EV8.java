package EV1;
import java.util.Scanner;

public class EV8 {
	public static boolean esPrimo(int numero) {
			  int contador = 2;
			  boolean primo=true;
			  while ((primo) && (contador!=numero)){
			    if (numero % contador == 0)
			      primo = false;
			    contador++;
			  }
			  return primo;
			}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0;
		int num2 = 0;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el primer número: ");
		num1 = teclado.nextInt();
		System.out.println("Introduce el segundo número: ");
		num2 = teclado.nextInt();
		long tiempo = 0;
		
		
		for (int i = num1; i <= num2; i++) {
			 
			long starttime= System.currentTimeMillis();
			if(esPrimo(i)) {
				System.out.println(i+" SI es primo.");
			}
			else {
			System.out.println(i+ " NO es primo");
			
			}
			tiempo += (System.currentTimeMillis()-starttime);
		}
		System.out.print("Tiempo total de ejecución: "+tiempo);
		
		teclado.close();
		
		
	}

}
