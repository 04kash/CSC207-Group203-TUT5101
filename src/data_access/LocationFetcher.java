package data_access;

import entity.Location;

import java.util.ArrayList;

interface LocationFetcher {
    ArrayList<Location> getLocations(String cityName, String filter);
}

