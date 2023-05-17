/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account;

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

public class ApplicationUpdater extends Updater<Application>{
    private String pathSid;
    private String pathAccountSid;
    private String friendlyName;
    private String apiVersion;
    private URI voiceUrl;
    private HttpMethod voiceMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private Boolean voiceCallerIdLookup;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;
    private URI smsStatusCallback;
    private URI messageStatusCallback;
    private Boolean publicApplicationConnectEnabled;

    public ApplicationUpdater(final String pathSid){
        this.pathSid = pathSid;
    }
    public ApplicationUpdater(final String pathAccountSid, final String pathSid){
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    public ApplicationUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public ApplicationUpdater setApiVersion(final String apiVersion){
        this.apiVersion = apiVersion;
        return this;
    }
    public ApplicationUpdater setVoiceUrl(final URI voiceUrl){
        this.voiceUrl = voiceUrl;
        return this;
    }

    public ApplicationUpdater setVoiceUrl(final String voiceUrl){
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }
    public ApplicationUpdater setVoiceMethod(final HttpMethod voiceMethod){
        this.voiceMethod = voiceMethod;
        return this;
    }
    public ApplicationUpdater setVoiceFallbackUrl(final URI voiceFallbackUrl){
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    public ApplicationUpdater setVoiceFallbackUrl(final String voiceFallbackUrl){
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }
    public ApplicationUpdater setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod){
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }
    public ApplicationUpdater setStatusCallback(final URI statusCallback){
        this.statusCallback = statusCallback;
        return this;
    }

    public ApplicationUpdater setStatusCallback(final String statusCallback){
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }
    public ApplicationUpdater setStatusCallbackMethod(final HttpMethod statusCallbackMethod){
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }
    public ApplicationUpdater setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup){
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }
    public ApplicationUpdater setSmsUrl(final URI smsUrl){
        this.smsUrl = smsUrl;
        return this;
    }

    public ApplicationUpdater setSmsUrl(final String smsUrl){
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }
    public ApplicationUpdater setSmsMethod(final HttpMethod smsMethod){
        this.smsMethod = smsMethod;
        return this;
    }
    public ApplicationUpdater setSmsFallbackUrl(final URI smsFallbackUrl){
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    public ApplicationUpdater setSmsFallbackUrl(final String smsFallbackUrl){
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }
    public ApplicationUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod){
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }
    public ApplicationUpdater setSmsStatusCallback(final URI smsStatusCallback){
        this.smsStatusCallback = smsStatusCallback;
        return this;
    }

    public ApplicationUpdater setSmsStatusCallback(final String smsStatusCallback){
        return setSmsStatusCallback(Promoter.uriFromString(smsStatusCallback));
    }
    public ApplicationUpdater setMessageStatusCallback(final URI messageStatusCallback){
        this.messageStatusCallback = messageStatusCallback;
        return this;
    }

    public ApplicationUpdater setMessageStatusCallback(final String messageStatusCallback){
        return setMessageStatusCallback(Promoter.uriFromString(messageStatusCallback));
    }
    public ApplicationUpdater setPublicApplicationConnectEnabled(final Boolean publicApplicationConnectEnabled){
        this.publicApplicationConnectEnabled = publicApplicationConnectEnabled;
        return this;
    }

    @Override
    public Application update(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/Applications/{Sid}.json";

        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{"+"AccountSid"+"}", this.pathAccountSid.toString());
        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Application update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Application.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
    
        }
        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
    
        }
        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
    
        }
        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
    
        }
        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
    
        }
        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
    
        }
        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
    
        }
        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());
    
        }
        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
    
        }
        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
    
        }
        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
    
        }
        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
    
        }
        if (smsStatusCallback != null) {
            request.addPostParam("SmsStatusCallback", smsStatusCallback.toString());
    
        }
        if (messageStatusCallback != null) {
            request.addPostParam("MessageStatusCallback", messageStatusCallback.toString());
    
        }
        if (publicApplicationConnectEnabled != null) {
            request.addPostParam("PublicApplicationConnectEnabled", publicApplicationConnectEnabled.toString());
    
        }
    }
}
