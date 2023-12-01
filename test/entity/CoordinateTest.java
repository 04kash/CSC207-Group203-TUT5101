package test.entity;

import entity.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordinateTest {
    private Coordinate coordinate;

    @BeforeEach
    void init(){
        coordinate = new Coordinate(1.234455, 1.223344);
        this.coordinate = coordinate;
    }
    @Test
    void getLatitude() {
        Assertions.assertEquals(1.234455, coordinate.getLatitude());
    }

    @Test
    void getLongitude() {
        Assertions.assertEquals(1.223344, coordinate.getLongitude());
    }
}