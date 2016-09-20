/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.chat.v1.service;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class RoleFetcher extends Fetcher<Role> {
    private final String serviceSid;
    private final String sid;

    /**
     * Construct a new RoleFetcher.
     * 
     * @param serviceSid The service_sid
     * @param sid The sid
     */
    public RoleFetcher(final String serviceSid, 
                       final String sid) {
        this.serviceSid = serviceSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Role
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Role execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.CHAT.toString(),
            "/v1/Services/" + this.serviceSid + "/Roles/" + this.sid + "",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Role fetch failed: Unable to connect to server");
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
        
        return Role.fromJson(response.getStream(), client.getObjectMapper());
    }
}