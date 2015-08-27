package com.lawyer.android.bean;

import java.io.Serializable;

/**
 * Created by chenguoquan on 8/27/15.
 */
public class LawyerItem implements Serializable{
    private String id;
    private String name;
    private String birthDay;
    private String sex;
    private String firstPracticeTime;
    private String expertIn;
    private String mobile;
    private String tel;
    private String lawyerCertificateNo;
    private String idCard;
    private String level;
    private String loginCode;
    private String registerDate;
    private String updateDate;
    private String auditStatus;
    private String status;
    private String mac;
    private String orderNum;
    private String consultNum;

    public LawyerItem(String id, String name, String birthDay, String sex, String firstPracticeTime, String expertIn, String mobile, String tel, String lawyerCertificateNo, String idCard, String level, String loginCode, String registerDate, String updateDate, String auditStatus, String status, String mac, String orderNum, String consultNum) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
        this.firstPracticeTime = firstPracticeTime;
        this.expertIn = expertIn;
        this.mobile = mobile;
        this.tel = tel;
        this.lawyerCertificateNo = lawyerCertificateNo;
        this.idCard = idCard;
        this.level = level;
        this.loginCode = loginCode;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.auditStatus = auditStatus;
        this.status = status;
        this.mac = mac;
        this.orderNum = orderNum;
        this.consultNum = consultNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFirstPracticeTime() {
        return firstPracticeTime;
    }

    public void setFirstPracticeTime(String firstPracticeTime) {
        this.firstPracticeTime = firstPracticeTime;
    }

    public String getExpertIn() {
        return expertIn;
    }

    public void setExpertIn(String expertIn) {
        this.expertIn = expertIn;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLawyerCertificateNo() {
        return lawyerCertificateNo;
    }

    public void setLawyerCertificateNo(String lawyerCertificateNo) {
        this.lawyerCertificateNo = lawyerCertificateNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getConsultNum() {
        return consultNum;
    }

    public void setConsultNum(String consultNum) {
        this.consultNum = consultNum;
    }
}
