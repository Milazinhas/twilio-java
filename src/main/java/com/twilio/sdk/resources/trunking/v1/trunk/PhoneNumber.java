package com.twilio.sdk.resources.trunking.v1.trunk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.MarshalConverter;
import com.twilio.sdk.creators.trunking.v1.trunk.PhoneNumberCreator;
import com.twilio.sdk.deleters.trunking.v1.trunk.PhoneNumberDeleter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.trunking.v1.trunk.PhoneNumberFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.numbers.PhoneNumber;
import com.twilio.sdk.readers.trunking.v1.trunk.PhoneNumberReader;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.SidResource;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneNumber extends SidResource {
    private static final long serialVersionUID = 99734519858175L;

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
        
        @JsonCreator
        public static AddressRequirement forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            return AddressRequirement.valueOf(normalized);
        }
    }

    /**
     * fetch
     * 
     * @param trunkSid The trunk_sid
     * @param sid The sid
     * @return PhoneNumberFetcher capable of executing the fetch
     */
    public static PhoneNumberFetcher fetch(final String trunkSid, final String sid) {
        return new PhoneNumberFetcher(trunkSid, sid);
    }

    /**
     * delete
     * 
     * @param trunkSid The trunk_sid
     * @param sid The sid
     * @return PhoneNumberDeleter capable of executing the delete
     */
    public static PhoneNumberDeleter delete(final String trunkSid, final String sid) {
        return new PhoneNumberDeleter(trunkSid, sid);
    }

    /**
     * create
     * 
     * @param trunkSid The trunk_sid
     * @param phoneNumberSid The phone_number_sid
     * @return PhoneNumberCreator capable of executing the create
     */
    public static PhoneNumberCreator create(final String trunkSid, final String phoneNumberSid) {
        return new PhoneNumberCreator(trunkSid, phoneNumberSid);
    }

    /**
     * read
     * 
     * @param trunkSid The trunk_sid
     * @return PhoneNumberReader capable of executing the read
     */
    public static PhoneNumberReader read(final String trunkSid) {
        return new PhoneNumberReader(trunkSid);
    }

    /**
     * Converts a JSON String into a PhoneNumber object using the provided
     * ObjectMapper
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
     * ObjectMapper
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

    private final String accountSid;
    private final PhoneNumber.AddressRequirement addressRequirements;
    private final String apiVersion;
    private final Boolean beta;
    private final Map<String, String> capabilities;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final Map<String, String> links;
    private final PhoneNumber phoneNumber;
    private final String sid;
    private final String smsApplicationSid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String trunkSid;
    private final URI url;
    private final String voiceApplicationSid;
    private final Boolean voiceCallerIdLookup;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceUrl;

    @JsonCreator
    private PhoneNumber(@JsonProperty("account_sid") final String accountSid, 
                        @JsonProperty("address_requirements") final PhoneNumber.AddressRequirement addressRequirements, 
                        @JsonProperty("api_version") final String apiVersion, 
                        @JsonProperty("beta") final Boolean beta, 
                        @JsonProperty("capabilities") final Map<String, String> capabilities, 
                        @JsonProperty("date_created") final String dateCreated, 
                        @JsonProperty("date_updated") final String dateUpdated, 
                        @JsonProperty("friendly_name") final String friendlyName, 
                        @JsonProperty("links") final Map<String, String> links, 
                        @JsonProperty("phone_number") final PhoneNumber phoneNumber, 
                        @JsonProperty("sid") final String sid, 
                        @JsonProperty("sms_application_sid") final String smsApplicationSid, 
                        @JsonProperty("sms_fallback_method") final HttpMethod smsFallbackMethod, 
                        @JsonProperty("sms_fallback_url") final URI smsFallbackUrl, 
                        @JsonProperty("sms_method") final HttpMethod smsMethod, 
                        @JsonProperty("sms_url") final URI smsUrl, 
                        @JsonProperty("status_callback") final URI statusCallback, 
                        @JsonProperty("status_callback_method") final HttpMethod statusCallbackMethod, 
                        @JsonProperty("trunk_sid") final String trunkSid, 
                        @JsonProperty("url") final URI url, 
                        @JsonProperty("voice_application_sid") final String voiceApplicationSid, 
                        @JsonProperty("voice_caller_id_lookup") final Boolean voiceCallerIdLookup, 
                        @JsonProperty("voice_fallback_method") final HttpMethod voiceFallbackMethod, 
                        @JsonProperty("voice_fallback_url") final URI voiceFallbackUrl, 
                        @JsonProperty("voice_method") final HttpMethod voiceMethod, 
                        @JsonProperty("voice_url") final URI voiceUrl) {
        this.accountSid = accountSid;
        this.addressRequirements = addressRequirements;
        this.apiVersion = apiVersion;
        this.beta = beta;
        this.capabilities = capabilities;
        this.dateCreated = MarshalConverter.dateTimeFromString(dateCreated);
        this.dateUpdated = MarshalConverter.dateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.links = links;
        this.phoneNumber = phoneNumber;
        this.sid = sid;
        this.smsApplicationSid = smsApplicationSid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.trunkSid = trunkSid;
        this.url = url;
        this.voiceApplicationSid = voiceApplicationSid;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceUrl = voiceUrl;
    }

    /**
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * @return The address_requirements
     */
    public final PhoneNumber.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    /**
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * @return The beta
     */
    public final Boolean getBeta() {
        return this.beta;
    }

    /**
     * @return The capabilities
     */
    public final Map<String, String> getCapabilities() {
        return this.capabilities;
    }

    /**
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    /**
     * @return The phone_number
     */
    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * @return The sms_application_sid
     */
    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    /**
     * @return The sms_fallback_method
     */
    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    /**
     * @return The sms_fallback_url
     */
    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    /**
     * @return The sms_method
     */
    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    /**
     * @return The sms_url
     */
    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    /**
     * @return The status_callback
     */
    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    /**
     * @return The status_callback_method
     */
    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    /**
     * @return The trunk_sid
     */
    public final String getTrunkSid() {
        return this.trunkSid;
    }

    /**
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * @return The voice_application_sid
     */
    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    /**
     * @return The voice_caller_id_lookup
     */
    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
    }

    /**
     * @return The voice_fallback_method
     */
    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    /**
     * @return The voice_fallback_url
     */
    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    /**
     * @return The voice_method
     */
    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    /**
     * @return The voice_url
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
        
        PhoneNumber other = (PhoneNumber) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(addressRequirements, other.addressRequirements) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(beta, other.beta) && 
               Objects.equals(capabilities, other.capabilities) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(links, other.links) && 
               Objects.equals(phoneNumber, other.phoneNumber) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(smsApplicationSid, other.smsApplicationSid) && 
               Objects.equals(smsFallbackMethod, other.smsFallbackMethod) && 
               Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && 
               Objects.equals(smsMethod, other.smsMethod) && 
               Objects.equals(smsUrl, other.smsUrl) && 
               Objects.equals(statusCallback, other.statusCallback) && 
               Objects.equals(statusCallbackMethod, other.statusCallbackMethod) && 
               Objects.equals(trunkSid, other.trunkSid) && 
               Objects.equals(url, other.url) && 
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
                            addressRequirements,
                            apiVersion,
                            beta,
                            capabilities,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            links,
                            phoneNumber,
                            sid,
                            smsApplicationSid,
                            smsFallbackMethod,
                            smsFallbackUrl,
                            smsMethod,
                            smsUrl,
                            statusCallback,
                            statusCallbackMethod,
                            trunkSid,
                            url,
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
                          .add("addressRequirements", addressRequirements)
                          .add("apiVersion", apiVersion)
                          .add("beta", beta)
                          .add("capabilities", capabilities)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("links", links)
                          .add("phoneNumber", phoneNumber)
                          .add("sid", sid)
                          .add("smsApplicationSid", smsApplicationSid)
                          .add("smsFallbackMethod", smsFallbackMethod)
                          .add("smsFallbackUrl", smsFallbackUrl)
                          .add("smsMethod", smsMethod)
                          .add("smsUrl", smsUrl)
                          .add("statusCallback", statusCallback)
                          .add("statusCallbackMethod", statusCallbackMethod)
                          .add("trunkSid", trunkSid)
                          .add("url", url)
                          .add("voiceApplicationSid", voiceApplicationSid)
                          .add("voiceCallerIdLookup", voiceCallerIdLookup)
                          .add("voiceFallbackMethod", voiceFallbackMethod)
                          .add("voiceFallbackUrl", voiceFallbackUrl)
                          .add("voiceMethod", voiceMethod)
                          .add("voiceUrl", voiceUrl)
                          .toString();
    }
}