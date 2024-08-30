/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.recording.addonresult.payload;

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

public class DataFetcher extends Fetcher<Data> {

    private String pathReferenceSid;
    private String pathAddOnResultSid;
    private String pathPayloadSid;
    private String pathAccountSid;

    public DataFetcher(
        final String pathReferenceSid,
        final String pathAddOnResultSid,
        final String pathPayloadSid
    ) {
        this.pathReferenceSid = pathReferenceSid;
        this.pathAddOnResultSid = pathAddOnResultSid;
        this.pathPayloadSid = pathPayloadSid;
    }

    public DataFetcher(
        final String pathAccountSid,
        final String pathReferenceSid,
        final String pathAddOnResultSid,
        final String pathPayloadSid
    ) {
        this.pathAccountSid = pathAccountSid;
        this.pathReferenceSid = pathReferenceSid;
        this.pathAddOnResultSid = pathAddOnResultSid;
        this.pathPayloadSid = pathPayloadSid;
    }

    @Override
    public Data fetch(final TwilioRestClient client) {
        String path =
            "/2010-04-01/Accounts/{AccountSid}/Recordings/{ReferenceSid}/AddOnResults/{AddOnResultSid}/Payloads/{PayloadSid}/Data.json";

        this.pathAccountSid =
            this.pathAccountSid == null
                ? client.getAccountSid()
                : this.pathAccountSid;
        path =
            path.replace(
                "{" + "AccountSid" + "}",
                this.pathAccountSid.toString()
            );
        path =
            path.replace(
                "{" + "ReferenceSid" + "}",
                this.pathReferenceSid.toString()
            );
        path =
            path.replace(
                "{" + "AddOnResultSid" + "}",
                this.pathAddOnResultSid.toString()
            );
        path =
            path.replace(
                "{" + "PayloadSid" + "}",
                this.pathPayloadSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Data fetch failed: Unable to connect to server"
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

        return Data.fromJson(response.getStream(), client.getObjectMapper());
    }
}
