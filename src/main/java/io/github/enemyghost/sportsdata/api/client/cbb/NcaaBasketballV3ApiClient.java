package io.github.enemyghost.sportsdata.api.client.cbb;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Feign-annotated API Client for the sportsdata.io NCAA Men's Basketball (CBB) API.
 *
 * @see <a href="https://sportsdata.io/developers/api-documentation/ncaa-basketball">sportsdata.io</a> for API docs.
 *
 * @author enemyghost
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
}
