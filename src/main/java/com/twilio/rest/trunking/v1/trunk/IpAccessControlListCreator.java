/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trunking
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trunking.v1.trunk;

import com.twilio.base.Creator;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import com.twilio.converter.Converter;
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

import java.net.URI;

public class IpAccessControlListCreator extends Creator<IpAccessControlList>{
    private String pathTrunkSid;
    private String ipAccessControlListSid;

    public IpAccessControlListCreator(final String pathTrunkSid, final String ipAccessControlListSid) {
        this.pathTrunkSid = pathTrunkSid;
        this.ipAccessControlListSid = ipAccessControlListSid;
    }

    public IpAccessControlListCreator setIpAccessControlListSid(final String ipAccessControlListSid){
        this.ipAccessControlListSid = ipAccessControlListSid;
        return this;
    }

    @Override
    public IpAccessControlList create(final TwilioRestClient client){
        String path = "/v1/Trunks/{TrunkSid}/IpAccessControlLists";

        path = path.replace("{"+"TrunkSid"+"}", this.pathTrunkSid.toString());
        path = path.replace("{"+"IpAccessControlListSid"+"}", this.ipAccessControlListSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TRUNKING.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("IpAccessControlList creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IpAccessControlList.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (ipAccessControlListSid != null) {
            request.addPostParam("IpAccessControlListSid", ipAccessControlListSid);
    
        }
    }
}
