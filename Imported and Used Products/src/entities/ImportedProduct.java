package entities;

public class ImportedProduct extends Product {
	private Double customsFee;

	public ImportedProduct() {
	}

	public ImportedProduct(Double customsFee, String name, Double price) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public double totalPrice() {
		return customsFee + getPrice();
	}

	@Override
	public String priceTag() {
		return name + " $ " + String.format("%.2f ", price) + String.format("Customs fee: $ %.2f", customsFee);
	}
}

