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

package com.twilio.rest.conversations.v1.service.conversation.message;

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
public class DeliveryReceipt extends Resource {
    private static final long serialVersionUID = 201260516970011L;

    public static DeliveryReceiptFetcher fetcher(final String pathChatServiceSid, final String pathConversationSid, final String pathMessageSid, final String pathSid){
        return new DeliveryReceiptFetcher(pathChatServiceSid, pathConversationSid, pathMessageSid, pathSid);
    }

    public static DeliveryReceiptReader reader(final String pathChatServiceSid, final String pathConversationSid, final String pathMessageSid){
        return new DeliveryReceiptReader(pathChatServiceSid, pathConversationSid, pathMessageSid);
    }

    /**
    * Converts a JSON String into a DeliveryReceipt object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return DeliveryReceipt object represented by the provided JSON
    */
    public static DeliveryReceipt fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DeliveryReceipt.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a DeliveryReceipt object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return DeliveryReceipt object represented by the provided JSON
    */
    public static DeliveryReceipt fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, DeliveryReceipt.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum DeliveryStatus {
        READ("read"),
        FAILED("failed"),
        DELIVERED("delivered"),
        UNDELIVERED("undelivered"),
        SENT("sent");

        private final String value;

        private DeliveryStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static DeliveryStatus forValue(final String value) {
            return Promoter.enumFromString(value, DeliveryStatus.values());
        }
    }

    private final String accountSid;
    private final String chatServiceSid;
    private final String conversationSid;
    private final String messageSid;
    private final String sid;
    private final String channelMessageSid;
    private final String participantSid;
    private final DeliveryReceipt.DeliveryStatus status;
    private final Integer errorCode;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private DeliveryReceipt(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("chat_service_sid")
        final String chatServiceSid,

        @JsonProperty("conversation_sid")
        final String conversationSid,

        @JsonProperty("message_sid")
        final String messageSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("channel_message_sid")
        final String channelMessageSid,

        @JsonProperty("participant_sid")
        final String participantSid,

        @JsonProperty("status")
        final DeliveryReceipt.DeliveryStatus status,

        @JsonProperty("error_code")
        final Integer errorCode,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url
    ) {
        this.accountSid = accountSid;
        this.chatServiceSid = chatServiceSid;
        this.conversationSid = conversationSid;
        this.messageSid = messageSid;
        this.sid = sid;
        this.channelMessageSid = channelMessageSid;
        this.participantSid = participantSid;
        this.status = status;
        this.errorCode = errorCode;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
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
        public final String getMessageSid() {
            return this.messageSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final String getChannelMessageSid() {
            return this.channelMessageSid;
        }
        public final String getParticipantSid() {
            return this.participantSid;
        }
        public final DeliveryReceipt.DeliveryStatus getStatus() {
            return this.status;
        }
        public final Integer getErrorCode() {
            return this.errorCode;
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

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DeliveryReceipt other = (DeliveryReceipt) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(chatServiceSid, other.chatServiceSid) &&  Objects.equals(conversationSid, other.conversationSid) &&  Objects.equals(messageSid, other.messageSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(channelMessageSid, other.channelMessageSid) &&  Objects.equals(participantSid, other.participantSid) &&  Objects.equals(status, other.status) &&  Objects.equals(errorCode, other.errorCode) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, chatServiceSid, conversationSid, messageSid, sid, channelMessageSid, participantSid, status, errorCode, dateCreated, dateUpdated, url);
    }

}

