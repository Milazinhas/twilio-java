/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Monitor
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.monitor.v1;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;

public class AlertReader extends Reader<Alert> {

    private String logLevel;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Integer pageSize;

    public AlertReader() {}

    public AlertReader setLogLevel(final String logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public AlertReader setStartDate(final ZonedDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public AlertReader setEndDate(final ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public AlertReader setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Alert> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Alert> firstPage(final TwilioRestClient client) {
        String path = "/v1/Alerts";

        Request request = new Request(
            HttpMethod.GET,
            Domains.MONITOR.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<Alert> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Alert read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "alerts",
            response.getContent(),
            Alert.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Alert> previousPage(
        final Page<Alert> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.MONITOR.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Alert> nextPage(
        final Page<Alert> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.MONITOR.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Alert> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (logLevel != null) {
            request.addQueryParam("LogLevel", logLevel);
        }
        if (startDate != null) {
            request.addQueryParam(
                "StartDate",
                startDate.toInstant().toString()
            );
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
