package com.volleydev.runtastic.api;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
public class RuntasticActivity {

    private long id;
    private String type;
    private long type_id;
    private long duration;
    private long distance;
    private double pace;
    private String speed;
    private long kcal;
    private long elevation_gain;
    private long elevation_loss;
    private String weather;
    private Object weather_id;
    private String page_url;
    private String map_url;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(JSONObject date) {
        Calendar instance = Calendar.getInstance();
        instance.set(date.getInt("year"),
                Integer.parseInt(date.getString("month")),
                Integer.parseInt(date.getString("day")),
                date.getInt("hour"),
                date.getInt("minutes"),
                date.getInt("seconds"));

        this.date = instance.getTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public long getKcal() {
        return kcal;
    }

    public void setKcal(long kcal) {
        this.kcal = kcal;
    }

    public long getElevation_gain() {
        return elevation_gain;
    }

    public void setElevation_gain(long elevation_gain) {
        this.elevation_gain = elevation_gain;
    }

    public long getElevation_loss() {
        return elevation_loss;
    }

    public void setElevation_loss(long elevation_loss) {
        this.elevation_loss = elevation_loss;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Object getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(Object weather_id) {
        this.weather_id = weather_id;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public String getMap_url() {
        return map_url;
    }

    public void setMap_url(String map_url) {
        this.map_url = map_url;
    }
}
