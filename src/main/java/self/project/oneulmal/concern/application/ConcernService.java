package self.project.oneulmal.concern.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import self.project.oneulmal.concern.application.dto.ConcernResponseDto;
import self.project.oneulmal.concern.domain.Concern;
import self.project.oneulmal.concern.domain.ConcernRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConcernService {

    private final ConcernRepository concernRepository;

    @Transactional(readOnly = true)
    public List<ConcernResponseDto> findAllConcerns() {
        List<Concern> concerns = concernRepository.findAll();
        return concerns.stream()
                .map(ConcernResponseDto::create)
                .collect(Collectors.toList());
    }


    public ConcernResponseDto findConcern(Long concernId) {
        Concern concern = concernRepository.findById(concernId)
                .orElseThrow(RuntimeException::new);

        return ConcernResponseDto.create(concern);
    }
}
