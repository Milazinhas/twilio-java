/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace.worker;

import com.twilio.base.Fetcher;
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

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.twilio.converter.DateConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.ToString;

public class WorkersStatisticsFetcher extends Fetcher<WorkersStatistics> {
    private String pathWorkspaceSid;
    private Integer minutes;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String taskQueueSid;
    private String taskQueueName;
    private String friendlyName;
    private String taskChannel;

    public WorkersStatisticsFetcher(final String pathWorkspaceSid){
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    public WorkersStatisticsFetcher setMinutes(final Integer minutes){
        this.minutes = minutes;
        return this;
    }
    public WorkersStatisticsFetcher setStartDate(final ZonedDateTime startDate){
        this.startDate = startDate;
        return this;
    }
    public WorkersStatisticsFetcher setEndDate(final ZonedDateTime endDate){
        this.endDate = endDate;
        return this;
    }
    public WorkersStatisticsFetcher setTaskQueueSid(final String taskQueueSid){
        this.taskQueueSid = taskQueueSid;
        return this;
    }
    public WorkersStatisticsFetcher setTaskQueueName(final String taskQueueName){
        this.taskQueueName = taskQueueName;
        return this;
    }
    public WorkersStatisticsFetcher setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public WorkersStatisticsFetcher setTaskChannel(final String taskChannel){
        this.taskChannel = taskChannel;
        return this;
    }

    @Override
    public WorkersStatistics fetch(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Workers/Statistics";

        path = path.replace("{"+"WorkspaceSid"+"}", this.pathWorkspaceSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            path
        );
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("WorkersStatistics fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return WorkersStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addQueryParams(final Request request) {
        if (minutes != null) {
    
            request.addQueryParam("Minutes", minutes.toString());
        }
        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toInstant().toString());
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (taskQueueSid != null) {
    
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }
        if (taskQueueName != null) {
    
            request.addQueryParam("TaskQueueName", taskQueueName);
        }
        if (friendlyName != null) {
    
            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (taskChannel != null) {
    
            request.addQueryParam("TaskChannel", taskChannel);
        }
    }
}
