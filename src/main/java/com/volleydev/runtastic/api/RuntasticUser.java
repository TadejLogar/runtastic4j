package com.volleydev.runtastic.api;

/**
 * Created by flonussi on 11/21/15.
 */
public class RuntasticUser {

    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private long age;
    private String gender;
    private double height;
    private double weight;
    private String slug;
    private long activity_level;
    private String locale;

    private Object fb_user_id;
    private Object google_user_id;
    private Object docomo_user_id;

    private String format_of_date;
    private String format_of_time;
    private long timezone_offset;
    private String temperature_unit_type;
    private String weight_unit_type;
    private String unit_type;

    private boolean is_beta_tester;
    private boolean is_gold_user;

    private String status;
    private String records_path;
    private String run_sessions_path;
    private long training_plans_count;
    private String user_type;
    private String week_starts_at;
    private String currency;
    private long cache_key_for_run_sessions;
    private boolean can_add_training_plan;

    public long getId() {
        return id;
    }

    public String getRun_sessions_path() {
        return run_sessions_path;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getActivity_level() {
        return activity_level;
    }

    public void setActivity_level(long activity_level) {
        this.activity_level = activity_level;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getCache_key_for_run_sessions() {
        return cache_key_for_run_sessions;
    }

    public void setCache_key_for_run_sessions(long cache_key_for_run_sessions) {
        this.cache_key_for_run_sessions = cache_key_for_run_sessions;
    }

    public boolean isCan_add_training_plan() {
        return can_add_training_plan;
    }

    public void setCan_add_training_plan(boolean can_add_training_plan) {
        this.can_add_training_plan = can_add_training_plan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getFb_user_id() {
        return fb_user_id;
    }

    public void setFb_user_id(Object fb_user_id) {
        this.fb_user_id = fb_user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFormat_of_date() {
        return format_of_date;
    }

    public void setFormat_of_date(String format_of_date) {
        this.format_of_date = format_of_date;
    }

    public String getFormat_of_time() {
        return format_of_time;
    }

    public void setFormat_of_time(String format_of_time) {
        this.format_of_time = format_of_time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getGoogle_user_id() {
        return google_user_id;
    }

    public void setGoogle_user_id(Object google_user_id) {
        this.google_user_id = google_user_id;
    }

    public Object getDocomo_user_id() {
        return docomo_user_id;
    }

    public void setDocomo_user_id(Object docomo_user_id) {
        this.docomo_user_id = docomo_user_id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean is_beta_tester() {
        return is_beta_tester;
    }

    public void setIs_beta_tester(boolean is_beta_tester) {
        this.is_beta_tester = is_beta_tester;
    }

    public boolean is_gold_user() {
        return is_gold_user;
    }

    public void setIs_gold_user(boolean is_gold_user) {
        this.is_gold_user = is_gold_user;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getRecords_path() {
        return records_path;
    }

    public void setRecords_path(String records_path) {
        this.records_path = records_path;
    }

    public void setRun_sessions_path(String run_sessions_path) {
        this.run_sessions_path = run_sessions_path;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTemperature_unit_type() {
        return temperature_unit_type;
    }

    public void setTemperature_unit_type(String temperature_unit_type) {
        this.temperature_unit_type = temperature_unit_type;
    }

    public long getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(long timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public long getTraining_plans_count() {
        return training_plans_count;
    }

    public void setTraining_plans_count(long training_plans_count) {
        this.training_plans_count = training_plans_count;
    }

    public String getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getWeek_starts_at() {
        return week_starts_at;
    }

    public void setWeek_starts_at(String week_starts_at) {
        this.week_starts_at = week_starts_at;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight_unit_type() {
        return weight_unit_type;
    }

    public void setWeight_unit_type(String weight_unit_type) {
        this.weight_unit_type = weight_unit_type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
