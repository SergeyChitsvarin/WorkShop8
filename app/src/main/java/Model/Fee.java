package Model;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class Fee {
    private String feeId;
    private String feeName;
    private BigDecimal feeAmt;
    private String feeDesc;

    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_DESC_LENGTH = 50;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        validateLength(feeId, MAX_ID_LENGTH);
        this.feeId = feeId;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        validateLength(feeName, MAX_NAME_LENGTH);
        this.feeName = feeName;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        validateLength(feeDesc, MAX_DESC_LENGTH);
        this.feeDesc = feeDesc;
    }

    // Method for validating Length
    private void validateLength(String value, int maxLength) {
        if (value != null && value.length() > maxLength) {
            throw new IllegalArgumentException("Length of value exceeds maximum allowed length");
        }
    }

    // toString Method
    @Override
    public String toString() {
        return "Fee{" +
                "feeId='" + feeId + '\'' +
                ", feeName='" + feeName + '\'' +
                ", feeAmt=" + feeAmt +
                ", feeDesc='" + feeDesc + '\'' +
                '}';
    }
}
