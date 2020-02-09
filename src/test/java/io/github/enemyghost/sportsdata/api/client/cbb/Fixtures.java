package io.github.enemyghost.sportsdata.api.client.cbb;

import io.github.enemyghost.sportsdata.api.client.cbb.entities.Conference;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Player;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.PlayerGame;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Season;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Stadium;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Team;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Contains POJO fixtures which map to the json fixtures in {@code src/test/resources}
 *
 * @author enemyghost
 */
public final class Fixtures {
    /**
     * Private ctor.
     */
    private Fixtures() {
    }

    static final Season CURRENT_SEASON = Season.newBuilder()
            .withSeason(2020)
            .withStartYear(2019)
            .withEndYear(2020)
            .withDescription("2019-20")
            .withRegularSeasonStartDate(LocalDate.of(2019, 11, 1))
            .withPostSeasonStartDate(LocalDate.of(2020, 3, 16))
            .withApiSeason("2020REG")
            .build();

    static final Stadium MOODY_COLISEUM = Stadium.newBuilder()
            .withStadiumID(101)
            .withActive(true)
            .withName("Moody Coliseum")
            .withCity("Dallas")
            .withState("TX")
            .withCapacity(7000)
            .build();

    static final Team SMU = Team.newBuilder()
            .withTeamID(1)
            .withKey("SMU")
            .withActive(true)
            .withSchool("SMU")
            .withName("Mustangs")
            .withWins(12)
            .withLosses(3)
            .withConferenceWins(2)
            .withConferenceLosses(1)
            .withGlobalTeamID(60000001)
            .withConferenceID(1)
            .withConference("American Athletic")
            .withTeamLogoUrl("https://s3-us-west-2.amazonaws.com/static.fantasydata.com/logos/ncaa/1.png")
            .withShortDisplayName("SMU")
            .withStadium(MOODY_COLISEUM)
            .build();


    static final Stadium LIACOURAS_CENTER = Stadium.newBuilder()
            .withStadiumID(45)
            .withActive(true)
            .withName("Liacouras Center")
            .withCity("Philadelphia")
            .withState("PA")
            .withCapacity(10200)
            .build();

    static final Team TEMPLE = Team.newBuilder()
            .withTeamID(2)
            .withKey("TEMPL")
            .withActive(true)
            .withSchool("Temple")
            .withName("Owls")
            .withApRank(17)
            .withWins(9)
            .withLosses(6)
            .withConferenceWins(1)
            .withConferenceLosses(3)
            .withGlobalTeamID(60000002)
            .withConferenceID(1)
            .withConference("American Athletic")
            .withTeamLogoUrl("https://s3-us-west-2.amazonaws.com/static.fantasydata.com/logos/ncaa/2.png")
            .withShortDisplayName("TEMPLE")
            .withStadium(LIACOURAS_CENTER)
            .build();

    static final Stadium ISLAND_FCU_ARENA = Stadium.newBuilder()
            .withStadiumID(339)
            .withActive(true)
            .withName("Island FCU Arena")
            .withCity("Stony Brook")
            .withState("NY")
            .withCapacity(4000)
            .build();

    static final Team STONY_BROOK = Team.newBuilder()
            .withTeamID(12)
            .withKey("STBR")
            .withActive(true)
            .withSchool("Stony Brook")
            .withName("Seawolves")
            .withWins(12)
            .withLosses(6)
            .withConferenceWins(3)
            .withConferenceLosses(0)
            .withGlobalTeamID(60000012)
            .withConferenceID(2)
            .withConference("America East")
            .withTeamLogoUrl("https://s3-us-west-2.amazonaws.com/static.fantasydata.com/logos/ncaa/12.png")
            .withShortDisplayName("STBR")
            .withStadium(ISLAND_FCU_ARENA)
            .build();

    static final Conference AMERICAN_ATHLETIC = Conference.newBuilder()
            .withConferenceID(1)
            .withName("American Athletic")
            .withTeams(List.of(SMU, TEMPLE))
            .build();

    static final Conference AMERICA_EAST = Conference.newBuilder()
            .withConferenceID(2)
            .withName("America East")
            .withTeams(List.of(STONY_BROOK))
            .build();

    static final Conference INDEPENDENTS = Conference.newBuilder()
            .withConferenceID(15)
            .withName("Independents")
            .build();

    static final List<Team> TEAMS = List.of(SMU, TEMPLE, STONY_BROOK);

