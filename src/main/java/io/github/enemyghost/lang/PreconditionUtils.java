package io.github.enemyghost.lang;

import java.util.Collection;
import java.util.Objects;

/**
 * Utilities for enforcing preconditions on input parameters.
 *
 * @author enemyghost
 */
public final class PreconditionUtils {
    /**
     * Private ctor.
     */
    private PreconditionUtils() {
    }

    /**
     * Checks that the specified String is not {@code null} or empty and throws a customized
     * {@link NullPointerException} if it is.
     *
     * @param entity  {@code entity} to check
     * @param message message to use in thrown exception
     * @return {@code entity}
     * @throws NullPointerException if {@code entity} is null or empty
     */
    public static String requireNonEmpty(final String entity, final String message) {
        if (Objects.isNull(entity) || entity.isEmpty()) {
            throw new NullPointerException(message);
        }
        return entity;
    }

    /**
     * Checks that the specified collection is not {@code null} or empty and throws a customized
     * {@link NullPointerException} if it is.
     *
     * @param entity  {@code entity} to check
     * @param message message to use in thrown exception
     * @return {@code entity}
     * @throws NullPointerException if {@code entity} is null or empty
     */
    public static Collection<?> requireNonEmpty(final Collection<?> entity, final String message) {
        if (Objects.isNull(entity) || entity.isEmpty()) {
            throw new NullPointerException(message);
        }
        return entity;
    }
}
