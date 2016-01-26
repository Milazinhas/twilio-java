package com.twilio.sdk.creators.conversations.v1.conversation;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.creators.Creator;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.numbers.PhoneNumber;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.conversations.v1.conversation.Participant;

public class ParticipantCreator extends Creator<Participant> {
    private final String conversationSid;
    private final PhoneNumber to;
    private final PhoneNumber from;

    /**
     * Construct a new ParticipantCreator
     * 
     * @param conversationSid The conversation_sid
     * @param to The to
     * @param from The from
     */
    public ParticipantCreator(final String conversationSid, final PhoneNumber to, final PhoneNumber from) {
        this.conversationSid = conversationSid;
        this.to = to;
        this.from = from;
    }

    /**
     * Make the request to the Twilio API to perform the create
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Participant
     */
    @Override
    public Participant execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            "/v1/Conversations/" + this.conversationSid + "/Participants",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Participant creation failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_CREATED) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Participant.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to.toString());
        }
        
        if (from != null) {
            request.addPostParam("From", from.toString());
        }
    }
}