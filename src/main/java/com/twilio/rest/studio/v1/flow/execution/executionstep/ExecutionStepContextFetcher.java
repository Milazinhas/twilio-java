/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.studio.v1.flow.execution.executionstep;

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

public class ExecutionStepContextFetcher extends Fetcher<ExecutionStepContext> {
    private String pathFlowSid;
    private String pathExecutionSid;
    private String pathStepSid;

    public ExecutionStepContextFetcher(final String pathFlowSid, final String pathExecutionSid, final String pathStepSid){
        this.pathFlowSid = pathFlowSid;
        this.pathExecutionSid = pathExecutionSid;
        this.pathStepSid = pathStepSid;
    }


    @Override
    public ExecutionStepContext fetch(final TwilioRestClient client) {
        String path = "/v1/Flows/{FlowSid}/Executions/{ExecutionSid}/Steps/{StepSid}/Context";

        path = path.replace("{"+"FlowSid"+"}", this.pathFlowSid.toString());
        path = path.replace("{"+"ExecutionSid"+"}", this.pathExecutionSid.toString());
        path = path.replace("{"+"StepSid"+"}", this.pathStepSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.STUDIO.toString(),
            path
        );
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("ExecutionStepContext fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ExecutionStepContext.fromJson(response.getStream(), client.getObjectMapper());
    }
}
