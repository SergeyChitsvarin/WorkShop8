package Model;


public class ProductsSupplier {

    private Integer productSupplierId;


    private String productId;

    private String supplierId;

    public Integer getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(Integer productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        validateLength(productId, 10);
        this.productId = productId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        validateLength(supplierId, 10);
        this.supplierId = supplierId;
    }

    // validating Max Length
    private void validateLength(String value, int maxLength) {
        if (value != null && value.length() > maxLength) {
            throw new IllegalArgumentException("Length of value exceeds maximum allowed length");
        }
    }

    // toString() Method
    @Override
    public String toString() {
        return "ProductsSupplier{" +
                "productSupplierId=" + productSupplierId +
                ", productId='" + productId + '\'' +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }
}
