# sportsdata.io API Client
This is a [feign](https://github.com/OpenFeign/feign) based Java client for the [sportsdata.io API](https://sportsdata.io/developers/api-documentation/ncaa-basketball#).

## Maven
```xml
    <dependency>
        <groupId>io.github.enemyghost</groupId>
        <artifactId>sportsdataio-api-client</artifactId>
        <version>0.2.0</version>
    </dependency>
```

This dependency will transitively bring required Feign and Jackson dependencies.

## Usage
Use `FeignClientFactory` to get a properly configured Feign client targeting `NcaaBasketballV3ApiClient`:

```java
    final NcaaBasketballV3ApiClient client = FeignClientFactory.createClient("https://api.sportsdata.io",
            API_KEY,
            NcaaBasketballV3ApiClient.class);
    final List<Conference> conferences = client.leagueHierarchy();
    conferences
            .stream()
            .map(Conference::getName)
            .forEach(System.out::println);
```

You can also add your own configuration to the Feign client:

```java
final NcaaBasketballV3ApiClient client = FeignClientFactory.createDefaultBuilder(API_KEY, NcaaBasketballV3ApiClient.class)
        .client(myConfiguredClient)
        .logLevel(Level.FULL)
        .target("https://api.sportsdata.io", NcaaBasketballV3ApiClient.class);
```

Of course, you can avoid using the factory altogether and configure your own Feign client however you like.

### Coverage
Currently, only the following endpoints for NCAA Men's Basketball are supported.
* FREE tier
    * Are Games In Progress
    * Current Season
    * League Hierarchy
    * Player Details by Active
    * Player Details by Player
    * Player Details by Team
    * Stadiums
    * Teams
* PLAYER STATS tier
    * Player Game Stats by Date
    * Player Game Stats by Player
* FANTASY tier
    * Projected Game Stats by Date
    * Projected Game Stats by Player 

The project is under active development.

### Implementation Details
Accessors for all properties marked as `nullable` in the API documentation will return an `Optional`. A value of
`Optional#empty()` represents a null field in the API response.

## Contributions
Contributions are welcome, and should follow the patterns established in the `entities` and `client` packages. PRs will run `mvn package` to verify changes. Test coverage is required.

### Build
```bash
$ git clone git@github.com:enemyghost/sportsdataio-api-client.git
$ cd sportsdataio-api-client
$ mvn clean install
```
