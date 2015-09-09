package com.lawyer.android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenguoquan on 9/2/15.
 */
public class OrderEntity implements Serializable {


    /**
     * body :
     * message :
     * orders : [{"companyName":"","createDate":"2015-08-17 13:25:05","end":null,"id":13,"idCard":"320106198006130434","lawyer":null,"mac":"86AA0030A2EBF0A1E5E6B3FE9E00546987C1DDC9","orderStatus":"NOT_BIND","payDate":"2015-08-17 13:25:05","payInfo":"PayInfo","payNo":"1006910184201508170640285339","payProvider":"WEIXIN","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":".上海好啊信息技术有限公司","createDate":"2015-08-15 09:27:50","end":null,"id":12,"idCard":"","lawyer":null,"mac":"18B364F38B409303F968AE42D2AEA49E22E7C10B","orderStatus":"NOT_BIND","payDate":"2015-08-15 09:27:50","payInfo":"PayInfo","payNo":"1006360184201508150624222670","payProvider":"WEIXIN","price":1000,"product":{"description":"","id":2,"name":"千元聘法顾","price":1000,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-10 10:33:25","id":3,"idCard":"310101195405051234","loginCode":"13311683808","mac":"F5CF09580CFD7AA70EC62C3E8C492F8DF49BC9E0","mobile":"13311683808","name":"13311683808","nickname":"","registerDate":"2015-08-10 10:33:25","sex":"","status":"VALID","updateDate":"2015-08-10 10:33:25","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-15 09:26:54","end":null,"id":11,"idCard":"310101195405051234","lawyer":null,"mac":"613BE733F4049BFB7166C43AC60C8914AB14D0F6","orderStatus":"NOT_BIND","payDate":"2015-08-15 09:26:55","payInfo":"PayInfo","payNo":"1006360184201508150624227204","payProvider":"WEIXIN","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-10 10:33:25","id":3,"idCard":"310101195405051234","loginCode":"13311683808","mac":"F5CF09580CFD7AA70EC62C3E8C492F8DF49BC9E0","mobile":"13311683808","name":"13311683808","nickname":"","registerDate":"2015-08-10 10:33:25","sex":"","status":"VALID","updateDate":"2015-08-10 10:33:25","userLogoUrl":""}},{"companyName":"shanghai yituo","createDate":"2015-08-14 23:46:11","end":"2016-09-07 15:23:33","id":10,"idCard":"","lawyer":{"auditStatus":null,"birthday":"2015-09-01 00:00:00","consultNum":0,"expertIn":"marry","firstPracticeTime":"2015-09-05 00:00:00","id":3,"idCard":"","lawFirm":null,"lawyerCertificateNo":"01234567896","lawyerCertificatePhoto":"","level":"","loginCode":"13052373168","mac":"F5CF09580CFD7AA70EC62C3E8C492F8DF49BC9E0","mobile":"13052373168","name":"嵩的空间","orderNum":0,"recordUrl":"","registerDate":"2015-08-31 14:05:57","sex":"男","status":"VALID","tel":"135267881731","updateDate":"2015-09-08 14:54:05","userLogoUrl":"http://static.shuofatang.com/upload/images/201509/07/1441641554247064216.jpg"},"mac":"3AE7782DDDC7AB3679446AC2EB40B598BDD589C2","orderStatus":"BIND_LAWYER","payDate":"2015-08-14 23:46:11","payInfo":"PayInfo","payNo":"1006910184201508140623235705","payProvider":"WEIXIN","price":1000,"product":{"description":"","id":2,"name":"千元聘法顾","price":1000,"status":"VALID"},"start":"2015-09-07 15:23:56","user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 22:35:38","end":null,"id":9,"idCard":"320106198006130434","lawyer":null,"mac":"B06E153D9F5ED2496CD63EFDA5B401C68BEA16AC","orderStatus":"NOT_BIND","payDate":"2015-08-14 22:35:40","payInfo":"PayInfo","payNo":"1006910184201508140622931470","payProvider":"WEIXIN","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 22:35:21","end":null,"id":8,"idCard":"320106198006130434","lawyer":null,"mac":"3D45FBF5918AA15E927DF5163F1D250E2B64D726","orderStatus":"NOT_PAY","payDate":null,"payInfo":"","payNo":"","payProvider":"","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 22:33:49","end":null,"id":7,"idCard":"320106198006130434","lawyer":null,"mac":"57F2BA9B3A366C68001C57B7CAAA356D96853F83","orderStatus":"NOT_PAY","payDate":null,"payInfo":"","payNo":"","payProvider":"","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 22:24:15","end":null,"id":6,"idCard":"320106198006130434","lawyer":null,"mac":"45D8554554C51DA178A41B8FF4089B265819B7AA","orderStatus":"NOT_PAY","payDate":null,"payInfo":"","payNo":"","payProvider":"","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 17:41:08","end":null,"id":5,"idCard":"320106198006130434","lawyer":null,"mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","orderStatus":"NOT_PAY","payDate":null,"payInfo":"","payNo":"","payProvider":"","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 17:30:47","end":null,"id":4,"idCard":"320106198006130434","lawyer":null,"mac":"F760A5EAA644F53A5D6DB530EF2F16E8B84877D1","orderStatus":"NOT_PAY","payDate":null,"payInfo":"","payNo":"","payProvider":"","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 17:27:47","end":null,"id":3,"idCard":"320106198006130434","lawyer":null,"mac":"F5CF09580CFD7AA70EC62C3E8C492F8DF49BC9E0","orderStatus":"NOT_PAY","payDate":null,"payInfo":"","payNo":"","payProvider":"","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":null,"user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}},{"companyName":"","createDate":"2015-08-14 17:27:40","end":"2016-09-07 15:23:33","id":2,"idCard":"320106198006130434","lawyer":{"auditStatus":null,"birthday":"2015-09-01 00:00:00","consultNum":0,"expertIn":"marry","firstPracticeTime":"2015-09-05 00:00:00","id":3,"idCard":"","lawFirm":null,"lawyerCertificateNo":"01234567896","lawyerCertificatePhoto":"","level":"","loginCode":"13052373168","mac":"F5CF09580CFD7AA70EC62C3E8C492F8DF49BC9E0","mobile":"13052373168","name":"嵩的空间","orderNum":0,"recordUrl":"","registerDate":"2015-08-31 14:05:57","sex":"男","status":"VALID","tel":"135267881731","updateDate":"2015-09-08 14:54:05","userLogoUrl":"http://static.shuofatang.com/upload/images/201509/07/1441641554247064216.jpg"},"mac":"6579CE9DF58392F3543EB4DE555FEFBD61CA4A7E","orderStatus":"BIND_LAWYER","payDate":"2015-08-14 22:35:40","payInfo":"PayInfo","payNo":"1006910184201508140622931470","payProvider":"WEIXIN","price":100,"product":{"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"},"start":"2015-09-07 15:23:23","user":{"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}}]
     * success : true
     */

