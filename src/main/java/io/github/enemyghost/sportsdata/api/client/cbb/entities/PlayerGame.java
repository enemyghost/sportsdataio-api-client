package io.github.enemyghost.sportsdata.api.client.cbb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.PlayerGame.Builder;
import io.github.enemyghost.sportsdata.api.client.util.DateFormatUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * POJO representing stats for a player in a particular game.
 *
 * @author enemyghost
 */
@JsonDeserialize(builder = Builder.class)
public class PlayerGame {
    private final int statId;
    private final Integer teamId;
    private final Integer globalTeamId;
    private final Integer gameId;
    private final Integer globalGameId;
    private final Integer playerId;
    private final Integer seasonType;
    private final Integer season;
    private final String name;
    private final String team;
    private final String position;
    private final String injuryStatus;
    private final String injuryBodyPart;
    private final LocalDate injuryStartDate;
    private final String injuryNotes;
    private final Integer opponentId;
    private final Integer globalOpponentId;
    private final String opponent;
    private final Integer opponentRank;
    private final Integer opponentPositionRank;
    private final Instant gameInstant;
    private final String homeOrAway;
    private final boolean isGameOver;
    private final Instant updatedInstant;
    private final Integer games;
    private final String fanDuelPosition;
    private final String draftKingsPosition;
    private final String yahooPosition;

