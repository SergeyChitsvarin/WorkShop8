package Model;

import java.util.Date;

public class Booking {
    private Integer bookingId;
    private Date bookingDate;
    private String bookingNo;
    private Double travelerCount;
    private Integer customerId;
    private String tripTypeId;
    private Integer packageId;

    private static final int MAX_BOOKING_NO_LENGTH = 50;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        validateBookingNoLength(bookingNo);
        this.bookingNo = bookingNo;
    }

    public Double getTravelerCount() {
        return travelerCount;
    }

    public void setTravelerCount(Double travelerCount) {
        this.travelerCount = travelerCount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        this.tripTypeId = tripTypeId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    // Utility method to validate bookingNo length
    private void validateBookingNoLength(String bookingNo) {
        if (bookingNo != null && bookingNo.length() > MAX_BOOKING_NO_LENGTH) {
            throw new IllegalArgumentException("Booking number length exceeds maximum length");
        }
    }

    // Override toString() method for debugging or logging
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", bookingNo='" + bookingNo + '\'' +
                ", travelerCount=" + travelerCount +
                ", customerId=" + customerId +
                ", tripTypeId='" + tripTypeId + '\'' +
                ", packageId=" + packageId +
                '}';
    }
}
