package entities;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    public double calculateTotalPrice() {
        return super.getPrice() + customsFee;
    }

    @Override
    public String showPriceTag() {
        return String.format("%s, $ %.2f (customs fee: $ %.2f)", super.getName(), calculateTotalPrice(), customsFee);
    }
}
