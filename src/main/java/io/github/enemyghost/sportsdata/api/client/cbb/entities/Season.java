package io.github.enemyghost.sportsdata.api.client.cbb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Season.Builder;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;

/**
 * POJO representing a season of NCAA Men's Basketball
 *
 * @author enemyghost
 */
@JsonDeserialize(builder = Builder.class)
public class Season {
    private final int season;
    private final int startYear;
    private final int endYear;
    private final String description;
    private final LocalDate regularSeasonStartDate;
    private final LocalDate postSeasonStartDate;
    private final String apiSeason;

    private Season(final Builder builder) {
        season = builder.season;
        startYear = builder.startYear;
        endYear = builder.endYear;
        description = builder.description;
        regularSeasonStartDate = builder.regularSeasonStartDate;
        postSeasonStartDate = builder.postSeasonStartDate;
        apiSeason = builder.apiSeason;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The college basketball season of the game
     *
     * @return college basketball season of the game
     */
    public int getSeason() {
        return season;
    }

    /**
     * The year in which the season started
     *
     * @return year in which the season started
     */
    public int getStartYear() {
        return startYear;
    }

    /**
     * The year in which the season ended
     *
     * @return year in which the season ended
     */
    public int getEndYear() {
        return endYear;
    }

    /**
     * The description of the season, if provided.
     *
     * @return description of the season, or {@link Optional#empty()} if none provided
     */
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    /**
     * The start date of the regular season, if provided.
     *
     * @return start time of the regular season, or {@link Optional#empty()} if none provided
     */
    public Optional<LocalDate> getRegularSeasonStartDate() {
        return Optional.ofNullable(regularSeasonStartDate);
    }

    /**
     * The start date of the post season, if provided.
     *
     * @return start time of the post season, or {@link Optional#empty()} if none provided
     */
    public Optional<LocalDate> getPostSeasonStartDate() {
        return Optional.ofNullable(postSeasonStartDate);
    }

    /**
     * The string to pass into subsequent API calls in the season parameter, if provided
     *
     * @return string to pass into subsequent API calls in the season parameter, or {@link Optional#empty()} if none provided
     */
    public Optional<String> getApiSeason() {
        return Optional.ofNullable(apiSeason);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Season season1 = (Season) o;
        return season == season1.season &&
                startYear == season1.startYear &&
                endYear == season1.endYear &&
                Objects.equals(description, season1.description) &&
                Objects.equals(regularSeasonStartDate, season1.regularSeasonStartDate) &&
                Objects.equals(postSeasonStartDate, season1.postSeasonStartDate) &&
                Objects.equals(apiSeason, season1.apiSeason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(season, startYear, endYear, description, regularSeasonStartDate, postSeasonStartDate, apiSeason);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Season.class.getSimpleName() + "[", "]")
                .add("season=" + season)
                .add("startYear=" + startYear)
                .add("endYear=" + endYear)
                .add("description='" + description + "'")
                .add("regularSeasonStartDate=" + regularSeasonStartDate)
                .add("postSeasonStartDate=" + postSeasonStartDate)
                .add("apiSeason='" + apiSeason + "'")
                .toString();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer season;
        private Integer startYear;
        private Integer endYear;
        private String description;
        private LocalDate regularSeasonStartDate;
        private LocalDate postSeasonStartDate;
        private String apiSeason;

        private Builder() {
        }

        public Builder withSeason(final int val) {
            season = val;
            return this;
        }

        public Builder withStartYear(final int val) {
            startYear = val;
            return this;
        }

        public Builder withEndYear(final int val) {
            endYear = val;
            return this;
        }

        public Builder withDescription(final String val) {
            description = val;
            return this;
        }

        public Builder withRegularSeasonStartDate(final LocalDate val) {
            regularSeasonStartDate = val;
            return this;
        }

        public Builder withPostSeasonStartDate(final LocalDate val) {
            postSeasonStartDate = val;
            return this;
        }

        public Builder withApiSeason(final String val) {
            apiSeason = val;
            return this;
        }

        public Season build() {
            requireNonNull(season, "Season is not nullable");
            requireNonNull(startYear, "Start year is not nullable");
            requireNonNull(endYear, "End year is not nullable");

            return new Season(this);
        }
    }
}
