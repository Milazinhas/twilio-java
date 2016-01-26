package com.twilio.sdk.updaters.api.v2010.account.sms;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.Promoter;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.api.v2010.account.sms.ShortCode;
import com.twilio.sdk.updaters.Updater;

import java.net.URI;

public class ShortCodeUpdater extends Updater<ShortCode> {
    private final String accountSid;
    private final String sid;
    private String friendlyName;
    private String apiVersion;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;

    /**
     * Construct a new ShortCodeUpdater
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     */
    public ShortCodeUpdater(final String accountSid, final String sid) {
        this.accountSid = accountSid;
        this.sid = sid;
    }

    /**
     * A human readable descriptive text for this resource, up to 64 characters
     * long. By default, the `FriendlyName` is just the short code.
     * 
     * @param friendlyName A human readable description of this resource
     * @return this
     */
    public ShortCodeUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * SMSs to this short code will start a new TwiML session with this API version.
     * 
     * @param apiVersion The API version to use
     * @return this
     */
    public ShortCodeUpdater setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * The URL Twilio will request when receiving an incoming SMS message to this
     * short code.
     * 
     * @param smsUrl URL Twilio will request when receiving an SMS
     * @return this
     */
    public ShortCodeUpdater setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL Twilio will request when receiving an incoming SMS message to this
     * short code.
     * 
     * @param smsUrl URL Twilio will request when receiving an SMS
     * @return this
     */
    public ShortCodeUpdater setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The HTTP method Twilio will use when making requests to the `SmsUrl`. Either
     * `GET` or `POST`.
     * 
     * @param smsMethod HTTP method to use when requesting the sms url
     * @return this
     */
    public ShortCodeUpdater setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL that Twilio will request if an error occurs retrieving or executing
     * the TwiML from `SmsUrl`.
     * 
     * @param smsFallbackUrl URL Twilio will request if an error occurs in
     *                       executing TwiML
     * @return this
     */
    public ShortCodeUpdater setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The URL that Twilio will request if an error occurs retrieving or executing
     * the TwiML from `SmsUrl`.
     * 
     * @param smsFallbackUrl URL Twilio will request if an error occurs in
     *                       executing TwiML
     * @return this
     */
    public ShortCodeUpdater setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method Twilio will use when requesting the above URL. Either `GET`
     * or `POST`.
     * 
     * @param smsFallbackMethod HTTP method Twilio will use with sms fallback url
     * @return this
     */
    public ShortCodeUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated ShortCode
     */
    @Override
    public ShortCode execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            "/2010-04-01/Accounts/" + this.accountSid + "/SMS/ShortCodes/" + this.sid + ".json",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("ShortCode update failed: Unable to connect to server");
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
        
        return ShortCode.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }
        
        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }
        
        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }
        
        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }
        
        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }
    }
}