package Model;

import java.math.BigDecimal;
import java.util.Date;

public class BookingDetails {
    private Integer bookingDetailId;
    private Double itineraryNo;
    private Date tripStart;
    private Date tripEnd;
    private String description;
    private String destination;
    private BigDecimal basePrice;
    private BigDecimal agencyCommission;
    private Integer bookingId;
    private String regionId;
    private String classId;
    private String feeId;
    private Integer productSupplierId;

    private static final int MAX_DESCRIPTION_LENGTH = 1000;
    private static final int MAX_DESTINATION_LENGTH = 100;

    public Integer getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(Integer bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public Double getItineraryNo() {
        return itineraryNo;
    }

    public void setItineraryNo(Double itineraryNo) {
        this.itineraryNo = itineraryNo;
    }

    public Date getTripStart() {
        return tripStart;
    }

    public void setTripStart(Date tripStart) {
        this.tripStart = tripStart;
    }

    public Date getTripEnd() {
        return tripEnd;
    }

    public void setTripEnd(Date tripEnd) {
        this.tripEnd = tripEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateDescriptionLength(description);
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        validateDestinationLength(destination);
        this.destination = destination;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getAgencyCommission() {
        return agencyCommission;
    }

    public void setAgencyCommission(BigDecimal agencyCommission) {
        this.agencyCommission = agencyCommission;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public Integer getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(Integer productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    // Method to validate description length
    private void validateDescriptionLength(String description) {
        if (description != null && description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description length exceeds maximum length");
        }
    }

    // Method to validate destination length
    private void validateDestinationLength(String destination) {
        if (destination != null && destination.length() > MAX_DESTINATION_LENGTH) {
            throw new IllegalArgumentException("Destination length exceeds maximum length");
        }
    }

    // toString() method
    @Override
    public String toString() {
        return "BookingDetail{" +
                "bookingDetailId=" + bookingDetailId +
                ", itineraryNo=" + itineraryNo +
                ", tripStart=" + tripStart +
                ", tripEnd=" + tripEnd +
                ", description='" + description + '\'' +
                ", destination='" + destination + '\'' +
                ", basePrice=" + basePrice +
                ", agencyCommission=" + agencyCommission +
                ", bookingId=" + bookingId +
                ", regionId='" + regionId + '\'' +
                ", classId='" + classId + '\'' +
                ", feeId='" + feeId + '\'' +
                ", productSupplierId=" + productSupplierId +
                '}';
    }
}
