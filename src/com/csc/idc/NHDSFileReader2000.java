package com.csc.idc;

import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record
public class NHDSFileReader2000 {

	private String surveyYear;
	private String newbornStatus;
	private String ageUnit;
	private String age;
	private String sex;
	private String race;
	private String maritalStatus;
	private String dischargeMonth;
	private String dischargeStatus;
	private String daysOfCare;
	private String lengthOfStayFlag;
	private String geographicRegion;
	private String numberOfBeds;
	private String hospitalOwnership;
	private String analysisWeight;
	private String surveyYearFirst2Digits;
	
	private String diagCodes;	
	private String procCodes;
	
	private String principalSourceOfPay;
	private String secondarySourceOfPay;
	private String diagRelatedGroups;
	
	@Field(offset=1, length=2)
	public String getSurveyYear() {
		return surveyYear;
	}
	@Field(offset=3, length=1)
	public String getNewbornStatus() {
		return newbornStatus;
	}
	@Field(offset=4, length=1)
	public String getAgeUnit() {
		return ageUnit;
	}
	@Field(offset=5, length=2)
	public String getAge() {
		return age;
	}
	@Field(offset=7, length=1)
	public String getSex() {
		return sex;
	}
	@Field(offset=8, length=1)
	public String getRace() {
		return race;
	}
	@Field(offset=9, length=1)
	public String getMaritalStatus() {
		return maritalStatus;
	}
	@Field(offset=10, length=2)
	public String getDischargeMonth() {
		return dischargeMonth;
	}
	@Field(offset=12, length=1)
	public String getDischargeStatus() {
		return dischargeStatus;
	}
	@Field(offset=13, length=4)
	public String getDaysOfCare() {
		return daysOfCare;
	}
	@Field(offset=17, length=1)
	public String getLengthOfStayFlag() {
		return lengthOfStayFlag;
	}
	@Field(offset=18, length=1)
	public String getGeographicRegion() {
		return geographicRegion;
	}
	@Field(offset=19, length=1)
	public String getNumberOfBeds() {
		return numberOfBeds;
	}
	@Field(offset=20, length=1)
	public String getHospitalOwnership() {
		return hospitalOwnership;
	}
	@Field(offset=21, length=5)
	public String getAnalysisWeight() {
		return analysisWeight;
	}
	@Field(offset=26, length=2)
	public String getSurveyYearFirst2Digits() {
		return surveyYearFirst2Digits;
	}
	@Field(offset=28, length=35)
	public String getDiagCodes() {
		return diagCodes;
	}
	@Field(offset=63, length=16)
	public String getProcCodes() {
		return procCodes;
	}	
	@Field(offset=79, length=2)
	public String getPrincipalSourceOfPay() {
		return principalSourceOfPay;
	}
	@Field(offset=81, length=2)
	public String getSecondarySourceOfPay() {
		return secondarySourceOfPay;
	}
	@Field(offset=83, length=3)
	public String getDiagRelatedGroups() {
		return diagRelatedGroups;
	}
	
	
	public void setSurveyYear(String surveyYear) {
		this.surveyYear = surveyYear;
	}
	public void setNewbornStatus(String newbornStatus) {
		this.newbornStatus = newbornStatus;
	}
	public void setAgeUnit(String ageUnit) {
		this.ageUnit = ageUnit;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public void setDischargeMonth(String dischargeMonth) {
		this.dischargeMonth = dischargeMonth;
	}
	public void setDischargeStatus(String dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}
	public void setDaysOfCare(String daysOfCare) {
		this.daysOfCare = daysOfCare;
	}
	public void setLengthOfStayFlag(String lengthOfStayFlag) {
		this.lengthOfStayFlag = lengthOfStayFlag;
	}
	public void setGeographicRegion(String geographicRegion) {
		this.geographicRegion = geographicRegion;
	}
	public void setNumberOfBeds(String numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	public void setHospitalOwnership(String hospitalOwnership) {
		this.hospitalOwnership = hospitalOwnership;
	}
	public void setAnalysisWeight(String analysisWeight) {
		this.analysisWeight = analysisWeight;
	}
	public void setSurveyYearFirst2Digits(String surveyYearFirst2Digits) {
		this.surveyYearFirst2Digits = surveyYearFirst2Digits;
	}
	public void setDiagCodes(String diagCodes) {
		this.diagCodes = diagCodes;
	}
	public void setProcCodes(String procCodes) {
		this.procCodes = procCodes;
	}	
	public void setPrincipalSourceOfPay(String principalSourceOfPay) {
		this.principalSourceOfPay = principalSourceOfPay;
	}
	public void setSecondarySourceOfPay(String secondarySourceOfPay) {
		this.secondarySourceOfPay = secondarySourceOfPay;
	}
	public void setDiagRelatedGroups(String diagRelatedGroups) {
		this.diagRelatedGroups = diagRelatedGroups;
	}	

}
