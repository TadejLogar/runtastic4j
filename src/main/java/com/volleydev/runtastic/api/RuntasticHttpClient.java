package com.volleydev.runtastic.api;

import com.sun.istack.internal.Nullable;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by flonussi on 11/21/15.
 */
public interface RuntasticHttpClient {

    enum RequestMethod {
        GET,
        POST
    }

    void initialize();

    RunResponse getResponse(String url, RequestMethod rm, @Nullable HashMap<String, String> postParams) throws IOException;

}
