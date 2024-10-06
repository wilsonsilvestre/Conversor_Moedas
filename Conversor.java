class Conversor {
    private static final String API_KEY = "YOUR_API_KEY";

    public static double converter(String moedaOrigem, String moedaDestino, double valor) throws IOException, InterruptedException {
        String url = "https://api.exchangerate-api.com/v6/latest/" + moedaOrigem + "?access_key=" + API_KEY;

        // ... código para realizar a requisição HTTP e obter a taxa de conversão
        // ... similar ao código apresentado na pergunta original

        return valor * taxaConversao;
    }
}