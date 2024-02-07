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

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.List;
import java.util.List;

public class WebhookCreator extends Creator<Webhook> {

    private String pathChatServiceSid;
    private String pathConversationSid;
    private Webhook.Target target;
    private String configurationUrl;
    private Webhook.Method configurationMethod;
    private List<String> configurationFilters;
    private List<String> configurationTriggers;
    private String configurationFlowSid;
    private Integer configurationReplayAfter;

    public WebhookCreator(
        final String pathChatServiceSid,
        final String pathConversationSid,
        final Webhook.Target target
    ) {
        this.pathChatServiceSid = pathChatServiceSid;
        this.pathConversationSid = pathConversationSid;
        this.target = target;
    }

    public WebhookCreator setTarget(final Webhook.Target target) {
        this.target = target;
        return this;
    }

    public WebhookCreator setConfigurationUrl(final String configurationUrl) {
        this.configurationUrl = configurationUrl;
        return this;
    }

    public WebhookCreator setConfigurationMethod(
        final Webhook.Method configurationMethod
    ) {
        this.configurationMethod = configurationMethod;
        return this;
    }

    public WebhookCreator setConfigurationFilters(
        final List<String> configurationFilters
    ) {
        this.configurationFilters = configurationFilters;
        return this;
    }

    public WebhookCreator setConfigurationFilters(
        final String configurationFilters
    ) {
        return setConfigurationFilters(
            Promoter.listOfOne(configurationFilters)
        );
    }

    public WebhookCreator setConfigurationTriggers(
        final List<String> configurationTriggers
    ) {
        this.configurationTriggers = configurationTriggers;
        return this;
    }

    public WebhookCreator setConfigurationTriggers(
        final String configurationTriggers
    ) {
        return setConfigurationTriggers(
            Promoter.listOfOne(configurationTriggers)
        );
    }

    public WebhookCreator setConfigurationFlowSid(
        final String configurationFlowSid
    ) {
        this.configurationFlowSid = configurationFlowSid;
        return this;
    }

    public WebhookCreator setConfigurationReplayAfter(
        final Integer configurationReplayAfter
    ) {
        this.configurationReplayAfter = configurationReplayAfter;
        return this;
    }

    @Override
    public Webhook create(final TwilioRestClient client) {
        String path =
            "/v1/Services/{ChatServiceSid}/Conversations/{ConversationSid}/Webhooks";

        path =
            path.replace(
                "{" + "ChatServiceSid" + "}",
                this.pathChatServiceSid.toString()
            );
        path =
            path.replace(
                "{" + "ConversationSid" + "}",
                this.pathConversationSid.toString()
            );
        path = path.replace("{" + "Target" + "}", this.target.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "Webhook creation failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (target != null) {
            request.addPostParam("Target", target.toString());
        }
        if (configurationUrl != null) {
            request.addPostParam("Configuration.Url", configurationUrl);
        }
        if (configurationMethod != null) {
            request.addPostParam(
                "Configuration.Method",
                configurationMethod.toString()
            );
        }
        if (configurationFilters != null) {
            for (String prop : configurationFilters) {
                request.addPostParam("Configuration.Filters", prop);
            }
        }
        if (configurationTriggers != null) {
            for (String prop : configurationTriggers) {
                request.addPostParam("Configuration.Triggers", prop);
            }
        }
        if (configurationFlowSid != null) {
            request.addPostParam("Configuration.FlowSid", configurationFlowSid);
        }
        if (configurationReplayAfter != null) {
            request.addPostParam(
                "Configuration.ReplayAfter",
                configurationReplayAfter.toString()
            );
        }
    }
}
