package com.samyotech.machinetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loginmodel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Loginmodel() {
    }

    /**
     *
     * @param data
     * @param message
     * @param status
     */
    public Loginmodel(Integer status, String message, Data data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("landmark")
        @Expose
        private String landmark;
        @SerializedName("credits")
        @Expose
        private String credits;
        @SerializedName("device_type")
        @Expose
        private String deviceType;
        @SerializedName("device_token")
        @Expose
        private String deviceToken;
        @SerializedName("created_at")
        @Expose
        private String createdAt;

        public Data() {
        }


        public Data(String userId, String name, String email, String countryCode, String mobile, String image, String password, String address, String status, String latitude, String longitude, String landmark, String credits, String deviceType, String deviceToken, String createdAt) {
            super();
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.countryCode = countryCode;
            this.mobile = mobile;
            this.image = image;
            this.password = password;
            this.address = address;
            this.status = status;
            this.latitude = latitude;
            this.longitude = longitude;
            this.landmark = landmark;
            this.credits = credits;
            this.deviceType = deviceType;
            this.deviceToken = deviceToken;
            this.createdAt = createdAt;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public String getCredits() {
            return credits;
        }

        public void setCredits(String credits) {
            this.credits = credits;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

    }

}
