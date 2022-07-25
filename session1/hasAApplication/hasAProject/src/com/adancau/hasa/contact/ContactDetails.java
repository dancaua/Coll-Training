package com.adancau.hasa.contact;

import java.util.Objects;

public class ContactDetails {
    private String houseNumber;
    private String localityName;
    private String cityName;
    private String stateName;
    private String countryName;
    private long pincode;
    private long mobileNumber;
    private long emailId;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ContactDetails(String houseNumber, String localityName, String cityName, String stateName, String countryName, long pincode, long mobileNumber, long emailId) {
        this.houseNumber = houseNumber;
        this.localityName = localityName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.pincode = pincode;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDetails that = (ContactDetails) o;
        return pincode == that.pincode && mobileNumber == that.mobileNumber && emailId == that.emailId && houseNumber.equals(that.houseNumber) && localityName.equals(that.localityName) && cityName.equals(that.cityName) && stateName.equals(that.stateName) && countryName.equals(that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, localityName, cityName, stateName, countryName, pincode, mobileNumber, emailId);
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "houseNumber='" + houseNumber + '\'' +
                ", localityName='" + localityName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", pincode=" + pincode +
                ", mobileNumber=" + mobileNumber +
                ", emailId=" + emailId +
                '}';
    }
}
