package com.toyproject.jobposting.controller;

import com.toyproject.jobposting.dto.PostingDto;
import com.toyproject.jobposting.entity.Posting;
import com.toyproject.jobposting.entity.User;
import com.toyproject.jobposting.service.PostingService;
import com.toyproject.jobposting.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/posts")
    public ReadPostResponse posts(){
        List<Posting> postingList = postingService.findPostings();
        List<PostingDto> postingDtoList = new ArrayList<>();
        ReadPostResponse<List<PostingDto>> response = new ReadPostResponse<>();
        for (Posting posting : postingList) {
            PostingDto postingDto = modelMapper.map(posting, PostingDto.class);
            postingDtoList.add(postingDto);
        }
        response.setData(postingDtoList);
        return response;
    }

    @GetMapping("/posts/{id}")
    public ReadPostResponse postsById(@PathVariable Long id){
        Posting posting = postingService.findOne(id);
        PostingDto postingDto = modelMapper.map(posting, PostingDto.class);
        ReadPostResponse<List<PostingDto>> result = new ReadPostResponse<>();
        List<PostingDto> postingDtoList = new ArrayList<>();
        postingDtoList.add(postingDto);
        result.setData(postingDtoList);
        return result;
    }

    //posting get

    @PostMapping("/posts")
    public void savePosting(@RequestBody @Valid SavePostingRequest request){
        Posting posting = modelMapper.map(request.postingDto,Posting.class);
        User findUser = userService.findOne(request.getUserId());
        postingService.savePosting(posting, findUser);

    }

    @PutMapping("/posts/{id}")
    public void editPost(@RequestBody @Valid PostingDto request, @PathVariable Long id){
        Posting posting = modelMapper.map(request, Posting.class);

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
        private Long userId;
    }
}
