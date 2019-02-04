/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Creator;
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

public class IncomingPhoneNumberCreator extends Creator<IncomingPhoneNumber> {
    private String pathAccountSid;
    private com.twilio.type.PhoneNumber phoneNumber;
    private String areaCode;
    private String apiVersion;
    private String friendlyName;
    private String smsApplicationSid;
    private HttpMethod smsFallbackMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsMethod;
    private URI smsUrl;
    private URI statusCallback;
    private HttpMethod statusCallbackMethod;
    private String voiceApplicationSid;
    private Boolean voiceCallerIdLookup;
    private HttpMethod voiceFallbackMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceMethod;
    private URI voiceUrl;
    private IncomingPhoneNumber.EmergencyStatus emergencyStatus;
    private String emergencyAddressSid;
    private String trunkSid;
    private String identitySid;
    private String addressSid;
    private IncomingPhoneNumber.VoiceReceiveMode voiceReceiveMode;

    /**
     * Construct a new IncomingPhoneNumberCreator.
     * 
     * @param phoneNumber The phone number to purchase in E.164 format
     */
    public IncomingPhoneNumberCreator(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Construct a new IncomingPhoneNumberCreator.
     * 
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param phoneNumber The phone number to purchase in E.164 format
     */
    public IncomingPhoneNumberCreator(final String pathAccountSid, 
                                      final com.twilio.type.PhoneNumber phoneNumber) {
        this.pathAccountSid = pathAccountSid;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Construct a new IncomingPhoneNumberCreator.
     * 
     * @param areaCode The desired area code for the new phone number
     */
    public IncomingPhoneNumberCreator(final String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Construct a new IncomingPhoneNumberCreator.
     * 
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param areaCode The desired area code for the new phone number
     */
    public IncomingPhoneNumberCreator(final String pathAccountSid, 
                                      final String areaCode) {
        this.pathAccountSid = pathAccountSid;
        this.areaCode = areaCode;
    }

    /**
     * The API version to use for incoming calls made to the new phone number. The
     * default is `2010-04-01`..
     * 
     * @param apiVersion The API version to use for incoming calls made to the new
     *                   phone number
     * @return this
     */
    public IncomingPhoneNumberCreator setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * A descriptive string that you created to describe the new phone number. It
     * can be up to 64 characters long. By default, this is a formatted version of
     * the new phone number..
     * 
     * @param friendlyName A string to describe the new phone number
     * @return this
     */
    public IncomingPhoneNumberCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The SID of the application that should handle SMS messages sent to the new
     * phone number. If an `sms_application_sid` is present, we ignore all of the
     * `sms_*_url` urls and use those set on the application..
     * 
     * @param smsApplicationSid The SID of the application to handle SMS messages
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsApplicationSid(final String smsApplicationSid) {
        this.smsApplicationSid = smsApplicationSid;
        return this;
    }

    /**
     * The HTTP method that we should use to call `sms_fallback_url`. Can be: `GET`
     * or `POST` and defaults to `POST`..
     * 
     * @param smsFallbackMethod HTTP method used with sms_fallback_url
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while requesting or
     * executing the TwiML defined by `sms_url`..
     * 
     * @param smsFallbackUrl The URL we call when an error occurs while executing
     *                       TwiML
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while requesting or
     * executing the TwiML defined by `sms_url`..
     * 
     * @param smsFallbackUrl The URL we call when an error occurs while executing
     *                       TwiML
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method that we should use to call `sms_url`. Can be: `GET` or `POST`
     * and defaults to `POST`..
     * 
     * @param smsMethod The HTTP method to use with sms url
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL we should call when the new phone number receives an incoming SMS
     * message..
     * 
     * @param smsUrl The URL we should call when the new phone number receives an
     *               incoming SMS message
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL we should call when the new phone number receives an incoming SMS
     * message..
     * 
     * @param smsUrl The URL we should call when the new phone number receives an
     *               incoming SMS message
     * @return this
     */
    public IncomingPhoneNumberCreator setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application..
     * 
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public IncomingPhoneNumberCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application..
     * 
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public IncomingPhoneNumberCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The HTTP method we should use to call `status_callback`. Can be: `GET` or
     * `POST` and defaults to `POST`..
     * 
     * @param statusCallbackMethod HTTP method we should use to call status_callback
     * @return this
     */
    public IncomingPhoneNumberCreator setStatusCallbackMethod(final HttpMethod statusCallbackMethod) {
        this.statusCallbackMethod = statusCallbackMethod;
        return this;
    }

    /**
     * The SID of the application we should use to handle calls to the new phone
     * number. If a `voice_application_sid` is present, we ignore all of the voice
     * urls and use only those set on the application. Setting a
     * `voice_application_sid` will automatically delete your `trunk_sid` and vice
     * versa..
     * 
     * @param voiceApplicationSid The SID of the application to handle the new
     *                            phone number
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceApplicationSid(final String voiceApplicationSid) {
        this.voiceApplicationSid = voiceApplicationSid;
        return this;
    }

    /**
     * Whether to lookup the caller's name from the CNAM database and post it to
     * your app. Can be: `true` or `false` and defaults to `false`..
     * 
     * @param voiceCallerIdLookup Whether to lookup the caller's name
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceCallerIdLookup(final Boolean voiceCallerIdLookup) {
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        return this;
    }

    /**
     * The HTTP method that we should use to call `voice_fallback_url`. Can be:
     * `GET` or `POST` and defaults to `POST`..
     * 
     * @param voiceFallbackMethod The HTTP method used with voice_fallback_url
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs retrieving or executing the
     * TwiML requested by `url`..
     * 
     * @param voiceFallbackUrl The URL we will call when an error occurs in TwiML
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs retrieving or executing the
     * TwiML requested by `url`..
     * 
     * @param voiceFallbackUrl The URL we will call when an error occurs in TwiML
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    /**
     * The HTTP method that we should use to call `voice_url`. Can be: `GET` or
     * `POST` and defaults to `POST`..
     * 
     * @param voiceMethod The HTTP method used with the voice_url
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL that we should call to answer a call to the new phone number. The
     * `voice_url` will not be called if a `voice_application_sid` or a `trunk_sid`
     * is set..
     * 
     * @param voiceUrl The URL we should call when the phone number receives a call
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The URL that we should call to answer a call to the new phone number. The
     * `voice_url` will not be called if a `voice_application_sid` or a `trunk_sid`
     * is set..
     * 
     * @param voiceUrl The URL we should call when the phone number receives a call
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    /**
     * The configuration status parameter that determines whether the new phone
     * number is enabled for emergency calling..
     * 
     * @param emergencyStatus Status determining whether the new phone number is
     *                        enabled for emergency calling
     * @return this
     */
    public IncomingPhoneNumberCreator setEmergencyStatus(final IncomingPhoneNumber.EmergencyStatus emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
        return this;
    }

    /**
     * The SID of the emergency address configuration to use for emergency calling
     * from the new phone number..
     * 
     * @param emergencyAddressSid The emergency address configuration to use for
     *                            emergency calling
     * @return this
     */
    public IncomingPhoneNumberCreator setEmergencyAddressSid(final String emergencyAddressSid) {
        this.emergencyAddressSid = emergencyAddressSid;
        return this;
    }

    /**
     * The SID of the Trunk we should use to handle calls to the new phone number.
     * If a `trunk_sid` is present, we ignore all of the voice urls and voice
     * applications and use only those set on the Trunk. Setting a `trunk_sid` will
     * automatically delete your `voice_application_sid` and vice versa..
     * 
     * @param trunkSid SID of the trunk to handle calls to the new phone number
     * @return this
     */
    public IncomingPhoneNumberCreator setTrunkSid(final String trunkSid) {
        this.trunkSid = trunkSid;
        return this;
    }

    /**
     * The SID of the Identity resource that we should associate with the new phone
     * number. Some regions require an identity to meet local regulations..
     * 
     * @param identitySid The SID of the Identity resource to associate with the
     *                    new phone number
     * @return this
     */
    public IncomingPhoneNumberCreator setIdentitySid(final String identitySid) {
        this.identitySid = identitySid;
        return this;
    }

    /**
     * The SID of the Address resource we should associate with the new phone
     * number. Some regions require addresses to meet local regulations..
     * 
     * @param addressSid The SID of the Address resource associated with the phone
     *                   number
     * @return this
     */
    public IncomingPhoneNumberCreator setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    /**
     * The configuration parameter for the new phone number to receive incoming
     * voice calls or faxes. Can be: `fax` or `voice` and defaults to `voice`..
     * 
     * @param voiceReceiveMode Incoming call type: fax or voice
     * @return this
     */
    public IncomingPhoneNumberCreator setVoiceReceiveMode(final IncomingPhoneNumber.VoiceReceiveMode voiceReceiveMode) {
        this.voiceReceiveMode = voiceReceiveMode;
        return this;
    }

    /**
     * The phone number to purchase specified in
     * [E.164](https://www.twilio.com/docs/glossary/what-e164) format.  E.164 phone
     * numbers consist of a + followed by the country code and subscriber number
     * without punctuation characters. For example, +14155551234..
     * 
     * @param phoneNumber The phone number to purchase in E.164 format
     * @return this
     */
    public IncomingPhoneNumberCreator setPhoneNumber(final com.twilio.type.PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * The phone number to purchase specified in
     * [E.164](https://www.twilio.com/docs/glossary/what-e164) format.  E.164 phone
     * numbers consist of a + followed by the country code and subscriber number
     * without punctuation characters. For example, +14155551234..
     * 
     * @param phoneNumber The phone number to purchase in E.164 format
     * @return this
     */
    public IncomingPhoneNumberCreator setPhoneNumber(final String phoneNumber) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    /**
     * The desired area code for your new incoming phone number. Can be any
     * three-digit, US or Canada area code. We will provision an available phone
     * number within this area code for you. **You must provide an `area_code` or a
     * `phone_number`.** (US and Canada only)..
     * 
     * @param areaCode The desired area code for the new phone number
     * @return this
     */
    public IncomingPhoneNumberCreator setAreaCode(final String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created IncomingPhoneNumber
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IncomingPhoneNumber create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/IncomingPhoneNumbers.json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IncomingPhoneNumber creation failed: Unable to connect to server");
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

        return IncomingPhoneNumber.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (phoneNumber != null) {
            request.addPostParam("PhoneNumber", phoneNumber.toString());
        }

        if (areaCode != null) {
            request.addPostParam("AreaCode", areaCode);
        }

        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (smsApplicationSid != null) {
            request.addPostParam("SmsApplicationSid", smsApplicationSid);
        }

        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }

        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }

        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }

        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (statusCallbackMethod != null) {
            request.addPostParam("StatusCallbackMethod", statusCallbackMethod.toString());
        }

        if (voiceApplicationSid != null) {
            request.addPostParam("VoiceApplicationSid", voiceApplicationSid);
        }

        if (voiceCallerIdLookup != null) {
            request.addPostParam("VoiceCallerIdLookup", voiceCallerIdLookup.toString());
        }

        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
        }

        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
        }

        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
        }

        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
        }

        if (emergencyStatus != null) {
            request.addPostParam("EmergencyStatus", emergencyStatus.toString());
        }

        if (emergencyAddressSid != null) {
            request.addPostParam("EmergencyAddressSid", emergencyAddressSid);
        }

        if (trunkSid != null) {
            request.addPostParam("TrunkSid", trunkSid);
        }

        if (identitySid != null) {
            request.addPostParam("IdentitySid", identitySid);
        }

        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);
        }

        if (voiceReceiveMode != null) {
            request.addPostParam("VoiceReceiveMode", voiceReceiveMode.toString());
        }
    }
}