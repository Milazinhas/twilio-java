/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.preview.sync.service.syncmap;

import com.twilio.base.Updater;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.Map;

public class SyncMapItemUpdater extends Updater<SyncMapItem> {

    private String pathServiceSid;
    private String pathMapSid;
    private String pathKey;
    private Map<String, Object> data;
    private String ifMatch;

    public SyncMapItemUpdater(
        final String pathServiceSid,
        final String pathMapSid,
        final String pathKey,
        final Map<String, Object> data
    ) {
        this.pathServiceSid = pathServiceSid;
        this.pathMapSid = pathMapSid;
        this.pathKey = pathKey;
        this.data = data;
    }

    public SyncMapItemUpdater setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public SyncMapItemUpdater setIfMatch(final String ifMatch) {
        this.ifMatch = ifMatch;
        return this;
    }

    @Override
    public SyncMapItem update(final TwilioRestClient client) {
        String path = "/Sync/Services/{ServiceSid}/Maps/{MapSid}/Items/{Key}";

        path =
            path.replace(
                "{" + "ServiceSid" + "}",
                this.pathServiceSid.toString()
            );
        path = path.replace("{" + "MapSid" + "}", this.pathMapSid.toString());
        path = path.replace("{" + "Key" + "}", this.pathKey.toString());
        path = path.replace("{" + "Data" + "}", this.data.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "SyncMapItem update failed: Unable to connect to server"
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

        return SyncMapItem.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }
    }

    private void addHeaderParams(final Request request) {
        if (ifMatch != null) {
            request.addHeaderParam("If-Match", ifMatch);
        }
    }
}
