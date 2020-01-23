/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.bulkExports.export;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
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
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job extends Resource {
    private static final long serialVersionUID = 26365801574783L;

    /**
     * Create a JobFetcher to execute fetch.
     *
     * @param pathJobSid The job_sid
     * @return JobFetcher capable of executing the fetch
     */
    public static JobFetcher fetcher(final String pathJobSid) {
        return new JobFetcher(pathJobSid);
    }

    /**
     * Create a JobDeleter to execute delete.
     *
     * @param pathJobSid The job_sid
     * @return JobDeleter capable of executing the delete
     */
    public static JobDeleter deleter(final String pathJobSid) {
        return new JobDeleter(pathJobSid);
    }

    /**
     * Converts a JSON String into a Job object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Job object represented by the provided JSON
     */
    public static Job fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Job object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Job object represented by the provided JSON
     */
    public static Job fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String resourceType;
    private final String friendlyName;
    private final Map<String, Object> details;
    private final String startDay;
    private final String endDay;
    private final String jobSid;
    private final String webhookUrl;
    private final String webhookMethod;
    private final String email;
    private final URI url;

    @JsonCreator
    private Job(@JsonProperty("resource_type")
                final String resourceType,
                @JsonProperty("friendly_name")
                final String friendlyName,
                @JsonProperty("details")
                final Map<String, Object> details,
                @JsonProperty("start_day")
                final String startDay,
                @JsonProperty("end_day")
                final String endDay,
                @JsonProperty("job_sid")
                final String jobSid,
                @JsonProperty("webhook_url")
                final String webhookUrl,
                @JsonProperty("webhook_method")
                final String webhookMethod,
                @JsonProperty("email")
                final String email,
                @JsonProperty("url")
                final URI url) {
        this.resourceType = resourceType;
        this.friendlyName = friendlyName;
        this.details = details;
        this.startDay = startDay;
        this.endDay = endDay;
        this.jobSid = jobSid;
        this.webhookUrl = webhookUrl;
        this.webhookMethod = webhookMethod;
        this.email = email;
        this.url = url;
    }

    /**
     * Returns The type of communication – Messages, Calls.
     *
     * @return The type of communication – Messages, Calls
     */
    public final String getResourceType() {
        return this.resourceType;
    }

    /**
     * Returns The friendly name specified when creating the job.
     *
     * @return The friendly name specified when creating the job
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns This is a list of the completed, pending, or errored dates within the
     * export time range, with one entry for each status with more than one day in
     * that status.
     *
     * @return This is a list of the completed, pending, or errored dates within
     *         the export time range, with one entry for each status with more than
     *         one day in that status
     */
    public final Map<String, Object> getDetails() {
        return this.details;
    }

    /**
     * Returns The start time for the export specified when creating the job.
     *
     * @return The start time for the export specified when creating the job
     */
    public final String getStartDay() {
        return this.startDay;
    }

    /**
     * Returns The end time for the export specified when creating the job.
     *
     * @return The end time for the export specified when creating the job
     */
    public final String getEndDay() {
        return this.endDay;
    }

    /**
     * Returns The job_sid returned when the export was created.
     *
     * @return The job_sid returned when the export was created
     */
    public final String getJobSid() {
        return this.jobSid;
    }

    /**
     * Returns The optional webhook url called on completion.
     *
     * @return The optional webhook url called on completion
     */
    public final String getWebhookUrl() {
        return this.webhookUrl;
    }

    /**
     * Returns This is the method used to call the webhook.
     *
     * @return This is the method used to call the webhook
     */
    public final String getWebhookMethod() {
        return this.webhookMethod;
    }

    /**
     * Returns The optional email to send the completion notification to.
     *
     * @return The optional email to send the completion notification to
     */
    public final String getEmail() {
        return this.email;
    }

    /**
     * Returns The url.
     *
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Job other = (Job) o;

        return Objects.equals(resourceType, other.resourceType) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(details, other.details) &&
               Objects.equals(startDay, other.startDay) &&
               Objects.equals(endDay, other.endDay) &&
               Objects.equals(jobSid, other.jobSid) &&
               Objects.equals(webhookUrl, other.webhookUrl) &&
               Objects.equals(webhookMethod, other.webhookMethod) &&
               Objects.equals(email, other.email) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceType,
                            friendlyName,
                            details,
                            startDay,
                            endDay,
                            jobSid,
                            webhookUrl,
                            webhookMethod,
                            email,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("resourceType", resourceType)
                          .add("friendlyName", friendlyName)
                          .add("details", details)
                          .add("startDay", startDay)
                          .add("endDay", endDay)
                          .add("jobSid", jobSid)
                          .add("webhookUrl", webhookUrl)
                          .add("webhookMethod", webhookMethod)
                          .add("email", email)
                          .add("url", url)
                          .toString();
    }
}