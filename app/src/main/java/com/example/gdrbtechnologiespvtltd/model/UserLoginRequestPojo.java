package com.example.gdrbtechnologiespvtltd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class UserLoginRequestPojo {
    @SerializedName("email")
    @JsonProperty("email")
    private String email;
    @SerializedName("password")
    @JsonProperty("password")
    private String password;
    @SerializedName("device_id")
    @JsonProperty("device_id")
    private String deviceId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
