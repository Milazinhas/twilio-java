/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.messaging.v1.brandregistration;

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

public class BrandVettingCreator extends Creator<BrandVetting> {

    private String pathBrandSid;
    private BrandVetting.VettingProvider vettingProvider;
    private String vettingId;

    public BrandVettingCreator(
        final String pathBrandSid,
        final BrandVetting.VettingProvider vettingProvider
    ) {
        this.pathBrandSid = pathBrandSid;
        this.vettingProvider = vettingProvider;
    }

    public BrandVettingCreator setVettingProvider(
        final BrandVetting.VettingProvider vettingProvider
    ) {
        this.vettingProvider = vettingProvider;
        return this;
    }

    public BrandVettingCreator setVettingId(final String vettingId) {
        this.vettingId = vettingId;
        return this;
    }

    @Override
    public BrandVetting create(final TwilioRestClient client) {
        String path = "/v1/a2p/BrandRegistrations/{BrandSid}/Vettings";

        path =
            path.replace("{" + "BrandSid" + "}", this.pathBrandSid.toString());
        path =
            path.replace(
                "{" + "VettingProvider" + "}",
                this.vettingProvider.toString()
            );

        Request request = new Request(
            HttpMethod.POST,
            Domains.MESSAGING.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "BrandVetting creation failed: Unable to connect to server"
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

        return BrandVetting.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (vettingProvider != null) {
            request.addPostParam("VettingProvider", vettingProvider.toString());
        }
        if (vettingId != null) {
            request.addPostParam("VettingId", vettingId);
        }
    }
}
