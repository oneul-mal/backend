package self.project.oneulmal.concern.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import self.project.oneulmal.concern.domain.Concern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConcernResponseDto {
    private String title;
    private String description;

    public static ConcernResponseDto create(
            Concern concern
    ){
        return new ConcernResponseDto(
                concern.getTitle(),
                concern.getDescription()
        );
    }

}
