package com.lawyer.android.bean;

import java.util.List;

/**
 * Created by chenguoquan on 9/2/15.
 */
public class OrderEntity {


    /**
     * orders : [{"createDate":1439789105000,"id":13,"idCard":"320106198006130434","mac":"B164E7C29B8D955908D834510254641510F16090","orderStatus":"NOT_BIND","payDate":1439789105000,"payInfo":"PayInfo","payNo":"1006910184201508170640285339","payProvider":"WEIXIN","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"companyName":".上海好啊信息技术有限公司","createDate":1439602070000,"id":12,"mac":"CF4DB6C4E33FE28A03CA3F21FD92257791111DEE","orderStatus":"NOT_BIND","payDate":1439602070000,"payInfo":"PayInfo","payNo":"1006360184201508150624222670","payProvider":"WEIXIN","price":1000,"product":{"id":2,"name":"千元聘法顾","price":1000},"user":{"createDate":1439174005000,"id":3,"idCard":"310101195405051234","loginCode":"13311683808","mac":"BEB8643CC70E4B324B27B45FDF0C50A1F49C045E","mobile":"13311683808","name":"13311683808","registerDate":1439174005000,"status":"VALID","updateDate":1439174005000}},{"createDate":1439602014000,"id":11,"idCard":"310101195405051234","mac":"A349A37C17D7C1FF1CFA622F64631AE45EDC3470","orderStatus":"NOT_BIND","payDate":1439602015000,"payInfo":"PayInfo","payNo":"1006360184201508150624227204","payProvider":"WEIXIN","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439174005000,"id":3,"idCard":"310101195405051234","loginCode":"13311683808","mac":"BEB8643CC70E4B324B27B45FDF0C50A1F49C045E","mobile":"13311683808","name":"13311683808","registerDate":1439174005000,"status":"VALID","updateDate":1439174005000}},{"companyName":"shanghai yituo","createDate":1439567171000,"id":10,"mac":"482786057FCC45E130A339E9BA1920D384ADF662","orderStatus":"NOT_BIND","payDate":1439567171000,"payInfo":"PayInfo","payNo":"1006910184201508140623235705","payProvider":"WEIXIN","price":1000,"product":{"id":2,"name":"千元聘法顾","price":1000},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439562938000,"id":9,"idCard":"320106198006130434","mac":"E403D7304856217EB93EB91873D5A092945E11F6","orderStatus":"NOT_BIND","payDate":1439562940000,"payInfo":"PayInfo","payNo":"1006910184201508140622931470","payProvider":"WEIXIN","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439562921000,"id":8,"idCard":"320106198006130434","mac":"4593CB0EB4585CA25DB2AD68A6D65236F055D379","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439562829000,"id":7,"idCard":"320106198006130434","mac":"635A78247B936E750B00358AB9E6C7315ED7E3D1","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439562255000,"id":6,"idCard":"320106198006130434","mac":"61B0DB6241099B7166793CEF1E91D85073697C7E","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439545268000,"id":5,"idCard":"320106198006130434","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439544647000,"id":4,"idCard":"320106198006130434","mac":"7C24FE2A588EBFF07D43D73ADC8C6CEE350D93E0","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439544467000,"id":3,"idCard":"320106198006130434","mac":"BEB8643CC70E4B324B27B45FDF0C50A1F49C045E","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}},{"createDate":1439544460000,"id":2,"idCard":"320106198006130434","mac":"F50FA82CA1A6601689052BBCD4476F613C0D786E","orderStatus":"NOT_PAY","price":100,"product":{"id":1,"name":"百元聘律师","price":100},"user":{"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}}]
     * success : true
     */

    private boolean success;
    private String message;
    private List<OrdersEntity> orders;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<OrdersEntity> getOrders() {
        return orders;
    }


    public static class OrdersEntity {
        /**
         * companyName:shanghai yituo
         * createDate : 1439789105000
         * id : 13
         * idCard : 320106198006130434
         * mac : B164E7C29B8D955908D834510254641510F16090
         * orderStatus : NOT_BIND
         * payDate : 1439789105000
         * payInfo : PayInfo
         * payNo : 1006910184201508170640285339
         * payProvider : WEIXIN
         * price : 100
         * product : {"id":1,"name":"百元聘律师","price":100}
         * user : {"createDate":1439349680000,"id":5,"idCard":"320106198006130434","loginCode":"13761687932","mac":"DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4","mobile":"13761687932","name":"柳攀","nickname":"leon","registerDate":1439349680000,"status":"VALID","updateDate":1439731246000}
         */

        private String companyName;
        private long createDate;
        private int id;
        private String idCard;
        private String mac;
        private String orderStatus;
        private long payDate;
        private String payInfo;
        private String payNo;
        private String payProvider;
        private int price;
        private ProductEntity product;
        private UserEntity user;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public void setPayDate(long payDate) {
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

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public long getCreateDate() {
            return createDate;
        }

        public int getId() {
            return id;
        }

        public String getIdCard() {
            return idCard;
        }

        public String getMac() {
            return mac;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public long getPayDate() {
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

        public UserEntity getUser() {
            return user;
        }

        public static class ProductEntity {
            /**
             * id : 1
             * name : 百元聘律师
             * price : 100
             */

            private int id;
            private String name;
            private int price;

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPrice(int price) {
                this.price = price;
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
        }

        public static class UserEntity {
            /**
             * createDate : 1439349680000
             * id : 5
             * idCard : 320106198006130434
             * loginCode : 13761687932
             * mac : DFC8DB22A4C4418394FC75B1B4CECAF8C8C311E4
             * mobile : 13761687932
             * name : 柳攀
             * nickname : leon
             * registerDate : 1439349680000
             * status : VALID
             * updateDate : 1439731246000
             */

            private long createDate;
            private int id;
            private String idCard;
            private String loginCode;
            private String mac;
            private String mobile;
            private String name;
            private String nickname;
            private long registerDate;
            private String status;
            private long updateDate;

            public void setCreateDate(long createDate) {
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

            public void setRegisterDate(long registerDate) {
                this.registerDate = registerDate;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setUpdateDate(long updateDate) {
                this.updateDate = updateDate;
            }

            public long getCreateDate() {
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

            public long getRegisterDate() {
                return registerDate;
            }

            public String getStatus() {
                return status;
            }

            public long getUpdateDate() {
                return updateDate;
            }
        }
    }
}
