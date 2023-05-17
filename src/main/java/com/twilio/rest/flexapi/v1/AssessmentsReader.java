/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Flex
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.flexapi.v1;

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

public class AssessmentsReader extends Reader<Assessments> {
    private String token;
    private String segmentId;
    private Integer pageSize;

    public AssessmentsReader(){
    }

    public AssessmentsReader setToken(final String token){
        this.token = token;
        return this;
    }
    public AssessmentsReader setSegmentId(final String segmentId){
        this.segmentId = segmentId;
        return this;
    }
    public AssessmentsReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Assessments> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Assessments> firstPage(final TwilioRestClient client) {
        String path = "/v1/Insights/QualityManagement/Assessments";

        Request request = new Request(
            HttpMethod.GET,
            Domains.FLEXAPI.toString(),
            path
        );

        addQueryParams(request);
        addHeaderParams(request);
        return pageForRequest(client, request);
    }

    private Page<Assessments> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Assessments read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "assessments",
            response.getContent(),
            Assessments.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Assessments> previousPage(final Page<Assessments> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.FLEXAPI.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<Assessments> nextPage(final Page<Assessments> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.FLEXAPI.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Assessments> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addHeaderParams(final Request request) {
        if (token != null) {
            request.addHeaderParam("Token", token);

        }
    }
    private void addQueryParams(final Request request) {
        if (segmentId != null) {
    
            request.addQueryParam("SegmentId", segmentId);
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if(getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
