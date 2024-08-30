/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Sync
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.sync.v1.service.synclist;

import com.twilio.base.Fetcher;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SyncListPermissionFetcher extends Fetcher<SyncListPermission> {

    private String pathServiceSid;
    private String pathListSid;
    private String pathIdentity;

    public SyncListPermissionFetcher(
        final String pathServiceSid,
        final String pathListSid,
        final String pathIdentity
    ) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.pathIdentity = pathIdentity;
    }

    @Override
    public SyncListPermission fetch(final TwilioRestClient client) {
        String path =
            "/v1/Services/{ServiceSid}/Lists/{ListSid}/Permissions/{Identity}";

        path =
            path.replace(
                "{" + "ServiceSid" + "}",
                this.pathServiceSid.toString()
            );
        path = path.replace("{" + "ListSid" + "}", this.pathListSid.toString());
        path =
            path.replace("{" + "Identity" + "}", this.pathIdentity.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.SYNC.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "SyncListPermission fetch failed: Unable to connect to server"
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

        return SyncListPermission.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }
}
