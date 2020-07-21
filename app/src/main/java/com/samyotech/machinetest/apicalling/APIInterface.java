package com.samyotech.machinetest.apicalling;

import com.samyotech.machinetest.model.Homemodel;
import com.samyotech.machinetest.model.Loginmodel;
import com.samyotech.machinetest.model.Signupmodel;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @FormUrlEncoded
    @POST("login")
    Call<Loginmodel> userLogin(@Field("email") String email, @Field("password") String password, @Field("device_type") String devicetype, @Field("device_token") String devicetoken);

    @FormUrlEncoded
    @POST("signup")
    Call<Signupmodel> userSignup(@Field("email") String email, @Field("name") String name, @Field("password") String passwrod,@Field("device_type") String devicetype,@Field("device_token") String devicetoken,@Field("device_id") String devicetid);

    @FormUrlEncoded
    @POST("getHomeData")
    Call<Homemodel> getHomedata(@Field("user_id") String userid);





}
