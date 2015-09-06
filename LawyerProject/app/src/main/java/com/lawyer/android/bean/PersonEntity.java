package com.lawyer.android.bean;

import java.io.Serializable;

/**
 * Created by chenguoquan on 9/4/15.
 */
public class PersonEntity implements Serializable{

    /**
     * lawyer : {"birthday":1441123200000,"consultNum":0,"expertIn":"dd","firstPracticeTime":1441123200000,"id":2,"idCard":"212121212121","lawyerCertificateNo":"211111111","loginCode":"18516276648","mac":"03F31A05CE9628F8BB93B31CAFE36043E2A3E034","mobile":"15926395578","name":"陈列","orderNum":0,"registerDate":1440755520000,"sex":"男","status":"VALID","tel":"12121212","updateDate":1441371009000}
     * success : true
     */

    private LawyerEntity lawyer;
    private String message;
    private boolean success;

    public void setLawyer(LawyerEntity lawyer) {
        this.lawyer = lawyer;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public LawyerEntity getLawyer() {
        return lawyer;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class LawyerEntity {
        /**
         * birthday : 1441123200000
         * consultNum : 0
         * expertIn : dd
         * firstPracticeTime : 1441123200000
         * id : 2
         * idCard : 212121212121
         * lawyerCertificateNo : 211111111
         * loginCode : 18516276648
         * mac : 03F31A05CE9628F8BB93B31CAFE36043E2A3E034
         * mobile : 15926395578
         * name : 陈列
         * orderNum : 0
         * registerDate : 1440755520000
         * sex : 男
         * status : VALID
         * tel : 12121212
         * updateDate : 1441371009000
         */

        private long birthday;
        private int consultNum;
        private String expertIn;
        private long firstPracticeTime;
        private int id;
        private String idCard;
        private String lawyerCertificateNo;
        private String loginCode;
        private String mac;
        private String mobile;
        private String name;
        private int orderNum;
        private long registerDate;
        private String sex;
        private String status;
        private String tel;
        private long updateDate;
        private String userLogoUrl;

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public void setConsultNum(int consultNum) {
            this.consultNum = consultNum;
        }

        public void setExpertIn(String expertIn) {
            this.expertIn = expertIn;
        }

        public void setFirstPracticeTime(long firstPracticeTime) {
            this.firstPracticeTime = firstPracticeTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public void setLawyerCertificateNo(String lawyerCertificateNo) {
            this.lawyerCertificateNo = lawyerCertificateNo;
        }

        public void setLoginCode(String loginCode) {
            this.loginCode = loginCode;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public void setRegisterDate(long registerDate) {
            this.registerDate = registerDate;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }

        public long getBirthday() {
            return birthday;
        }

        public int getConsultNum() {
            return consultNum;
        }

        public String getExpertIn() {
            return expertIn;
        }

        public long getFirstPracticeTime() {
            return firstPracticeTime;
        }

        public int getId() {
            return id;
        }

        public String getIdCard() {
            return idCard;
        }

        public String getLawyerCertificateNo() {
            return lawyerCertificateNo;
        }

        public String getLoginCode() {
            return loginCode;
        }

        public String getMac() {
            return mac;
        }

        public String getMobile() {
            return mobile;
        }

        public String getName() {
            return name;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public long getRegisterDate() {
            return registerDate;
        }

        public String getSex() {
            return sex;
        }

        public String getStatus() {
            return status;
        }

        public String getTel() {
            return tel;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public String getUserLogoUrl() {
            return userLogoUrl;
        }

        public void setUserLogoUrl(String userLogoUrl) {
            this.userLogoUrl = userLogoUrl;
        }
    }
}
