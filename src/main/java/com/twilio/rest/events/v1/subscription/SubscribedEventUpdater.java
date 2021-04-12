/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1.subscription;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SubscribedEventUpdater extends Updater<SubscribedEvent> {
    private final String pathSubscriptionSid;
    private final String pathType;
    private Integer version;

    /**
     * Construct a new SubscribedEventUpdater.
     *
     * @param pathSubscriptionSid Subscription SID.
     * @param pathType Type of event being subscribed to.
     */
    public SubscribedEventUpdater(final String pathSubscriptionSid,
                                  final String pathType) {
        this.pathSubscriptionSid = pathSubscriptionSid;
        this.pathType = pathType;
    }

    /**
     * The schema version that the subscription should use..
     *
     * @param version The schema version that the subscription should use.
     * @return this
     */
    public SubscribedEventUpdater setVersion(final Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated SubscribedEvent
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SubscribedEvent update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.EVENTS.toString(),
            "/v1/Subscriptions/" + this.pathSubscriptionSid + "/SubscribedEvents/" + this.pathType + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SubscribedEvent update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SubscribedEvent.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (version != null) {
            request.addPostParam("Version", version.toString());
        }
    }
}