package com.volleydev.runtastic.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by flonussi on 11/20/15.
 */
public final class RuntasticLoginResponse {

    private boolean success;

    private String update;

    private RuntasticUser current_user;

    public RuntasticUser getCurrent_user() {
        return current_user;
    }

    public void setCurrent_user(RuntasticUser current_user) {
        this.current_user = current_user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getAuthToken() {
        if (update == null) {
            return "";
        }

        Matcher matcher = Pattern.compile("name=\\\"authenticity_token\\\" type=\\\"hidden\\\" value=\\\"(.*)\\\"").matcher(update);

        if (!matcher.find()) {
            return "";
        }

        return matcher.group(1);
    }
}
