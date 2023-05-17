/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service.conversation;

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
public class Message extends Resource {
    private static final long serialVersionUID = 273348594526439L;

    public static MessageCreator creator(final String pathChatServiceSid, final String pathConversationSid){
        return new MessageCreator(pathChatServiceSid, pathConversationSid);
    }

    public static MessageDeleter deleter(final String pathChatServiceSid, final String pathConversationSid, final String pathSid){
        return new MessageDeleter(pathChatServiceSid, pathConversationSid, pathSid);
    }

    public static MessageFetcher fetcher(final String pathChatServiceSid, final String pathConversationSid, final String pathSid){
        return new MessageFetcher(pathChatServiceSid, pathConversationSid, pathSid);
    }

    public static MessageReader reader(final String pathChatServiceSid, final String pathConversationSid){
        return new MessageReader(pathChatServiceSid, pathConversationSid);
    }

    public static MessageUpdater updater(final String pathChatServiceSid, final String pathConversationSid, final String pathSid){
        return new MessageUpdater(pathChatServiceSid, pathConversationSid, pathSid);
    }

    /**
    * Converts a JSON String into a Message object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Message object represented by the provided JSON
    */
    public static Message fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Message.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Message object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Message object represented by the provided JSON
    */
    public static Message fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Message.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum OrderType {
        ASC("asc"),
        DESC("desc");

        private final String value;

        private OrderType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static OrderType forValue(final String value) {
            return Promoter.enumFromString(value, OrderType.values());
        }
    }
    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    private final String accountSid;
    private final String chatServiceSid;
    private final String conversationSid;
    private final String sid;
    private final Integer index;
    private final String author;
    private final String body;
    private final List<Map<String, Object>> media;
    private final String attributes;
    private final String participantSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Map<String, Object> delivery;
    private final URI url;
    private final Map<String, String> links;
    private final String contentSid;

    @JsonCreator
    private Message(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("chat_service_sid")
        final String chatServiceSid,

        @JsonProperty("conversation_sid")
        final String conversationSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("index")
        final Integer index,

        @JsonProperty("author")
        final String author,

        @JsonProperty("body")
        final String body,

        @JsonProperty("media")
        final List<Map<String, Object>> media,

        @JsonProperty("attributes")
        final String attributes,

        @JsonProperty("participant_sid")
        final String participantSid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("delivery")
        final Map<String, Object> delivery,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("links")
        final Map<String, String> links,

        @JsonProperty("content_sid")
        final String contentSid
    ) {
        this.accountSid = accountSid;
        this.chatServiceSid = chatServiceSid;
        this.conversationSid = conversationSid;
        this.sid = sid;
        this.index = index;
        this.author = author;
        this.body = body;
        this.media = media;
        this.attributes = attributes;
        this.participantSid = participantSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.delivery = delivery;
        this.url = url;
        this.links = links;
        this.contentSid = contentSid;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getChatServiceSid() {
            return this.chatServiceSid;
        }
        public final String getConversationSid() {
            return this.conversationSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final Integer getIndex() {
            return this.index;
        }
        public final String getAuthor() {
            return this.author;
        }
        public final String getBody() {
            return this.body;
        }
        public final List<Map<String, Object>> getMedia() {
            return this.media;
        }
        public final String getAttributes() {
            return this.attributes;
        }
        public final String getParticipantSid() {
            return this.participantSid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final Map<String, Object> getDelivery() {
            return this.delivery;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Map<String, String> getLinks() {
            return this.links;
        }
        public final String getContentSid() {
            return this.contentSid;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message other = (Message) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(chatServiceSid, other.chatServiceSid) &&  Objects.equals(conversationSid, other.conversationSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(index, other.index) &&  Objects.equals(author, other.author) &&  Objects.equals(body, other.body) &&  Objects.equals(media, other.media) &&  Objects.equals(attributes, other.attributes) &&  Objects.equals(participantSid, other.participantSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(delivery, other.delivery) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links) &&  Objects.equals(contentSid, other.contentSid)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, chatServiceSid, conversationSid, sid, index, author, body, media, attributes, participantSid, dateCreated, dateUpdated, delivery, url, links, contentSid);
    }

}

