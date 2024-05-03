package Model;

public class Customer {
    private Integer customerId;
    private String custFirstName;
    private String custLastName;
    private String custAddress;
    private String custCity;
    private String custProv;
    private String custPostal;
    private String custCountry;
    private String custHomePhone;
    private String custBusPhone;
    private String custEmail;
    private Integer agentId;

    private static final int MAX_FIRST_NAME_LENGTH = 25;
    private static final int MAX_LAST_NAME_LENGTH = 25;
    private static final int MAX_ADDRESS_LENGTH = 75;
    private static final int MAX_CITY_LENGTH = 50;
    private static final int MAX_PROV_LENGTH = 2;
    private static final int MAX_POSTAL_LENGTH = 7;
    private static final int MAX_COUNTRY_LENGTH = 25;
    private static final int MAX_HOME_PHONE_LENGTH = 20;
    private static final int MAX_BUS_PHONE_LENGTH = 20;
    private static final int MAX_EMAIL_LENGTH = 50;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        validateLength(custFirstName, MAX_FIRST_NAME_LENGTH);
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        validateLength(custLastName, MAX_LAST_NAME_LENGTH);
        this.custLastName = custLastName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        validateLength(custAddress, MAX_ADDRESS_LENGTH);
        this.custAddress = custAddress;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        validateLength(custCity, MAX_CITY_LENGTH);
        this.custCity = custCity;
    }

    public String getCustProv() {
        return custProv;
    }

    public void setCustProv(String custProv) {
        validateLength(custProv, MAX_PROV_LENGTH);
        this.custProv = custProv;
    }

    public String getCustPostal() {
        return custPostal;
    }

    public void setCustPostal(String custPostal) {
        validateLength(custPostal, MAX_POSTAL_LENGTH);
        this.custPostal = custPostal;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        validateLength(custCountry, MAX_COUNTRY_LENGTH);
        this.custCountry = custCountry;
    }

    public String getCustHomePhone() {
        return custHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        validateLength(custHomePhone, MAX_HOME_PHONE_LENGTH);
        this.custHomePhone = custHomePhone;
    }

    public String getCustBusPhone() {
        return custBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        validateLength(custBusPhone, MAX_BUS_PHONE_LENGTH);
        this.custBusPhone = custBusPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        validateLength(custEmail, MAX_EMAIL_LENGTH);
        this.custEmail = custEmail;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    // Method to validate length
    private void validateLength(String value, int maxLength) {
        if (value != null && value.length() > maxLength) {
            throw new IllegalArgumentException("Length of value exceeds maximum allowed length");
        }
    }
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", custFirstName='" + custFirstName + '\'' +
                ", custLastName='" + custLastName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custCity='" + custCity + '\'' +
                ", custProv='" + custProv + '\'' +
                ", custPostal='" + custPostal + '\'' +
                ", custCountry='" + custCountry + '\'' +
                ", custHomePhone='" + custHomePhone + '\'' +
                ", custBusPhone='" + custBusPhone + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", agentId=" + agentId +
                '}';
    }
}
