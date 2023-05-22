package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;
import peaksoft.service.AgencyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    @Override
    public void saveAgency(Agency agency) {
        agencyRepository.saveAgency(agency);
    }

    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepository.getAgencyById(id);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.getAllAgencies();
    }

    @Override
    public void updateAgency(Long id, Agency agency) {
        agencyRepository.updateAgency(id,agency);
    }

    @Override
    public void deleteAgencyById(Long id) {
        agencyRepository.deleteAgencyById(id);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return agencyRepository.searchAgency(word);
    }
}
