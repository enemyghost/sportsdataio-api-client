package io.github.enemyghost.lang;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link PreconditionUtils}
 */
class PreconditionUtilsTest {

    @Test
    void testRequireNonEmptyStringValid() {
        assertEquals("test-string", PreconditionUtils.requireNonEmpty("test-string", "error message"));
    }

    @Test
    void testRequireNonEmptyStringNull() {
        assertThrows(NullPointerException.class, () -> PreconditionUtils.requireNonEmpty((String)null, "error message"));
    }

    @Test
    void testRequireNonEmptyStringEmpty() {
        assertThrows(NullPointerException.class, () -> PreconditionUtils.requireNonEmpty("", "error message"));
    }

    @Test
    void testRequireNonEmptyCollectionValid() {
        final List<String> coll = List.of("test", "strings");
        assertEquals(coll, PreconditionUtils.requireNonEmpty(coll, "error message"));
    }

    @Test
    void testRequireNonEmptyCollectionNull() {
        assertThrows(NullPointerException.class, () -> PreconditionUtils.requireNonEmpty((List<String>)null, "error message"));
    }

    @Test
    void testRequireNonEmptyCollectionEmpty() {
        assertThrows(NullPointerException.class, () -> PreconditionUtils.requireNonEmpty(List.of(), "error message"));
    }

    @Test
    void testCheckArgumentBoolean() {
        PreconditionUtils.checkArgument(true, "error message");
    }

    @Test
    void testCheckArgumentBooleanFalse() {
        assertThrows(IllegalArgumentException.class, () -> PreconditionUtils.checkArgument(false, "error message"));
    }

    @Test
    void testCheckArgumentPredicate() {
        assertEquals("my-string",
                PreconditionUtils.checkArgument("my-string", (s) -> !s.isEmpty(), "empty string!"));
    }

    @Test
    void testCheckArgumentPredicateFalse() {
        assertThrows(IllegalArgumentException.class,
                () -> PreconditionUtils.checkArgument("", (s) -> !s.isEmpty(), "empty string!"));
    }
}