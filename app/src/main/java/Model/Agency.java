package Model;

public class Agency {
    private Integer agencyId;
    private String agncyAddress;
    private String agncyCity;
    private String agncyProv;
    private String agncyPostal;
    private String agncyCountry;
    private String agncyPhone;
    private String agncyFax;

    private static final int MAX_LENGTH = 50;

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgncyAddress() {
        return agncyAddress;
    }

    public void setAgncyAddress(String agncyAddress) {
        validateLength(agncyAddress);
        this.agncyAddress = agncyAddress;
    }

    public String getAgncyCity() {
        return agncyCity;
    }

    public void setAgncyCity(String agncyCity) {
        validateLength(agncyCity);
        this.agncyCity = agncyCity;
    }

    public String getAgncyProv() {
        return agncyProv;
    }

    public void setAgncyProv(String agncyProv) {
        validateLength(agncyProv);
        this.agncyProv = agncyProv;
    }

    public String getAgncyPostal() {
        return agncyPostal;
    }

    public void setAgncyPostal(String agncyPostal) {
        validateLength(agncyPostal);
        this.agncyPostal = agncyPostal;
    }

    public String getAgncyCountry() {
        return agncyCountry;
    }

    public void setAgncyCountry(String agncyCountry) {
        validateLength(agncyCountry);
        this.agncyCountry = agncyCountry;
    }

    public String getAgncyPhone() {
        return agncyPhone;
    }

    public void setAgncyPhone(String agncyPhone) {
        validateLength(agncyPhone);
        this.agncyPhone = agncyPhone;
    }

    public String getAgncyFax() {
        return agncyFax;
    }

    public void setAgncyFax(String agncyFax) {
        validateLength(agncyFax);
        this.agncyFax = agncyFax;
    }

    // Validating the length
    private void validateLength(String value) {
        if (value != null && value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Value exceeds maximum length");
        }
    }

    // to string() method
    @Override
    public String toString() {
        return "Agency{" +
                "agencyId=" + agencyId +
                ", agncyAddress='" + agncyAddress + '\'' +
                ", agncyCity='" + agncyCity + '\'' +
                ", agncyProv='" + agncyProv + '\'' +
                ", agncyPostal='" + agncyPostal + '\'' +
                ", agncyCountry='" + agncyCountry + '\'' +
                ", agncyPhone='" + agncyPhone + '\'' +
                ", agncyFax='" + agncyFax + '\'' +
                '}';
    }
}
