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
}