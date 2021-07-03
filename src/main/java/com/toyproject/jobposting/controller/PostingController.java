package com.toyproject.jobposting.controller;

import com.toyproject.jobposting.dto.PostingDto;
import com.toyproject.jobposting.dto.UserDto;
import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.service.PostingService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @GetMapping("/posts")
    public ReadPostResponse posts(){
        List<Posting> postingList = postingService.findPostings();
        List<PostingDto> postingDtoList = new ArrayList<>();
        ReadPostResponse<List<PostingDto>> response = new ReadPostResponse<>();
        for (Posting posting : postingList) {
            PostingDto postingDto = new PostingDto();
            postingDto.changeToDto(posting);
            postingDtoList.add(postingDto);
        }
        response.setData(postingDtoList);
        return response;
    }

    @GetMapping("/posts/{id}")
    public ReadPostResponse postsById(@PathVariable Long id){
        Posting posting = postingService.findOne(id);
        PostingDto postingDto = new PostingDto();
        postingDto.changeToDto(posting);
        ReadPostResponse<List<PostingDto>> result = new ReadPostResponse<>();
        List<PostingDto> postingDtoList = new ArrayList<>();
        postingDtoList.add(postingDto);
        result.setData(postingDtoList);
        return result;
    }


    @PostMapping("/posts")
    public void savePosting(@RequestBody @Valid SavePostingRequest request){
        Posting posting = new Posting();
        User user = new User();

        posting.changeToPosting(request.getPostingDto());
        user.changeToUser(request.getUserDto());

        postingService.savePosting(posting, user);

    }

    @PutMapping("/posts/{id}")
    public void editPost(@RequestBody @Valid PostingDto request, @PathVariable Long id){
        Posting posting = new Posting();
        posting.changeToPosting(request);

        postingService.updatePosting(id, posting);
    }

    @DeleteMapping("/posts/{id}")
    public void removePost(@PathVariable Long id){
        postingService.deletePosting(id);
    }
    @Data
    static class ReadPostResponse<T> {
        private T data;
    }

    @Data
    static class SavePostingRequest {
        private PostingDto postingDto;
        private UserDto userDto;
    }
}
