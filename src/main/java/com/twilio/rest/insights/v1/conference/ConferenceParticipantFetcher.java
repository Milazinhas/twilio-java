/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Insights
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.insights.v1.conference;

import com.twilio.base.Fetcher;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ConferenceParticipantFetcher
    extends Fetcher<ConferenceParticipant> {

    private String pathConferenceSid;
    private String pathParticipantSid;
    private String events;
    private String metrics;

    public ConferenceParticipantFetcher(
        final String pathConferenceSid,
        final String pathParticipantSid
    ) {
        this.pathConferenceSid = pathConferenceSid;
        this.pathParticipantSid = pathParticipantSid;
    }

    public ConferenceParticipantFetcher setEvents(final String events) {
        this.events = events;
        return this;
    }

    public ConferenceParticipantFetcher setMetrics(final String metrics) {
        this.metrics = metrics;
        return this;
    }

    @Override
    public ConferenceParticipant fetch(final TwilioRestClient client) {
        String path =
            "/v1/Conferences/{ConferenceSid}/Participants/{ParticipantSid}";

        path =
            path.replace(
                "{" + "ConferenceSid" + "}",
                this.pathConferenceSid.toString()
            );
        path =
            path.replace(
                "{" + "ParticipantSid" + "}",
                this.pathParticipantSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.INSIGHTS.toString(),
            path
        );
        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ConferenceParticipant fetch failed: Unable to connect to server"
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

        return ConferenceParticipant.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addQueryParams(final Request request) {
        if (events != null) {
            request.addQueryParam("Events", events);
        }
        if (metrics != null) {
            request.addQueryParam("Metrics", metrics);
        }
    }
}
