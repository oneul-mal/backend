package self.project.oneulmal.concern.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.project.oneulmal.concern.application.ConcernService;
import self.project.oneulmal.concern.application.dto.ConcernResponseDto;
import self.project.oneulmal.concern.presentation.dto.response.ConcernResponse;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ConcernController {

    private final ConcernService concernService;

    @GetMapping("/concerns")
    public ResponseEntity<List<ConcernResponse>> findConcerns() {
        List<ConcernResponseDto> concernResponseDtos = concernService.findAllConcerns();
        List<ConcernResponse> concernResponses = concernResponseDtos.stream()
                .map(ConcernResponse::create)
                .collect(Collectors.toList());
        return ResponseEntity.ok(concernResponses);
    }

    @GetMapping("/concerns/{id}")
    public ResponseEntity<ConcernResponse> findConcern(@PathVariable Long id) {
        ConcernResponseDto concernResponseDto = concernService.findConcern(id);
        ConcernResponse concernResponse = ConcernResponse.create(concernResponseDto);
        return ResponseEntity.ok(concernResponse);
    }
}
