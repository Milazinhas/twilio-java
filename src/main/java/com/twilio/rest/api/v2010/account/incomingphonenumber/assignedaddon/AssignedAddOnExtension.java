/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber.assignedaddon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssignedAddOnExtension extends Resource {
    private static final long serialVersionUID = 254756104668429L;

    /**
     * Create a AssignedAddOnExtensionFetcher to execute fetch.
     * 
     * @param pathAccountSid The SID of the Account that created the resource to
     *                       fetch
     * @param pathResourceSid The SID of the Phone Number to which the Add-on is
     *                        assigned
     * @param pathAssignedAddOnSid The SID that uniquely identifies the assigned
     *                             Add-on installation
     * @param pathSid The unique string that identifies the resource
     * @return AssignedAddOnExtensionFetcher capable of executing the fetch
     */
    public static AssignedAddOnExtensionFetcher fetcher(final String pathAccountSid, 
                                                        final String pathResourceSid, 
                                                        final String pathAssignedAddOnSid, 
                                                        final String pathSid) {
        return new AssignedAddOnExtensionFetcher(pathAccountSid, pathResourceSid, pathAssignedAddOnSid, pathSid);
    }

    /**
     * Create a AssignedAddOnExtensionFetcher to execute fetch.
     * 
     * @param pathResourceSid The SID of the Phone Number to which the Add-on is
     *                        assigned
     * @param pathAssignedAddOnSid The SID that uniquely identifies the assigned
     *                             Add-on installation
     * @param pathSid The unique string that identifies the resource
     * @return AssignedAddOnExtensionFetcher capable of executing the fetch
     */
    public static AssignedAddOnExtensionFetcher fetcher(final String pathResourceSid, 
                                                        final String pathAssignedAddOnSid, 
                                                        final String pathSid) {
        return new AssignedAddOnExtensionFetcher(pathResourceSid, pathAssignedAddOnSid, pathSid);
    }

    /**
     * Create a AssignedAddOnExtensionReader to execute read.
     * 
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @param pathResourceSid The SID of the Phone Number to which the Add-on is
     *                        assigned
     * @param pathAssignedAddOnSid The SID that uniquely identifies the assigned
     *                             Add-on installation
     * @return AssignedAddOnExtensionReader capable of executing the read
     */
    public static AssignedAddOnExtensionReader reader(final String pathAccountSid, 
                                                      final String pathResourceSid, 
                                                      final String pathAssignedAddOnSid) {
        return new AssignedAddOnExtensionReader(pathAccountSid, pathResourceSid, pathAssignedAddOnSid);
    }

    /**
     * Create a AssignedAddOnExtensionReader to execute read.
     * 
     * @param pathResourceSid The SID of the Phone Number to which the Add-on is
     *                        assigned
     * @param pathAssignedAddOnSid The SID that uniquely identifies the assigned
     *                             Add-on installation
     * @return AssignedAddOnExtensionReader capable of executing the read
     */
    public static AssignedAddOnExtensionReader reader(final String pathResourceSid, 
                                                      final String pathAssignedAddOnSid) {
        return new AssignedAddOnExtensionReader(pathResourceSid, pathAssignedAddOnSid);
    }

    /**
     * Converts a JSON String into a AssignedAddOnExtension object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return AssignedAddOnExtension object represented by the provided JSON
     */
    public static AssignedAddOnExtension fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssignedAddOnExtension.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a AssignedAddOnExtension object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return AssignedAddOnExtension object represented by the provided JSON
     */
    public static AssignedAddOnExtension fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, AssignedAddOnExtension.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String resourceSid;
    private final String assignedAddOnSid;
    private final String friendlyName;
    private final String productName;
    private final String uniqueName;
    private final String uri;
    private final Boolean enabled;

    @JsonCreator
    private AssignedAddOnExtension(@JsonProperty("sid")
                                   final String sid, 
                                   @JsonProperty("account_sid")
                                   final String accountSid, 
                                   @JsonProperty("resource_sid")
                                   final String resourceSid, 
                                   @JsonProperty("assigned_add_on_sid")
                                   final String assignedAddOnSid, 
                                   @JsonProperty("friendly_name")
                                   final String friendlyName, 
                                   @JsonProperty("product_name")
                                   final String productName, 
                                   @JsonProperty("unique_name")
                                   final String uniqueName, 
                                   @JsonProperty("uri")
                                   final String uri, 
                                   @JsonProperty("enabled")
                                   final Boolean enabled) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.resourceSid = resourceSid;
        this.assignedAddOnSid = assignedAddOnSid;
        this.friendlyName = friendlyName;
        this.productName = productName;
        this.uniqueName = uniqueName;
        this.uri = uri;
        this.enabled = enabled;
    }

    /**
     * Returns The The unique string that identifies the resource.
     * 
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     * 
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The SID of the Phone Number to which the Add-on is assigned.
     * 
     * @return The SID of the Phone Number to which the Add-on is assigned
     */
    public final String getResourceSid() {
        return this.resourceSid;
    }

    /**
     * Returns The The SID that uniquely identifies the assigned Add-on
     * installation.
     * 
     * @return The SID that uniquely identifies the assigned Add-on installation
     */
    public final String getAssignedAddOnSid() {
        return this.assignedAddOnSid;
    }

    /**
     * Returns The The string that you assigned to describe the resource.
     * 
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The A string that you assigned to describe the Product this Extension
     * is used within.
     * 
     * @return A string that you assigned to describe the Product this Extension is
     *         used within
     */
    public final String getProductName() {
        return this.productName;
    }

    /**
     * Returns The An application-defined string that uniquely identifies the
     * resource.
     * 
     * @return An application-defined string that uniquely identifies the resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The The URI of the resource, relative to `https://api.twilio.com`.
     * 
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The Whether the Extension will be invoked.
     * 
     * @return Whether the Extension will be invoked
     */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssignedAddOnExtension other = (AssignedAddOnExtension) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(resourceSid, other.resourceSid) && 
               Objects.equals(assignedAddOnSid, other.assignedAddOnSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(productName, other.productName) && 
               Objects.equals(uniqueName, other.uniqueName) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(enabled, other.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            resourceSid,
                            assignedAddOnSid,
                            friendlyName,
                            productName,
                            uniqueName,
                            uri,
                            enabled);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("resourceSid", resourceSid)
                          .add("assignedAddOnSid", assignedAddOnSid)
                          .add("friendlyName", friendlyName)
                          .add("productName", productName)
                          .add("uniqueName", uniqueName)
                          .add("uri", uri)
                          .add("enabled", enabled)
                          .toString();
    }
}