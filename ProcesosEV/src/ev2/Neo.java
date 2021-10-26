package ev2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Neo {
	
	public double Funcion(String nombre,double posicionNEO,double velocidadNEO) {
		
		String nom = nombre;
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		return resultado;
		}

		public static void main(String[] args) {
			
			Neo prob = new Neo();
			
			//variables per a replegar y emmagatzemar les dades del llançador
			String nom = args[0];
			Double pos = Double.parseDouble(args[1]);
			Double vel = Double.parseDouble(args[2]);
			String f = nom+".txt";
			File f1 = new File(f);
			double result = 0;

			try {
				FileWriter fw = new FileWriter(f1);
				BufferedWriter bw = new BufferedWriter(fw);
				String linea = ""+prob.Funcion(nom, pos, vel);			//linea que utilitzare per a escriure en cada fitxer 
				
				//bucle per a escriure en cada fixter la probabilitat de col·lisió
				do {
					bw.write(nom+" : "+linea);				
				}while(linea == null);
				
				result = Double.parseDouble(linea);
				double redResult = (Math.round(result*100d)/100d);			//truncament del resultat a les dos desenes
				if(result <= 10) {
					System.out.println(nom +": --EL MON ESTA SENSE PERILL-- " + redResult);
				}
				else {
					System.err.print(nom +" --CRISIS MUNDIAL-- " + redResult+"\n");
				}
				
//				fw.close();
				bw.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}

}
