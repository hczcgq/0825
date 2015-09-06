package com.lawyer.android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chenguoquan on 9/6/15.
 */
public class AdviceEntity implements Serializable{


    private boolean success;
    private String message;
    private List<ConsultsEntity> consults;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setConsults(List<ConsultsEntity> consults) {
        this.consults = consults;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<ConsultsEntity> getConsults() {
        return consults;
    }

    public static class ConsultsEntity {
        /**
         * category : {"childNum":0,"code":"CATEGORY","isParent":false,"mac":"-","name":"刑事案件","parent":{"childNum":0,"code":"CATEGORY","isParent":false,"mac":"-","name":"法律分类","sortedByPinyin":{},"sortedBySort":{}},"sortedByPinyin":{},"sortedBySort":{}}
         * createDate : 1441542358000
         * id : 54
         * mac : 02536C853B067089CAD77DA5F3D78A84C04B5B18
         * user : {"createDate":1439174005000,"id":3,"idCard":"310101195405051234","loginCode":"13311683808","mac":"D375E84D0535BCF7C97CAD828388062764C92F07","mobile":"13311683808","name":"13311683808","registerDate":1439174005000,"status":"VALID","updateDate":1439174005000}
         */

        private CategoryEntity category;
        private long createDate;
        private int id;
        private String mac;
        private UserEntity user;

        public void setCategory(CategoryEntity category) {
            this.category = category;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public CategoryEntity getCategory() {
            return category;
        }

        public long getCreateDate() {
            return createDate;
        }

        public int getId() {
            return id;
        }

        public String getMac() {
            return mac;
        }

        public UserEntity getUser() {
            return user;
        }

        public static class CategoryEntity implements Serializable{
            /**
             * childNum : 0
             * code : CATEGORY
             * isParent : false
             * mac : -
             * name : 刑事案件
             * parent : {"childNum":0,"code":"CATEGORY","isParent":false,"mac":"-","name":"法律分类","sortedByPinyin":{},"sortedBySort":{}}
             * sortedByPinyin : {}
             * sortedBySort : {}
             */

            private int childNum;
            private String code;
            private boolean isParent;
            private String mac;
            private String name;
            private ParentEntity parent;

            public void setChildNum(int childNum) {
                this.childNum = childNum;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public void setIsParent(boolean isParent) {
                this.isParent = isParent;
            }

            public void setMac(String mac) {
                this.mac = mac;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setParent(ParentEntity parent) {
                this.parent = parent;
            }

            public int getChildNum() {
                return childNum;
            }

            public String getCode() {
                return code;
            }

            public boolean getIsParent() {
                return isParent;
            }

            public String getMac() {
                return mac;
            }

            public String getName() {
                return name;
            }

            public ParentEntity getParent() {
                return parent;
            }

            public static class ParentEntity {
                /**
                 * childNum : 0
                 * code : CATEGORY
                 * isParent : false
                 * mac : -
                 * name : 法律分类
                 * sortedByPinyin : {}
                 * sortedBySort : {}
                 */

                private int childNum;
                private String code;
                private boolean isParent;
                private String mac;
                private String name;

                public void setChildNum(int childNum) {
                    this.childNum = childNum;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public void setIsParent(boolean isParent) {
                    this.isParent = isParent;
                }

                public void setMac(String mac) {
                    this.mac = mac;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getChildNum() {
                    return childNum;
                }

                public String getCode() {
                    return code;
                }

                public boolean getIsParent() {
                    return isParent;
                }

                public String getMac() {
                    return mac;
                }

                public String getName() {
                    return name;
                }
            }
        }

        public static class UserEntity implements Serializable{
            /**
             * createDate : 1439174005000
             * id : 3
             * idCard : 310101195405051234
             * loginCode : 13311683808
             * mac : D375E84D0535BCF7C97CAD828388062764C92F07
             * mobile : 13311683808
             * name : 13311683808
             * registerDate : 1439174005000
             * status : VALID
             * updateDate : 1439174005000
             */

            private long createDate;
            private int id;
            private String idCard;
            private String loginCode;
            private String mac;
            private String mobile;
            private String name;
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
