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

package com.twilio.rest.flexapi.v1.interaction.interactionchannel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class InteractionChannelParticipant extends Resource {
    private static final long serialVersionUID = 108435204885654L;

    public static InteractionChannelParticipantCreator creator(final String interactionSid, final String channelSid, final InteractionChannelParticipant.Type type, final Map<String, Object> mediaProperties){
        return new InteractionChannelParticipantCreator(interactionSid, channelSid, type, mediaProperties);
    }



    public static InteractionChannelParticipantReader reader(final String interactionSid, final String channelSid){
        return new InteractionChannelParticipantReader(interactionSid, channelSid);
    }

    public static InteractionChannelParticipantUpdater updater(final String interactionSid, final String channelSid, final String sid, final InteractionChannelParticipant.Status status){
        return new InteractionChannelParticipantUpdater(interactionSid, channelSid, sid, status);
    }

    /**
    * Converts a JSON String into a InteractionChannelParticipant object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return InteractionChannelParticipant object represented by the provided JSON
    */
    public static InteractionChannelParticipant fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, InteractionChannelParticipant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a InteractionChannelParticipant object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return InteractionChannelParticipant object represented by the provided JSON
    */
    public static InteractionChannelParticipant fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, InteractionChannelParticipant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Status {
        CLOSED("closed"),
        WRAPUP("wrapup");

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
    public enum Type {
        SUPERVISOR("supervisor"),
        CUSTOMER("customer"),
        EXTERNAL("external"),
        AGENT("agent"),
        UNKNOWN("unknown");

        private final String value;

        private Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Type forValue(final String value) {
            return Promoter.enumFromString(value, Type.values());
        }
    }

    private final String sid;
    private final InteractionChannelParticipant.Type type;
    private final String interactionSid;
    private final String channelSid;
    private final URI url;

    @JsonCreator
    private InteractionChannelParticipant(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("type")
        final InteractionChannelParticipant.Type type,

        @JsonProperty("interaction_sid")
        final String interactionSid,

        @JsonProperty("channel_sid")
        final String channelSid,

        @JsonProperty("url")
        final URI url
    ) {
        this.sid = sid;
        this.type = type;
        this.interactionSid = interactionSid;
        this.channelSid = channelSid;
        this.url = url;
    }

        public final String getSid() {
            return this.sid;
        }
        public final InteractionChannelParticipant.Type getType() {
            return this.type;
        }
        public final String getInteractionSid() {
            return this.interactionSid;
        }
        public final String getChannelSid() {
            return this.channelSid;
        }
        public final URI getUrl() {
            return this.url;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InteractionChannelParticipant other = (InteractionChannelParticipant) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(type, other.type) &&  Objects.equals(interactionSid, other.interactionSid) &&  Objects.equals(channelSid, other.channelSid) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, type, interactionSid, channelSid, url);
    }

}
