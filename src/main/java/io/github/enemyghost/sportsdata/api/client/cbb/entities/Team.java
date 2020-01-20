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

    /**
     * The auto-generated unique ID of the Team
     *
     * @return the auto-generated unique ID of the Team
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Abbreviation of the team  (e.g. OU, TTU, USC, UK, etc.), used to reference the team in API endpoints
     *
     * @return abbreviation of the team
     */
    public String getKey() {
        return key;
    }

    /**
     * Whether or not the team is active
     *
     * @return true if the team is currently active, false otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * A globally unique ID for this team. This value is guaranteed to be unique across all sports/leagues.
     *
     * @return a globally unique ID for this team
     */
    public int getGlobalTeamId() {
        return globalTeamId;
    }

    /**
     * The school of the team (e.g. Oklahoma University, Texas Tech University, University of Southern California,
     * Kentucky University, etc)
     *
     * @return the school of the team
     */
    public Optional<String> getSchool() {
        return Optional.ofNullable(school);
    }

    /**
     * The mascot of the team (e.g. Sooners, Red Raiders, Trojans, Wildcats, etc.)
     *
     * @return the mascot of the team
     */
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    /**
     * The AP Rank of the team
     *
     * @return the AP Rank of the team
     */
    public Optional<Integer> getApRank() {
        return Optional.ofNullable(apRank);
    }

    /**
     * The total number of wins by the school
     *
     * @return the total number of wins by the school
     */
    public Optional<Integer> getWins() {
        return Optional.ofNullable(wins);
    }

    /**
     * The total number of losses by the school
     *
     * @return the total number of losses by the school
     */
    public Optional<Integer> getLosses() {
        return Optional.ofNullable(losses);
    }

    /**
     * The total number of conference wins by the school
     *
     * @return the total number of conference wins by the school
     */
    public Optional<Integer> getConferenceWins() {
        return Optional.ofNullable(conferenceWins);
    }

    /**
     * The total number of conference losses by the school
     *
     * @return the total number of conference losses by the school
     */
    public Optional<Integer> getConferenceLosses() {
        return Optional.ofNullable(conferenceLosses);
    }

    /**
     * The ID of the team's conference
     *
     * @return the ID of the team's conference
     */
    public Optional<Integer> getConferenceId() {
        return Optional.ofNullable(conferenceId);
    }

    /**
     * The name of the team's conference
     *
     * @return the name of the team's conference
     */
    public Optional<String> getConference() {
        return Optional.ofNullable(conference);
    }

    /**
     * The url of the team logo image
     *
     * @return the url of the team logo image
     */
    public Optional<String> getTeamLogoUrl() {
        return Optional.ofNullable(teamLogoUrl);
    }

    /**
     * The short display name of the team
     *
     * @return the short display name of the team
     */
    public Optional<String> getShortDisplayName() {
        return Optional.ofNullable(shortDisplayName);
    }

    /**
     * The home stadium of the team
     *
     * @return the home stadium of the team
     */
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
