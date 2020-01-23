/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.lookups.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneNumber extends Resource {
    private static final long serialVersionUID = 198564396301377L;

    public enum Type {
        LANDLINE("landline"),
        MOBILE("mobile"),
        VOIP("voip");

        private final String value;

        private Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Type from a string.
         * @param value string value
         * @return generated Type
         */
        @JsonCreator
        public static Type forValue(final String value) {
            return Promoter.enumFromString(value, Type.values());
        }
    }

    /**
     * Create a PhoneNumberFetcher to execute fetch.
     *
     * @param pathPhoneNumber The phone number to fetch in E.164 format
     * @return PhoneNumberFetcher capable of executing the fetch
     */
    public static PhoneNumberFetcher fetcher(final com.twilio.type.PhoneNumber pathPhoneNumber) {
        return new PhoneNumberFetcher(pathPhoneNumber);
    }

    /**
     * Converts a JSON String into a PhoneNumber object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return PhoneNumber object represented by the provided JSON
     */
    public static PhoneNumber fromJson(final String json, final ObjectMapper objectMapper) {
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
    public static PhoneNumber fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, PhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final Map<String, String> callerName;
    private final String countryCode;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final String nationalFormat;
    private final Map<String, String> carrier;
    private final Map<String, Object> addOns;
    private final URI url;

    @JsonCreator
    private PhoneNumber(@JsonProperty("caller_name")
                        final Map<String, String> callerName,
                        @JsonProperty("country_code")
                        final String countryCode,
                        @JsonProperty("phone_number")
                        final com.twilio.type.PhoneNumber phoneNumber,
                        @JsonProperty("national_format")
                        final String nationalFormat,
                        @JsonProperty("carrier")
                        final Map<String, String> carrier,
                        @JsonProperty("add_ons")
                        final Map<String, Object> addOns,
                        @JsonProperty("url")
                        final URI url) {
        this.callerName = callerName;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.nationalFormat = nationalFormat;
        this.carrier = carrier;
        this.addOns = addOns;
        this.url = url;
    }

    /**
     * Returns The name of the phone number's owner.
     *
     * @return The name of the phone number's owner
     */
    public final Map<String, String> getCallerName() {
        return this.callerName;
    }

    /**
     * Returns The ISO country code for the phone number.
     *
     * @return The ISO country code for the phone number
     */
    public final String getCountryCode() {
        return this.countryCode;
    }

    /**
     * Returns The phone number in E.164 format.
     *
     * @return The phone number in E.164 format
     */
    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns The phone number, in national format.
     *
     * @return The phone number, in national format
     */
    public final String getNationalFormat() {
        return this.nationalFormat;
    }

    /**
     * Returns The telecom company that provides the phone number.
     *
     * @return The telecom company that provides the phone number
     */
    public final Map<String, String> getCarrier() {
        return this.carrier;
    }

    /**
     * Returns A JSON string with the results of the Add-ons you specified.
     *
     * @return A JSON string with the results of the Add-ons you specified
     */
    public final Map<String, Object> getAddOns() {
        return this.addOns;
    }

    /**
     * Returns The absolute URL of the resource.
     *
     * @return The absolute URL of the resource
     */
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

        return Objects.equals(callerName, other.callerName) &&
               Objects.equals(countryCode, other.countryCode) &&
               Objects.equals(phoneNumber, other.phoneNumber) &&
               Objects.equals(nationalFormat, other.nationalFormat) &&
               Objects.equals(carrier, other.carrier) &&
               Objects.equals(addOns, other.addOns) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callerName,
                            countryCode,
                            phoneNumber,
                            nationalFormat,
                            carrier,
                            addOns,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("callerName", callerName)
                          .add("countryCode", countryCode)
                          .add("phoneNumber", phoneNumber)
                          .add("nationalFormat", nationalFormat)
                          .add("carrier", carrier)
                          .add("addOns", addOns)
                          .add("url", url)
                          .toString();
    }
}