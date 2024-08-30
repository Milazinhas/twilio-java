/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.studio.v2.flow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Execution extends Resource {

    private static final long serialVersionUID = 276284150060496L;

    public static ExecutionCreator creator(
        final String pathFlowSid,
        final com.twilio.type.PhoneNumber to,
        final com.twilio.type.PhoneNumber from
    ) {
        return new ExecutionCreator(pathFlowSid, to, from);
    }

    public static ExecutionDeleter deleter(
        final String pathFlowSid,
        final String pathSid
    ) {
        return new ExecutionDeleter(pathFlowSid, pathSid);
    }

    public static ExecutionFetcher fetcher(
        final String pathFlowSid,
        final String pathSid
    ) {
        return new ExecutionFetcher(pathFlowSid, pathSid);
    }

    public static ExecutionReader reader(final String pathFlowSid) {
        return new ExecutionReader(pathFlowSid);
    }

    public static ExecutionUpdater updater(
        final String pathFlowSid,
        final String pathSid,
        final Execution.Status status
    ) {
        return new ExecutionUpdater(pathFlowSid, pathSid, status);
    }

    /**
     * Converts a JSON String into a Execution object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Execution object represented by the provided JSON
     */
    public static Execution fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Execution.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Execution object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Execution object represented by the provided JSON
     */
    public static Execution fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Execution.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String flowSid;
    private final String contactChannelAddress;
    private final Map<String, Object> context;
    private final Execution.Status status;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Execution(
        @JsonProperty("sid") final String sid,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("flow_sid") final String flowSid,
        @JsonProperty(
            "contact_channel_address"
        ) final String contactChannelAddress,
        @JsonProperty("context") final Map<String, Object> context,
        @JsonProperty("status") final Execution.Status status,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("url") final URI url,
        @JsonProperty("links") final Map<String, String> links
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.flowSid = flowSid;
        this.contactChannelAddress = contactChannelAddress;
        this.context = context;
        this.status = status;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFlowSid() {
        return this.flowSid;
    }

    public final String getContactChannelAddress() {
        return this.contactChannelAddress;
    }

    public final Map<String, Object> getContext() {
        return this.context;
    }

    public final Execution.Status getStatus() {
        return this.status;
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

    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Execution other = (Execution) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(flowSid, other.flowSid) &&
            Objects.equals(
                contactChannelAddress,
                other.contactChannelAddress
            ) &&
            Objects.equals(context, other.context) &&
            Objects.equals(status, other.status) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(url, other.url) &&
            Objects.equals(links, other.links)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            accountSid,
            flowSid,
            contactChannelAddress,
            context,
            status,
            dateCreated,
            dateUpdated,
            url,
            links
        );
    }

    public enum Status {
        ACTIVE("active"),
        ENDED("ended");

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
