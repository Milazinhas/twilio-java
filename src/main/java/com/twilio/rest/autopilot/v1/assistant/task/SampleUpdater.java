/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Autopilot
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.autopilot.v1.assistant.task;

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

public class SampleUpdater extends Updater<Sample>{
    private String pathAssistantSid;
    private String pathTaskSid;
    private String pathSid;
    private String language;
    private String taggedText;
    private String sourceChannel;

    public SampleUpdater(final String pathAssistantSid, final String pathTaskSid, final String pathSid){
        this.pathAssistantSid = pathAssistantSid;
        this.pathTaskSid = pathTaskSid;
        this.pathSid = pathSid;
    }

    public SampleUpdater setLanguage(final String language){
        this.language = language;
        return this;
    }
    public SampleUpdater setTaggedText(final String taggedText){
        this.taggedText = taggedText;
        return this;
    }
    public SampleUpdater setSourceChannel(final String sourceChannel){
        this.sourceChannel = sourceChannel;
        return this;
    }

    @Override
    public Sample update(final TwilioRestClient client){
        String path = "/v1/Assistants/{AssistantSid}/Tasks/{TaskSid}/Samples/{Sid}";

        path = path.replace("{"+"AssistantSid"+"}", this.pathAssistantSid.toString());
        path = path.replace("{"+"TaskSid"+"}", this.pathTaskSid.toString());
        path = path.replace("{"+"Sid"+"}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTOPILOT.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Sample update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Sample.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (language != null) {
            request.addPostParam("Language", language);
    
        }
        if (taggedText != null) {
            request.addPostParam("TaggedText", taggedText);
    
        }
        if (sourceChannel != null) {
            request.addPostParam("SourceChannel", sourceChannel);
    
        }
    }
}
