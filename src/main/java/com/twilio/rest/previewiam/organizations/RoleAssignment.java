/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Organization Public API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.previewiam.organizations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.bearertoken.Resource;
import com.twilio.converter.Converter;
import java.util.Currency;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.converter.PrefixedCollapsibleMap;
import com.twilio.converter.CurrencyDeserializer;
import com.twilio.exception.ApiConnectionException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.twilio.type.PhoneNumberCapabilities;
import com.twilio.type.FeedbackIssue;
import com.twilio.type.IceServer;
import com.twilio.type.InboundCallPrice;
import com.twilio.type.OutboundPrefixPriceWithOrigin;
import com.twilio.type.OutboundPrefixPrice;
import com.twilio.type.OutboundCallPriceWithOrigin;
import com.twilio.type.PhoneNumberPrice;
import com.twilio.type.InboundSmsPrice;
import com.twilio.type.OutboundSmsPrice;
import com.twilio.type.OutboundCallPrice;
import com.twilio.type.RecordingRule;
import com.twilio.type.SubscribeRule;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class RoleAssignment extends Resource {
    private static final long serialVersionUID = 175566213667704L;

    
        @ToString
        static public class PublicApiCreateRoleAssignmentRequest {
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            @JsonProperty("role_sid")
            @Getter @Setter private String roleSid;

            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            @JsonProperty("scope")
            @Getter @Setter private String scope;

            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            @JsonProperty("identity")
            @Getter @Setter private String identity;

            public PublicApiCreateRoleAssignmentRequest(final String roleSid, final String scope, final String identity ) {
                this.roleSid = roleSid;
                this.scope = scope;
                this.identity = identity;
            }

            public static PublicApiCreateRoleAssignmentRequest fromJson(String jsonString, ObjectMapper mapper) throws IOException {
                return mapper.readValue(jsonString, PublicApiCreateRoleAssignmentRequest.class);
            }
        }

    public static RoleAssignmentCreator creator(final String pathOrganizationSid, final PublicApiCreateRoleAssignmentRequest publicApiCreateRoleAssignmentRequest){
        return new RoleAssignmentCreator(pathOrganizationSid, publicApiCreateRoleAssignmentRequest);
    }

    public static RoleAssignmentDeleter deleter(final String pathOrganizationSid, final String pathRoleAssignmentSid){
        return new RoleAssignmentDeleter(pathOrganizationSid, pathRoleAssignmentSid);
    }

    public static RoleAssignmentReader reader(final String pathOrganizationSid){
        return new RoleAssignmentReader(pathOrganizationSid);
    }

    /**
    * Converts a JSON String into a RoleAssignment object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return RoleAssignment object represented by the provided JSON
    */
    public static RoleAssignment fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RoleAssignment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a RoleAssignment object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return RoleAssignment object represented by the provided JSON
    */
    public static RoleAssignment fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, RoleAssignment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public static String toJson(Object object, ObjectMapper mapper) {
        try {
            return mapper.writeValueAsString(object);
        } catch (final JsonMappingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (JsonProcessingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    private final String sid;
    private final String roleSid;
    private final String scope;
    private final String identity;

    @JsonCreator
    private RoleAssignment(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("role_sid")
        final String roleSid,

        @JsonProperty("scope")
        final String scope,

        @JsonProperty("identity")
        final String identity
    ) {
        this.sid = sid;
        this.roleSid = roleSid;
        this.scope = scope;
        this.identity = identity;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getRoleSid() {
            return this.roleSid;
        }
        public final String getScope() {
            return this.scope;
        }
        public final String getIdentity() {
            return this.identity;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RoleAssignment other = (RoleAssignment) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(roleSid, other.roleSid) &&  Objects.equals(scope, other.scope) &&  Objects.equals(identity, other.identity)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, roleSid, scope, identity);
    }


}

