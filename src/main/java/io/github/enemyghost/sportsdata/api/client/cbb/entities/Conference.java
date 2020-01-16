package io.github.enemyghost.sportsdata.api.client.cbb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Conference.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static io.github.enemyghost.lang.PreconditionUtils.requireNonEmpty;
import static java.util.Objects.requireNonNull;

/**
 * POJO representing an NCAA Men's Basketball conference
 *
 * @author enemyghost
 */
@JsonDeserialize(builder = Builder.class)
public class Conference {
    private final int conferenceId;
    private final String name;
    private final List<Team> teams;

    private Conference(final Builder builder) {
        conferenceId = builder.conferenceId;
        name = builder.name;
        teams = List.copyOf(builder.teams);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getConferenceId() {
        return conferenceId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Conference that = (Conference) o;
        return conferenceId == that.conferenceId &&
                Objects.equals(name, that.name) &&
                Objects.equals(teams, that.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId, name, teams);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Conference.class.getSimpleName() + "[", "]")
                .add("conferenceId=" + conferenceId)
                .add("name='" + name + "'")
                .add("teams=" + teams)
                .toString();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer conferenceId;
        private String name;
        private List<Team> teams;

        private Builder() {
            teams = new ArrayList<>();
        }

        public Builder withConferenceID(final int val) {
            conferenceId = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withTeams(final List<Team> val) {
            teams = val == null ? new ArrayList<>() : val;
            return this;
        }

        public Conference build() {
            requireNonNull(conferenceId, "Conference ID is not nullable");
            requireNonEmpty(name, "Name is not nullable");

            return new Conference(this);
        }
    }
}
