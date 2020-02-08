package io.github.enemyghost.sportsdata.api.client.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utilities for formatting dates for sportsdata.io endpoints.
 *
 * @author enemyghost
 */
public final class DateFormatUtils {
    private static final DateTimeFormatter DATE_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    private DateFormatUtils() {
    }

    /**
     * Formats the {@link LocalDate} for use in path parameters sportsdata.io endpoints.
     *
     * @param localDate {@link LocalDate} to format
     * @return formatted date string
     */
    public static String toDatePathParam(final LocalDate localDate) {
        return DATE_PARAM_FORMATTER.format(localDate).toUpperCase();
    }
}
