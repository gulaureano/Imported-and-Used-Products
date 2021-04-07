package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		List<Product> listProduct = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			System.out.printf("Product #%d Data:", i);
			System.out.print("Common, used or imported (c/u/i)? ");
			char answer = sc.next().charAt(0);
			switch (answer) {
			case 'c':
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Price ");
				Double price = sc.nextDouble();
				Product product = new Product(name, price);
				listProduct.add(product);
				break;

			case 'u':
				System.out.print("Name: ");
				sc.nextLine();
				String nameUsed = sc.nextLine();
				System.out.print("Price ");
				Double priceUsed = sc.nextDouble();
				System.out.print("Manufacture date: (dd/MM/yyyy) ");
				sc.nextLine();
				Date manufactureDate = sdf.parse(sc.nextLine());
				UsedProduct usedProduct = new UsedProduct(nameUsed, priceUsed, manufactureDate);
				listProduct.add(usedProduct);
				break;

			case 'i':
				System.out.print("Name: ");
				sc.nextLine();
				String nameImported = sc.nextLine();
				System.out.print("Price ");
				Double priceImported = sc.nextDouble();
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				ImportedProduct importedProduct = new ImportedProduct(customsFee, nameImported, priceImported);
				listProduct.add(importedProduct);
				break;

			default:
				System.out.println("Insira apenas os valores pedidos");
				break;
			}
		}

		System.out.println("Price Tags:");
		for (Product list : listProduct) {
			System.out.println(list.priceTag());
		}

		sc.close();

	}

}
