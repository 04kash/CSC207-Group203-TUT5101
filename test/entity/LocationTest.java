package test.entity;

import entity.Coordinate;
import entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    private Location location;
    private Coordinate coordinate;

    @BeforeEach
    void init() {
    Coordinate coordinate = new Coordinate(1.234, 5.678);
    location = new Location("McDonalds", coordinate, "abc", "interesting places" );
    this.location = location;
    this.coordinate = coordinate;
    }

    @Test
    void getFilter() {
        Assertions.assertEquals("interesting places", location.getFilter());
    }

    @Test
    void getCoordinate() {
        Assertions.assertEquals(coordinate, location.getCoordinate());
    }

    @Test
    void getName() {
        Assertions.assertEquals("McDonalds", location.getName());
    }

    @Test
    void getOsmLink() {
        Assertions.assertEquals("abc", location.getOsmLink());
    }
}