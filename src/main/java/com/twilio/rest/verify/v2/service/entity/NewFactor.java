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

package com.twilio.rest.verify.v2.service.entity;

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
public class NewFactor extends Resource {
    private static final long serialVersionUID = 115808224888150L;

    public static NewFactorCreator creator(final String pathServiceSid, final String pathIdentity, final String friendlyName, final NewFactor.FactorTypes factorType){
        return new NewFactorCreator(pathServiceSid, pathIdentity, friendlyName, factorType);
    }

    /**
    * Converts a JSON String into a NewFactor object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return NewFactor object represented by the provided JSON
    */
    public static NewFactor fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, NewFactor.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a NewFactor object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return NewFactor object represented by the provided JSON
    */
    public static NewFactor fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, NewFactor.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum FactorStatuses {
        UNVERIFIED("unverified"),
        VERIFIED("verified");

        private final String value;

        private FactorStatuses(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static FactorStatuses forValue(final String value) {
            return Promoter.enumFromString(value, FactorStatuses.values());
        }
    }
    public enum FactorTypes {
        PUSH("push"),
        TOTP("totp");

        private final String value;

        private FactorTypes(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static FactorTypes forValue(final String value) {
            return Promoter.enumFromString(value, FactorTypes.values());
        }
    }
    public enum NotificationPlatforms {
        APN("apn"),
        FCM("fcm"),
        NONE("none");

        private final String value;

        private NotificationPlatforms(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static NotificationPlatforms forValue(final String value) {
            return Promoter.enumFromString(value, NotificationPlatforms.values());
        }
    }
    public enum TotpAlgorithms {
        SHA1("sha1"),
        SHA256("sha256"),
        SHA512("sha512");

        private final String value;

        private TotpAlgorithms(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static TotpAlgorithms forValue(final String value) {
            return Promoter.enumFromString(value, TotpAlgorithms.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String entitySid;
    private final String identity;
    private final Map<String, Object> binding;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String friendlyName;
    private final NewFactor.FactorStatuses status;
    private final NewFactor.FactorTypes factorType;
    private final Map<String, Object> config;
    private final Map<String, Object> metadata;
    private final URI url;

    @JsonCreator
    private NewFactor(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("service_sid")
        final String serviceSid,

        @JsonProperty("entity_sid")
        final String entitySid,

        @JsonProperty("identity")
        final String identity,

        @JsonProperty("binding")
        final Map<String, Object> binding,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("status")
        final NewFactor.FactorStatuses status,

        @JsonProperty("factor_type")
        final NewFactor.FactorTypes factorType,

        @JsonProperty("config")
        final Map<String, Object> config,

        @JsonProperty("metadata")
        final Map<String, Object> metadata,

        @JsonProperty("url")
        final URI url
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.entitySid = entitySid;
        this.identity = identity;
        this.binding = binding;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.status = status;
        this.factorType = factorType;
        this.config = config;
        this.metadata = metadata;
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
        public final String getEntitySid() {
            return this.entitySid;
        }
        public final String getIdentity() {
            return this.identity;
        }
        public final Map<String, Object> getBinding() {
            return this.binding;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final NewFactor.FactorStatuses getStatus() {
            return this.status;
        }
        public final NewFactor.FactorTypes getFactorType() {
            return this.factorType;
        }
        public final Map<String, Object> getConfig() {
            return this.config;
        }
        public final Map<String, Object> getMetadata() {
            return this.metadata;
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

        NewFactor other = (NewFactor) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(serviceSid, other.serviceSid) &&  Objects.equals(entitySid, other.entitySid) &&  Objects.equals(identity, other.identity) &&  Objects.equals(binding, other.binding) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(status, other.status) &&  Objects.equals(factorType, other.factorType) &&  Objects.equals(config, other.config) &&  Objects.equals(metadata, other.metadata) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, serviceSid, entitySid, identity, binding, dateCreated, dateUpdated, friendlyName, status, factorType, config, metadata, url);
    }

}

