package self.project.oneulmal.concern.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import self.project.oneulmal.concern.application.ConcernService;
import self.project.oneulmal.concern.presentation.dto.response.ConcernResponse;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class ConcernControllerTest {
    @MockBean
    private ConcernService concernService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext) {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @DisplayName("고민 글을 전체 조회한다.")
    @Test
    void findConcerns() throws  Exception {
        List<ConcernResponse> concernResponses = Arrays.asList(
                new ConcernResponse("고민", "있어요"),
                new ConcernResponse("고민2", "있어요2")
        );
//        given(concernService.findAllConcerns()).willReturn(concernResponses);

        mockMvc.perform(get("/api/concerns")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}