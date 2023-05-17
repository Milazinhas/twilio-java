/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2.service;

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

public class AccessTokenCreator extends Creator<AccessToken>{
    private String pathServiceSid;
    private String identity;
    private AccessToken.FactorTypes factorType;
    private String factorFriendlyName;
    private Integer ttl;

    public AccessTokenCreator(final String pathServiceSid, final String identity, final AccessToken.FactorTypes factorType) {
        this.pathServiceSid = pathServiceSid;
        this.identity = identity;
        this.factorType = factorType;
    }

    public AccessTokenCreator setIdentity(final String identity){
        this.identity = identity;
        return this;
    }
    public AccessTokenCreator setFactorType(final AccessToken.FactorTypes factorType){
        this.factorType = factorType;
        return this;
    }
    public AccessTokenCreator setFactorFriendlyName(final String factorFriendlyName){
        this.factorFriendlyName = factorFriendlyName;
        return this;
    }
    public AccessTokenCreator setTtl(final Integer ttl){
        this.ttl = ttl;
        return this;
    }

    @Override
    public AccessToken create(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/AccessTokens";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"Identity"+"}", this.identity.toString());
        path = path.replace("{"+"FactorType"+"}", this.factorType.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("AccessToken creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return AccessToken.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
    
        }
        if (factorType != null) {
            request.addPostParam("FactorType", factorType.toString());
    
        }
        if (factorFriendlyName != null) {
            request.addPostParam("FactorFriendlyName", factorFriendlyName);
    
        }
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
    
        }
    }
}
