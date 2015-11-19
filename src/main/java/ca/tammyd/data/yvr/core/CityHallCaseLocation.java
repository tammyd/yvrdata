package ca.tammyd.data.yvr.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;


public class CityHallCaseLocation {

    @JsonProperty protected int id;
    @JsonProperty protected int year;
    @JsonProperty protected int month;
    @JsonProperty protected int day;
    @JsonProperty protected int hour;
    @JsonProperty protected int min;
    @JsonProperty protected String department;
    @JsonProperty protected String division;
    @JsonProperty protected String caseType;
    @JsonProperty protected int hundredBlock;
    @JsonProperty protected String streetName;
    @JsonProperty protected String localArea;

    public CityHallCaseLocation(int id, int year, int month, int day, int hour, int min, String department,
                                String division, String caseType, int hundredBlock, String streetName,
                                String localArea) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.department = department;
        this.division = division;
        this.caseType = caseType;
        this.hundredBlock = hundredBlock;
        this.streetName = streetName;
        this.localArea = localArea;
    }

    public int getId() {
        return id;
    }

    @JsonProperty public DateTime getDate() {
        return new DateTime(year, month, day, hour, min, DateTimeZone.forID("America/Los_Angeles"));
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public int getHundredBlock() {
        return hundredBlock;
    }

    public void setHundredBlock(int hundredBlock) {
        this.hundredBlock = hundredBlock;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLocalArea() {
        return localArea;
    }

    public void setLocalArea(String localArea) {
        this.localArea = localArea;
    }
}
