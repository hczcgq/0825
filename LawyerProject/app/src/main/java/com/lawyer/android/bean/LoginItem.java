package com.lawyer.android.bean;

/**
 * Created by hm-soft on 2015/8/28.
 */
public class LoginItem {
    /**
     * success : true
     * lawyer : {"id":2,"status":"VALID","consultNum":0,"registerDate":1440755520000,"orderNum":0,"mac":"3A51F6C84B09630022B257359BBE6E8484325937","loginCode":"18516276648"}
     */
    private boolean success;
    private LawyerEntity lawyer;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setLawyer(LawyerEntity lawyer) {
        this.lawyer = lawyer;
    }

    public boolean isSuccess() {
        return success;
    }

    public LawyerEntity getLawyer() {
        return lawyer;
    }

    public static class LawyerEntity {
        /**
         * id : 2
         * status : VALID
         * consultNum : 0
         * registerDate : 1440755520000
         * orderNum : 0
         * mac : 3A51F6C84B09630022B257359BBE6E8484325937
         * loginCode : 18516276648
         */
        private int id;
        private String status;
        private int consultNum;
        private long registerDate;
        private int orderNum;
        private String mac;
        private String loginCode;

        public void setId(int id) {
            this.id = id;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setConsultNum(int consultNum) {
            this.consultNum = consultNum;
        }

        public void setRegisterDate(long registerDate) {
            this.registerDate = registerDate;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public void setLoginCode(String loginCode) {
            this.loginCode = loginCode;
        }

        public int getId() {
            return id;
        }

        public String getStatus() {
            return status;
        }

        public int getConsultNum() {
            return consultNum;
        }

        public long getRegisterDate() {
            return registerDate;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public String getMac() {
            return mac;
        }

        public String getLoginCode() {
            return loginCode;
        }
    }
}
