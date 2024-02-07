/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trunking
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trunking.v1.trunk;

import com.twilio.base.Updater;
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
import java.net.URI;

public class OriginationUrlUpdater extends Updater<OriginationUrl> {

    private String pathTrunkSid;
    private String pathSid;
    private Integer weight;
    private Integer priority;
    private Boolean enabled;
    private String friendlyName;
    private URI sipUrl;

    public OriginationUrlUpdater(
        final String pathTrunkSid,
        final String pathSid
    ) {
        this.pathTrunkSid = pathTrunkSid;
        this.pathSid = pathSid;
    }

    public OriginationUrlUpdater setWeight(final Integer weight) {
        this.weight = weight;
        return this;
    }

    public OriginationUrlUpdater setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    public OriginationUrlUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public OriginationUrlUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public OriginationUrlUpdater setSipUrl(final URI sipUrl) {
        this.sipUrl = sipUrl;
        return this;
    }

    public OriginationUrlUpdater setSipUrl(final String sipUrl) {
        return setSipUrl(Promoter.uriFromString(sipUrl));
    }

    @Override
    public OriginationUrl update(final TwilioRestClient client) {
        String path = "/v1/Trunks/{TrunkSid}/OriginationUrls/{Sid}";

        path =
            path.replace("{" + "TrunkSid" + "}", this.pathTrunkSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TRUNKING.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "OriginationUrl update failed: Unable to connect to server"
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

        return OriginationUrl.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (weight != null) {
            request.addPostParam("Weight", weight.toString());
        }
        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        if (sipUrl != null) {
            request.addPostParam("SipUrl", sipUrl.toString());
        }
    }
}
