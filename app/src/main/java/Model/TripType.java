package Model;

public class TripType {

    private String tripTypeId;

    private String tTName;

    public String getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        validateLength(tripTypeId, 1);
        this.tripTypeId = tripTypeId;
    }

    public String getTTName() {
        return tTName;
    }

    public void setTTName(String tTName) {
        this.tTName = tTName;
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
        return "Triptype{" +
                "tripTypeId='" + tripTypeId + '\'' +
                ", tTName='" + tTName + '\'' +
                '}';
    }
}
