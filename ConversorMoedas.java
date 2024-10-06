import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoedas {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Conversor  
                    de Moedas");
                    System.out.println("1. Dólar para Real");
            System.out.println("2. Real para Dólar");
            // ... outras opções de conversão

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                double valor = solicitarValor(scanner, "dólares");
                double resultado = Conversor.converter("USD", "BRL", valor);
                System.out.println(valor + " dólares equivalem a " + resultado + " reais.");
            } else if (opcao == 2) {
                // ... outras opções de conversão
            } else {
                System.out.println("Opção inválida.");
            }

            System.out.print("Deseja realizar outra conversão? (S/N): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private static double solicitarValor(Scanner scanner, String moeda) {
        System.out.print("Digite o valor em " + moeda + ": ");
        return scanner.nextDouble();
    }
}