    static final List<Conference> LEAGUE_HIERARCHY = List.of(AMERICAN_ATHLETIC, AMERICA_EAST, INDEPENDENTS);

    static final List<Stadium> STADIUMS = List.of(LIACOURAS_CENTER, MOODY_COLISEUM, ISLAND_FCU_ARENA);

    static final Player TYSON_JOLLY = Player.newBuilder()
            .withPlayerID(60006480)
            .withFirstName("Tyson")
            .withLastName("Jolly")
            .withTeamID(1)
            .withTeam("SMU")
            .withJersey(0)
            .withPosition("G")
            .withPlayerClass("Senior")
            .withHeight(76)
            .withWeight(0)
            .withBirthCity("Oklahoma City")
            .withBirthState("OK")
            .withHighSchool("Putnam City West HS")
            .withSportRadarPlayerID("")
            .withGlobalTeamID(60000001)
            .build();

    static final Player ISIAHA_MIKE = Player.newBuilder()
            .withPlayerID(60006717)
            .withFirstName("Isiaha")
            .withLastName("Mike")
            .withTeamID(1)
            .withTeam("SMU")
            .withJersey(15)
            .withPosition("F")
            .withPlayerClass("Junior")
            .withHeight(80)
            .withWeight(0)
            .withBirthCity("Scarborough")
            .withBirthState("ON")
            .withHighSchool("Duquesne")
            .withSportRadarPlayerID("")
            .withGlobalTeamID(60000001)
            .build();

    static final Player GRANT_YOUNGKIN = Player.newBuilder()
            .withPlayerID(60007054)
            .withFirstName("Grant")
            .withLastName("Youngkin")
            .withTeamID(1)
            .withTeam("SMU")
            .withJersey(20)
            .withPosition("G")
            .withPlayerClass("Junior")
            .withHeight(75)
            .withWeight(0)
            .withBirthCity("Washington")
            .withBirthState("DC")
            .withHighSchool("Rice")
            .withSportRadarPlayerID("")
            .withGlobalTeamID(60000001)
            .build();

    static final List<Player> SMU_PLAYERS = List.of(TYSON_JOLLY, ISIAHA_MIKE, GRANT_YOUNGKIN);

    static final PlayerGame PLAYER_GAME_1 = PlayerGame.newBuilder()
            .withStatID(652532)
            .withTeamID(177)
            .withPlayerID(60008866)
            .withSeasonType(1)
            .withSeason(2020)
            .withName("Bryan Trimble Jr.")
            .withTeam("AKRON")
            .withPosition("G")
            .withInjuryStatus("Out for season")
            .withInjuryBodyPart("Eligibility")
            .withInjuryStartDate(LocalDate.of(2020, 1, 9))
            .withInjuryNotes("Trimble Jr. has been declared ineligible for the 2019-20 campaign by the NCAA and will have to sit out the entire season.")
            .withGlobalTeamID(60000177)
            .withGameID(27599)
            .withOpponentID(187)
            .withOpponent("EMICH")
            .withDateTime(LocalDateTime.of(2020, 2, 8, 14, 0, 0))
            .withHomeOrAway("HOME")
            .withIsGameOver(false)
            .withGlobalGameID(60027599)
            .withGlobalOpponentID(60000187)
            .withUpdated(LocalDateTime.of(2020,2,5,11,41,31))
            .withGames(1)
            .build();

    static final PlayerGame PLAYER_GAME_2 = PlayerGame.newBuilder()
            .withStatID(652942)
            .withTeamID(267)
            .withPlayerID(60016201)
            .withSeasonType(1)
            .withSeason(2020)
            .withName("Jalyn McCreary")
            .withTeam("SC")
            .withPosition("F")
            .withGlobalTeamID(60000267)
            .withGameID(27635)
            .withOpponentID(270)
            .withOpponent("TXAM")
            .withDateTime(LocalDateTime.of(2020, 2, 8, 13, 0, 0))
            .withHomeOrAway("AWAY")
            .withIsGameOver(false)
            .withGlobalGameID(60027635)
            .withGlobalOpponentID(60000270)
            .withUpdated(LocalDateTime.of(2020,2,5,21,22,35))
            .withGames(1)
            .build();

    static final List<PlayerGame> PLAYER_GAMES = List.of(PLAYER_GAME_1, PLAYER_GAME_2);
}
