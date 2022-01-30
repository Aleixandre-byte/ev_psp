package ev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler{
	
	int temperaturaActual, temperaturaTermostato;

	public GestorHTTP() {
		temperaturaActual = 15;
		temperaturaTermostato = 15;
	}
	
	public int getTemperaturaActual() {
		return temperaturaActual;
	}

	public int getTemperaturaTermostato() {
		return temperaturaTermostato;
	}

	public void setTemperaturaActual(int temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}

	public void setTemperaturaTermostato(int temperaturaTermostato) {
		this.temperaturaTermostato = temperaturaTermostato;
	}

	
	private String handleGetRequest(HttpExchange exchange) {
		return exchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
		}
	
	private void handleGETResponse(HttpExchange httpExchange) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<html><body>Temperatura termostato: "+getTemperaturaTermostato()+" temperatura actual: "+getTemperaturaActual()+"</body></html>";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
	}
	
	private String handlePostRequest(HttpExchange httpExchange) {
		InputStream inputStream = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String postRequest;
		try {
			while((postRequest = br.readLine()) != null){
				sb.append(postRequest);
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
		}
	
	private void handlePOSTResponse(HttpExchange httpExchange,String requestParam) throws IOException, InterruptedException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String temp = requestParam.split("=")[1];
		int data = Integer.parseInt(temp);
		setTemperaturaTermostato(data);
		String htmlResponse = "Respuesta a la peticion POST -> Poner termostato a: " + data+ " grados";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		regularTemperatura();
		outputStream.flush();
		outputStream.close();
		}
	
	//método para aumentar o disminuir la temperatura según los datos indicados en el POST
	private void regularTemperatura() throws InterruptedException {
	
		if(temperaturaActual < temperaturaTermostato) {
			while(temperaturaActual< temperaturaTermostato) {
				temperaturaActual++;
				System.out.println("temperatura aumenta, actualmente: " + temperaturaActual);
				TimeUnit.SECONDS.sleep(2);
			}
		}else if(temperaturaActual > temperaturaTermostato) {
			while(temperaturaActual > temperaturaTermostato) {
				temperaturaActual--;
				System.out.println("temperatura disminuye, actualmente: "+ temperaturaActual);
				TimeUnit.SECONDS.sleep(2);
			}
		}else{
			System.out.println("LA TEMPERATURA YA ES CORRECTA");
		}
		
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		
		String requestParam = null;
		if("GET".equals(exchange.getRequestMethod())) {
			requestParam = handleGetRequest(exchange);
			handleGETResponse(exchange);
		}else if("POST".equals(exchange.getRequestMethod())) {
			requestParam = handlePostRequest(exchange);
			try {
				handlePOSTResponse(exchange,requestParam);
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
}
