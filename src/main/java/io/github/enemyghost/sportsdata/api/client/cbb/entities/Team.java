package io.github.enemyghost.sportsdata.api.client.cbb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Team.Builder;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import static io.github.enemyghost.lang.PreconditionUtils.requireNonEmpty;
import static java.util.Objects.requireNonNull;

/**
 * POJO representing an NCAA Men's Basketball team
 *
 * @author enemyghost
 */
@JsonDeserialize(builder = Builder.class)
public class Team {
    private final int teamId;
    private final String key;
    private final boolean active;
    private final int globalTeamId;
    private final String school;
    private final String name;
    private final Integer apRank;
    private final Integer wins;
    private final Integer losses;
    private final Integer conferenceWins;
    private final Integer conferenceLosses;
    private final Integer conferenceId;
    private final String conference;
    private final String teamLogoUrl;
    private final String shortDisplayName;
    private final Stadium stadium;

    private Team(final Builder builder) {
        teamId = builder.teamId;
        key = builder.key;
        active = builder.active;
        globalTeamId = builder.globalTeamId;
        school = builder.school;
        name = builder.name;
        apRank = builder.apRank;
        wins = builder.wins;
        losses = builder.losses;
        conferenceWins = builder.conferenceWins;
        conferenceLosses = builder.conferenceLosses;
        conferenceId = builder.conferenceId;
        conference = builder.conference;
        teamLogoUrl = builder.teamLogoUrl;
        shortDisplayName = builder.shortDisplayName;
        stadium = builder.stadium;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getTeamId() {
        return teamId;
    }

    public String getKey() {
        return key;
    }

    public boolean isActive() {
        return active;
    }

    public int getGlobalTeamId() {
        return globalTeamId;
    }

    public Optional<String> getSchool() {
        return Optional.ofNullable(school);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getApRank() {
        return Optional.ofNullable(apRank);
    }

    public Optional<Integer> getWins() {
        return Optional.ofNullable(wins);
    }

    public Optional<Integer> getLosses() {
        return Optional.ofNullable(losses);
    }

    public Optional<Integer> getConferenceWins() {
        return Optional.ofNullable(conferenceWins);
    }

    public Optional<Integer> getConferenceLosses() {
        return Optional.ofNullable(conferenceLosses);
    }

    public Optional<Integer> getConferenceId() {
        return Optional.ofNullable(conferenceId);
    }

    public Optional<String> getConference() {
        return Optional.ofNullable(conference);
    }

    public Optional<String> getTeamLogoUrl() {
        return Optional.ofNullable(teamLogoUrl);
    }

    public Optional<String> getShortDisplayName() {
        return Optional.ofNullable(shortDisplayName);
    }

    public Optional<Stadium> getStadium() {
        return Optional.ofNullable(stadium);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Team team = (Team) o;
        return teamId == team.teamId &&
                active == team.active &&
                globalTeamId == team.globalTeamId &&
                Objects.equals(key, team.key) &&
                Objects.equals(school, team.school) &&
                Objects.equals(name, team.name) &&
                Objects.equals(apRank, team.apRank) &&
                Objects.equals(wins, team.wins) &&
                Objects.equals(losses, team.losses) &&
                Objects.equals(conferenceWins, team.conferenceWins) &&
                Objects.equals(conferenceLosses, team.conferenceLosses) &&
                Objects.equals(conferenceId, team.conferenceId) &&
                Objects.equals(conference, team.conference) &&
                Objects.equals(teamLogoUrl, team.teamLogoUrl) &&
                Objects.equals(shortDisplayName, team.shortDisplayName) &&
                Objects.equals(stadium, team.stadium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, key, active, globalTeamId, school, name, apRank, wins, losses, conferenceWins, conferenceLosses, conferenceId, conference, teamLogoUrl, shortDisplayName, stadium);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
                .add("teamId=" + teamId)
                .add("key='" + key + "'")
                .add("active=" + active)
                .add("globalTeamId=" + globalTeamId)
                .add("school='" + school + "'")
                .add("name='" + name + "'")
                .add("apRank=" + apRank)
                .add("wins=" + wins)
                .add("losses=" + losses)
                .add("conferenceWins=" + conferenceWins)
                .add("conferenceLosses=" + conferenceLosses)
                .add("conferenceId=" + conferenceId)
                .add("conference='" + conference + "'")
                .add("teamLogoUrl='" + teamLogoUrl + "'")
                .add("shortDisplayName='" + shortDisplayName + "'")
                .add("stadium=" + stadium)
                .toString();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer teamId;
        private String key;
        private Boolean active;
        private Integer globalTeamId;
        private String school;
        private String name;
        private Integer apRank;
        private Integer wins;
        private Integer losses;
        private Integer conferenceWins;
        private Integer conferenceLosses;
        private Integer conferenceId;
        private String conference;
        private String teamLogoUrl;
        private String shortDisplayName;
        private Stadium stadium;

        private Builder() {
        }

        public Builder withTeamID(final Integer val) {
            teamId = val;
            return this;
        }

        public Builder withKey(final String val) {
            key = val;
            return this;
        }

        public Builder withActive(final boolean val) {
            active = val;
            return this;
        }

        public Builder withGlobalTeamID(final Integer val) {
            globalTeamId = val;
            return this;
        }

        public Builder withSchool(final String val) {
            school = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withApRank(final Integer val) {
            apRank = val;
            return this;
        }

        public Builder withWins(final Integer val) {
            wins = val;
            return this;
        }

        public Builder withLosses(final Integer val) {
            losses = val;
            return this;
        }

        public Builder withConferenceWins(final Integer val) {
            conferenceWins = val;
            return this;
        }

        public Builder withConferenceLosses(final Integer val) {
            conferenceLosses = val;
            return this;
        }

        public Builder withConferenceID(final Integer val) {
            conferenceId = val;
            return this;
        }

        public Builder withConference(final String val) {
            conference = val;
            return this;
        }

        public Builder withTeamLogoUrl(final String val) {
            teamLogoUrl = val;
            return this;
        }

        public Builder withShortDisplayName(final String val) {
            shortDisplayName = val;
            return this;
        }

        public Builder withStadium(final Stadium val) {
            stadium = val;
            return this;
        }

        public Team build() {
            requireNonNull(teamId, "Team ID is not nullable");
            requireNonEmpty(key, "Key is not nullable");
            requireNonNull(active, "Active is not nullable");
            requireNonNull(globalTeamId, "Global Team ID is not nullable");
            return new Team(this);
        }
    }
}
