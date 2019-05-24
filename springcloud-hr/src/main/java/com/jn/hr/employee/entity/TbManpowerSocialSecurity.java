package com.jn.hr.employee.entity;

import java.io.Serializable;

public class TbManpowerSocialSecurity implements Serializable {
    private String id;

    private String jobNumber;

    private String salaryBank;

    private String salaryNumber;

    private String providentFundAccount;

    private String providentFundPayment;

    private String socialSecurityAccount;

    private String socialSecurityPayment;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getSalaryBank() {
        return salaryBank;
    }

    public void setSalaryBank(String salaryBank) {
        this.salaryBank = salaryBank == null ? null : salaryBank.trim();
    }

    public String getSalaryNumber() {
        return salaryNumber;
    }

    public void setSalaryNumber(String salaryNumber) {
        this.salaryNumber = salaryNumber == null ? null : salaryNumber.trim();
    }

    public String getProvidentFundAccount() {
        return providentFundAccount;
    }

    public void setProvidentFundAccount(String providentFundAccount) {
        this.providentFundAccount = providentFundAccount == null ? null : providentFundAccount.trim();
    }

    public String getProvidentFundPayment() {
        return providentFundPayment;
    }

    public void setProvidentFundPayment(String providentFundPayment) {
        this.providentFundPayment = providentFundPayment == null ? null : providentFundPayment.trim();
    }

    public String getSocialSecurityAccount() {
        return socialSecurityAccount;
    }

    public void setSocialSecurityAccount(String socialSecurityAccount) {
        this.socialSecurityAccount = socialSecurityAccount == null ? null : socialSecurityAccount.trim();
    }

    public String getSocialSecurityPayment() {
        return socialSecurityPayment;
    }

    public void setSocialSecurityPayment(String socialSecurityPayment) {
        this.socialSecurityPayment = socialSecurityPayment == null ? null : socialSecurityPayment.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbManpowerSocialSecurity other = (TbManpowerSocialSecurity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getSalaryBank() == null ? other.getSalaryBank() == null : this.getSalaryBank().equals(other.getSalaryBank()))
            && (this.getSalaryNumber() == null ? other.getSalaryNumber() == null : this.getSalaryNumber().equals(other.getSalaryNumber()))
            && (this.getProvidentFundAccount() == null ? other.getProvidentFundAccount() == null : this.getProvidentFundAccount().equals(other.getProvidentFundAccount()))
            && (this.getProvidentFundPayment() == null ? other.getProvidentFundPayment() == null : this.getProvidentFundPayment().equals(other.getProvidentFundPayment()))
            && (this.getSocialSecurityAccount() == null ? other.getSocialSecurityAccount() == null : this.getSocialSecurityAccount().equals(other.getSocialSecurityAccount()))
            && (this.getSocialSecurityPayment() == null ? other.getSocialSecurityPayment() == null : this.getSocialSecurityPayment().equals(other.getSocialSecurityPayment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getSalaryBank() == null) ? 0 : getSalaryBank().hashCode());
        result = prime * result + ((getSalaryNumber() == null) ? 0 : getSalaryNumber().hashCode());
        result = prime * result + ((getProvidentFundAccount() == null) ? 0 : getProvidentFundAccount().hashCode());
        result = prime * result + ((getProvidentFundPayment() == null) ? 0 : getProvidentFundPayment().hashCode());
        result = prime * result + ((getSocialSecurityAccount() == null) ? 0 : getSocialSecurityAccount().hashCode());
        result = prime * result + ((getSocialSecurityPayment() == null) ? 0 : getSocialSecurityPayment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", salaryBank=").append(salaryBank);
        sb.append(", salaryNumber=").append(salaryNumber);
        sb.append(", providentFundAccount=").append(providentFundAccount);
        sb.append(", providentFundPayment=").append(providentFundPayment);
        sb.append(", socialSecurityAccount=").append(socialSecurityAccount);
        sb.append(", socialSecurityPayment=").append(socialSecurityPayment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}