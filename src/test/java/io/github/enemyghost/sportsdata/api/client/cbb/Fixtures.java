package io.github.enemyghost.sportsdata.api.client.cbb;

import io.github.enemyghost.sportsdata.api.client.cbb.entities.Conference;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Player;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Season;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Stadium;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Team;

import java.time.LocalDate;
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
}
