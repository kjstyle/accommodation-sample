package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.Accommodation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccommodationRestController extends BaseApiController {

    @GetMapping("/accommodation/{id}")
    public Accommodation getAccommodationById(Long id) {
        return Accommodation.builder().id(1L).name("대박호텔").build();
    }
}