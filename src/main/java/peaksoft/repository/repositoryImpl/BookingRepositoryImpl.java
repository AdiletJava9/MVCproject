package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Agency;
import peaksoft.entity.Booking;
import peaksoft.entity.Customer;
import peaksoft.repository.BookingRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Booking> getAllBookings() {
        return entityManager.createQuery("select c from Booking c", Booking.class).getResultList();
    }
}
