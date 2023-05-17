/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.ipmessaging.v2.service;

import com.twilio.base.Creator;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import com.twilio.converter.Converter;
import java.time.ZonedDateTime;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import com.twilio.converter.DateConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.ToString;

import java.net.URI;

public class UserCreator extends Creator<User>{
    private String pathServiceSid;
    private String identity;
    private User.WebhookEnabledType xTwilioWebhookEnabled;
    private String roleSid;
    private String attributes;
    private String friendlyName;

    public UserCreator(final String pathServiceSid, final String identity) {
        this.pathServiceSid = pathServiceSid;
        this.identity = identity;
    }

    public UserCreator setIdentity(final String identity){
        this.identity = identity;
        return this;
    }
    public UserCreator setXTwilioWebhookEnabled(final User.WebhookEnabledType xTwilioWebhookEnabled){
        this.xTwilioWebhookEnabled = xTwilioWebhookEnabled;
        return this;
    }
    public UserCreator setRoleSid(final String roleSid){
        this.roleSid = roleSid;
        return this;
    }
    public UserCreator setAttributes(final String attributes){
        this.attributes = attributes;
        return this;
    }
    public UserCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }

    @Override
    public User create(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/Users";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"Identity"+"}", this.identity.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            path
        );
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("User creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return User.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
    
        }
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
    
        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
    }
    private void addHeaderParams(final Request request) {
        if (xTwilioWebhookEnabled != null) {
            request.addHeaderParam("X-Twilio-Webhook-Enabled", xTwilioWebhookEnabled.toString());

        }
    }
}
