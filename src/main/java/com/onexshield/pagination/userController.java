package com.onexshield.pagination;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class userController {
    private final userService userService;

    @GetMapping("/generate")
    public ResponseEntity<Void> generateUsers(){
        userService.generateUser();
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    public Page<user> getAll(@PathVariable Integer page, @PathVariable Integer size){
        return userService.getAll(page, size);
    }
}
