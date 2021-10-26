package ev2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



public class Lanzador {

public void lanzarFuncion(String nom,Double pos,Double vel){
	String clase = "ev2.Neo";
	try {

		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");

		String className = clase;

		List<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		command.add(nom);
		command.add(pos.toString());
		command.add(vel.toString());



		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.inheritIO().start();

		process.waitFor();
		System.out.println(process.exitValue());

	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) throws InterruptedException{
		long inicio = System.currentTimeMillis();			//variable per a començar a contar el temps d'execució

		String[] guardaLinea;
		Lanzador lan = new Lanzador();


		String ruta = args[0];
		try {
			File f1 = new File(ruta);
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			
			//bucle per a recorrer el arxius del fitxer 
			for (int i = 0; i < 12; i++) {									
				
				guardaLinea = linea.split(",");											// array on es guarden les dades de cada linea de NEOs separades per comes 
				//System.out.print(linea+"\n");
				lan.lanzarFuncion(guardaLinea[0], Double.parseDouble(guardaLinea[1]), 	//pase les dades que s'han llegit mitjançant el llançador
						Double.parseDouble(guardaLinea[2]));
				linea = br.readLine();
				
			}
				
			 
			br.close();
			fr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 long fin = System.currentTimeMillis();				//variable de final de temps d'execució 
		 double tiempo = (double) ((fin - inicio)/1000);
		 System.out.println("Total de tiempo: "+tiempo+" segundos");
		 tiempo /= 12;
	     System.out.println("Media de tiempo por ejecución NEO: "+tiempo+" segundos");
	     int cores = Runtime.getRuntime().availableProcessors();		//proces per a obtindre número de procesadors
	     System.out.println("Cores disponibles: "+cores);
	}
	

}
