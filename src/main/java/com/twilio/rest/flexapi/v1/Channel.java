/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Flex
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.flexapi.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Channel extends Resource {

    private static final long serialVersionUID = 86822994047371L;

    public static ChannelCreator creator(
        final String flexFlowSid,
        final String identity,
        final String chatUserFriendlyName,
        final String chatFriendlyName
    ) {
        return new ChannelCreator(
            flexFlowSid,
            identity,
            chatUserFriendlyName,
            chatFriendlyName
        );
    }

    public static ChannelDeleter deleter(final String pathSid) {
        return new ChannelDeleter(pathSid);
    }

    public static ChannelFetcher fetcher(final String pathSid) {
        return new ChannelFetcher(pathSid);
    }

    public static ChannelReader reader() {
        return new ChannelReader();
    }

    /**
     * Converts a JSON String into a Channel object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Channel object represented by the provided JSON
     */
    public static Channel fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Channel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Channel object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Channel object represented by the provided JSON
     */
    public static Channel fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Channel.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String flexFlowSid;
    private final String sid;
    private final String userSid;
    private final String taskSid;
    private final URI url;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;

    @JsonCreator
    private Channel(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("flex_flow_sid") final String flexFlowSid,
        @JsonProperty("sid") final String sid,
        @JsonProperty("user_sid") final String userSid,
        @JsonProperty("task_sid") final String taskSid,
        @JsonProperty("url") final URI url,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated
    ) {
        this.accountSid = accountSid;
        this.flexFlowSid = flexFlowSid;
        this.sid = sid;
        this.userSid = userSid;
        this.taskSid = taskSid;
        this.url = url;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getFlexFlowSid() {
        return this.flexFlowSid;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getUserSid() {
        return this.userSid;
    }

    public final String getTaskSid() {
        return this.taskSid;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Channel other = (Channel) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(flexFlowSid, other.flexFlowSid) &&
            Objects.equals(sid, other.sid) &&
            Objects.equals(userSid, other.userSid) &&
            Objects.equals(taskSid, other.taskSid) &&
            Objects.equals(url, other.url) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            flexFlowSid,
            sid,
            userSid,
            taskSid,
            url,
            dateCreated,
            dateUpdated
        );
    }
}
