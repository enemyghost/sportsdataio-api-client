package io.github.enemyghost.sportsdata.api.client.cbb;

import io.github.enemyghost.sportsdata.api.client.cbb.entities.Conference;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Player;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.PlayerGame;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Season;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Stadium;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Team;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static io.github.enemyghost.sportsdata.api.client.util.DateFormatUtils.toDatePathParam;

/**
 * Feign-annotated API Client for the sportsdata.io NCAA Men's Basketball (CBB) API.
 * <p>
 * Note that {@link Optional#empty()} responses are used when API returns a 404 status code.
 *
 * @author enemyghost
 * @see <a href="https://sportsdata.io/developers/api-documentation/ncaa-basketball">sportsdata.io</a> for API docs.
 * @see feign.optionals.OptionalDecoder
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("v3/cbb")
public interface NcaaBasketballV3ApiClient {
    /**
     * Returns true if there is at least one game being played at the time of the request
     *
     * @return true if any games are currently in progress, false otherwise
     */
    @GET
    @Path("/scores/json/AreAnyGamesInProgress")
    boolean areAnyGamesInProgress();

    /**
     * Returns the current {@link Season} for NCAA Men's Basketball
     *
     * @return current {@link Season}, or {@link Optional#empty()} if there is no current season
     */
    @GET
    @Path("/scores/json/CurrentSeason")
    Optional<Season> currentSeason();

    /**
     * Returns the conference and team hierarchy for NCAA Men's Basketball
     *
     * @return list of {@link Conference}s
     */
    @GET
    @Path("/scores/json/LeagueHierarchy")
    List<Conference> leagueHierarchy();

    /**
     * Returns all available players in NCAA Men's Basketball
     *
     * @return list of all available {@link Player}s
     */
    @GET
    @Path("/scores/json/Players")
    List<Player> players();

    /**
     * Returns all available players on the given team
     *
     * @param teamKey {@code key} abbreviation for the team
     * @return all available players on the given team
     */
    @GET
    @Path("/scores/json/Players/{teamKey}")
    List<Player> players(@PathParam("teamKey") final String teamKey);

    /**
     * Returns all available players on the given {@link Team}. Delegates to {@link NcaaBasketballV3ApiClient#players(String)}
     *
     * @param team {@link Team} to get players
     * @return all available players on the given {@link Team}
     */
    default List<Player> players(final Team team) {
        return players(team.getKey());
    }

    /**
     * Returns detailed {@link Player} information for the given {@code playerId}
     *
     * @param playerId player ID to fetch
     * @return {@link Player} if found, otherwise {@link Optional#empty()}
     */
    @GET
    @Path("/scores/json/Player/{playerId}")
    Optional<Player> player(@PathParam("playerId") final int playerId);

    /**
     * Returns all available stadiums hosting NCAA Men's Basketball games
     *
     * @return all available {@link Stadium}s
     */
    @GET
    @Path("/scores/json/Stadiums")
    List<Stadium> stadiums();

    /**
     * Returns all available NCAA Men's basketball teams
     *
     * @return all available {@link Team}
     */
    @GET
    @Path("/scores/json/Teams")
    List<Team> teams();

    /**
     * Gets a player's game stats for games which started in the past.
     *
     * @param playerId id of the player
     * @param date     date the game was played in format {@code "yyyy-MMM-dd".toUpperCase()}
     * @return player's game stats for the given day
     */
    @GET
    @Path("/stats/json/PlayerGameStatsByPlayer/{date}/{playerId}")
    Optional<PlayerGame> playerGameStatsByPlayer(@PathParam("playerId") final int playerId,
                                                 @PathParam("date") final String date);

    /**
     * Gets a player's game stats for games which started in the past.
     *
     * @param playerId id of the player
     * @param date     date the game was played
     * @return player's game stats for the given day, or {@link Optional#empty()} if none found
     */
    default Optional<PlayerGame> playerGameStatsByPlayer(final int playerId, final LocalDate date) {
        return playerGameStatsByPlayer(playerId, toDatePathParam(date));
    }

    /**
     * Gets all players' game stats for games which started in the past.
     *
     * @param date date the games were played in format {@code "yyyy-MMM-dd".toUpperCase()}
     * @return all players' game stats for games which started in the past.
     */
    @GET
    @Path("/stats/json/PlayerGameStatsByDate/{date}")
    List<PlayerGame> playerGameStatsByDate(@PathParam("date") final String date);

    /**
     * Gets all players' game stats for games which started in the past.
     *
     * @param date date the games were played
     * @return all players' game stats for games which started in the past.
     */
    default List<PlayerGame> playerGameStatsByDate(final LocalDate date) {
        return playerGameStatsByDate(toDatePathParam(date));
    }

    /**
     * Gets a player's projected game stats for games which start in the future
     *
     * @param playerId id of the player
     * @param date     date the game was played in format {@code "yyyy-MMM-dd".toUpperCase()}
     * @return player's projected game stats for the given day, or {@link Optional#empty()} if none found
     */
    @GET
    @Path("/stats/json/PlayerGameProjectionStatsByPlayer/{date}/{playerId}")
    Optional<PlayerGame> playerGameProjectionStatsByPlayer(@PathParam("playerId") final int playerId,
                                                           @PathParam("date") final String date);

    /**
     * Gets a player's projected game stats for games which start in the future
     *
     * @param playerId id of the player
     * @param date     date the game was played
     * @return player's projected game stats for the given day, or {@link Optional#empty()} if none found
     */
    default Optional<PlayerGame> playerGameProjectionStatsByPlayer(final int playerId, final LocalDate date) {
        return playerGameProjectionStatsByPlayer(playerId, toDatePathParam(date));
    }

    /**
     * Gets all players' projected game stats for games which start in the future
     *
     * @param date date the games were played in format {@code "yyyy-MMM-dd".toUpperCase()}
     * @return all players' projected game stats for games which start in the future
     */
    @GET
    @Path("/stats/json/PlayerGameProjectionStatsByDate/{date}")
    List<PlayerGame> playerGameProjectionStatsByDate(@PathParam("date") final String date);

    /**
     * Gets all players' projected game stats for games which start in the future
     *
     * @param date date the games were played
     * @return all players' projected game stats for games which start in the future
     */
    default List<PlayerGame> playerGameProjectionStatsByDate(final LocalDate date) {
        return playerGameProjectionStatsByDate(toDatePathParam(date));
    }
}
