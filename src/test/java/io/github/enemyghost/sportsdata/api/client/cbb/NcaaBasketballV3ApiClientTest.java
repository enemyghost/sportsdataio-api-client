package io.github.enemyghost.sportsdata.api.client.cbb;

import com.google.common.io.Resources;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import feign.mock.MockTarget;
import io.github.enemyghost.sportsdata.api.client.FeignClientFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link NcaaBasketballV3ApiClient}
 */
class NcaaBasketballV3ApiClientTest {
    private static final String MY_API_KEY = "my-api-key";

    private NcaaBasketballV3ApiClient apiClient;
    private MockClient mockClient;

    @BeforeEach
    void setup() throws IOException {
        mockClient = new MockClient();

        apiClient = FeignClientFactory.createDefaultBuilder(MY_API_KEY, NcaaBasketballV3ApiClient.class)
                .client(mockClient)
                .target(new MockTarget<>(NcaaBasketballV3ApiClient.class));
    }

    @Test
    void testAreAnyGamesInProgress() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/AreAnyGamesInProgress", 200, "true");
        assertTrue(apiClient.areAnyGamesInProgress());
    }

    @Test
    void testAreAnyGamesInProgressFalse() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/AreAnyGamesInProgress", 200, "false");
        assertFalse(apiClient.areAnyGamesInProgress());
    }

    @Test
    void testCurrentSeason() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/CurrentSeason", 200, getResponseFixture("CurrentSeason"));
        assertEquals(Fixtures.CURRENT_SEASON, apiClient.currentSeason().orElseThrow());
    }

    @Test
    void testCurrentSeason404() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/CurrentSeason", 404);
        assertTrue(apiClient.currentSeason().isEmpty());
    }

    @Test
    void testLeagueHierarchy() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/LeagueHierarchy", 200, getResponseFixture("LeagueHierarchy"));
        assertEquals(Fixtures.LEAGUE_HIERARCHY, apiClient.leagueHierarchy());
    }

    @Test
    void testGetAllPlayers() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Players", 200, getResponseFixture("Players"));
        assertEquals(Fixtures.SMU_PLAYERS, apiClient.players());
    }

    @Test
    void testGetAllPlayersForTeam() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Players/SMU", 200, getResponseFixture("Players"));
        assertEquals(Fixtures.SMU_PLAYERS, apiClient.players("SMU"));
    }

    @Test
    void testGetAllPlayersForTeamDelegated() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Players/SMU", 200, getResponseFixture("Players"));
        assertEquals(Fixtures.SMU_PLAYERS, apiClient.players(Fixtures.SMU));
    }

    @Test
    void testGetPlayer() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Player/60007054", 200, getResponseFixture("Player"));
        assertEquals(Fixtures.TYSON_JOLLY, apiClient.player(60007054).orElseThrow());
    }

    @Test
    void testGetPlayer404() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Player/60007054", 404);
        assertTrue(apiClient.player(60007054).isEmpty());
    }

    @Test
    void testGetStadiums() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Stadiums", 200, getResponseFixture("Stadiums"));
        assertEquals(Fixtures.STADIUMS, apiClient.stadiums());
    }

    @Test
    void testGetTeams() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/scores/json/Teams", 200, getResponseFixture("Teams"));
        assertEquals(Fixtures.TEAMS, apiClient.teams());
    }

    @Test
    void testGetPlayerGameProjectionStatsByPlayer() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/stats/json/PlayerGameProjectionStatsByPlayer/2020-FEB-08/60008866", 200, getResponseFixture("PlayerGameProjectionStatsByPlayer"));
        assertEquals(Fixtures.PLAYER_GAME_1, apiClient.playerGameProjectionStatsByPlayer(60008866, LocalDate.of(2020, 2, 8)).orElseThrow());
    }

    @Test
    void testGetPlayerGameProjectionStats404() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/stats/json/PlayerGameProjectionStatsByPlayer/2020-FEB-08/60008866", 404);
        assertTrue(apiClient.playerGameProjectionStatsByPlayer(60008866, LocalDate.of(2020, 2, 8)).isEmpty());
    }

    @Test
    void testGetPlayerGameProjectionStatsByDate() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/stats/json/PlayerGameProjectionStatsByDate/2020-FEB-08", 200, getResponseFixture("PlayerGameProjectionStatsByDate"));
        assertEquals(Fixtures.PLAYER_GAMES, apiClient.playerGameProjectionStatsByDate(LocalDate.of(2020, 2, 8)));
    }

    @Test
    void testGetPlayerGameStatsByPlayer() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/stats/json/PlayerGameStatsByPlayer/2020-FEB-08/60008866", 200, getResponseFixture("PlayerGameProjectionStatsByPlayer"));
        assertEquals(Fixtures.PLAYER_GAME_1, apiClient.playerGameStatsByPlayer(60008866, LocalDate.of(2020, 2, 8)).orElseThrow());
    }

    @Test
    void testGetPlayerGameStats404() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/stats/json/PlayerGameStatsByPlayer/2020-FEB-08/60008866", 404);
        assertTrue(apiClient.playerGameStatsByPlayer(60008866, LocalDate.of(2020, 2, 8)).isEmpty());
    }

    @Test
    void testGetPlayerGameStatsByDate() {
        mockClient.add(HttpMethod.GET, "/v3/cbb/stats/json/PlayerGameStatsByDate/2020-FEB-08", 200, getResponseFixture("PlayerGameProjectionStatsByDate"));
        assertEquals(Fixtures.PLAYER_GAMES, apiClient.playerGameStatsByDate(LocalDate.of(2020, 2, 8)));
    }

    @SuppressWarnings("UnstableApiUsage")
    private static String getResponseFixture(final String fixtureName) {
        final String filePath = String.format("fixtures/v3/json/%s.json", fixtureName);
        try {
            return Resources.toString(Resources.getResource(filePath), StandardCharsets.UTF_8);
        } catch (final IOException e) {
            throw new UncheckedIOException(String.format("Unable to read resource %s from file", filePath), e);
        }
    }
}
