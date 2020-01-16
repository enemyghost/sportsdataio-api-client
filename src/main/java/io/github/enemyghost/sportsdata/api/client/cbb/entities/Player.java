package io.github.enemyghost.sportsdata.api.client.cbb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Player.Builder;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;

/**
 * POJO representing an NCAA Men's Basketball player
 *
 * @author enemyghost
 */
@JsonDeserialize(builder = Builder.class)
public class Player {
    private final int playerId;
    private final String firstName;
    private final String lastName;
    private final Integer teamId;
    private final String team;
    private final Integer jersey;
    private final String position;
    private final String playerClass;
    private final Integer height;
    private final Integer weight;
    private final String birthCity;
    private final String birthState;
    private final String highSchool;
    private final String sportRadarPlayerId;
    private final Integer rotoworldPlayerId;
    private final Integer rotoWirePlayerId;
    private final Integer fantasyAlarmPlayerId;
    private final Integer globalTeamID;

    private Player(final Builder builder) {
        playerId = builder.playerId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        teamId = builder.teamId;
        team = builder.team;
        jersey = builder.jersey;
        position = builder.position;
        playerClass = builder.playerClass;
        height = builder.height;
        weight = builder.weight;
        birthCity = builder.birthCity;
        birthState = builder.birthState;
        highSchool = builder.highSchool;
        sportRadarPlayerId = builder.sportRadarPlayerId;
        rotoworldPlayerId = builder.rotoworldPlayerId;
        rotoWirePlayerId = builder.rotoWirePlayerId;
        fantasyAlarmPlayerId = builder.fantasyAlarmPlayerId;
        globalTeamID = builder.globalTeamID;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getPlayerId() {
        return playerId;
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<Integer> getTeamId() {
        return Optional.ofNullable(teamId);
    }

    public Optional<String> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Integer> getJersey() {
        return Optional.ofNullable(jersey);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<String> getPlayerClass() {
        return Optional.ofNullable(playerClass);
    }

    public Optional<Integer> getHeight() {
        return Optional.ofNullable(height);
    }

    public Optional<Integer> getWeight() {
        return Optional.ofNullable(weight);
    }

    public Optional<String> getBirthCity() {
        return Optional.ofNullable(birthCity);
    }

    public Optional<String> getBirthState() {
        return Optional.ofNullable(birthState);
    }

    public Optional<String> getHighSchool() {
        return Optional.ofNullable(highSchool);
    }

    public Optional<String> getSportRadarPlayerId() {
        return Optional.ofNullable(sportRadarPlayerId);
    }

    public Optional<Integer> getRotoworldPlayerId() {
        return Optional.ofNullable(rotoworldPlayerId);
    }

    public Optional<Integer> getRotoWirePlayerId() {
        return Optional.ofNullable(rotoWirePlayerId);
    }

    public Optional<Integer> getFantasyAlarmPlayerId() {
        return Optional.ofNullable(fantasyAlarmPlayerId);
    }

    public Optional<Integer> getGlobalTeamID() {
        return Optional.ofNullable(globalTeamID);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return playerId == player.playerId &&
                Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName) &&
                Objects.equals(teamId, player.teamId) &&
                Objects.equals(team, player.team) &&
                Objects.equals(jersey, player.jersey) &&
                Objects.equals(position, player.position) &&
                Objects.equals(playerClass, player.playerClass) &&
                Objects.equals(height, player.height) &&
                Objects.equals(weight, player.weight) &&
                Objects.equals(birthCity, player.birthCity) &&
                Objects.equals(birthState, player.birthState) &&
                Objects.equals(highSchool, player.highSchool) &&
                Objects.equals(sportRadarPlayerId, player.sportRadarPlayerId) &&
                Objects.equals(rotoworldPlayerId, player.rotoworldPlayerId) &&
                Objects.equals(rotoWirePlayerId, player.rotoWirePlayerId) &&
                Objects.equals(fantasyAlarmPlayerId, player.fantasyAlarmPlayerId) &&
                Objects.equals(globalTeamID, player.globalTeamID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, firstName, lastName, teamId, team, jersey, position, playerClass, height, weight, birthCity, birthState, highSchool, sportRadarPlayerId, rotoworldPlayerId, rotoWirePlayerId, fantasyAlarmPlayerId, globalTeamID);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
                .add("playerId=" + playerId)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("teamId=" + teamId)
                .add("team='" + team + "'")
                .add("jersey=" + jersey)
                .add("position='" + position + "'")
                .add("playerClass='" + playerClass + "'")
                .add("height=" + height)
                .add("weight=" + weight)
                .add("birthCity='" + birthCity + "'")
                .add("birthState='" + birthState + "'")
                .add("highSchool='" + highSchool + "'")
                .add("sportRadarPlayerId='" + sportRadarPlayerId + "'")
                .add("rotoworldPlayerId=" + rotoworldPlayerId)
                .add("rotoWirePlayerId=" + rotoWirePlayerId)
                .add("fantasyAlarmPlayerId=" + fantasyAlarmPlayerId)
                .add("globalTeamID=" + globalTeamID)
                .toString();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer playerId;
        private String firstName;
        private String lastName;
        private Integer teamId;
        private String team;
        private Integer jersey;
        private String position;
        private String playerClass;
        private Integer height;
        private Integer weight;
        private String birthCity;
        private String birthState;
        private String highSchool;
        private String sportRadarPlayerId;
        private Integer rotoworldPlayerId;
        private Integer rotoWirePlayerId;
        private Integer fantasyAlarmPlayerId;
        private Integer globalTeamID;

        private Builder() {
        }

        public Builder withPlayerID(final Integer val) {
            playerId = val;
            return this;
        }

        public Builder withFirstName(final String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(final String val) {
            lastName = val;
            return this;
        }

        public Builder withTeamID(final Integer val) {
            teamId = val;
            return this;
        }

        public Builder withTeam(final String val) {
            team = val;
            return this;
        }

        public Builder withJersey(final Integer val) {
            jersey = val;
            return this;
        }

        public Builder withPosition(final String val) {
            position = val;
            return this;
        }

        @JsonProperty("Class")
        public Builder withPlayerClass(final String val) {
            playerClass = val;
            return this;
        }

        public Builder withHeight(final Integer val) {
            height = val;
            return this;
        }

        public Builder withWeight(final Integer val) {
            weight = val;
            return this;
        }

        public Builder withBirthCity(final String val) {
            birthCity = val;
            return this;
        }

        public Builder withBirthState(final String val) {
            birthState = val;
            return this;
        }

        public Builder withHighSchool(final String val) {
            highSchool = val;
            return this;
        }

        public Builder withSportRadarPlayerID(final String val) {
            sportRadarPlayerId = val;
            return this;
        }

        public Builder withRotoworldPlayerID(final Integer val) {
            rotoworldPlayerId = val;
            return this;
        }

        public Builder withRotoWirePlayerID(final Integer val) {
            rotoWirePlayerId = val;
            return this;
        }

        public Builder withFantasyAlarmPlayerID(final Integer val) {
            fantasyAlarmPlayerId = val;
            return this;
        }

        public Builder withGlobalTeamID(final Integer val) {
            globalTeamID = val;
            return this;
        }

        public Player build() {
            requireNonNull(playerId, "Player ID is not nullable");
            return new Player(this);
        }
    }
}
