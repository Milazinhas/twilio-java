/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.availablephonenumbercountry;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.converter.PrefixedCollapsibleMap;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import com.twilio.converter.DateConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.ToString;

public class VoipReader extends Reader<Voip> {
    private String pathCountryCode;
    private String pathAccountSid;
    private Integer areaCode;
    private String contains;
    private Boolean smsEnabled;
    private Boolean mmsEnabled;
    private Boolean voiceEnabled;
    private Boolean excludeAllAddressRequired;
    private Boolean excludeLocalAddressRequired;
    private Boolean excludeForeignAddressRequired;
    private Boolean beta;
    private com.twilio.type.PhoneNumber nearNumber;
    private String nearLatLong;
    private Integer distance;
    private String inPostalCode;
    private String inRegion;
    private String inRateCenter;
    private String inLata;
    private String inLocality;
    private Boolean faxEnabled;
    private Integer pageSize;

    public VoipReader(final String pathCountryCode){
        this.pathCountryCode = pathCountryCode;
    }
    public VoipReader(final String pathAccountSid, final String pathCountryCode){
        this.pathAccountSid = pathAccountSid;
        this.pathCountryCode = pathCountryCode;
    }

    public VoipReader setAreaCode(final Integer areaCode){
        this.areaCode = areaCode;
        return this;
    }
    public VoipReader setContains(final String contains){
        this.contains = contains;
        return this;
    }
    public VoipReader setSmsEnabled(final Boolean smsEnabled){
        this.smsEnabled = smsEnabled;
        return this;
    }
    public VoipReader setMmsEnabled(final Boolean mmsEnabled){
        this.mmsEnabled = mmsEnabled;
        return this;
    }
    public VoipReader setVoiceEnabled(final Boolean voiceEnabled){
        this.voiceEnabled = voiceEnabled;
        return this;
    }
    public VoipReader setExcludeAllAddressRequired(final Boolean excludeAllAddressRequired){
        this.excludeAllAddressRequired = excludeAllAddressRequired;
        return this;
    }
    public VoipReader setExcludeLocalAddressRequired(final Boolean excludeLocalAddressRequired){
        this.excludeLocalAddressRequired = excludeLocalAddressRequired;
        return this;
    }
    public VoipReader setExcludeForeignAddressRequired(final Boolean excludeForeignAddressRequired){
        this.excludeForeignAddressRequired = excludeForeignAddressRequired;
        return this;
    }
    public VoipReader setBeta(final Boolean beta){
        this.beta = beta;
        return this;
    }
    public VoipReader setNearNumber(final com.twilio.type.PhoneNumber nearNumber){
        this.nearNumber = nearNumber;
        return this;
    }

    public VoipReader setNearNumber(final String nearNumber){
        return setNearNumber(Promoter.phoneNumberFromString(nearNumber));
    }
    public VoipReader setNearLatLong(final String nearLatLong){
        this.nearLatLong = nearLatLong;
        return this;
    }
    public VoipReader setDistance(final Integer distance){
        this.distance = distance;
        return this;
    }
    public VoipReader setInPostalCode(final String inPostalCode){
        this.inPostalCode = inPostalCode;
        return this;
    }
    public VoipReader setInRegion(final String inRegion){
        this.inRegion = inRegion;
        return this;
    }
    public VoipReader setInRateCenter(final String inRateCenter){
        this.inRateCenter = inRateCenter;
        return this;
    }
    public VoipReader setInLata(final String inLata){
        this.inLata = inLata;
        return this;
    }
    public VoipReader setInLocality(final String inLocality){
        this.inLocality = inLocality;
        return this;
    }
    public VoipReader setFaxEnabled(final Boolean faxEnabled){
        this.faxEnabled = faxEnabled;
        return this;
    }
    public VoipReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Voip> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Voip> firstPage(final TwilioRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/AvailablePhoneNumbers/{CountryCode}/Voip.json";
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        path = path.replace("{"+"AccountSid"+"}", this.pathAccountSid.toString());
        path = path.replace("{"+"CountryCode"+"}", this.pathCountryCode.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Voip> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Voip read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "available_phone_numbers",
            response.getContent(),
            Voip.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Voip> previousPage(final Page<Voip> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<Voip> nextPage(final Page<Voip> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Voip> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (areaCode != null) {
    
            request.addQueryParam("AreaCode", areaCode.toString());
        }
        if (contains != null) {
    
            request.addQueryParam("Contains", contains);
        }
        if (smsEnabled != null) {
    
            request.addQueryParam("SmsEnabled", smsEnabled.toString());
        }
        if (mmsEnabled != null) {
    
            request.addQueryParam("MmsEnabled", mmsEnabled.toString());
        }
        if (voiceEnabled != null) {
    
            request.addQueryParam("VoiceEnabled", voiceEnabled.toString());
        }
        if (excludeAllAddressRequired != null) {
    
            request.addQueryParam("ExcludeAllAddressRequired", excludeAllAddressRequired.toString());
        }
        if (excludeLocalAddressRequired != null) {
    
            request.addQueryParam("ExcludeLocalAddressRequired", excludeLocalAddressRequired.toString());
        }
        if (excludeForeignAddressRequired != null) {
    
            request.addQueryParam("ExcludeForeignAddressRequired", excludeForeignAddressRequired.toString());
        }
        if (beta != null) {
    
            request.addQueryParam("Beta", beta.toString());
        }
        if (nearNumber != null) {
    
            request.addQueryParam("NearNumber", nearNumber.toString());
        }
        if (nearLatLong != null) {
    
            request.addQueryParam("NearLatLong", nearLatLong);
        }
        if (distance != null) {
    
            request.addQueryParam("Distance", distance.toString());
        }
        if (inPostalCode != null) {
    
            request.addQueryParam("InPostalCode", inPostalCode);
        }
        if (inRegion != null) {
    
            request.addQueryParam("InRegion", inRegion);
        }
        if (inRateCenter != null) {
    
            request.addQueryParam("InRateCenter", inRateCenter);
        }
        if (inLata != null) {
    
            request.addQueryParam("InLata", inLata);
        }
        if (inLocality != null) {
    
            request.addQueryParam("InLocality", inLocality);
        }
        if (faxEnabled != null) {
    
            request.addQueryParam("FaxEnabled", faxEnabled.toString());
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if(getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
