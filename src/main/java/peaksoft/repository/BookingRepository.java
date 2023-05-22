package peaksoft.repository;

import peaksoft.entity.Booking;
import peaksoft.entity.Customer;

import java.util.List;

public interface BookingRepository {
    List<Booking> getAllBookings();
}
