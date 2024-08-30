/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Lookups
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.lookups.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class PhoneNumber extends Resource {

    private static final long serialVersionUID = 141589309941045L;

    public static PhoneNumberFetcher fetcher(final String pathPhoneNumber) {
        return new PhoneNumberFetcher(pathPhoneNumber);
    }

    /**
     * Converts a JSON String into a PhoneNumber object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return PhoneNumber object represented by the provided JSON
     */
    public static PhoneNumber fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a PhoneNumber object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return PhoneNumber object represented by the provided JSON
     */
    public static PhoneNumber fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final Map<String, Object> callerName;
    private final String countryCode;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final String nationalFormat;
    private final Map<String, Object> carrier;
    private final Map<String, Object> addOns;
    private final URI url;

    @JsonCreator
    private PhoneNumber(
        @JsonProperty("caller_name") final Map<String, Object> callerName,
        @JsonProperty("country_code") final String countryCode,
        @JsonProperty(
            "phone_number"
        ) final com.twilio.type.PhoneNumber phoneNumber,
        @JsonProperty("national_format") final String nationalFormat,
        @JsonProperty("carrier") final Map<String, Object> carrier,
        @JsonProperty("add_ons") final Map<String, Object> addOns,
        @JsonProperty("url") final URI url
    ) {
        this.callerName = callerName;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.nationalFormat = nationalFormat;
        this.carrier = carrier;
        this.addOns = addOns;
        this.url = url;
    }

    public final Map<String, Object> getCallerName() {
        return this.callerName;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getNationalFormat() {
        return this.nationalFormat;
    }

    public final Map<String, Object> getCarrier() {
        return this.carrier;
    }

    public final Map<String, Object> getAddOns() {
        return this.addOns;
    }

    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhoneNumber other = (PhoneNumber) o;

        return (
            Objects.equals(callerName, other.callerName) &&
            Objects.equals(countryCode, other.countryCode) &&
            Objects.equals(phoneNumber, other.phoneNumber) &&
            Objects.equals(nationalFormat, other.nationalFormat) &&
            Objects.equals(carrier, other.carrier) &&
            Objects.equals(addOns, other.addOns) &&
            Objects.equals(url, other.url)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            callerName,
            countryCode,
            phoneNumber,
            nationalFormat,
            carrier,
            addOns,
            url
        );
    }
}
