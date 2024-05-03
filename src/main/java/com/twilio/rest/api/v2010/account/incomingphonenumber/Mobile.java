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

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.http.HttpMethod;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Mobile extends Resource {

    private static final long serialVersionUID = 101001992016981L;

    @ToString
    public static class ApiV2010AccountIncomingPhoneNumberCapabilities {

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("mms")
        @Getter
        @Setter
        private Boolean mms;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("sms")
        @Getter
        @Setter
        private Boolean sms;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("voice")
        @Getter
        @Setter
        private Boolean voice;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("fax")
        @Getter
        @Setter
        private Boolean fax;

        public static ApiV2010AccountIncomingPhoneNumberCapabilities fromJson(
            String jsonString,
            ObjectMapper mapper
        ) throws IOException {
            return mapper.readValue(
                jsonString,
                ApiV2010AccountIncomingPhoneNumberCapabilities.class
            );
        }
    }

    public static MobileCreator creator(
        final com.twilio.type.PhoneNumber phoneNumber
    ) {
        return new MobileCreator(phoneNumber);
    }

    public static MobileCreator creator(
        final String pathAccountSid,
        final com.twilio.type.PhoneNumber phoneNumber
    ) {
        return new MobileCreator(pathAccountSid, phoneNumber);
    }

    public static MobileReader reader() {
        return new MobileReader();
    }

    public static MobileReader reader(final String pathAccountSid) {
        return new MobileReader(pathAccountSid);
    }

    /**
     * Converts a JSON String into a Mobile object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Mobile object represented by the provided JSON
     */
    public static Mobile fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Mobile.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Mobile object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Mobile object represented by the provided JSON
     */
    public static Mobile fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Mobile.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String addressSid;
    private final Mobile.AddressRequirement addressRequirements;
    private final String apiVersion;
    private final Boolean beta;
    private final ApiV2010AccountIncomingPhoneNumberCapabilities capabilities;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
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
    private final Mobile.VoiceReceiveMode voiceReceiveMode;
    private final String voiceApplicationSid;
    private final Boolean voiceCallerIdLookup;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceUrl;
    private final Mobile.EmergencyStatus emergencyStatus;
    private final String emergencyAddressSid;
    private final Mobile.EmergencyAddressStatus emergencyAddressStatus;
    private final String bundleSid;
    private final String status;

    @JsonCreator
    private Mobile(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("address_sid") final String addressSid,
        @JsonProperty(
            "address_requirements"
        ) final Mobile.AddressRequirement addressRequirements,
        @JsonProperty("api_version") final String apiVersion,
        @JsonProperty("beta") final Boolean beta,
        @JsonProperty(
            "capabilities"
        ) final ApiV2010AccountIncomingPhoneNumberCapabilities capabilities,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("friendly_name") final String friendlyName,
        @JsonProperty("identity_sid") final String identitySid,
        @JsonProperty(
            "phone_number"
        ) final com.twilio.type.PhoneNumber phoneNumber,
        @JsonProperty("origin") final String origin,
        @JsonProperty("sid") final String sid,
        @JsonProperty("sms_application_sid") final String smsApplicationSid,
        @JsonProperty("sms_fallback_method") final HttpMethod smsFallbackMethod,
        @JsonProperty("sms_fallback_url") final URI smsFallbackUrl,
        @JsonProperty("sms_method") final HttpMethod smsMethod,
        @JsonProperty("sms_url") final URI smsUrl,
        @JsonProperty("status_callback") final URI statusCallback,
        @JsonProperty(
            "status_callback_method"
        ) final HttpMethod statusCallbackMethod,
        @JsonProperty("trunk_sid") final String trunkSid,
        @JsonProperty("uri") final String uri,
        @JsonProperty(
            "voice_receive_mode"
        ) final Mobile.VoiceReceiveMode voiceReceiveMode,
        @JsonProperty("voice_application_sid") final String voiceApplicationSid,
        @JsonProperty(
            "voice_caller_id_lookup"
        ) final Boolean voiceCallerIdLookup,
        @JsonProperty(
            "voice_fallback_method"
        ) final HttpMethod voiceFallbackMethod,
        @JsonProperty("voice_fallback_url") final URI voiceFallbackUrl,
        @JsonProperty("voice_method") final HttpMethod voiceMethod,
        @JsonProperty("voice_url") final URI voiceUrl,
        @JsonProperty(
            "emergency_status"
        ) final Mobile.EmergencyStatus emergencyStatus,
        @JsonProperty("emergency_address_sid") final String emergencyAddressSid,
        @JsonProperty(
            "emergency_address_status"
        ) final Mobile.EmergencyAddressStatus emergencyAddressStatus,
        @JsonProperty("bundle_sid") final String bundleSid,
        @JsonProperty("status") final String status
    ) {
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
        this.voiceReceiveMode = voiceReceiveMode;
        this.voiceApplicationSid = voiceApplicationSid;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceUrl = voiceUrl;
        this.emergencyStatus = emergencyStatus;
        this.emergencyAddressSid = emergencyAddressSid;
        this.emergencyAddressStatus = emergencyAddressStatus;
        this.bundleSid = bundleSid;
        this.status = status;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getAddressSid() {
        return this.addressSid;
    }

    public final Mobile.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final Boolean getBeta() {
        return this.beta;
    }

    public final ApiV2010AccountIncomingPhoneNumberCapabilities getCapabilities() {
        return this.capabilities;
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

    public final String getIdentitySid() {
        return this.identitySid;
    }

    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    public final String getTrunkSid() {
        return this.trunkSid;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Mobile.VoiceReceiveMode getVoiceReceiveMode() {
        return this.voiceReceiveMode;
    }

    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
    }

    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    public final Mobile.EmergencyStatus getEmergencyStatus() {
        return this.emergencyStatus;
    }

    public final String getEmergencyAddressSid() {
        return this.emergencyAddressSid;
    }

    public final Mobile.EmergencyAddressStatus getEmergencyAddressStatus() {
        return this.emergencyAddressStatus;
    }

    public final String getBundleSid() {
        return this.bundleSid;
    }

    public final String getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Mobile other = (Mobile) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
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
            Objects.equals(voiceReceiveMode, other.voiceReceiveMode) &&
            Objects.equals(voiceApplicationSid, other.voiceApplicationSid) &&
            Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup) &&
            Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod) &&
            Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl) &&
            Objects.equals(voiceMethod, other.voiceMethod) &&
            Objects.equals(voiceUrl, other.voiceUrl) &&
            Objects.equals(emergencyStatus, other.emergencyStatus) &&
            Objects.equals(emergencyAddressSid, other.emergencyAddressSid) &&
            Objects.equals(
                emergencyAddressStatus,
                other.emergencyAddressStatus
            ) &&
            Objects.equals(bundleSid, other.bundleSid) &&
            Objects.equals(status, other.status)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
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
            voiceReceiveMode,
            voiceApplicationSid,
            voiceCallerIdLookup,
            voiceFallbackMethod,
            voiceFallbackUrl,
            voiceMethod,
            voiceUrl,
            emergencyStatus,
            emergencyAddressSid,
            emergencyAddressStatus,
            bundleSid,
            status
        );
    }

    public enum EmergencyAddressStatus {
        REGISTERED("registered"),
        UNREGISTERED("unregistered"),
        PENDING_REGISTRATION("pending-registration"),
        REGISTRATION_FAILURE("registration-failure"),
        PENDING_UNREGISTRATION("pending-unregistration"),
        UNREGISTRATION_FAILURE("unregistration-failure");

        private final String value;

        private EmergencyAddressStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static EmergencyAddressStatus forValue(final String value) {
            return Promoter.enumFromString(
                value,
                EmergencyAddressStatus.values()
            );
        }
    }

    public enum VoiceReceiveMode {
        VOICE("voice"),
        FAX("fax");

        private final String value;

        private VoiceReceiveMode(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static VoiceReceiveMode forValue(final String value) {
            return Promoter.enumFromString(value, VoiceReceiveMode.values());
        }
    }

    public enum EmergencyStatus {
        ACTIVE("Active"),
        INACTIVE("Inactive");

        private final String value;

        private EmergencyStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static EmergencyStatus forValue(final String value) {
            return Promoter.enumFromString(value, EmergencyStatus.values());
        }
    }

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
            return Promoter.enumFromString(value, AddressRequirement.values());
        }
    }
}
