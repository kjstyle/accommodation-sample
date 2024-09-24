package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.domain.Accommodation;
import kjstyle.accommodation.domain.exceptions.NotFoundSuchAccommodationException;
import kjstyle.accommodation.domain.repository.AccommodationRepository;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    @Transactional(readOnly = true)
    public Accommodation findById(long id) {
        AccommodationEntity accommodationEntity = accommodationRepository.findById(id).orElseThrow(
                NotFoundSuchAccommodationException::new
        );
        return Accommodation.from(accommodationEntity);
    }
}
