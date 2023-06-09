package peaksoft.service;

import peaksoft.entity.House;

import java.util.List;

public interface HouseService {
    void saveHouse(House house);

    House getHouseById(Long id);

    List<House> getAllHouses();

    void updateHouse(Long id, House house);

    void deleteHouseById(Long id);

    List<House> searchHouse(String word);
}
