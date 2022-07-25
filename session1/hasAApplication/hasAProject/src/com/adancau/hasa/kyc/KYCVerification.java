package com.adancau.hasa.kyc;

public class KYCVerification {
    private String panNumber;
    private long adharNumber;
    private String documentType;
    private String documentNumber;

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public long getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(long adharNumber) {
        this.adharNumber = adharNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }


    public KYCVerification(String panNumber, long adharNumber, String documentType, String documentNumber) {
        this.panNumber = panNumber;
        this.adharNumber = adharNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "KYCVerification{" +
                "panNumber='" + panNumber + '\'' +
                ", adharNumber=" + adharNumber +
                ", documentType='" + documentType + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
