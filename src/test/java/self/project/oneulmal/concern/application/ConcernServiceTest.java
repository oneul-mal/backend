package self.project.oneulmal.concern.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import self.project.oneulmal.concern.application.dto.ConcernResponseDto;
import self.project.oneulmal.concern.domain.Concern;
import self.project.oneulmal.concern.domain.ConcernRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConcernServiceTest {
    private ConcernService concernService;

    @Mock
    private ConcernRepository concernRepository;

    @BeforeEach
    void setUp() {
        concernService = new ConcernService(concernRepository);
    }

    @DisplayName("모든 고민 글을 조회한다.")
    @Test
    void findAllConcerns() {
        Concern concern1 = Concern.create("고민이 있어요", "장난이에요");
        Concern concern2 = Concern.create("고민이 있어요2", "장난이에요2");

        when(concernRepository.findAll()).thenReturn(List.of(concern1, concern2));

        List<ConcernResponseDto> concerns = concernService.findAllConcerns();

        assertThat(concerns).extracting("title")
                .containsExactly(concern1.getTitle(), concern2.getTitle());
    }
}