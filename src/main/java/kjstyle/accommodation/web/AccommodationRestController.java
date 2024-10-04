package kjstyle.accommodation.web;

import jakarta.validation.Valid;
import kjstyle.accommodation.domain.model.Accommodation;
import kjstyle.accommodation.domain.service.AccommodationService;
import kjstyle.accommodation.web.common.BaseApiController;
import kjstyle.accommodation.web.dto.AccommodationReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccommodationRestController extends BaseApiController {

    private final AccommodationService accommodationService;

    @GetMapping("/accommodation/{id}")
    public Accommodation getAccommodationById(@PathVariable Long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Accommodation id must be greater than 0");
        }
        return accommodationService.findById(id);
    }

    @PostMapping("/accommodation")
    public Accommodation createAccommodation(@RequestBody @Valid AccommodationReq.Create accommodationReqCreate) {
        log.info("{}",accommodationReqCreate);
        return null;
    }
}