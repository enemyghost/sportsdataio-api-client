package io.github.enemyghost.sportsdata.api.client.cbb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.enemyghost.sportsdata.api.client.cbb.entities.Stadium.Builder;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import static io.github.enemyghost.lang.PreconditionUtils.requireNonEmpty;
import static java.util.Objects.requireNonNull;

/**
 * POJO representing a team's home stadium
 *
 * @author enemyghost
 */
@JsonDeserialize(builder = Builder.class)
public class Stadium {
    private final int stadiumId;
    private final boolean active;
    private final String name;
    private final String address;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;
    private final Integer capacity;

    private Stadium(final Builder builder) {
        stadiumId = builder.stadiumId;
        active = builder.active;
        name = builder.name;
        address = builder.address;
        city = builder.city;
        state = builder.state;
        zip = builder.zip;
        country = builder.country;
        capacity = builder.capacity;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getState() {
        return Optional.ofNullable(state);
    }

    public Optional<String> getZip() {
        return Optional.ofNullable(zip);
    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public Optional<Integer> getCapacity() {
        return Optional.ofNullable(capacity);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Stadium stadium = (Stadium) o;
        return stadiumId == stadium.stadiumId &&
                active == stadium.active &&
                Objects.equals(name, stadium.name) &&
                Objects.equals(address, stadium.address) &&
                Objects.equals(city, stadium.city) &&
                Objects.equals(state, stadium.state) &&
                Objects.equals(zip, stadium.zip) &&
                Objects.equals(country, stadium.country) &&
                Objects.equals(capacity, stadium.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stadiumId, active, name, address, city, state, zip, country, capacity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Stadium.class.getSimpleName() + "[", "]")
                .add("stadiumId=" + stadiumId)
                .add("active=" + active)
                .add("name='" + name + "'")
                .add("address='" + address + "'")
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("zip='" + zip + "'")
                .add("country='" + country + "'")
                .add("capacity=" + capacity)
                .toString();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Integer stadiumId;
        private Boolean active;
        private String name;
        private String address;
        private String city;
        private String state;
        private String zip;
        private String country;
        private Integer capacity;

        private Builder() {
        }

        public Builder withStadiumID(final Integer val) {
            stadiumId = val;
            return this;
        }

        public Builder withActive(final Boolean val) {
            active = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withAddress(final String val) {
            address = val;
            return this;
        }

        public Builder withCity(final String val) {
            city = val;
            return this;
        }

        public Builder withState(final String val) {
            state = val;
            return this;
        }

        public Builder withZip(final String val) {
            zip = val;
            return this;
        }

        public Builder withCountry(final String val) {
            country = val;
            return this;
        }

        public Builder withCapacity(final Integer val) {
            capacity = val;
            return this;
        }

        public Stadium build() {
            requireNonNull(stadiumId, "Stadium ID is not nullable");
            requireNonNull(active, "Active is not nullable");
            requireNonEmpty(name, "Name is not nullable");
            return new Stadium(this);
        }
    }
}