    private String body;
    private String message;
    private boolean success;
    private List<OrdersEntity> orders;

    public void setBody(String body) {
        this.body = body;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    public String getBody() {
        return body;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public static class OrdersEntity implements Serializable{
        /**
         * companyName :
         * createDate : 2015-08-17 13:25:05
         * end : null
         * id : 13
         * idCard : 320106198006130434
         * lawyer : null
         * mac : 86AA0030A2EBF0A1E5E6B3FE9E00546987C1DDC9
         * orderStatus : NOT_BIND
         * payDate : 2015-08-17 13:25:05
         * payInfo : PayInfo
         * payNo : 1006910184201508170640285339
         * payProvider : WEIXIN
         * price : 100
         * product : {"description":"","id":1,"name":"百元聘律师","price":100,"status":"VALID"}
         * start : null
         * user : {"auditStatus":null,"createDate":"2015-08-12 11:21:20","id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"99AB93925FCE4AA7DAE02BE01EDB225041F437BF","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":"2015-08-12 11:21:20","sex":"","status":"VALID","updateDate":"2015-08-16 21:20:46","userLogoUrl":""}
         */

        private String companyName;
        private String createDate;
        private Object end;
        private int id;
        private String idCard;
        private Object lawyer;
        private String mac;
        private String orderStatus;
        private String payDate;
        private String payInfo;
        private String payNo;
        private String payProvider;
        private int price;
        private ProductEntity product;
        private Object start;
        private UserEntity user;

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public void setEnd(Object end) {
            this.end = end;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public void setLawyer(Object lawyer) {
            this.lawyer = lawyer;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public void setPayDate(String payDate) {
            this.payDate = payDate;
        }

        public void setPayInfo(String payInfo) {
            this.payInfo = payInfo;
        }

        public void setPayNo(String payNo) {
            this.payNo = payNo;
        }

        public void setPayProvider(String payProvider) {
            this.payProvider = payProvider;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setProduct(ProductEntity product) {
            this.product = product;
        }

        public void setStart(Object start) {
            this.start = start;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getCreateDate() {
            return createDate;
        }

        public Object getEnd() {
            return end;
        }

        public int getId() {
            return id;
        }

        public String getIdCard() {
            return idCard;
        }

        public Object getLawyer() {
            return lawyer;
        }

        public String getMac() {
            return mac;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public String getPayDate() {
            return payDate;
        }

        public String getPayInfo() {
            return payInfo;
        }

        public String getPayNo() {
            return payNo;
        }

        public String getPayProvider() {
            return payProvider;
        }

        public int getPrice() {
            return price;
        }

        public ProductEntity getProduct() {
            return product;
        }

        public Object getStart() {
            return start;
        }

        public UserEntity getUser() {
            return user;
        }

        public static class ProductEntity implements Serializable{
            /**
             * description :
             * id : 1
             * name : 百元聘律师
             * price : 100
             * status : VALID
             */

            private String description;
            private int id;
            private String name;
            private int price;
            private String status;

            public void setDescription(String description) {
                this.description = description;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public int getPrice() {
                return price;
            }

            public String getStatus() {
                return status;
            }
        }

        public static class UserEntity implements Serializable{
            /**
             * auditStatus : null
             * createDate : 2015-08-12 11:21:20
             * id : 5
             * idCard : 320106198006130434
             * loginCode : 13761687932
             * mac : 99AB93925FCE4AA7DAE02BE01EDB225041F437BF
             * mobile : 13761687932
             * name : 柳攀
             * nickname : leon
             * registerDate : 2015-08-12 11:21:20
             * sex :
             * status : VALID
             * updateDate : 2015-08-16 21:20:46
             * userLogoUrl :
             */

            private Object auditStatus;
            private String createDate;
            private int id;
            private String idCard;
            private String loginCode;
            private String mac;
            private String mobile;
            private String name;
            private String nickname;
            private String registerDate;
            private String sex;
            private String status;
            private String updateDate;
            private String userLogoUrl;

            public void setAuditStatus(Object auditStatus) {
                this.auditStatus = auditStatus;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
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

            public void setNickname(String nickname) {
                this.nickname = nickname;
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

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public void setUserLogoUrl(String userLogoUrl) {
                this.userLogoUrl = userLogoUrl;
            }

            public Object getAuditStatus() {
                return auditStatus;
            }

            public String getCreateDate() {
                return createDate;
            }

            public int getId() {
                return id;
            }

            public String getIdCard() {
                return idCard;
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

            public String getNickname() {
                return nickname;
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

            public String getUpdateDate() {
                return updateDate;
            }

            public String getUserLogoUrl() {
                return userLogoUrl;
            }
        }
    }
}
