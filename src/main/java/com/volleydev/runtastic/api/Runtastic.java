package com.volleydev.runtastic.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by flonussi on 11/20/15.
 */
public class Runtastic {

    private static final String BASE_URL = "https://www.runtastic.com";
    private static final String LOGIN_URL = BASE_URL + "/en/d/users/sign_in.json";
    private static final String LOGOUT_URL = BASE_URL + "/en/d/users/sign_out.json";
    private static final String SESSION_API_URL = BASE_URL + "/api/run_sessions/json";

    private RuntasticHttpClient client;

    private String loginUsername;

    RuntasticLoginResponse loginResponse;

    public String authToken = "";

    private boolean loggedIn = false;

    public Runtastic(RuntasticHttpClient client) {
        this.client = client;
        client.initialize();
    }

    public boolean login(String loginUsername, String loginPassword) throws IOException {
        if (loggedIn && loginResponse != null)
            return true;

        HashMap<String, String> postValues = new HashMap<String, String>();
        postValues.put("user[email]", loginUsername);
        postValues.put("user[password]", loginPassword);
        postValues.put("authenticity_token", authToken);


        RunResponse response = client.getResponse(LOGIN_URL, RuntasticHttpClient.RequestMethod.POST, postValues);


        if (response.getStatusCode() != 200) {
            throw new IOException("Login failed! Http status code is: " +
                    response.getStatusCode() + ", should be 200\n" +
                    response.getResponseBody());
        }

        loginResponse = parseLoginResponse(response.getResponseBody());

        if (!loginResponse.isSuccess()) {
            throw new IOException("Json response is not successful");
        }

        this.authToken = loginResponse.getAuthToken();
        this.loginUsername = loginUsername;
        return loggedIn = true;
    }


    public RuntasticUser getUser() throws IOException {
        if (!loggedIn) {
            throw new IOException("You must be logged in to access the user data");
        }

        return loginResponse.getCurrent_user();
    }


    public List<RuntasticActivity> getActivities() throws IOException, ParseException {
        if (!loggedIn || loginResponse == null)
            throw new IOException("You have to log in to access your activities");

        RunResponse sessionListResponse = client.getResponse(BASE_URL + loginResponse.getCurrent_user().getRun_sessions_path(),
                RuntasticHttpClient.RequestMethod.GET, null);

        if (sessionListResponse.getStatusCode() != 200) {
            throw new IOException("Http status code is: " + sessionListResponse.getStatusCode() + ", should be 200");
        }

        Matcher matcher = Pattern.compile("var index_data = (.*);").matcher(sessionListResponse.getResponseBody());
        if (!matcher.find()) {
            throw new ParseException("Couldn't parse activity data", -1);
        }

        JSONArray jsonActivityArray = new JSONArray(matcher.group(1));

        List<String> idList = new ArrayList<String>();

        for (int i = 0; i < jsonActivityArray.length(); i++) {
            idList.add(String.valueOf(jsonActivityArray.getJSONArray(i).getInt(0)));
        }

        Collections.sort(idList);
        Collections.reverse(idList);

        HashMap<String, String> postValues = new HashMap<String, String>();
        postValues.put("user_id", String.valueOf(loginResponse.getCurrent_user().getId()));
        postValues.put("items", String.join(",", idList));
        postValues.put("authenticity_token", authToken);

        RunResponse activityListResponse = client.getResponse(SESSION_API_URL, RuntasticHttpClient.RequestMethod.POST, postValues);

        if (activityListResponse.getStatusCode() != 200) {
            throw new IOException("Http status code is: " + sessionListResponse.getStatusCode() + ", should be 200");
        }

        List<RuntasticActivity> activityList = parseActivityList(activityListResponse.getResponseBody());

        return activityList;
    }

