package com.twilio.sdk.updaters.api.v2010.account.queue;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.api.v2010.account.queue.Member;
import com.twilio.sdk.updaters.Updater;

import java.net.URI;

public class MemberUpdater extends Updater<Member> {
    private final String accountSid;
    private final String queueSid;
    private final String callSid;
    private final URI url;
    private final HttpMethod method;

    /**
     * Construct a new MemberUpdater
     * 
     * @param accountSid The account_sid
     * @param queueSid The Queue in which to find the members
     * @param callSid The call_sid
     * @param url The url
     * @param method The method
     */
    public MemberUpdater(final String accountSid, final String queueSid, final String callSid, final URI url, final HttpMethod method) {
        this.accountSid = accountSid;
        this.queueSid = queueSid;
        this.callSid = callSid;
        this.url = url;
        this.method = method;
    }

    /**
     * Make the request to the Twilio API to perform the update
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Member
     */
    @Override
    public Member execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            "/2010-04-01/Accounts/" + this.accountSid + "/Queues/" + this.queueSid + "/Members/" + this.callSid + ".json",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Member update failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (url != null) {
            request.addPostParam("Url", url.toString());
        }
        
        if (method != null) {
            request.addPostParam("Method", method.toString());
        }
    }
}