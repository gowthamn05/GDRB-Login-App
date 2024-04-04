package com.example.gdrbtechnologiespvtltd.interfaces;

import com.example.gdrbtechnologiespvtltd.model.UserLoginRequestPojo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAPIService {

    @POST("login")
    Call<ResponseBody> getLogin(@Body UserLoginRequestPojo loginUserPojo);

}

