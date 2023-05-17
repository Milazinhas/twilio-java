/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.messaging.v1;

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
public class BrandRegistration extends Resource {
    private static final long serialVersionUID = 243231933683239L;

    public static BrandRegistrationCreator creator(final String customerProfileBundleSid, final String a2PProfileBundleSid){
        return new BrandRegistrationCreator(customerProfileBundleSid, a2PProfileBundleSid);
    }

    public static BrandRegistrationFetcher fetcher(final String pathSid){
        return new BrandRegistrationFetcher(pathSid);
    }

    public static BrandRegistrationReader reader(){
        return new BrandRegistrationReader();
    }

    public static BrandRegistrationUpdater updater(final String pathSid){
        return new BrandRegistrationUpdater(pathSid);
    }

    /**
    * Converts a JSON String into a BrandRegistration object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return BrandRegistration object represented by the provided JSON
    */
    public static BrandRegistration fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, BrandRegistration.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a BrandRegistration object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return BrandRegistration object represented by the provided JSON
    */
    public static BrandRegistration fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, BrandRegistration.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum BrandFeedback {
        TAX_ID("TAX_ID"),
        STOCK_SYMBOL("STOCK_SYMBOL"),
        NONPROFIT("NONPROFIT"),
        GOVERNMENT_ENTITY("GOVERNMENT_ENTITY"),
        OTHERS("OTHERS");

        private final String value;

        private BrandFeedback(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static BrandFeedback forValue(final String value) {
            return Promoter.enumFromString(value, BrandFeedback.values());
        }
    }
    public enum IdentityStatus {
        SELF_DECLARED("SELF_DECLARED"),
        UNVERIFIED("UNVERIFIED"),
        VERIFIED("VERIFIED"),
        VETTED_VERIFIED("VETTED_VERIFIED");

        private final String value;

        private IdentityStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static IdentityStatus forValue(final String value) {
            return Promoter.enumFromString(value, IdentityStatus.values());
        }
    }
    public enum Status {
        PENDING("PENDING"),
        APPROVED("APPROVED"),
        FAILED("FAILED"),
        IN_REVIEW("IN_REVIEW"),
        DELETED("DELETED");

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

    private final String sid;
    private final String accountSid;
    private final String customerProfileBundleSid;
    private final String a2pProfileBundleSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String brandType;
    private final BrandRegistration.Status status;
    private final String tcrId;
    private final String failureReason;
    private final URI url;
    private final Integer brandScore;
    private final List<BrandRegistration.BrandFeedback> brandFeedback;
    private final BrandRegistration.IdentityStatus identityStatus;
    private final Boolean russell3000;
    private final Boolean governmentEntity;
    private final String taxExemptStatus;
    private final Boolean skipAutomaticSecVet;
    private final Boolean mock;
    private final Map<String, String> links;

    @JsonCreator
    private BrandRegistration(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("customer_profile_bundle_sid")
        final String customerProfileBundleSid,

        @JsonProperty("a2p_profile_bundle_sid")
        final String a2pProfileBundleSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("brand_type")
        final String brandType,

        @JsonProperty("status")
        final BrandRegistration.Status status,

        @JsonProperty("tcr_id")
        final String tcrId,

        @JsonProperty("failure_reason")
        final String failureReason,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("brand_score")
        final Integer brandScore,

        @JsonProperty("brand_feedback")
        final List<BrandRegistration.BrandFeedback> brandFeedback,

        @JsonProperty("identity_status")
        final BrandRegistration.IdentityStatus identityStatus,

        @JsonProperty("russell3000")
        final Boolean russell3000,

        @JsonProperty("government_entity")
        final Boolean governmentEntity,

        @JsonProperty("tax_exempt_status")
        final String taxExemptStatus,

        @JsonProperty("skip_automatic_sec_vet")
        final Boolean skipAutomaticSecVet,

        @JsonProperty("mock")
        final Boolean mock,

        @JsonProperty("links")
        final Map<String, String> links
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.customerProfileBundleSid = customerProfileBundleSid;
        this.a2pProfileBundleSid = a2pProfileBundleSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.brandType = brandType;
        this.status = status;
        this.tcrId = tcrId;
        this.failureReason = failureReason;
        this.url = url;
        this.brandScore = brandScore;
        this.brandFeedback = brandFeedback;
        this.identityStatus = identityStatus;
        this.russell3000 = russell3000;
        this.governmentEntity = governmentEntity;
        this.taxExemptStatus = taxExemptStatus;
        this.skipAutomaticSecVet = skipAutomaticSecVet;
        this.mock = mock;
        this.links = links;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getCustomerProfileBundleSid() {
            return this.customerProfileBundleSid;
        }
        public final String getA2pProfileBundleSid() {
            return this.a2pProfileBundleSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getBrandType() {
            return this.brandType;
        }
        public final BrandRegistration.Status getStatus() {
            return this.status;
        }
        public final String getTcrId() {
            return this.tcrId;
        }
        public final String getFailureReason() {
            return this.failureReason;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Integer getBrandScore() {
            return this.brandScore;
        }
        public final List<BrandRegistration.BrandFeedback> getBrandFeedback() {
            return this.brandFeedback;
        }
        public final BrandRegistration.IdentityStatus getIdentityStatus() {
            return this.identityStatus;
        }
        public final Boolean getRussell3000() {
            return this.russell3000;
        }
        public final Boolean getGovernmentEntity() {
            return this.governmentEntity;
        }
        public final String getTaxExemptStatus() {
            return this.taxExemptStatus;
        }
        public final Boolean getSkipAutomaticSecVet() {
            return this.skipAutomaticSecVet;
        }
        public final Boolean getMock() {
            return this.mock;
        }
        public final Map<String, String> getLinks() {
            return this.links;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrandRegistration other = (BrandRegistration) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(customerProfileBundleSid, other.customerProfileBundleSid) &&  Objects.equals(a2pProfileBundleSid, other.a2pProfileBundleSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(brandType, other.brandType) &&  Objects.equals(status, other.status) &&  Objects.equals(tcrId, other.tcrId) &&  Objects.equals(failureReason, other.failureReason) &&  Objects.equals(url, other.url) &&  Objects.equals(brandScore, other.brandScore) &&  Objects.equals(brandFeedback, other.brandFeedback) &&  Objects.equals(identityStatus, other.identityStatus) &&  Objects.equals(russell3000, other.russell3000) &&  Objects.equals(governmentEntity, other.governmentEntity) &&  Objects.equals(taxExemptStatus, other.taxExemptStatus) &&  Objects.equals(skipAutomaticSecVet, other.skipAutomaticSecVet) &&  Objects.equals(mock, other.mock) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, customerProfileBundleSid, a2pProfileBundleSid, dateCreated, dateUpdated, brandType, status, tcrId, failureReason, url, brandScore, brandFeedback, identityStatus, russell3000, governmentEntity, taxExemptStatus, skipAutomaticSecVet, mock, links);
    }

}

