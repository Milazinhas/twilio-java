/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1;

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
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ExternalCampaign extends Resource {
    private static final long serialVersionUID = 5202740466165L;

    /**
     * Create a ExternalCampaignCreator to execute create.
     *
     * @param campaignId ID of the preregistered campaign.
     * @param messagingServiceSid The SID of the Messaging Service the resource is
     *                            associated with
     * @return ExternalCampaignCreator capable of executing the create
     */
    public static ExternalCampaignCreator creator(final String campaignId,
                                                  final String messagingServiceSid) {
        return new ExternalCampaignCreator(campaignId, messagingServiceSid);
    }

    /**
     * Converts a JSON String into a ExternalCampaign object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ExternalCampaign object represented by the provided JSON
     */
    public static ExternalCampaign fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExternalCampaign.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ExternalCampaign object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ExternalCampaign object represented by the provided JSON
     */
    public static ExternalCampaign fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExternalCampaign.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String campaignId;
    private final String messagingServiceSid;
    private final ZonedDateTime dateCreated;

    @JsonCreator
    private ExternalCampaign(@JsonProperty("account_sid")
                             final String accountSid,
                             @JsonProperty("campaign_id")
                             final String campaignId,
                             @JsonProperty("messaging_service_sid")
                             final String messagingServiceSid,
                             @JsonProperty("date_created")
                             final String dateCreated) {
        this.accountSid = accountSid;
        this.campaignId = campaignId;
        this.messagingServiceSid = messagingServiceSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
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
     * Returns ID of the preregistered campaign..
     *
     * @return ID of the preregistered campaign.
     */
    public final String getCampaignId() {
        return this.campaignId;
    }

    /**
     * Returns The SID of the Messaging Service the resource is associated with.
     *
     * @return The SID of the Messaging Service the resource is associated with
     */
    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExternalCampaign other = (ExternalCampaign) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(campaignId, other.campaignId) &&
               Objects.equals(messagingServiceSid, other.messagingServiceSid) &&
               Objects.equals(dateCreated, other.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            campaignId,
                            messagingServiceSid,
                            dateCreated);
    }
}