package com.example.gdrbtechnologiespvtltd.model;

public class UserItemModel {
    private String taxRegistrationNumber;
    private String investor;
    private String scZoneLicenseNo;
    private String natureOfBusiness;
    private String status;
    private String formNumber;
    private String formProcedure;
    private String process;
    private String declarationProcedure;
    private String createdDate;

    public UserItemModel(String taxRegistrationNumber, String investor, String scZoneLicenseNo, String natureOfBusiness, String status, String formNumber, String formProcedure, String process, String declarationProcedure, String createdDate) {
        this.taxRegistrationNumber = taxRegistrationNumber;
        this.investor = investor;
        this.scZoneLicenseNo = scZoneLicenseNo;
        this.natureOfBusiness = natureOfBusiness;
        this.status = status;
        this.formNumber = formNumber;
        this.formProcedure = formProcedure;
        this.process = process;
        this.declarationProcedure = declarationProcedure;
        this.createdDate = createdDate;
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public String getScZoneLicenseNo() {
        return scZoneLicenseNo;
    }

    public void setScZoneLicenseNo(String scZoneLicenseNo) {
        this.scZoneLicenseNo = scZoneLicenseNo;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }

    public String getFormProcedure() {
        return formProcedure;
    }

    public void setFormProcedure(String formProcedure) {
        this.formProcedure = formProcedure;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getDeclarationProcedure() {
        return declarationProcedure;
    }

    public void setDeclarationProcedure(String declarationProcedure) {
        this.declarationProcedure = declarationProcedure;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
