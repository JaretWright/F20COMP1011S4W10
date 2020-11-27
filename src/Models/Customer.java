package Models;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private int id;
    private String firstName, lastName,ccType,bloodType;
    private PhoneNumber phoneNumber;
    private double weightInKG, heightInCm;

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param ccType
     * @param bloodType
     * @param phoneNumber -this must be in the format of NXX-NXX-XXXX
     * @param weightInKG
     * @param heightInCm
     */
    public Customer(int id, String firstName, String lastName, String ccType, String bloodType, String phoneNumber, double weightInKG, double heightInCm) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setCcType(ccType);
        setBloodType(bloodType);
        setPhoneNumber(phoneNumber);
        setWeightInKG(weightInKG);
        setHeightInCm(heightInCm);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else
            throw new IllegalArgumentException("id must be greater than 0");
    }

    public String getFirstName() {
        return firstName;
    }

    private boolean nameLengthIsValid(String name)
    {
        return name.length()>=1 && name.length()<=30;
    }

    public void setFirstName(String firstName) {
        if (nameLengthIsValid(firstName))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("first name must be 1-30 characters");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (nameLengthIsValid(lastName))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name must be 1-30 characters");
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        if (ccType.equalsIgnoreCase("Visa")||ccType.equalsIgnoreCase("Mastercard"))
            this.ccType = ccType;
        else
            throw new IllegalArgumentException("Credit card must be Visa or Mastercard");
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        List<String> bloodTypes = Arrays.asList("B+","O+","AB+","O-","A+","B-","A-","AB-");
        if (bloodTypes.contains(bloodType))
            this.bloodType = bloodType;
        else
            throw new IllegalArgumentException("Blood type must be in the list: "+
                                bloodTypes);
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String[] phoneInfo = phoneNumber.split("-");
        String areaCode = phoneInfo[0];
        String cityCode = phoneInfo[1];
        String lineCode = phoneInfo[2];
        this.phoneNumber = new PhoneNumber(areaCode,cityCode,lineCode);
    }

    public double getWeightInKG() {
        return weightInKG;
    }

    public void setWeightInKG(double weightInKG) {
        if (weightInKG>=3 && weightInKG<=500)
            this.weightInKG = weightInKG;
        else
            throw new IllegalArgumentException("weight must be 3-500");
    }

    public double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(double heightInCm) {
        if (heightInCm>=30 && heightInCm<=300)
            this.heightInCm = heightInCm;
        else
            throw new IllegalArgumentException("height must be 30-300");
    }

    public String toString()
    {
        return String.format("%d, %s %s, Height: %.0f cm   Weight: %.0f kg",
                                id, firstName, lastName, heightInCm,weightInKG);
    }
}
