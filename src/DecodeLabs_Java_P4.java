import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CurrencyConverter {

    private Map<String, BigDecimal> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();

        // Base currency = USD
        exchangeRates.put("USD", new BigDecimal("1.0"));
        exchangeRates.put("INR", new BigDecimal("83.0"));
        exchangeRates.put("EUR", new BigDecimal("0.92"));
        exchangeRates.put("GBP", new BigDecimal("0.78"));
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid currency code.");
        }

        // Convert to USD first (pivot)
        BigDecimal amountInUSD = amount.divide(exchangeRates.get(from), 10, RoundingMode.HALF_EVEN);

        // Convert USD to target currency
        BigDecimal result = amountInUSD.multiply(exchangeRates.get(to));

        return result.setScale(2, RoundingMode.HALF_EVEN);
    }
}

public class DecodeLabs_Java_P4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        String fromCurrency, toCurrency;
        BigDecimal amount;

        System.out.println("=== Currency Converter ===");

        try {
            System.out.print("Enter base currency (USD/INR/EUR/GBP): ");
            fromCurrency = sc.nextLine().toUpperCase();

            System.out.print("Enter target currency (USD/INR/EUR/GBP): ");
            toCurrency = sc.nextLine().toUpperCase();

            System.out.print("Enter amount: ");
            amount = new BigDecimal(sc.nextLine());

            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }

            BigDecimal result = converter.convert(fromCurrency, toCurrency, amount);

            System.out.printf("Converted Amount: %.2f %s\n", result, toCurrency);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}