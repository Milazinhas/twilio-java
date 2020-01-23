/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1.session;

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
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant extends Resource {
    private static final long serialVersionUID = 38286874885630L;

    public enum ParticipantType {
        CHAT("chat"),
        SMS("sms");

        private final String value;

        private ParticipantType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a ParticipantType from a string.
         * @param value string value
         * @return generated ParticipantType
         */
        @JsonCreator
        public static ParticipantType forValue(final String value) {
            return Promoter.enumFromString(value, ParticipantType.values());
        }
    }

    /**
     * Create a ParticipantCreator to execute create.
     *
     * @param pathSessionSid The SID of the Session for the participant
     * @return ParticipantCreator capable of executing the create
     */
    public static ParticipantCreator creator(final String pathSessionSid) {
        return new ParticipantCreator(pathSessionSid);
    }

    /**
     * Create a ParticipantUpdater to execute update.
     *
     * @param pathSessionSid The SID of the Session with the participant to update
     * @param pathSid The SID that identifies the resource to update
     * @return ParticipantUpdater capable of executing the update
     */
    public static ParticipantUpdater updater(final String pathSessionSid,
                                             final String pathSid) {
        return new ParticipantUpdater(pathSessionSid, pathSid);
    }

    /**
     * Create a ParticipantFetcher to execute fetch.
     *
     * @param pathSessionSid The SID of the Session with the participant to fetch
     * @param pathSid The SID that identifies the resource to fetch
     * @return ParticipantFetcher capable of executing the fetch
     */
    public static ParticipantFetcher fetcher(final String pathSessionSid,
                                             final String pathSid) {
        return new ParticipantFetcher(pathSessionSid, pathSid);
    }

    /**
     * Create a ParticipantReader to execute read.
     *
     * @param pathSessionSid The SID of the Session with the participants to read
     * @return ParticipantReader capable of executing the read
     */
    public static ParticipantReader reader(final String pathSessionSid) {
        return new ParticipantReader(pathSessionSid);
    }

    /**
     * Create a ParticipantDeleter to execute delete.
     *
     * @param pathSessionSid The SID of the Session with the participant to delete
     * @param pathSid The SID that identifies the resource to delete
     * @return ParticipantDeleter capable of executing the delete
     */
    public static ParticipantDeleter deleter(final String pathSessionSid,
                                             final String pathSid) {
        return new ParticipantDeleter(pathSessionSid, pathSid);
    }

    /**
     * Converts a JSON String into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String serviceSid;
    private final String messagingServiceSid;
    private final String sessionSid;
    private final String sid;
    private final String identity;
    private final String twilioAddress;
    private final String userAddress;
    private final String attributes;
    private final Participant.ParticipantType type;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private Participant(@JsonProperty("account_sid")
                        final String accountSid,
                        @JsonProperty("service_sid")
                        final String serviceSid,
                        @JsonProperty("messaging_service_sid")
                        final String messagingServiceSid,
                        @JsonProperty("session_sid")
                        final String sessionSid,
                        @JsonProperty("sid")
                        final String sid,
                        @JsonProperty("identity")
                        final String identity,
                        @JsonProperty("twilio_address")
                        final String twilioAddress,
                        @JsonProperty("user_address")
                        final String userAddress,
                        @JsonProperty("attributes")
                        final String attributes,
                        @JsonProperty("type")
                        final Participant.ParticipantType type,
                        @JsonProperty("date_created")
                        final String dateCreated,
                        @JsonProperty("date_updated")
                        final String dateUpdated,
                        @JsonProperty("url")
                        final URI url) {
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.messagingServiceSid = messagingServiceSid;
        this.sessionSid = sessionSid;
        this.sid = sid;
        this.identity = identity;
        this.twilioAddress = twilioAddress;
        this.userAddress = userAddress;
        this.attributes = attributes;
        this.type = type;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The SID of the Service the session belongs to.
     *
     * @return The SID of the Service the session belongs to
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The SID of the SMS Service the session belongs to.
     *
     * @return The SID of the SMS Service the session belongs to
     */
    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
    }

    /**
     * Returns The SID of the Session for the participant.
     *
     * @return The SID of the Session for the participant
     */
    public final String getSessionSid() {
        return this.sessionSid;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The string that identifies the resource's User.
     *
     * @return The string that identifies the resource's User
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns The address of the Twilio phone number that the participant is in
     * contact with.
     *
     * @return The address of the Twilio phone number that the participant is in
     *         contact with
     */
    public final String getTwilioAddress() {
        return this.twilioAddress;
    }

    /**
     * Returns The address of the participant's device.
     *
     * @return The address of the participant's device
     */
    public final String getUserAddress() {
        return this.userAddress;
    }

    /**
     * Returns The JSON string that stores application-specific data.
     *
     * @return The JSON string that stores application-specific data
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns The type of messaging used by the participant.
     *
     * @return The type of messaging used by the participant
     */
    public final Participant.ParticipantType getType() {
        return this.type;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the participant.
     *
     * @return The absolute URL of the participant
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

        Participant other = (Participant) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(messagingServiceSid, other.messagingServiceSid) &&
               Objects.equals(sessionSid, other.sessionSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(identity, other.identity) &&
               Objects.equals(twilioAddress, other.twilioAddress) &&
               Objects.equals(userAddress, other.userAddress) &&
               Objects.equals(attributes, other.attributes) &&
               Objects.equals(type, other.type) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            serviceSid,
                            messagingServiceSid,
                            sessionSid,
                            sid,
                            identity,
                            twilioAddress,
                            userAddress,
                            attributes,
                            type,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("messagingServiceSid", messagingServiceSid)
                          .add("sessionSid", sessionSid)
                          .add("sid", sid)
                          .add("identity", identity)
                          .add("twilioAddress", twilioAddress)
                          .add("userAddress", userAddress)
                          .add("attributes", attributes)
                          .add("type", type)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}