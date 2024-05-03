/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Numbers
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.numbers.v2.authorizationdocument;

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
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class DependentHostedNumberOrder extends Resource {

    private static final long serialVersionUID = 201492867090828L;

    @ToString
    public static class NumbersV2AuthorizationDocumentDependentHostedNumberOrderCapabilities {

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

        public static NumbersV2AuthorizationDocumentDependentHostedNumberOrderCapabilities fromJson(
            String jsonString,
            ObjectMapper mapper
        ) throws IOException {
            return mapper.readValue(
                jsonString,
                NumbersV2AuthorizationDocumentDependentHostedNumberOrderCapabilities.class
            );
        }
    }

    public static DependentHostedNumberOrderReader reader(
        final String pathSigningDocumentSid
    ) {
        return new DependentHostedNumberOrderReader(pathSigningDocumentSid);
    }

    /**
     * Converts a JSON String into a DependentHostedNumberOrder object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return DependentHostedNumberOrder object represented by the provided JSON
     */
    public static DependentHostedNumberOrder fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(
                json,
                DependentHostedNumberOrder.class
            );
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a DependentHostedNumberOrder object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return DependentHostedNumberOrder object represented by the provided JSON
     */
    public static DependentHostedNumberOrder fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(
                json,
                DependentHostedNumberOrder.class
            );
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String bulkHostingRequestSid;
    private final String nextStep;
    private final String accountSid;
    private final String incomingPhoneNumberSid;
    private final String addressSid;
    private final String signingDocumentSid;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final NumbersV2AuthorizationDocumentDependentHostedNumberOrderCapabilities capabilities;
    private final String friendlyName;
    private final DependentHostedNumberOrder.Status status;
    private final String failureReason;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String email;
    private final List<String> ccEmails;
    private final String contactTitle;
    private final com.twilio.type.PhoneNumber contactPhoneNumber;

    @JsonCreator
    private DependentHostedNumberOrder(
        @JsonProperty("sid") final String sid,
        @JsonProperty(
            "bulk_hosting_request_sid"
        ) final String bulkHostingRequestSid,
        @JsonProperty("next_step") final String nextStep,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty(
            "incoming_phone_number_sid"
        ) final String incomingPhoneNumberSid,
        @JsonProperty("address_sid") final String addressSid,
        @JsonProperty("signing_document_sid") final String signingDocumentSid,
        @JsonProperty(
            "phone_number"
        ) final com.twilio.type.PhoneNumber phoneNumber,
        @JsonProperty(
            "capabilities"
        ) final NumbersV2AuthorizationDocumentDependentHostedNumberOrderCapabilities capabilities,
        @JsonProperty("friendly_name") final String friendlyName,
        @JsonProperty("status") final DependentHostedNumberOrder.Status status,
        @JsonProperty("failure_reason") final String failureReason,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("email") final String email,
        @JsonProperty("cc_emails") final List<String> ccEmails,
        @JsonProperty("contact_title") final String contactTitle,
        @JsonProperty(
            "contact_phone_number"
        ) final com.twilio.type.PhoneNumber contactPhoneNumber
    ) {
        this.sid = sid;
        this.bulkHostingRequestSid = bulkHostingRequestSid;
        this.nextStep = nextStep;
        this.accountSid = accountSid;
        this.incomingPhoneNumberSid = incomingPhoneNumberSid;
        this.addressSid = addressSid;
        this.signingDocumentSid = signingDocumentSid;
        this.phoneNumber = phoneNumber;
        this.capabilities = capabilities;
        this.friendlyName = friendlyName;
        this.status = status;
        this.failureReason = failureReason;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.email = email;
        this.ccEmails = ccEmails;
        this.contactTitle = contactTitle;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getBulkHostingRequestSid() {
        return this.bulkHostingRequestSid;
    }

    public final String getNextStep() {
        return this.nextStep;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getIncomingPhoneNumberSid() {
        return this.incomingPhoneNumberSid;
    }

    public final String getAddressSid() {
        return this.addressSid;
    }

    public final String getSigningDocumentSid() {
        return this.signingDocumentSid;
    }

    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final NumbersV2AuthorizationDocumentDependentHostedNumberOrderCapabilities getCapabilities() {
        return this.capabilities;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final DependentHostedNumberOrder.Status getStatus() {
        return this.status;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<String> getCcEmails() {
        return this.ccEmails;
    }

    public final String getContactTitle() {
        return this.contactTitle;
    }

    public final com.twilio.type.PhoneNumber getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DependentHostedNumberOrder other = (DependentHostedNumberOrder) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(
                bulkHostingRequestSid,
                other.bulkHostingRequestSid
            ) &&
            Objects.equals(nextStep, other.nextStep) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(
                incomingPhoneNumberSid,
                other.incomingPhoneNumberSid
            ) &&
            Objects.equals(addressSid, other.addressSid) &&
            Objects.equals(signingDocumentSid, other.signingDocumentSid) &&
            Objects.equals(phoneNumber, other.phoneNumber) &&
            Objects.equals(capabilities, other.capabilities) &&
            Objects.equals(friendlyName, other.friendlyName) &&
            Objects.equals(status, other.status) &&
            Objects.equals(failureReason, other.failureReason) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(email, other.email) &&
            Objects.equals(ccEmails, other.ccEmails) &&
            Objects.equals(contactTitle, other.contactTitle) &&
            Objects.equals(contactPhoneNumber, other.contactPhoneNumber)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            bulkHostingRequestSid,
            nextStep,
            accountSid,
            incomingPhoneNumberSid,
            addressSid,
            signingDocumentSid,
            phoneNumber,
            capabilities,
            friendlyName,
            status,
            failureReason,
            dateCreated,
            dateUpdated,
            email,
            ccEmails,
            contactTitle,
            contactPhoneNumber
        );
    }

    public enum Status {
        RECEIVED("received"),
        VERIFIED("verified"),
        PENDING_LOA("pending-loa"),
        CARRIER_PROCESSING("carrier-processing"),
        COMPLETED("completed"),
        FAILED("failed"),
        ACTION_REQUIRED("action-required");

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
}
