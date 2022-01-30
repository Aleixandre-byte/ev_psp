package ev;


import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class Servidor {

	public static void main(String[] args) throws Exception {
	
		int puerto = 7777;
		String host = "localhost";
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host,puerto);
		int backlog = 0;
		HttpServer servidor = HttpServer.create(direccionTCPIP,backlog);
		
		GestorHTTP gestorHTTP = new GestorHTTP();
		String rutaResponse = "/estufa"; 
		servidor.createContext(rutaResponse,gestorHTTP);
		
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);
		
		servidor.start();
		System.out.println("Servidor HTTP arranca en el puerto " + puerto);
		
	}

}
