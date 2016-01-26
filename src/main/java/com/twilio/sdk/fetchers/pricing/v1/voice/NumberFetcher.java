package com.twilio.sdk.fetchers.pricing.v1.voice;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.Fetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.numbers.PhoneNumber;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.pricing.v1.voice.Number;

public class NumberFetcher extends Fetcher<Number> {
    private final PhoneNumber number;

    /**
     * Construct a new NumberFetcher
     * 
     * @param number The number
     */
    public NumberFetcher(final PhoneNumber number) {
        this.number = number;
    }

    /**
     * Make the request to the Twilio API to perform the fetch
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Number
     */
    @Override
    public Number execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            "/v1/Voice/Numbers/" + this.number + "",
            client.getAccountSid()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Number fetch failed: Unable to connect to server");
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
        
        return Number.fromJson(response.getStream(), client.getObjectMapper());
    }
}