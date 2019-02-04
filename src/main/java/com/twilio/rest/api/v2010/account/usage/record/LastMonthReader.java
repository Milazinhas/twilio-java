/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.usage.record;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.LocalDate;

public class LastMonthReader extends Reader<LastMonth> {
    private String pathAccountSid;
    private LastMonth.Category category;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean includeSubaccounts;

    /**
     * Construct a new LastMonthReader.
     */
    public LastMonthReader() {
    }

    /**
     * Construct a new LastMonthReader.
     * 
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     */
    public LastMonthReader(final String pathAccountSid) {
        this.pathAccountSid = pathAccountSid;
    }

    /**
     * The [usage
     * category](https://www.twilio.com/docs/api/rest/usage-records#usage-categories) of the UsageRecord resources to read. Only UsageRecord resources in the specified category are retrieved..
     * 
     * @param category The usage category of the UsageRecord resources to read
     * @return this
     */
    public LastMonthReader setCategory(final LastMonth.Category category) {
        this.category = category;
        return this;
    }

    /**
     * Only include usage that has occurred on or after this date. Specify the date
     * in GMT and format as `YYYY-MM-DD`. You can also specify offsets from the
     * current date, such as: `-30days`, which will set the start date to be 30 days
     * before the current date..
     * 
     * @param startDate Only include usage that has occurred on or after this date
     * @return this
     */
    public LastMonthReader setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Only include usage that occurred on or before this date. Specify the date in
     * GMT and format as `YYYY-MM-DD`.  You can also specify offsets from the
     * current date, such as: `+30days`, which will set the end date to 30 days from
     * the current date..
     * 
     * @param endDate Only include usage that occurred on or before this date
     * @return this
     */
    public LastMonthReader setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Whether to include usage from the master account and all its subaccounts. Can
     * be: `true` (the default) to include usage from the master account and all
     * subaccounts or `false` to retrieve usage from only the specified account..
     * 
     * @param includeSubaccounts Whether to include usage from the master account
     *                           and all its subaccounts
     * @return this
     */
    public LastMonthReader setIncludeSubaccounts(final Boolean includeSubaccounts) {
        this.includeSubaccounts = includeSubaccounts;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return LastMonth ResourceSet
     */
    @Override
    public ResourceSet<LastMonth> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return LastMonth ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<LastMonth> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Usage/Records/LastMonth.json",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     * 
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return LastMonth ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<LastMonth> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<LastMonth> nextPage(final Page<LastMonth> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<LastMonth> previousPage(final Page<LastMonth> page, 
                                        final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of LastMonth Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<LastMonth> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("LastMonth read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Page.fromJson(
            "usage_records",
            response.getContent(),
            LastMonth.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (category != null) {
            request.addQueryParam("Category", category.toString());
        }

        if (startDate != null) {
            request.addQueryParam("StartDate", DateConverter.dateStringFromLocalDate(startDate));
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", DateConverter.dateStringFromLocalDate(endDate));
        }

        if (includeSubaccounts != null) {
            request.addQueryParam("IncludeSubaccounts", includeSubaccounts.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}