    private PlayerGame(final Builder builder) {
        statId = builder.statId;
        teamId = builder.teamId;
        globalTeamId = builder.globalTeamId;
        gameId = builder.gameId;
        globalGameId = builder.globalGameId;
        playerId = builder.playerId;
        seasonType = builder.seasonType;
        season = builder.season;
        name = builder.name;
        team = builder.team;
        position = builder.position;
        injuryStatus = builder.injuryStatus;
        injuryBodyPart = builder.injuryBodyPart;
        injuryStartDate = builder.injuryStartDate;
        injuryNotes = builder.injuryNotes;
        opponentId = builder.opponentId;
        globalOpponentId = builder.globalOpponentId;
        opponent = builder.opponent;
        opponentRank = builder.opponentRank;
        opponentPositionRank = builder.opponentPositionRank;
        gameInstant = DateFormatUtils.toInstant(builder.dateTime);
        homeOrAway = builder.homeOrAway;
        isGameOver = builder.isGameOver;
        updatedInstant = DateFormatUtils.toInstant(builder.updated);
        games = builder.games;
        fanDuelPosition = builder.fanDuelPosition;
        draftKingsPosition = builder.draftKingsPosition;
        yahooPosition = builder.yahooPosition;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The unique ID of the stat
     *
     * @return the unique ID of the stat
     */
    public int getStatId() {
        return statId;
    }

    /**
     * The unique ID of the team
     *
     * @return the unique ID of the team
     */
    public Optional<Integer> getGlobalTeamId() {
        return Optional.ofNullable(globalTeamId);
    }

    /**
     * The unique ID of this game
     *
     * @return the unique ID of this game
     */
    public Optional<Integer> getGameId() {
        return Optional.ofNullable(gameId);
    }

    /**
     * A globally unique ID for this game. This value is guaranteed to be unique across all sports/leagues.
     *
     * @return globally unique ID for this game
     */
    public Optional<Integer> getGlobalGameId() {
        return Optional.ofNullable(globalGameId);
    }

    /**
     * Unique ID assigned to each player that stays with them throughout their career
     *
     * @return the unique ID for the player
     */
    public Optional<Integer> getPlayerId() {
        return Optional.ofNullable(playerId);
    }

    /**
     * The type of season that this record corresponds to (1=Regular Season, 2=Preseason, 3=Postseason, 4=Offseason, 5=AllStar).
     *
     * @return the type of season that this record corresponds to
     */
    public Optional<Integer> getSeasonType() {
        return Optional.ofNullable(seasonType);
    }

    /**
     * The college basketball season of the game
     *
     * @return the college basketball season of the game
     */
    public Optional<Integer> getSeason() {
        return Optional.ofNullable(season);
    }

    /**
     * Player's name
     *
     * @return player's name
     */
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    /**
     * The abbreviation of the Team
     *
     * @return the abbreviation of the Team
     */
    public Optional<String> getTeam() {
        return Optional.ofNullable(team);
    }

    /**
     * The player's position associated with the given game or season. Possible values: C, F, FC, G, GF, PF, PG, SF, SG
     *
     * @return player's position associated with the given game or season. Possible values: C, F, FC, G, GF, PF, PG, SF, SG
     */
    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    /**
     * Indicates the player's injury status. Possible values include: Probable, Questionable, Doubtful, Out
     *
     * @return the player's injury status
     */
    public Optional<String> getInjuryStatus() {
        return Optional.ofNullable(injuryStatus);
    }

    /**
     * The body part that is injured (Knee, Groin, Calf, Hamstring, etc.)
     *
     * @return the body part that is injured
     */
    public Optional<String> getInjuryBodyPart() {
        return Optional.ofNullable(injuryBodyPart);
    }

    /**
     * The day that the injury started or first discovered.
     *
     * @return the day that the injury started or first discovered.
     */
    public Optional<LocalDate> getInjuryStartDate() {
        return Optional.ofNullable(injuryStartDate);
    }

    /**
     * Brief description of the player's injury and expected availability
     *
     * @return brief description of the player's injury and expected availability
     */
    public Optional<String> getInjuryNotes() {
        return Optional.ofNullable(injuryNotes);
    }

    /**
     * The unique ID of the team's opponent
     *
     * @return the unique ID of the team's opponent
     */
    public Optional<Integer> getOpponentId() {
        return Optional.ofNullable(opponentId);
    }

    /**
     * A globally unique ID for this team's opponent. This value is guaranteed to be unique across all sports/leagues.
     *
     * @return globally unique ID for this team's opponent
     */
    public Optional<Integer> getGlobalOpponentId() {
        return Optional.ofNullable(globalOpponentId);
    }

    /**
     * The name of the opponent
     *
     * @return the name of the opponent
     */
    public Optional<String> getOpponent() {
        return Optional.ofNullable(opponent);
    }

    /**
     * The ranking of the player's opponent with regards to fantasy points allowed.
     *
     * @return the ranking of the player's opponent with regards to fantasy points allowed
     */
    public Optional<Integer> getOpponentRank() {
        return Optional.ofNullable(opponentRank);
    }

    /**
     * The ranking of the player's opponent by position with regards to fantasy points allowed.
     *
     * @return the ranking of the player's opponent by position with regards to fantasy points allowed.
     */
    public Optional<Integer> getOpponentPositionRank() {
        return Optional.ofNullable(opponentPositionRank);
    }

    /**
     * The date and time of the game
     *
     * @return the date and time of the game
     */
    public Optional<Instant> getGameInstant() {
        return Optional.ofNullable(gameInstant);
    }

    /**
     * Whether the team is home or away
     *
     * @return true if the team is at home, false otherwise
     */
    public Optional<Boolean> isHome() {
        return getHomeOrAway().map(t -> t.equalsIgnoreCase("HOME"));
    }

    /**
     * Whether the team is home or away. Valid values: HOME, AWAY
     *
     * @return whether the team is home or away
     */
    public Optional<String> getHomeOrAway() {
        return Optional.ofNullable(homeOrAway);
    }

    /**
     * Whether the game is over
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * The timestamp of when the record was last updated
     *
     * @return the timestamp of when the record was last updated
     */
    public Optional<Instant> getUpdatedInstant() {
        return Optional.ofNullable(updatedInstant);
    }

    /**
     * The number of games played
     *
     * @return the number of games played.
     */
    public Optional<Integer> getGames() {
        return Optional.ofNullable(games);
    }

    /**
     * The player's eligible position in FanDuel's daily fantasy sports platform
     *
     * @return the player's eligible position in FanDuel's daily fantasy sports platform
     */
    public Optional<String> getFanDuelPosition() {
        return Optional.ofNullable(fanDuelPosition);
    }

    /**
     * The player's eligible position in DraftKings' daily fantasy sports platform
     *
     * @return the player's eligible position in DraftKings' daily fantasy sports platform
     */
    public Optional<String> getDraftKingsPosition() {
        return Optional.ofNullable(draftKingsPosition);
    }

    /**
     * The player's eligible position in Yahoo's daily fantasy sports platform
     *
     * @return the player's eligible position in Yahoo's daily fantasy sports platform
     */
    public Optional<String> getYahooPosition() {
        return Optional.ofNullable(yahooPosition);
    }

    /**
     * The abbreviation of the home team in this matchup
     *
     * @return the abbreviation of the home team in this matchup
     */
    public Optional<String> getHomeTeam() {
        return isHome().flatMap(isHome -> isHome ? getTeam() : getOpponent());
    }

    /**
     * The abbreviation of the away team in this matchup
     *
     * @return the abbreviation of the away team in this matchup
     */
    public Optional<String> getAwayTeam() {
        return isHome().flatMap(isHome -> isHome ? getOpponent() : getTeam());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PlayerGame that = (PlayerGame) o;
        return statId == that.statId &&
                isGameOver == that.isGameOver &&
                Objects.equals(teamId, that.teamId) &&
                Objects.equals(globalTeamId, that.globalTeamId) &&
                Objects.equals(gameId, that.gameId) &&
                Objects.equals(globalGameId, that.globalGameId) &&
                Objects.equals(playerId, that.playerId) &&
                Objects.equals(seasonType, that.seasonType) &&
                Objects.equals(season, that.season) &&
                Objects.equals(name, that.name) &&
                Objects.equals(team, that.team) &&
                Objects.equals(position, that.position) &&
                Objects.equals(injuryStatus, that.injuryStatus) &&
                Objects.equals(injuryBodyPart, that.injuryBodyPart) &&
                Objects.equals(injuryStartDate, that.injuryStartDate) &&
                Objects.equals(injuryNotes, that.injuryNotes) &&
                Objects.equals(opponentId, that.opponentId) &&
                Objects.equals(globalOpponentId, that.globalOpponentId) &&
                Objects.equals(opponent, that.opponent) &&
                Objects.equals(opponentRank, that.opponentRank) &&
                Objects.equals(opponentPositionRank, that.opponentPositionRank) &&
                Objects.equals(gameInstant, that.gameInstant) &&
                Objects.equals(homeOrAway, that.homeOrAway) &&
                Objects.equals(updatedInstant, that.updatedInstant) &&
                Objects.equals(games, that.games) &&
                Objects.equals(fanDuelPosition, that.fanDuelPosition) &&
                Objects.equals(draftKingsPosition, that.draftKingsPosition) &&
                Objects.equals(yahooPosition, that.yahooPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statId, teamId, globalTeamId, gameId, globalGameId, playerId, seasonType, season, name, team, position, injuryStatus, injuryBodyPart, injuryStartDate, injuryNotes, opponentId, globalOpponentId, opponent, opponentRank, opponentPositionRank, gameInstant, homeOrAway, isGameOver, updatedInstant, games, fanDuelPosition, draftKingsPosition, yahooPosition);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PlayerGame.class.getSimpleName() + "[", "]")
                .add("statId=" + statId)
                .add("teamId=" + teamId)
                .add("globalTeamId=" + globalTeamId)
                .add("gameId=" + gameId)
                .add("globalGameId=" + globalGameId)
                .add("playerId=" + playerId)
                .add("seasonType=" + seasonType)
                .add("season=" + season)
                .add("name='" + name + "'")
                .add("team='" + team + "'")
                .add("position='" + position + "'")
                .add("injuryStatus='" + injuryStatus + "'")
                .add("injuryBodyPart='" + injuryBodyPart + "'")
                .add("injuryStartDate=" + injuryStartDate)
                .add("injuryNotes='" + injuryNotes + "'")
                .add("opponentId=" + opponentId)
                .add("globalOpponentId=" + globalOpponentId)
                .add("opponent='" + opponent + "'")
                .add("opponentRank=" + opponentRank)
                .add("opponentPositionRank=" + opponentPositionRank)
                .add("gameInstant=" + gameInstant)
                .add("homeOrAway='" + homeOrAway + "'")
                .add("isGameOver=" + isGameOver)
                .add("updatedInstant=" + updatedInstant)
                .add("games=" + games)
                .add("fanDuelPosition='" + fanDuelPosition + "'")
                .add("draftKingsPosition='" + draftKingsPosition + "'")
                .add("yahooPosition='" + yahooPosition + "'")
                .toString();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer statId;
        private Integer teamId;
        private Integer globalTeamId;
        private Integer gameId;
        private Integer globalGameId;
        private Integer playerId;
        private Integer seasonType;
        private Integer season;
        private String name;
        private String team;
        private String position;
        private String injuryStatus;
        private String injuryBodyPart;
        private LocalDate injuryStartDate;
        private String injuryNotes;
        private Integer opponentId;
        private Integer globalOpponentId;
        private String opponent;
        private Integer opponentRank;
        private Integer opponentPositionRank;
        private LocalDateTime dateTime;
        private String homeOrAway;
        private boolean isGameOver;
        private LocalDateTime updated;
        private Integer games;
        private String fanDuelPosition;
        private String draftKingsPosition;
        private String yahooPosition;

        private Builder() {
        }

        public Builder withStatID(final int val) {
            statId = val;
            return this;
        }

        public Builder withTeamID(final Integer val) {
            teamId = val;
            return this;
        }

        public Builder withGlobalTeamID(final Integer val) {
            globalTeamId = val;
            return this;
        }

        public Builder withGameID(final Integer val) {
            gameId = val;
            return this;
        }

        public Builder withGlobalGameID(final Integer val) {
            globalGameId = val;
            return this;
        }

        public Builder withPlayerID(final Integer val) {
            playerId = val;
            return this;
        }

        public Builder withSeasonType(final Integer val) {
            seasonType = val;
            return this;
        }

        public Builder withSeason(final Integer val) {
            season = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withTeam(final String val) {
            team = val;
            return this;
        }

        public Builder withPosition(final String val) {
            position = val;
            return this;
        }

        public Builder withInjuryStatus(final String val) {
            injuryStatus = val;
            return this;
        }

        public Builder withInjuryBodyPart(final String val) {
            injuryBodyPart = val;
            return this;
        }

        public Builder withInjuryStartDate(final LocalDate val) {
            injuryStartDate = val;
            return this;
        }

        public Builder withInjuryNotes(final String val) {
            injuryNotes = val;
            return this;
        }

        public Builder withOpponentID(final Integer val) {
            opponentId = val;
            return this;
        }

        public Builder withGlobalOpponentID(final Integer val) {
            globalOpponentId = val;
            return this;
        }

        public Builder withOpponent(final String val) {
            opponent = val;
            return this;
        }

        public Builder withOpponentRank(final Integer val) {
            opponentRank = val;
            return this;
        }

        public Builder withOpponentPositionRank(final Integer val) {
            opponentPositionRank = val;
            return this;
        }

        public Builder withDateTime(final LocalDateTime val) {
            dateTime = val;
            return this;
        }

        public Builder withHomeOrAway(final String val) {
            homeOrAway = val;
            return this;
        }

        public Builder withIsGameOver(final boolean val) {
            isGameOver = val;
            return this;
        }

        public Builder withUpdated(final LocalDateTime val) {
            updated = val;
            return this;
        }

        public Builder withGames(final Integer val) {
            games = val;
            return this;
        }

        public Builder withFanDuelPosition(final String val) {
            fanDuelPosition = val;
            return this;
        }

        public Builder withDraftKingsPosition(final String val) {
            draftKingsPosition = val;
            return this;
        }

        public Builder withYahooPosition(final String val) {
            yahooPosition = val;
            return this;
        }

        public PlayerGame build() {
            Objects.requireNonNull(statId, "Stat ID is not nullable");
            return new PlayerGame(this);
        }
    }
}
