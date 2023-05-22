package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.House;
import peaksoft.repository.HouseRepository;
import peaksoft.service.HouseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public void saveHouse(House house) {
        houseRepository.saveHouse(house);
    }

    @Override
    public House getHouseById(Long id) {
        return houseRepository.getHouseById(id);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.getAllHouses();
    }

    @Override
    public void updateHouse(Long id, House house) {
        houseRepository.updateHouse(id, house);
    }

    @Override
    public void deleteHouseById(Long id) {
        houseRepository.deleteHouseById(id);
    }

    @Override
    public List<House> searchHouse(String word) {
        return houseRepository.searchHouse(word);
    }
}