    private List<RuntasticActivity> parseActivityList(String activityListResponse) {

        JSONArray activityArray = new JSONArray(activityListResponse);

        List<RuntasticActivity> runtasticActivityList = new ArrayList<RuntasticActivity>();

        for (int i = 0; i < activityArray.length(); i++) {

            JSONObject entry = activityArray.getJSONObject(i);

            RuntasticActivity activity = new RuntasticActivity();
            activity.setId(entry.getLong("id"));
            activity.setType(entry.getString("type"));
            activity.setType_id(entry.getLong("type_id"));
            activity.setDuration(entry.getLong("duration"));
            activity.setPace(entry.getDouble("pace"));
            activity.setSpeed(entry.getString("speed"));
            activity.setKcal(entry.getLong("kcal"));
            activity.setElevation_gain(entry.getLong("elevation_gain"));
            activity.setElevation_loss(entry.getLong("elevation_loss"));
            activity.setWeather(entry.getString("weather"));
            activity.setWeather_id(entry.get("weather_id"));
            activity.setPage_url(entry.getString("page_url"));
            activity.setMap_url(entry.getString("map_url"));
            activity.setDate(entry.getJSONObject("date"));

            runtasticActivityList.add(activity);
        }

        return runtasticActivityList;
    }


    private RuntasticLoginResponse parseLoginResponse(String loginResponse) {
        JSONObject loginJSONObject = new JSONObject(loginResponse);

        RuntasticLoginResponse response = new RuntasticLoginResponse();
        RuntasticUser userDetail = new RuntasticUser();

        response.setSuccess(loginJSONObject.getBoolean("success"));
        response.setUpdate(loginJSONObject.getString("update"));

        JSONObject currentUser = loginJSONObject.getJSONObject("current_user");

        userDetail.setId(currentUser.getLong("id"));
        userDetail.setFirst_name(currentUser.getString("first_name"));
        userDetail.setLast_name(currentUser.getString("last_name"));
        userDetail.setEmail(currentUser.getString("email"));
        userDetail.setAge(currentUser.getLong("age"));
        userDetail.setGender(currentUser.getString("gender"));
        userDetail.setHeight(currentUser.getDouble("height"));
        userDetail.setWeight(currentUser.getDouble("weight"));
        userDetail.setSlug(currentUser.getString("slug"));
        userDetail.setActivity_level(currentUser.getLong("activity_level"));
        userDetail.setLocale(currentUser.getString("locale"));
        userDetail.setFb_user_id(currentUser.get("fb_user_id"));
        userDetail.setGoogle_user_id(currentUser.get("google_user_id"));
        userDetail.setDocomo_user_id(currentUser.get("docomo_user_id"));
        userDetail.setFormat_of_date(currentUser.getString("format_of_date"));
        userDetail.setFormat_of_time(currentUser.getString("format_of_time"));
        userDetail.setTimezone_offset(currentUser.getLong("timezone_offset"));
        userDetail.setTemperature_unit_type(currentUser.getString("temperature_unit_type"));
        userDetail.setWeight_unit_type(currentUser.getString("weight_unit_type"));
        userDetail.setUnit_type(currentUser.getString("unit_type"));
        userDetail.setIs_beta_tester(currentUser.getBoolean("is_beta_tester"));
        userDetail.setIs_gold_user(currentUser.getBoolean("is_gold_user"));
        userDetail.setStatus(currentUser.getString("status"));
        userDetail.setRecords_path(currentUser.getString("records_path"));
        userDetail.setRun_sessions_path(currentUser.getString("run_sessions_path"));
        userDetail.setTraining_plans_count(currentUser.getLong("training_plans_count"));
        userDetail.setUser_type(currentUser.getString("user_type"));
        userDetail.setWeek_starts_at(currentUser.getString("week_starts_at"));
        userDetail.setCurrency(currentUser.getString("currency"));
        userDetail.setCache_key_for_run_sessions(currentUser.getLong("cache_key_for_run_sessions"));
        userDetail.setCan_add_training_plan(currentUser.getBoolean("can_add_training_plan"));

        response.setCurrent_user(userDetail);

        return response;
    }
}
