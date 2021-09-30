package EV1;

public class EV5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] lista = new int[] {5,8,30,20,13,7};
		int mayor = 0;
		for (int i = 0; i < lista.length; i++) {
			if(lista[i] > mayor) {
				mayor = lista[i];
			}
		}
		System.out.print("El mayor es: "+mayor);
		
		
	}

}
