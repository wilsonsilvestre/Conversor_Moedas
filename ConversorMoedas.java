import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversao conversao = new Conversao();

        while (true) {
            System.out.println("Conversor de Moedas");
            System.out.println("Selecione uma opção:");
            System.out.println("1. USD para EUR");
            System.out.println("2. EUR para USD");
            System.out.println("3. USD para BRL");
            System.out.println("4. BRL para USD");
            System.out.println("5. EUR para BRL");
            System.out.println("6. BRL para EUR");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            if (opcao == 7) break;

            System.out.println("Digite o valor a ser convertido:");
            double valor = scanner.nextDouble();

            String fromCurrency;
            String toCurrency;

            switch (opcao) {
                case 1 -> { fromCurrency = "USD"; toCurrency = "EUR"; }
                case 2 -> { fromCurrency = "EUR"; toCurrency = "USD"; }
                case 3 -> { fromCurrency = "USD"; toCurrency = "BRL"; }
                case 4 -> { fromCurrency = "BRL"; toCurrency = "USD"; }
                case 5 -> { fromCurrency = "EUR"; toCurrency = "BRL"; }
                case 6 -> { fromCurrency = "BRL"; toCurrency = "EUR"; }
                default -> { System.out.println("Opção inválida"); continue; }
            }

            double valorConvertido = conversao.converter(fromCurrency, toCurrency, valor);
            System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, toCurrency);
        }

        scanner.close();
    }
}
