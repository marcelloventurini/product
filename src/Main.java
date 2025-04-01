import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("How many products will be registered? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for the product #" + (i + 1));
            System.out.print("Product type: common, used or imported (c/u/i)? ");
            char type = scanner.nextLine().charAt(0);

            if (type == 'c') {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                products.add(new Product(name, price));
            } else if (type == 'u') {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();

                System.out.print("Manufacture date (dd/mm/yyyy): ");
                Date manufactureDate = sdf.parse(scanner.next());
                scanner.nextLine();

                products.add(new UsedProduct(name, price, manufactureDate));
            } else if (type == 'i') {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Customs fee: ");
                double customsFee = scanner.nextDouble();
                scanner.nextLine();

                products.add(new ImportedProduct(name, price, customsFee));
            } else {
                System.out.println("Sorry, option invalid.");
            }
        }

        System.out.println("\nPrice Tags:");

        for (Product product : products) {
            System.out.println(product.showPriceTag());
        }

        scanner.close();
    }
}
