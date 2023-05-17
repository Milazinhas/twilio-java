/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trusthub
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trusthub.v1.trustproducts;

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
public class TrustProductsChannelEndpointAssignment extends Resource {
    private static final long serialVersionUID = 19553243454529L;

    public static TrustProductsChannelEndpointAssignmentCreator creator(final String pathTrustProductSid, final String channelEndpointType, final String channelEndpointSid){
        return new TrustProductsChannelEndpointAssignmentCreator(pathTrustProductSid, channelEndpointType, channelEndpointSid);
    }

    public static TrustProductsChannelEndpointAssignmentDeleter deleter(final String pathTrustProductSid, final String pathSid){
        return new TrustProductsChannelEndpointAssignmentDeleter(pathTrustProductSid, pathSid);
    }

    public static TrustProductsChannelEndpointAssignmentFetcher fetcher(final String pathTrustProductSid, final String pathSid){
        return new TrustProductsChannelEndpointAssignmentFetcher(pathTrustProductSid, pathSid);
    }

    public static TrustProductsChannelEndpointAssignmentReader reader(final String pathTrustProductSid){
        return new TrustProductsChannelEndpointAssignmentReader(pathTrustProductSid);
    }

    /**
    * Converts a JSON String into a TrustProductsChannelEndpointAssignment object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return TrustProductsChannelEndpointAssignment object represented by the provided JSON
    */
    public static TrustProductsChannelEndpointAssignment fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProductsChannelEndpointAssignment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a TrustProductsChannelEndpointAssignment object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return TrustProductsChannelEndpointAssignment object represented by the provided JSON
    */
    public static TrustProductsChannelEndpointAssignment fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProductsChannelEndpointAssignment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String trustProductSid;
    private final String accountSid;
    private final String channelEndpointType;
    private final String channelEndpointSid;
    private final ZonedDateTime dateCreated;
    private final URI url;

    @JsonCreator
    private TrustProductsChannelEndpointAssignment(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("trust_product_sid")
        final String trustProductSid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("channel_endpoint_type")
        final String channelEndpointType,

        @JsonProperty("channel_endpoint_sid")
        final String channelEndpointSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("url")
        final URI url
    ) {
        this.sid = sid;
        this.trustProductSid = trustProductSid;
        this.accountSid = accountSid;
        this.channelEndpointType = channelEndpointType;
        this.channelEndpointSid = channelEndpointSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getTrustProductSid() {
            return this.trustProductSid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getChannelEndpointType() {
            return this.channelEndpointType;
        }
        public final String getChannelEndpointSid() {
            return this.channelEndpointSid;
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

        TrustProductsChannelEndpointAssignment other = (TrustProductsChannelEndpointAssignment) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(trustProductSid, other.trustProductSid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(channelEndpointType, other.channelEndpointType) &&  Objects.equals(channelEndpointSid, other.channelEndpointSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, trustProductSid, accountSid, channelEndpointType, channelEndpointSid, dateCreated, url);
    }

}

