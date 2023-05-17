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
public class Recording extends Resource {
    private static final long serialVersionUID = 8927692317007L;

    public static RecordingDeleter deleter(final String pathSid){
        return new RecordingDeleter(pathSid);
    }
    public static RecordingDeleter deleter(final String pathAccountSid, final String pathSid){
        return new RecordingDeleter(pathAccountSid, pathSid);
    }

    public static RecordingFetcher fetcher(final String pathSid){
        return new RecordingFetcher(pathSid);
    }
    public static RecordingFetcher fetcher(final String pathAccountSid, final String pathSid){
        return new RecordingFetcher(pathAccountSid, pathSid);
    }

    public static RecordingReader reader(){
        return new RecordingReader();
    }
    public static RecordingReader reader(final String pathAccountSid){
        return new RecordingReader(pathAccountSid);
    }

    /**
    * Converts a JSON String into a Recording object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Recording object represented by the provided JSON
    */
    public static Recording fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Recording object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Recording object represented by the provided JSON
    */
    public static Recording fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Source {
        DIALVERB("DialVerb"),
        CONFERENCE("Conference"),
        OUTBOUNDAPI("OutboundAPI"),
        TRUNKING("Trunking"),
        RECORDVERB("RecordVerb"),
        STARTCALLRECORDINGAPI("StartCallRecordingAPI"),
        STARTCONFERENCERECORDINGAPI("StartConferenceRecordingAPI");

        private final String value;

        private Source(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Source forValue(final String value) {
            return Promoter.enumFromString(value, Source.values());
        }
    }
    public enum Status {
        IN_PROGRESS("in-progress"),
        PAUSED("paused"),
        STOPPED("stopped"),
        PROCESSING("processing"),
        COMPLETED("completed"),
        ABSENT("absent"),
        DELETED("deleted");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String callSid;
    private final String conferenceSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final ZonedDateTime startTime;
    private final String duration;
    private final String sid;
    private final String price;
    private final String priceUnit;
    private final Recording.Status status;
    private final Integer channels;
    private final Recording.Source source;
    private final Integer errorCode;
    private final String uri;
    private final Map<String, Object> encryptionDetails;
    private final Map<String, String> subresourceUris;
    private final URI mediaUrl;

    @JsonCreator
    private Recording(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("api_version")
        final String apiVersion,

        @JsonProperty("call_sid")
        final String callSid,

        @JsonProperty("conference_sid")
        final String conferenceSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("start_time")
        final String startTime,

        @JsonProperty("duration")
        final String duration,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("price")
        final String price,

        @JsonProperty("price_unit")
        final String priceUnit,

        @JsonProperty("status")
        final Recording.Status status,

        @JsonProperty("channels")
        final Integer channels,

        @JsonProperty("source")
        final Recording.Source source,

        @JsonProperty("error_code")
        final Integer errorCode,

        @JsonProperty("uri")
        final String uri,

        @JsonProperty("encryption_details")
        final Map<String, Object> encryptionDetails,

        @JsonProperty("subresource_uris")
        final Map<String, String> subresourceUris,

        @JsonProperty("media_url")
        final URI mediaUrl
    ) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callSid = callSid;
        this.conferenceSid = conferenceSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.startTime = DateConverter.rfc2822DateTimeFromString(startTime);
        this.duration = duration;
        this.sid = sid;
        this.price = price;
        this.priceUnit = priceUnit;
        this.status = status;
        this.channels = channels;
        this.source = source;
        this.errorCode = errorCode;
        this.uri = uri;
        this.encryptionDetails = encryptionDetails;
        this.subresourceUris = subresourceUris;
        this.mediaUrl = mediaUrl;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getApiVersion() {
            return this.apiVersion;
        }
        public final String getCallSid() {
            return this.callSid;
        }
        public final String getConferenceSid() {
            return this.conferenceSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final ZonedDateTime getStartTime() {
            return this.startTime;
        }
        public final String getDuration() {
            return this.duration;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getPrice() {
            return this.price;
        }
        public final String getPriceUnit() {
            return this.priceUnit;
        }
        public final Recording.Status getStatus() {
            return this.status;
        }
        public final Integer getChannels() {
            return this.channels;
        }
        public final Recording.Source getSource() {
            return this.source;
        }
        public final Integer getErrorCode() {
            return this.errorCode;
        }
        public final String getUri() {
            return this.uri;
        }
        public final Map<String, Object> getEncryptionDetails() {
            return this.encryptionDetails;
        }
        public final Map<String, String> getSubresourceUris() {
            return this.subresourceUris;
        }
        public final URI getMediaUrl() {
            return this.mediaUrl;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Recording other = (Recording) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(apiVersion, other.apiVersion) &&  Objects.equals(callSid, other.callSid) &&  Objects.equals(conferenceSid, other.conferenceSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(startTime, other.startTime) &&  Objects.equals(duration, other.duration) &&  Objects.equals(sid, other.sid) &&  Objects.equals(price, other.price) &&  Objects.equals(priceUnit, other.priceUnit) &&  Objects.equals(status, other.status) &&  Objects.equals(channels, other.channels) &&  Objects.equals(source, other.source) &&  Objects.equals(errorCode, other.errorCode) &&  Objects.equals(uri, other.uri) &&  Objects.equals(encryptionDetails, other.encryptionDetails) &&  Objects.equals(subresourceUris, other.subresourceUris) &&  Objects.equals(mediaUrl, other.mediaUrl)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, apiVersion, callSid, conferenceSid, dateCreated, dateUpdated, startTime, duration, sid, price, priceUnit, status, channels, source, errorCode, uri, encryptionDetails, subresourceUris, mediaUrl);
    }

}

