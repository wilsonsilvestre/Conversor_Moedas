import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversao {
    private static final String API_KEY = "777a1df91785ffeddb6f36ca";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/777a1df91785ffeddb6f36ca/latest/";

    public double converter(String fromCurrency, String toCurrency, double amount) {
        double taxaConversao = obterTaxaConversao(fromCurrency, toCurrency);
        if (taxaConversao != -1) {
            return amount * taxaConversao;
        } else {
            System.out.println("Erro ao obter a taxa de conversão.");
            return -1;
        }
    }

    private double obterTaxaConversao(String fromCurrency, String toCurrency) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + fromCurrency))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonObject.get("conversion_rates").getAsJsonObject().get(toCurrency).getAsDouble();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
