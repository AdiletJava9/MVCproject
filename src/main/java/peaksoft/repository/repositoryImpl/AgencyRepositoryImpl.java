package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class AgencyRepositoryImpl implements AgencyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveAgency(Agency agency) {
        entityManager.persist(agency);
    }

    @Override
    public Agency getAgencyById(Long id) {
        return entityManager.find(Agency.class, id);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return entityManager.createQuery("select c from Agency c", Agency.class).getResultList();
    }

    @Override
    public void updateAgency(Long id, Agency agency) {
        Agency agency1 = entityManager.find(Agency.class, id);
        agency1.setName(agency.getName());
        agency1.setCountry(agency.getCountry());
        agency1.setEmail(agency.getEmail());
        agency1.setImage(agency.getImage());
        agency1.setPhoneNumber(agency.getPhoneNumber());
    }

    @Override
    public void deleteAgencyById(Long id) {
        entityManager.remove(entityManager.find(Agency.class, id));
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return null;
    }
}
