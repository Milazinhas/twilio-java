/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.preview.understand.assistant.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import java.util.Currency;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.converter.PrefixedCollapsibleMap;
import com.twilio.converter.CurrencyDeserializer;
import com.twilio.exception.ApiConnectionException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import java.util.Map;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.twilio.type.PhoneNumberCapabilities;
import com.twilio.type.FeedbackIssue;
import com.twilio.type.IceServer;
import com.twilio.type.InboundCallPrice;
import com.twilio.type.OutboundPrefixPriceWithOrigin;
import com.twilio.type.OutboundPrefixPrice;
import com.twilio.type.OutboundCallPriceWithOrigin;
import com.twilio.type.PhoneNumberPrice;
import com.twilio.type.InboundSmsPrice;
import com.twilio.type.OutboundSmsPrice;
import com.twilio.type.OutboundCallPrice;
import com.twilio.type.RecordingRule;
import com.twilio.type.SubscribeRule;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Sample extends Resource {
    private static final long serialVersionUID = 197447215274163L;

    public static SampleCreator creator(final String pathAssistantSid, final String pathTaskSid, final String language, final String taggedText){
        return new SampleCreator(pathAssistantSid, pathTaskSid, language, taggedText);
    }

    public static SampleDeleter deleter(final String pathAssistantSid, final String pathTaskSid, final String pathSid){
        return new SampleDeleter(pathAssistantSid, pathTaskSid, pathSid);
    }

    public static SampleFetcher fetcher(final String pathAssistantSid, final String pathTaskSid, final String pathSid){
        return new SampleFetcher(pathAssistantSid, pathTaskSid, pathSid);
    }

    public static SampleReader reader(final String pathAssistantSid, final String pathTaskSid){
        return new SampleReader(pathAssistantSid, pathTaskSid);
    }

    public static SampleUpdater updater(final String pathAssistantSid, final String pathTaskSid, final String pathSid){
        return new SampleUpdater(pathAssistantSid, pathTaskSid, pathSid);
    }

    /**
    * Converts a JSON String into a Sample object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Sample object represented by the provided JSON
    */
    public static Sample fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Sample.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Sample object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Sample object represented by the provided JSON
    */
    public static Sample fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Sample.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String taskSid;
    private final String language;
    private final String assistantSid;
    private final String sid;
    private final String taggedText;
    private final URI url;
    private final String sourceChannel;

    @JsonCreator
    private Sample(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("task_sid")
        final String taskSid,

        @JsonProperty("language")
        final String language,

        @JsonProperty("assistant_sid")
        final String assistantSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("tagged_text")
        final String taggedText,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("source_channel")
        final String sourceChannel
    ) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.taskSid = taskSid;
        this.language = language;
        this.assistantSid = assistantSid;
        this.sid = sid;
        this.taggedText = taggedText;
        this.url = url;
        this.sourceChannel = sourceChannel;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getTaskSid() {
            return this.taskSid;
        }
        public final String getLanguage() {
            return this.language;
        }
        public final String getAssistantSid() {
            return this.assistantSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getTaggedText() {
            return this.taggedText;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final String getSourceChannel() {
            return this.sourceChannel;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Sample other = (Sample) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(taskSid, other.taskSid) &&  Objects.equals(language, other.language) &&  Objects.equals(assistantSid, other.assistantSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(taggedText, other.taggedText) &&  Objects.equals(url, other.url) &&  Objects.equals(sourceChannel, other.sourceChannel)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, dateCreated, dateUpdated, taskSid, language, assistantSid, sid, taggedText, url, sourceChannel);
    }

}

