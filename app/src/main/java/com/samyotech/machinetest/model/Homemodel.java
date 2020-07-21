package com.samyotech.machinetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Homemodel {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Homemodel() {
    }

    public Homemodel(Integer status, String message, Data data) {
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

        @SerializedName("recently_added_property")
        @Expose
        private List<RecentlyAddedProperty> recentlyAddedProperty = null;

        public Data() {
        }

        public Data(List<RecentlyAddedProperty> recentlyAddedProperty) {
            super();
            this.recentlyAddedProperty = recentlyAddedProperty;

        }

        public List<RecentlyAddedProperty> getRecentlyAddedProperty() {
            return recentlyAddedProperty;
        }

        public void setRecentlyAddedProperty(List<RecentlyAddedProperty> recentlyAddedProperty) {
            this.recentlyAddedProperty = recentlyAddedProperty;
        }
    }

    public static class RecentlyAddedProperty {

        @SerializedName("s_no")
        @Expose
        private String sNo;
        @SerializedName("property_id")
        @Expose
        private String propertyId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("amount")
        @Expose
        private String amount;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("landmark")
        @Expose
        private String landmark;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("live_stream_id")
        @Expose
        private String liveStreamId;
        @SerializedName("live_stream_date_time")
        @Expose
        private String liveStreamDateTime;
        @SerializedName("cat_id")
        @Expose
        private String catId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("feature")
        @Expose
        private String feature;
        @SerializedName("is_available")
        @Expose
        private String isAvailable;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("cat_name")
        @Expose
        private String catName;
        @SerializedName("pro_imgs")
        @Expose
        private List<ProImg> proImgs = null;
        @SerializedName("favourite_property")
        @Expose
        private String favouriteProperty;

        public RecentlyAddedProperty(String title,String description,String amount,String type) {
            this.title = title;
            this.description = description;
            this.amount = amount;
            this.type = type;


        }



        public String getSNo() {
            return sNo;
        }

        public void setSNo(String sNo) {
            this.sNo = sNo;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
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

        public String getLiveStreamId() {
            return liveStreamId;
        }

        public void setLiveStreamId(String liveStreamId) {
            this.liveStreamId = liveStreamId;
        }

        public String getLiveStreamDateTime() {
            return liveStreamDateTime;
        }

        public void setLiveStreamDateTime(String liveStreamDateTime) {
            this.liveStreamDateTime = liveStreamDateTime;
        }

        public String getCatId() {
            return catId;
        }

        public void setCatId(String catId) {
            this.catId = catId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFeature() {
            return feature;
        }

        public void setFeature(String feature) {
            this.feature = feature;
        }

        public String getIsAvailable() {
            return isAvailable;
        }

        public void setIsAvailable(String isAvailable) {
            this.isAvailable = isAvailable;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public List<ProImg> getProImgs() {
            return proImgs;
        }

        public void setProImgs(List<ProImg> proImgs) {
            this.proImgs = proImgs;
        }

        public String getFavouriteProperty() {
            return favouriteProperty;
        }

        public void setFavouriteProperty(String favouriteProperty) {
            this.favouriteProperty = favouriteProperty;
        }

        public  class ProImg {

            @SerializedName("image_id")
            @Expose
            private String imageId;
            @SerializedName("property_id")
            @Expose
            private String propertyId;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("created_at")
            @Expose
            private String createdAt;

            public ProImg() {
            }

            public ProImg(String title, String description, String amount, String type, String image) {
                this.image = image;
            }

            public String getImageId() {
                return imageId;
            }

            public void setImageId(String imageId) {
                this.imageId = imageId;
            }

            public String getPropertyId() {
                return propertyId;
            }

            public void setPropertyId(String propertyId) {
                this.propertyId = propertyId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

        }

    }


}
