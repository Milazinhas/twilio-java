/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Proxy
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.proxy.v1.service;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.converter.PrefixedCollapsibleMap;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.format.DateTimeFormatter;
import com.twilio.converter.DateConverter;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.time.ZonedDateTime;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.ToString;

public class SessionUpdater extends Updater<Session>{
    private String pathServiceSid;
    private String pathSid;
    private ZonedDateTime dateExpiry;
    private Integer ttl;
    private Session.Status status;

    public SessionUpdater(final String pathServiceSid, final String pathSid){
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    public SessionUpdater setDateExpiry(final ZonedDateTime dateExpiry){
        this.dateExpiry = dateExpiry;
        return this;
    }
    public SessionUpdater setTtl(final Integer ttl){
        this.ttl = ttl;
        return this;
    }
    public SessionUpdater setStatus(final Session.Status status){
        this.status = status;
        return this;
    }

    @Override
    public Session update(final TwilioRestClient client){
        String path = "/v1/Services/{ServiceSid}/Sessions/{Sid}";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Session update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Session.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (dateExpiry != null) {
            request.addPostParam("DateExpiry", dateExpiry.toInstant().toString());

        }
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
    
        }
        if (status != null) {
            request.addPostParam("Status", status.toString());
    
        }
    }
}
