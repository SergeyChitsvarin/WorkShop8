package Model;

public class Region {

    private String regionId;

    private String regionName;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        validateLength(regionId, 5);
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    // Method for Validating Length
    private void validateLength(String value, int maxLength) {
        if (value != null && value.length() > maxLength) {
            throw new IllegalArgumentException("Length of value exceeds maximum allowed length");
        }
    }

    // toString() Method
    @Override
    public String toString() {
        return "Region{" +
                "regionId='" + regionId + '\'' +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
