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

package com.twilio.rest.insights.v1;

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

public class RoomReader extends Reader<Room> {
    private List<Room.RoomType> roomType;
    private List<Room.Codec> codec;
    private String roomName;
    private ZonedDateTime createdAfter;
    private ZonedDateTime createdBefore;
    private Integer pageSize;

    public RoomReader(){
    }

    public RoomReader setRoomType(final List<Room.RoomType> roomType){
        this.roomType = roomType;
        return this;
    }
    public RoomReader setRoomType(final Room.RoomType roomType){
        return setRoomType(Promoter.listOfOne(roomType));
    }
    public RoomReader setCodec(final List<Room.Codec> codec){
        this.codec = codec;
        return this;
    }
    public RoomReader setCodec(final Room.Codec codec){
        return setCodec(Promoter.listOfOne(codec));
    }
    public RoomReader setRoomName(final String roomName){
        this.roomName = roomName;
        return this;
    }
    public RoomReader setCreatedAfter(final ZonedDateTime createdAfter){
        this.createdAfter = createdAfter;
        return this;
    }
    public RoomReader setCreatedBefore(final ZonedDateTime createdBefore){
        this.createdBefore = createdBefore;
        return this;
    }
    public RoomReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Room> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Room> firstPage(final TwilioRestClient client) {
        String path = "/v1/Video/Rooms";

        Request request = new Request(
            HttpMethod.GET,
            Domains.INSIGHTS.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<Room> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Room read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "rooms",
            response.getContent(),
            Room.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Room> previousPage(final Page<Room> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.INSIGHTS.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<Room> nextPage(final Page<Room> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.INSIGHTS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Room> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (roomType != null) {
            for (Room.RoomType prop : roomType) {
                request.addQueryParam("RoomType", prop.toString());
            }
        }
        if (codec != null) {
            for (Room.Codec prop : codec) {
                request.addQueryParam("Codec", prop.toString());
            }
        }
        if (roomName != null) {
    
            request.addQueryParam("RoomName", roomName);
        }
        if (createdAfter != null) {
            request.addQueryParam("CreatedAfter", createdAfter.toInstant().toString());
        }

        if (createdBefore != null) {
            request.addQueryParam("CreatedBefore", createdBefore.toInstant().toString());
        }

        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if(getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
