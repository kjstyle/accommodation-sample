package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.Accommodation;
import kjstyle.accommodation.domain.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccommodationRestController extends BaseApiController {

    private final AccommodationService accommodationService;

    @GetMapping("/accommodation/{id}")
    public Accommodation getAccommodationById(@PathVariable Long id) {
        return accommodationService.findById(id);
    }
}