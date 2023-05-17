/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

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
public class Reservation extends Resource {
    private static final long serialVersionUID = 88353198782173L;

    public static ReservationFetcher fetcher(final String pathWorkspaceSid, final String pathWorkerSid, final String pathSid){
        return new ReservationFetcher(pathWorkspaceSid, pathWorkerSid, pathSid);
    }

    public static ReservationReader reader(final String pathWorkspaceSid, final String pathWorkerSid){
        return new ReservationReader(pathWorkspaceSid, pathWorkerSid);
    }

    public static ReservationUpdater updater(final String pathWorkspaceSid, final String pathWorkerSid, final String pathSid){
        return new ReservationUpdater(pathWorkspaceSid, pathWorkerSid, pathSid);
    }

    /**
    * Converts a JSON String into a Reservation object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Reservation object represented by the provided JSON
    */
    public static Reservation fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Reservation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Reservation object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Reservation object represented by the provided JSON
    */
    public static Reservation fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Reservation.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum CallStatus {
        INITIATED("initiated"),
        RINGING("ringing"),
        ANSWERED("answered"),
        COMPLETED("completed");

        private final String value;

        private CallStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static CallStatus forValue(final String value) {
            return Promoter.enumFromString(value, CallStatus.values());
        }
    }
    public enum ConferenceEvent {
        START("start"),
        END("end"),
        JOIN("join"),
        LEAVE("leave"),
        MUTE("mute"),
        HOLD("hold"),
        SPEAKER("speaker");

        private final String value;

        private ConferenceEvent(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static ConferenceEvent forValue(final String value) {
            return Promoter.enumFromString(value, ConferenceEvent.values());
        }
    }
    public enum Status {
        PENDING("pending"),
        ACCEPTED("accepted"),
        REJECTED("rejected"),
        TIMEOUT("timeout"),
        CANCELED("canceled"),
        RESCINDED("rescinded"),
        WRAPPING("wrapping"),
        COMPLETED("completed");

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

    private final String accountSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Reservation.Status reservationStatus;
    private final String sid;
    private final String taskSid;
    private final String workerName;
    private final String workerSid;
    private final String workspaceSid;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Reservation(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("reservation_status")
        final Reservation.Status reservationStatus,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("task_sid")
        final String taskSid,

        @JsonProperty("worker_name")
        final String workerName,

        @JsonProperty("worker_sid")
        final String workerSid,

        @JsonProperty("workspace_sid")
        final String workspaceSid,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("links")
        final Map<String, String> links
    ) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.reservationStatus = reservationStatus;
        this.sid = sid;
        this.taskSid = taskSid;
        this.workerName = workerName;
        this.workerSid = workerSid;
        this.workspaceSid = workspaceSid;
        this.url = url;
        this.links = links;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final Reservation.Status getReservationStatus() {
            return this.reservationStatus;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getTaskSid() {
            return this.taskSid;
        }
        public final String getWorkerName() {
            return this.workerName;
        }
        public final String getWorkerSid() {
            return this.workerSid;
        }
        public final String getWorkspaceSid() {
            return this.workspaceSid;
        }
        public final URI getUrl() {
            return this.url;
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

        Reservation other = (Reservation) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(reservationStatus, other.reservationStatus) &&  Objects.equals(sid, other.sid) &&  Objects.equals(taskSid, other.taskSid) &&  Objects.equals(workerName, other.workerName) &&  Objects.equals(workerSid, other.workerSid) &&  Objects.equals(workspaceSid, other.workspaceSid) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, dateCreated, dateUpdated, reservationStatus, sid, taskSid, workerName, workerSid, workspaceSid, url, links);
    }

}

