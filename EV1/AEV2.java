package EV1;

import java.util.ArrayList;

public class AEV2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String[] listaNombres = new String[] {"Alex","Yosu","Oscar","Sergio","Ximo","Fran"};
//	
//		
//		for(int i = 0;i<listaNombres.length;i++) {
//			System.out.println(listaNombres[i]);
//		}
		
		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Alejandro");
		nombres.add("Oscar");
		nombres.add("Yosu");
		nombres.add("Sergio");
		nombres.add("Ximo");
		nombres.add("Fran");
		
		for(int i = 0;i<nombres.size();i++) {
		System.out.println(nombres.get(i));
		}
		
	}

}
