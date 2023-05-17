/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Serverless
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.serverless.v1.service.environment;

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
public class Log extends Resource {
    private static final long serialVersionUID = 129897058125132L;

    public static LogFetcher fetcher(final String pathServiceSid, final String pathEnvironmentSid, final String pathSid){
        return new LogFetcher(pathServiceSid, pathEnvironmentSid, pathSid);
    }

    public static LogReader reader(final String pathServiceSid, final String pathEnvironmentSid){
        return new LogReader(pathServiceSid, pathEnvironmentSid);
    }

    /**
    * Converts a JSON String into a Log object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Log object represented by the provided JSON
    */
    public static Log fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Log.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Log object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Log object represented by the provided JSON
    */
    public static Log fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Log.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Level {
        INFO("info"),
        WARN("warn"),
        ERROR("error");

        private final String value;

        private Level(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Level forValue(final String value) {
            return Promoter.enumFromString(value, Level.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String environmentSid;
    private final String buildSid;
    private final String deploymentSid;
    private final String functionSid;
    private final String requestSid;
    private final Log.Level level;
    private final String message;
    private final ZonedDateTime dateCreated;
    private final URI url;

    @JsonCreator
    private Log(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("service_sid")
        final String serviceSid,

        @JsonProperty("environment_sid")
        final String environmentSid,

        @JsonProperty("build_sid")
        final String buildSid,

        @JsonProperty("deployment_sid")
        final String deploymentSid,

        @JsonProperty("function_sid")
        final String functionSid,

        @JsonProperty("request_sid")
        final String requestSid,

        @JsonProperty("level")
        final Log.Level level,

        @JsonProperty("message")
        final String message,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("url")
        final URI url
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.environmentSid = environmentSid;
        this.buildSid = buildSid;
        this.deploymentSid = deploymentSid;
        this.functionSid = functionSid;
        this.requestSid = requestSid;
        this.level = level;
        this.message = message;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getServiceSid() {
            return this.serviceSid;
        }
        public final String getEnvironmentSid() {
            return this.environmentSid;
        }
        public final String getBuildSid() {
            return this.buildSid;
        }
        public final String getDeploymentSid() {
            return this.deploymentSid;
        }
        public final String getFunctionSid() {
            return this.functionSid;
        }
        public final String getRequestSid() {
            return this.requestSid;
        }
        public final Log.Level getLevel() {
            return this.level;
        }
        public final String getMessage() {
            return this.message;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final URI getUrl() {
            return this.url;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Log other = (Log) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(serviceSid, other.serviceSid) &&  Objects.equals(environmentSid, other.environmentSid) &&  Objects.equals(buildSid, other.buildSid) &&  Objects.equals(deploymentSid, other.deploymentSid) &&  Objects.equals(functionSid, other.functionSid) &&  Objects.equals(requestSid, other.requestSid) &&  Objects.equals(level, other.level) &&  Objects.equals(message, other.message) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, serviceSid, environmentSid, buildSid, deploymentSid, functionSid, requestSid, level, message, dateCreated, url);
    }

}

