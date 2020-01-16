package io.github.enemyghost.sportsdata.api.client;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Configures a default, immutable {@link ObjectMapper} properly configured for the sportsdata.io JSON API
 */
public final class ObjectMapperSingleton {
    /**
     * Default, immutable {@link ObjectMapper} configured for sportsdata.io feign clients.
     */
    public static final ObjectMapper INSTANCE;

    static {
        final UnmodifiableObjectMapper objectMapper = new UnmodifiableObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        objectMapper.seal();
        INSTANCE = objectMapper;
    }

    /**
     * An {@link ObjectMapper} implementation that, once sealed, disables additional configuration and
     * module registration.
     */
    private static final class UnmodifiableObjectMapper extends ObjectMapper {
        private final AtomicBoolean sealed = new AtomicBoolean(false);

        @Override
        public ObjectMapper registerModule(final Module module) {
            if (sealed.get()) {
                throw new IllegalStateException("Cannot modify sealed ObjectMapper");
            }
            return super.registerModule(module);
        }

        @Override
        public ObjectMapper configure(final MapperFeature f, final boolean state) {
            if (sealed.get()) {
                throw new IllegalStateException("Cannot modify sealed ObjectMapper");
            }
            return super.configure(f, state);
        }

        @Override
        public ObjectMapper configure(final SerializationFeature f, final boolean state) {
            if (sealed.get()) {
                throw new IllegalStateException("Cannot modify sealed ObjectMapper");
            }
            return super.configure(f, state);
        }

        @Override
        public ObjectMapper configure(final DeserializationFeature f, final boolean state) {
            if (sealed.get()) {
                throw new IllegalStateException("Cannot modify sealed ObjectMapper");
            }
            return super.configure(f, state);
        }

        @Override
        public ObjectMapper configure(final Feature f, final boolean state) {
            if (sealed.get()) {
                throw new IllegalStateException("Cannot modify sealed ObjectMapper");
            }
            return super.configure(f, state);
        }

        @Override
        public ObjectMapper configure(final JsonGenerator.Feature f, final boolean state) {
            if (sealed.get()) {
                throw new IllegalStateException("Cannot modify sealed ObjectMapper");
            }
            return super.configure(f, state);
        }

        /**
         * Seals this instance, disabling additional feature configuration and module registration.
         */
        void seal() {
            sealed.set(true);
        }
    }
}
