package io.github.enemyghost.sportsdata.api.client;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import feign.optionals.OptionalDecoder;
import feign.slf4j.Slf4jLogger;

import static io.github.enemyghost.lang.PreconditionUtils.requireNonEmpty;
import static java.util.Objects.requireNonNull;

/**
 * Contains factory methods for creating sportsdata.io feign clients.
 *
 * @author enemyghost
 */
public final class FeignClientFactory {

    /**
     * HTTP request header name for the sportsdata.io subscription key
     */
    private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";

    /**
     * Private ctor.
     */
    private FeignClientFactory() {
    }

    /**
     * Creates a new {@link Feign} client for a {@code apiType} class with the default settings for sportsdata.io
     *
     * @param baseApiUrl base API URL, e.g. https://api.sportsdata.io
     * @param apiKey     sportsdata.io API key
     * @param apiType    target interface class for feign
     * @param <T>        target interface type for feign
     * @return {@link T} feign-backed API client of the target type
     */
    public static <T> T createClient(final String baseApiUrl,
                                     final String apiKey,
                                     final Class<T> apiType) {
        return createDefaultBuilder(requireNonEmpty(apiKey, "Null/empty API key"), requireNonNull(apiType, "Null API type"))
                .target(apiType, requireNonEmpty(baseApiUrl, "Null/empty base API url"));
    }

    /**
     * Creates a {@link Feign.Builder} with the default settings for sportsdata.io feign clients
     *
     * @param apiKey  sportsdata.io subscription key
     * @param apiType target interface type for feign
     * @return {@link Feign.Builder} with the default settings for  sportsdata.io feign clients
     */
    public static Feign.Builder createDefaultBuilder(final String apiKey, final Class<?> apiType) {
        return Feign.builder()
                .decode404()
                .contract(new JAXRSContract())
                .decoder(new OptionalDecoder(new JacksonDecoder(ObjectMapperSingleton.INSTANCE)))
                .encoder(new JacksonEncoder(ObjectMapperSingleton.INSTANCE))
                .logger(new Slf4jLogger(requireNonNull(apiType, "Null API type")))
                .requestInterceptor(template ->
                        template.header(API_KEY_HEADER_NAME, requireNonEmpty(apiKey, "Null/empty API Key")));
    }
}
