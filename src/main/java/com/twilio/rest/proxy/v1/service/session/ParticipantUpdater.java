/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.proxy.v1.service.session;

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
public class ParticipantUpdater extends Updater<Participant> {
    private final String pathServiceSid;
    private final String pathSessionSid;
    private final String pathSid;
    private String identifier;
    private String friendlyName;
    private String proxyIdentifier;
    private String proxyIdentifierSid;

    /**
     * Construct a new ParticipantUpdater.
     * 
     * @param pathServiceSid Service Sid.
     * @param pathSessionSid Session Sid.
     * @param pathSid A string that uniquely identifies this Participant.
     */
    public ParticipantUpdater(final String pathServiceSid, 
                              final String pathSessionSid, 
                              final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSessionSid = pathSessionSid;
        this.pathSid = pathSid;
    }

    /**
     * The phone number of this Participant..
     * 
     * @param identifier The phone number of this Participant.
     * @return this
     */
    public ParticipantUpdater setIdentifier(final String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     * A human readable description of this resource, up to 64 characters..
     * 
     * @param friendlyName A human readable description of this resource.
     * @return this
     */
    public ParticipantUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The proxy phone number for this Participant..
     * 
     * @param proxyIdentifier The proxy phone number for this Participant.
     * @return this
     */
    public ParticipantUpdater setProxyIdentifier(final String proxyIdentifier) {
        this.proxyIdentifier = proxyIdentifier;
        return this;
    }

    /**
     * The unique SID identifier of the Proxy Identifier..
     * 
     * @param proxyIdentifierSid Proxy Identifier Sid.
     * @return this
     */
    public ParticipantUpdater setProxyIdentifierSid(final String proxyIdentifierSid) {
        this.proxyIdentifierSid = proxyIdentifierSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Participant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Participant update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Sessions/" + this.pathSessionSid + "/Participants/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Participant update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Participant.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identifier != null) {
            request.addPostParam("Identifier", identifier);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (proxyIdentifier != null) {
            request.addPostParam("ProxyIdentifier", proxyIdentifier);
        }

        if (proxyIdentifierSid != null) {
            request.addPostParam("ProxyIdentifierSid", proxyIdentifierSid);
        }
    }
}