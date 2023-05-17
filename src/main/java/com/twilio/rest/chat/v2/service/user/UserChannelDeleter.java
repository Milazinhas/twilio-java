/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Chat
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.chat.v2.service.user;

import com.twilio.base.Deleter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.converter.PrefixedCollapsibleMap;
import com.twilio.exception.ApiException;
import com.twilio.converter.Converter;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.LocalDate;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.twilio.converter.DateConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.ToString;

public class UserChannelDeleter extends Deleter<UserChannel> {
    private String pathServiceSid;
    private String pathUserSid;
    private String pathChannelSid;
    private UserChannel.WebhookEnabledType xTwilioWebhookEnabled;

    public UserChannelDeleter(final String pathServiceSid, final String pathUserSid, final String pathChannelSid){
        this.pathServiceSid = pathServiceSid;
        this.pathUserSid = pathUserSid;
        this.pathChannelSid = pathChannelSid;
    }

    public UserChannelDeleter setXTwilioWebhookEnabled(final UserChannel.WebhookEnabledType xTwilioWebhookEnabled){
        this.xTwilioWebhookEnabled = xTwilioWebhookEnabled;
        return this;
    }

    @Override
    public boolean delete(final TwilioRestClient client) {
        String path = "/v2/Services/{ServiceSid}/Users/{UserSid}/Channels/{ChannelSid}";

        path = path.replace("{"+"ServiceSid"+"}", this.pathServiceSid.toString());
        path = path.replace("{"+"UserSid"+"}", this.pathUserSid.toString());
        path = path.replace("{"+"ChannelSid"+"}", this.pathChannelSid.toString());

        Request request = new Request(
            HttpMethod.DELETE,
            Domains.CHAT.toString(),
            path
        );
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("UserChannel delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
    private void addHeaderParams(final Request request) {
        if (xTwilioWebhookEnabled != null) {
            request.addHeaderParam("X-Twilio-Webhook-Enabled", xTwilioWebhookEnabled.toString());

        }
    }
}
