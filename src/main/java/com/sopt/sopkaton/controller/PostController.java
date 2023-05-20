package com.sopt.sopkaton.controller;

import com.sopt.sopkaton.common.ApiResponse;
import com.sopt.sopkaton.controller.req.DalleReqDto;
import com.sopt.sopkaton.controller.req.PostReqDto;
import com.sopt.sopkaton.controller.res.DalleResDto;
import com.sopt.sopkaton.controller.res.PostResDto;
import com.sopt.sopkaton.domain.Post;
import com.sopt.sopkaton.exception.Success;
import com.sopt.sopkaton.service.ExternalService;
import com.sopt.sopkaton.service.PostService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

@CrossOrigin("https://emotion-studio.netlify.app")
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private Random random = new Random();
    private List<String> backgrounds = Arrays.asList("sky", "river", "beach", "park", "garden");
    private final PostService postService;
    private final ExternalService externalService;

    @GetMapping("/{postId}")
    public ApiResponse<PostResDto> getPost(@PathVariable Long postId) {
        Post post = postService.getPost(postId);
        return ApiResponse.success(Success.FIND_POST_SUCCESS, PostResDto.of(post));
    }

    @PostMapping
    public ApiResponse<PostResDto> savePost(@RequestBody PostReqDto request) {
        String prompt = writeContent(request.getEmotions());
        System.out.println("prompt is " + prompt);
        DalleReqDto dto = new DalleReqDto(prompt);
        Call<DalleResDto> call = externalService.getPost(dto);
        PostResDto result = null;
        try {
            Response<DalleResDto> response = call.execute();
            if (response.isSuccessful()) {
                result = postService.savePost(response.body().getData().get(0).getUrl(), request.getName(), request.getTitle());
            }
        } catch (IOException e) {
            System.out.println("img error " + e.getMessage());
        }
        return ApiResponse.success(Success.SAVE_POST_SUCCESS, result);

    }

    private String writeContent(List<Integer> emotions) {
        String emotion = moodContent(emotions.get(0), emotions.get(1));
        String expiration = workContent(emotions.get(2));
        return "A photo of " + randomBackground() + " \"I am " + emotion + ". " + expiration + "\", film camera style";
    }

    private String moodContent(Integer moodEmotion, Integer nextEmotion) {
        return switch (moodEmotion) {
            case 0 -> "happy, " + happinessContent(nextEmotion);
            case 1 -> "scared, " + fearContent(nextEmotion);
            case 2 -> "unpleasant, " + discomfortContent(nextEmotion);
            default -> "sorrowful, " + sadContent(nextEmotion);
        };
    }

    private String happinessContent(Integer emotion) {
        return switch (emotion) {
            case 0 -> "grateful";
            case 1 -> "satisfied";
            case 2 -> "thrilled";
            case 3 -> "excited";
            case 4 -> "proud";
            case 5 -> "comfortable";
            case 6 -> "happy";
            default -> "lighthearted";
        };
    }

    private String fearContent(Integer emotion) {
        return switch (emotion) {
            case 0 -> "nervous";
            case 1 -> "embarrassed";
            case 2 -> "scared";
            case 3 -> "frightened";
            case 4 -> "uncertain";
            case 5 -> "confused";
            case 6 -> "worried";
            default -> "surprised";
        };
    }

    private String discomfortContent(Integer emotion) {
        return switch (emotion) {
            case 0 -> "stuffy";
            case 1 -> "mortified";
            case 2 -> "reproachful";
            case 3 -> "bored";
            case 4 -> "shameful";
            case 5 -> "unnatural";
            case 6 -> "tired";
            default -> "envy";
        };
    }

    private String sadContent(Integer emotion) {
        return switch (emotion) {
            case 0 -> "painful";
            case 1 -> "longing";
            case 2 -> "feel sorry";
            case 3 -> "disappointed";
            case 4 -> "disheartened";
            case 5 -> "lonely";
            case 6 -> "depressed";
            default -> "regretful";
        };
    }

    private String workContent(Integer emotion) {
        return switch (emotion) {
            case 0 -> "I want to remember today’s moments forever.";
            case 1 -> "I want to share today’s experience with my friends.";
            case 2 -> "I just want to remember today’s moments until today. ";
            default -> "I want to forget about today’s memories.";
        };
    }

    private String randomBackground() {
        int index = random.nextInt(backgrounds.size());
        return backgrounds.get(index);
    }
}
