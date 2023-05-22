package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Customer;
import peaksoft.entity.House;
import peaksoft.repository.HouseRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class HouseRepositoryImpl implements HouseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveHouse(House house) {
        entityManager.persist(house);
    }

    @Override
    public House getHouseById(Long id) {
        return entityManager.find(House.class, id);
    }

    @Override
    public List<House> getAllHouses() {
        return entityManager.createQuery("SELECT s from House s ", House.class).getResultList();
    }

    @Override
    public void updateHouse(Long id, House house) {
        House house1 = entityManager.find(House.class, id);
        house1.setHouseType(house.getHouseType());
        house1.setCountry(house.getCountry());
        house1.setImage(house.getImage());
        house1.setDescription(house.getDescription());
        house1.setPrice(house.getPrice());
        house1.setAddress(house.getAddress());
        house1.setIsBooked(house.getIsBooked());
    }

    @Override
    public void deleteHouseById(Long id) {
        entityManager.remove(entityManager.find(House.class, id));
    }

    @Override
    public List<House> searchHouse(String word) {
        return null;
    }
}
