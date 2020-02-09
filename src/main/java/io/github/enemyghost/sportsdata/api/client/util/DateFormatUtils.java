package io.github.enemyghost.sportsdata.api.client.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Utilities for formatting dates for sportsdata.io endpoints.
 *
 * @author enemyghost
 */
public final class DateFormatUtils {
    private static final DateTimeFormatter DATE_PARAM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
    private static final ZoneId SPORTSDATA_IO_ZONE = ZoneId.of("America/New_York");

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

    /**
     * Converts the {@link LocalDateTime} returned by the sportsdata.io API to an equivalent instant.
     *
     * @param localDateTime {@link LocalDateTime}
     * @return {@link Instant}
     */
    public static Instant toInstant(final LocalDateTime localDateTime) {
        return localDateTime.atZone(SPORTSDATA_IO_ZONE).toInstant();
    }
}
