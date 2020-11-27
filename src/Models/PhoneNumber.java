package Models;

public class PhoneNumber {
    private String areaCode, cityCode, lineNumber;

    public PhoneNumber(String areaCode, String cityCode, String lineNumber) {
        setAreaCode(areaCode);
        setCityCode(cityCode);
        setLineNumber(lineNumber);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        if (areaCode.matches("[2-9][0-9][0-9]"))
            this.areaCode = areaCode;
        else
            throw new IllegalArgumentException("area code must be in the pattern [2-9][0-9][0-9]");
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        if (cityCode.matches("[2-9][0-9][0-9]"))
            this.cityCode = cityCode;
        else
            throw new IllegalArgumentException("city code must be in the pattern [2-9][0-9][0-9]");
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        if (lineNumber.matches("[0-9]{4}"))
            this.lineNumber = lineNumber;
        else
            throw new IllegalArgumentException("line number must be 4 digits");
    }

    public String toString()
    {
        return String.format("(%s) %s-%s",areaCode,cityCode,lineNumber);
    }
}
