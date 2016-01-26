package com.twilio.sdk.fetchers.api.v2010.account.queue;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.Fetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.api.v2010.account.queue.Member;

public class MemberFetcher extends Fetcher<Member> {
    private final String accountSid;
    private final String queueSid;
    private final String callSid;

    /**
     * Construct a new MemberFetcher
     * 
     * @param accountSid The account_sid
     * @param queueSid The Queue in which to find the members
     * @param callSid The call_sid
     */
    public MemberFetcher(final String accountSid, final String queueSid, final String callSid) {
        this.accountSid = accountSid;
        this.queueSid = queueSid;
        this.callSid = callSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Member
     */
    @Override
    public Member execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            "/2010-04-01/Accounts/" + this.accountSid + "/Queues/" + this.queueSid + "/Members/" + this.callSid + ".json",
            client.getAccountSid()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Member fetch failed: Unable to connect to server");
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
}