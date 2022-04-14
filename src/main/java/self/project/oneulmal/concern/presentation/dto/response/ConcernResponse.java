package self.project.oneulmal.concern.presentation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import self.project.oneulmal.concern.application.dto.ConcernResponseDto;

@AllArgsConstructor
@Getter
public class ConcernResponse {
    private String title;
    private String description;

    public static ConcernResponse create(
            ConcernResponseDto concernResponseDto
    ){
        return new ConcernResponse(
                concernResponseDto.getTitle(),
                concernResponseDto.getDescription()
        );
    }
}
