import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;

public class Conversion {
	String moneda = "USD";
	double cambio = 1;

	public void convertir(double valor) {
		String opcion = (JOptionPane.showInputDialog(null,"Desea convertir Dolares Americanos a:",  "Monedas",
			JOptionPane.PLAIN_MESSAGE, null, new Object[] {"Dolar", "Euro", "Real Brasilero",	"Yen Japonés", "Dinar Libio",
						"Peso Cubano", "Renminbi Chino", "Peso Argentino", "Bolívar Venezolano", "Dolar Australiano"},
					"Seleccion")).toString();

		switch (opcion) {
			case "Dolar":
				moneda = "USD";
				break;
			case "Euro":
				moneda = "EUR";
				break;
			case "Real Brasilero":
				moneda = "BRL";
				break;
			case "Yen Japonés":
				moneda = "JPY";
				break;
			case "Dinar Libio":
				moneda = "LYD";
				break;
			case "Peso Cubano":
				moneda = "CUP";
				break;
			case "Renminbi Chino":
				moneda = "CNY";
				break;
			case "Peso Argentino":
				moneda = "ARS";
				break;
			case "Bolívar Venezolano":
				moneda = "VES";
				break;
			case "Dolar Australiano":
				moneda = "AUD";
				break;
		}
		try {
			URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d139eec586aaf338bf98fc11/pair/USD/" + moneda + "/" + valor);
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(direccion)
					.build();
			HttpResponse<String> response = client
					.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();
			Gson gson = new Gson();
			Valer val = gson.fromJson(json, Valer.class);
			String conversion = val.convertido;

			JOptionPane.showMessageDialog(null, "Tienes $ " + conversion + " " + moneda);
		} catch (Exception e) {
				throw new RuntimeException("Ocurrio un error.");
		}
	}
}
