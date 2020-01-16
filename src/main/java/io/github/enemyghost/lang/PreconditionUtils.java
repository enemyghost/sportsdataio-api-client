package io.github.enemyghost.lang;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

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

    /**
     * Checks that the given value is true and throws a customized {@link IllegalArgumentException} if it is false
     *
     * @param val     value to check
     * @param message custom message to use in thrown {@link IllegalArgumentException}
     * @throws IllegalArgumentException if {@code val} is false
     */
    public static void checkArgument(final boolean val, final String message) {
        if (!val) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks that the given {@code argument} passes the {@code predicate}, and throws a customized {@link IllegalArgumentException}
     * if it does not. Returns the given argument unmodified if the predicate passes.
     *
     * @param argument  argument to check
     * @param predicate predicate to execute
     * @param message   custom message to use in thrown {@link IllegalArgumentException}
     * @param <T>       type of the argument
     * @return the given argument unmodified
     * @throws IllegalArgumentException if the given {@code predicate} fails
     */
    public static <T> T checkArgument(final T argument, final Predicate<T> predicate, final String message) {
        checkArgument(predicate.test(argument), message);
        return argument;
    }
}
