/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Voice
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.voice.v1;

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
public class IpRecord extends Resource {
    private static final long serialVersionUID = 256613502425072L;

    public static IpRecordCreator creator(final String ipAddress){
        return new IpRecordCreator(ipAddress);
    }

    public static IpRecordDeleter deleter(final String pathSid){
        return new IpRecordDeleter(pathSid);
    }

    public static IpRecordFetcher fetcher(final String pathSid){
        return new IpRecordFetcher(pathSid);
    }

    public static IpRecordReader reader(){
        return new IpRecordReader();
    }

    public static IpRecordUpdater updater(final String pathSid){
        return new IpRecordUpdater(pathSid);
    }

    /**
    * Converts a JSON String into a IpRecord object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return IpRecord object represented by the provided JSON
    */
    public static IpRecord fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpRecord.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a IpRecord object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return IpRecord object represented by the provided JSON
    */
    public static IpRecord fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpRecord.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String friendlyName;
    private final String ipAddress;
    private final Integer cidrPrefixLength;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private IpRecord(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("ip_address")
        final String ipAddress,

        @JsonProperty("cidr_prefix_length")
        final Integer cidrPrefixLength,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url
    ) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.ipAddress = ipAddress;
        this.cidrPrefixLength = cidrPrefixLength;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final String getIpAddress() {
            return this.ipAddress;
        }
        public final Integer getCidrPrefixLength() {
            return this.cidrPrefixLength;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
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

        IpRecord other = (IpRecord) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(ipAddress, other.ipAddress) &&  Objects.equals(cidrPrefixLength, other.cidrPrefixLength) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, sid, friendlyName, ipAddress, cidrPrefixLength, dateCreated, dateUpdated, url);
    }

}

