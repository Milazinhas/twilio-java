/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.PhoneNumberCapabilities;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TollFree extends Resource {
    private static final long serialVersionUID = 181300083665916L;

    public enum AddressRequirement {
        NONE("none"),
        ANY("any"),
        LOCAL("local"),
        FOREIGN("foreign");

        private final String value;

        private AddressRequirement(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a AddressRequirement from a string.
         * @param value string value
         * @return generated AddressRequirement
         */
        @JsonCreator
        public static AddressRequirement forValue(final String value) {
            return Promoter.enumFromString(value, AddressRequirement.values());
        }
    }

    /**
     * Create a TollFreeReader to execute read.
     * 
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @return TollFreeReader capable of executing the read
     */
    public static TollFreeReader reader(final String pathAccountSid) {
        return new TollFreeReader(pathAccountSid);
    }

    /**
     * Create a TollFreeReader to execute read.
     * 
     * @return TollFreeReader capable of executing the read
     */
    public static TollFreeReader reader() {
        return new TollFreeReader();
    }

    /**
     * Create a TollFreeCreator to execute create.
     * 
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param phoneNumber The phone number to purchase in E.164 format
     * @return TollFreeCreator capable of executing the create
     */
    public static TollFreeCreator creator(final String pathAccountSid, 
                                          final com.twilio.type.PhoneNumber phoneNumber) {
        return new TollFreeCreator(pathAccountSid, phoneNumber);
    }

    /**
     * Create a TollFreeCreator to execute create.
     * 
     * @param phoneNumber The phone number to purchase in E.164 format
     * @return TollFreeCreator capable of executing the create
     */
    public static TollFreeCreator creator(final com.twilio.type.PhoneNumber phoneNumber) {
        return new TollFreeCreator(phoneNumber);
    }

    /**
     * Converts a JSON String into a TollFree object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TollFree object represented by the provided JSON
     */
    public static TollFree fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TollFree.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TollFree object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TollFree object represented by the provided JSON
     */
    public static TollFree fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TollFree.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String addressSid;
    private final TollFree.AddressRequirement addressRequirements;
    private final String apiVersion;
    private final Boolean beta;
    private final PhoneNumberCapabilities capabilities;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String identitySid;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final String origin;
    private final String sid;
    private final String smsApplicationSid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String trunkSid;
    private final String uri;
    private final String voiceApplicationSid;
    private final Boolean voiceCallerIdLookup;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceUrl;

    @JsonCreator
    private TollFree(@JsonProperty("account_sid")
                     final String accountSid, 
                     @JsonProperty("address_sid")
                     final String addressSid, 
                     @JsonProperty("address_requirements")
                     final TollFree.AddressRequirement addressRequirements, 
                     @JsonProperty("api_version")
                     final String apiVersion, 
                     @JsonProperty("beta")
                     final Boolean beta, 
                     @JsonProperty("capabilities")
                     final PhoneNumberCapabilities capabilities, 
                     @JsonProperty("date_created")
                     final String dateCreated, 
                     @JsonProperty("date_updated")
                     final String dateUpdated, 
                     @JsonProperty("friendly_name")
                     final String friendlyName, 
                     @JsonProperty("identity_sid")
                     final String identitySid, 
                     @JsonProperty("phone_number")
                     final com.twilio.type.PhoneNumber phoneNumber, 
                     @JsonProperty("origin")
                     final String origin, 
                     @JsonProperty("sid")
                     final String sid, 
                     @JsonProperty("sms_application_sid")
                     final String smsApplicationSid, 
                     @JsonProperty("sms_fallback_method")
                     final HttpMethod smsFallbackMethod, 
                     @JsonProperty("sms_fallback_url")
                     final URI smsFallbackUrl, 
                     @JsonProperty("sms_method")
                     final HttpMethod smsMethod, 
                     @JsonProperty("sms_url")
                     final URI smsUrl, 
                     @JsonProperty("status_callback")
                     final URI statusCallback, 
                     @JsonProperty("status_callback_method")
                     final HttpMethod statusCallbackMethod, 
                     @JsonProperty("trunk_sid")
                     final String trunkSid, 
                     @JsonProperty("uri")
                     final String uri, 
                     @JsonProperty("voice_application_sid")
                     final String voiceApplicationSid, 
                     @JsonProperty("voice_caller_id_lookup")
                     final Boolean voiceCallerIdLookup, 
                     @JsonProperty("voice_fallback_method")
                     final HttpMethod voiceFallbackMethod, 
                     @JsonProperty("voice_fallback_url")
                     final URI voiceFallbackUrl, 
                     @JsonProperty("voice_method")
                     final HttpMethod voiceMethod, 
                     @JsonProperty("voice_url")
                     final URI voiceUrl) {
        this.accountSid = accountSid;
        this.addressSid = addressSid;
        this.addressRequirements = addressRequirements;
        this.apiVersion = apiVersion;
        this.beta = beta;
        this.capabilities = capabilities;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.identitySid = identitySid;
        this.phoneNumber = phoneNumber;
        this.origin = origin;
        this.sid = sid;
        this.smsApplicationSid = smsApplicationSid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.trunkSid = trunkSid;
        this.uri = uri;
        this.voiceApplicationSid = voiceApplicationSid;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceUrl = voiceUrl;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     * 
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The SID of the Address resource associated with the phone number.
     * 
     * @return The SID of the Address resource associated with the phone number
     */
    public final String getAddressSid() {
        return this.addressSid;
    }

    /**
     * Returns The Whether the phone number requires an Address registered with
     * Twilio..
     * 
     * @return Whether the phone number requires an Address registered with Twilio.
     */
    public final TollFree.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    /**
     * Returns The The API version used to start a new TwiML session.
     * 
     * @return The API version used to start a new TwiML session
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The Whether the phone number is new to the Twilio platform.
     * 
     * @return Whether the phone number is new to the Twilio platform
     */
    public final Boolean getBeta() {
        return this.beta;
    }

    /**
     * Returns The Indicate if a phone can receive calls or messages.
     * 
     * @return Indicate if a phone can receive calls or messages
     */
    public final PhoneNumberCapabilities getCapabilities() {
        return this.capabilities;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was created.
     * 
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was last
     * updated.
     * 
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The string that you assigned to describe the resource.
     * 
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The SID of the Identity resource associated with number.
     * 
     * @return The SID of the Identity resource associated with number
     */
    public final String getIdentitySid() {
        return this.identitySid;
    }

    /**
     * Returns The The phone number in E.164 format.
     * 
     * @return The phone number in E.164 format
     */
    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns The The phone number's origin. Can be twilio or hosted..
     * 
     * @return The phone number's origin. Can be twilio or hosted.
     */
    public final String getOrigin() {
        return this.origin;
    }

    /**
     * Returns The The unique string that identifies the resource.
     * 
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The SID of the application that handles SMS messages sent to the
     * phone number.
     * 
     * @return The SID of the application that handles SMS messages sent to the
     *         phone number
     */
    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    /**
     * Returns The The HTTP method used with sms_fallback_url.
     * 
     * @return The HTTP method used with sms_fallback_url
     */
    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    /**
     * Returns The The URL that we call when an error occurs while retrieving or
     * executing the TwiML.
     * 
     * @return The URL that we call when an error occurs while retrieving or
     *         executing the TwiML
     */
    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    /**
     * Returns The The HTTP method to use with sms_url.
     * 
     * @return The HTTP method to use with sms_url
     */
    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    /**
     * Returns The The URL we call when the phone number receives an incoming SMS
     * message.
     * 
     * @return The URL we call when the phone number receives an incoming SMS
     *         message
     */
    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    /**
     * Returns The The URL to send status information to your application.
     * 
     * @return The URL to send status information to your application
     */
    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    /**
     * Returns The The HTTP method we use to call status_callback.
     * 
     * @return The HTTP method we use to call status_callback
     */
    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    /**
     * Returns The The SID of the Trunk that handles calls to the phone number.
     * 
     * @return The SID of the Trunk that handles calls to the phone number
     */
    public final String getTrunkSid() {
        return this.trunkSid;
    }

    /**
     * Returns The The URI of the resource, relative to `https://api.twilio.com`.
     * 
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The SID of the application that handles calls to the phone
     * number.
     * 
     * @return The SID of the application that handles calls to the phone number
     */
    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    /**
     * Returns The Whether to lookup the caller's name.
     * 
     * @return Whether to lookup the caller's name
     */
    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
    }

    /**
     * Returns The The HTTP method used with voice_fallback_url.
     * 
     * @return The HTTP method used with voice_fallback_url
     */
    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    /**
     * Returns The The URL we call when an error occurs in TwiML.
     * 
     * @return The URL we call when an error occurs in TwiML
     */
    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    /**
     * Returns The The HTTP method used with the voice_url.
     * 
     * @return The HTTP method used with the voice_url
     */
    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    /**
     * Returns The The URL we call when the phone number receives a call.
     * 
     * @return The URL we call when the phone number receives a call
     */
    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TollFree other = (TollFree) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(addressSid, other.addressSid) && 
               Objects.equals(addressRequirements, other.addressRequirements) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(beta, other.beta) && 
               Objects.equals(capabilities, other.capabilities) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(identitySid, other.identitySid) && 
               Objects.equals(phoneNumber, other.phoneNumber) && 
               Objects.equals(origin, other.origin) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(smsApplicationSid, other.smsApplicationSid) && 
               Objects.equals(smsFallbackMethod, other.smsFallbackMethod) && 
               Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && 
               Objects.equals(smsMethod, other.smsMethod) && 
               Objects.equals(smsUrl, other.smsUrl) && 
               Objects.equals(statusCallback, other.statusCallback) && 
               Objects.equals(statusCallbackMethod, other.statusCallbackMethod) && 
               Objects.equals(trunkSid, other.trunkSid) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(voiceApplicationSid, other.voiceApplicationSid) && 
               Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup) && 
               Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod) && 
               Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl) && 
               Objects.equals(voiceMethod, other.voiceMethod) && 
               Objects.equals(voiceUrl, other.voiceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            addressSid,
                            addressRequirements,
                            apiVersion,
                            beta,
                            capabilities,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            identitySid,
                            phoneNumber,
                            origin,
                            sid,
                            smsApplicationSid,
                            smsFallbackMethod,
                            smsFallbackUrl,
                            smsMethod,
                            smsUrl,
                            statusCallback,
                            statusCallbackMethod,
                            trunkSid,
                            uri,
                            voiceApplicationSid,
                            voiceCallerIdLookup,
                            voiceFallbackMethod,
                            voiceFallbackUrl,
                            voiceMethod,
                            voiceUrl);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("addressSid", addressSid)
                          .add("addressRequirements", addressRequirements)
                          .add("apiVersion", apiVersion)
                          .add("beta", beta)
                          .add("capabilities", capabilities)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("identitySid", identitySid)
                          .add("phoneNumber", phoneNumber)
                          .add("origin", origin)
                          .add("sid", sid)
                          .add("smsApplicationSid", smsApplicationSid)
                          .add("smsFallbackMethod", smsFallbackMethod)
                          .add("smsFallbackUrl", smsFallbackUrl)
                          .add("smsMethod", smsMethod)
                          .add("smsUrl", smsUrl)
                          .add("statusCallback", statusCallback)
                          .add("statusCallbackMethod", statusCallbackMethod)
                          .add("trunkSid", trunkSid)
                          .add("uri", uri)
                          .add("voiceApplicationSid", voiceApplicationSid)
                          .add("voiceCallerIdLookup", voiceCallerIdLookup)
                          .add("voiceFallbackMethod", voiceFallbackMethod)
                          .add("voiceFallbackUrl", voiceFallbackUrl)
                          .add("voiceMethod", voiceMethod)
                          .add("voiceUrl", voiceUrl)
                          .toString();
    }
}