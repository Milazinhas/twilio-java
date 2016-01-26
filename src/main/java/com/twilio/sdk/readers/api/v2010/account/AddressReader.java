package com.twilio.sdk.readers.api.v2010.account;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.readers.Reader;
import com.twilio.sdk.resources.Page;
import com.twilio.sdk.resources.ResourceSet;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.api.v2010.account.Address;

public class AddressReader extends Reader<Address> {
    private final String accountSid;
    private String customerName;
    private String friendlyName;
    private String isoCountry;

    /**
     * Construct a new AddressReader
     * 
     * @param accountSid The account_sid
     */
    public AddressReader(final String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     * The customer_name
     * 
     * @param customerName The customer_name
     * @return this
     */
    public AddressReader byCustomerName(final String customerName) {
        this.customerName = customerName;
        return this;
    }

    /**
     * The friendly_name
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public AddressReader byFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The iso_country
     * 
     * @param isoCountry The iso_country
     * @return this
     */
    public AddressReader byIsoCountry(final String isoCountry) {
        this.isoCountry = isoCountry;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Address ResourceSet
     */
    @Override
    public ResourceSet<Address> execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            "/2010-04-01/Accounts/" + this.accountSid + "/Addresses.json",
            client.getAccountSid()
        );
        
        addQueryParams(request);
        
        Page<Address> page = pageForRequest(client, request);
        
        return new ResourceSet<>(this, client, page);
    }

    /**
     * Retrieve the next page from the Twilio API
     * 
     * @param nextPageUri URI from which to retrieve the next page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Address> nextPage(final String nextPageUri, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            nextPageUri,
            client.getAccountSid()
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Address Resources for a given request
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    protected Page<Address> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Address read failed: Unable to connect to server");
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
        
        Page<Address> result = new Page<>();
        result.deserialize("addresses", response.getContent(), Address.class, client.getObjectMapper());
        
        return result;
    }

    /**
     * Add the requested query string arguments to the Request
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (customerName != null) {
            request.addQueryParam("CustomerName", customerName);
        }
        
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        
        if (isoCountry != null) {
            request.addQueryParam("IsoCountry", isoCountry);
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}