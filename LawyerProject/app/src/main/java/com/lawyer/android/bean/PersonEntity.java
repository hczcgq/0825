package com.lawyer.android.bean;

import java.io.Serializable;

/**
 * Created by chenguoquan on 9/4/15.
 */
public class PersonEntity implements Serializable{


    /**
     * body :
     * lawyer : {"auditStatus":null,"birthday":"2015-09-06 00:00:00","consultNum":0,"expertIn":"marry","firstPracticeTime":"2013-07-02 00:00:00","id":2,"idCard":"4210231990124312","lawFirm":null,"lawyerCertificateNo":"0912718526152","lawyerCertificatePhoto":"","level":"","loginCode":"18516276648","mac":"6579CE9DF58392F3543EB4DE555FEFBD61CA4A7E","mobile":"15926395578","name":"陈22","orderNum":0,"recordUrl":"","registerDate":"2015-08-28 17:52:00","sex":"未指定","status":"VALID","tel":"18516276648","updateDate":"2015-09-08 21:12:04","userLogoUrl":"http://static.shuofatang.com/upload/images/201509/08/1441717924298053473.jpg"}
     * message :
     * success : true
     */

    private String body;
    private LawyerEntity lawyer;
    private String message;
    private boolean success;

    public void setBody(String body) {
        this.body = body;
    }

    public void setLawyer(LawyerEntity lawyer) {
        this.lawyer = lawyer;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBody() {
        return body;
    }

    public LawyerEntity getLawyer() {
        return lawyer;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    public static class LawyerEntity implements Serializable{
        /**
         * auditStatus : null
         * birthday : 2015-09-06 00:00:00
         * consultNum : 0
         * expertIn : marry
         * firstPracticeTime : 2013-07-02 00:00:00
         * id : 2
         * idCard : 4210231990124312
         * lawFirm : null
         * lawyerCertificateNo : 0912718526152
         * lawyerCertificatePhoto :
         * level :
         * loginCode : 18516276648
         * mac : 6579CE9DF58392F3543EB4DE555FEFBD61CA4A7E
         * mobile : 15926395578
         * name : 陈22
         * orderNum : 0
         * recordUrl :
         * registerDate : 2015-08-28 17:52:00
         * sex : 未指定
         * status : VALID
         * tel : 18516276648
         * updateDate : 2015-09-08 21:12:04
         * userLogoUrl : http://static.shuofatang.com/upload/images/201509/08/1441717924298053473.jpg
         */

        private Object auditStatus;
        private String birthday;
        private int consultNum;
        private String expertIn;
        private String firstPracticeTime;
        private int id;
        private String idCard;
        private String lawFirm;
        private String lawyerCertificateNo;
        private String lawyerCertificatePhoto;
        private String level;
        private String loginCode;
        private String mac;
        private String mobile;
        private String name;
        private int orderNum;
        private String recordUrl;
        private String registerDate;
        private String sex;
        private String status;
        private String tel;
        private String updateDate;
        private String userLogoUrl;

        public void setAuditStatus(Object auditStatus) {
            this.auditStatus = auditStatus;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setConsultNum(int consultNum) {
            this.consultNum = consultNum;
        }

        public void setExpertIn(String expertIn) {
            this.expertIn = expertIn;
        }

        public void setFirstPracticeTime(String firstPracticeTime) {
            this.firstPracticeTime = firstPracticeTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public void setLawFirm(String lawFirm) {
            this.lawFirm = lawFirm;
        }

        public void setLawyerCertificateNo(String lawyerCertificateNo) {
            this.lawyerCertificateNo = lawyerCertificateNo;
        }

        public void setLawyerCertificatePhoto(String lawyerCertificatePhoto) {
            this.lawyerCertificatePhoto = lawyerCertificatePhoto;
        }

        public void setLevel(String level) {
            this.level = level;
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

        public void setRecordUrl(String recordUrl) {
            this.recordUrl = recordUrl;
        }

        public void setRegisterDate(String registerDate) {
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

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public void setUserLogoUrl(String userLogoUrl) {
            this.userLogoUrl = userLogoUrl;
        }

        public Object getAuditStatus() {
            return auditStatus;
        }

        public String getBirthday() {
            return birthday;
        }

        public int getConsultNum() {
            return consultNum;
        }

        public String getExpertIn() {
            return expertIn;
        }

        public String getFirstPracticeTime() {
            return firstPracticeTime;
        }

        public int getId() {
            return id;
        }

        public String getIdCard() {
            return idCard;
        }

        public String getLawFirm() {
            return lawFirm;
        }

        public String getLawyerCertificateNo() {
            return lawyerCertificateNo;
        }

        public String getLawyerCertificatePhoto() {
            return lawyerCertificatePhoto;
        }

        public String getLevel() {
            return level;
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

        public String getRecordUrl() {
            return recordUrl;
        }

        public String getRegisterDate() {
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

        public String getUpdateDate() {
            return updateDate;
        }

        public String getUserLogoUrl() {
            return userLogoUrl;
        }
    }
}
