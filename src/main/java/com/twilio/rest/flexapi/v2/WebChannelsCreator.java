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

package com.twilio.rest.flexapi.v2;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WebChannelsCreator extends Creator<WebChannels> {

    private String addressSid;
    private String uiVersion;
    private String chatFriendlyName;
    private String customerFriendlyName;
    private String preEngagementData;

    public WebChannelsCreator(final String addressSid) {
        this.addressSid = addressSid;
    }

    public WebChannelsCreator setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    public WebChannelsCreator setUiVersion(final String uiVersion) {
        this.uiVersion = uiVersion;
        return this;
    }

    public WebChannelsCreator setChatFriendlyName(
        final String chatFriendlyName
    ) {
        this.chatFriendlyName = chatFriendlyName;
        return this;
    }

    public WebChannelsCreator setCustomerFriendlyName(
        final String customerFriendlyName
    ) {
        this.customerFriendlyName = customerFriendlyName;
        return this;
    }

    public WebChannelsCreator setPreEngagementData(
        final String preEngagementData
    ) {
        this.preEngagementData = preEngagementData;
        return this;
    }

    @Override
    public WebChannels create(final TwilioRestClient client) {
        String path = "/v2/WebChats";

        path =
            path.replace("{" + "AddressSid" + "}", this.addressSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.FLEXAPI.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "WebChannels creation failed: Unable to connect to server"
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

        return WebChannels.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);
        }
        if (chatFriendlyName != null) {
            request.addPostParam("ChatFriendlyName", chatFriendlyName);
        }
        if (customerFriendlyName != null) {
            request.addPostParam("CustomerFriendlyName", customerFriendlyName);
        }
        if (preEngagementData != null) {
            request.addPostParam("PreEngagementData", preEngagementData);
        }
    }

    private void addHeaderParams(final Request request) {
        if (uiVersion != null) {
            request.addHeaderParam("Ui-Version", uiVersion);
        }
    }
}
