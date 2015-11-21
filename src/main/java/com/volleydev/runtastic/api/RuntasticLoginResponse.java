package com.volleydev.runtastic.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
