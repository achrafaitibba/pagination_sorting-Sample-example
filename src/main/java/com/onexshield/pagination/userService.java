package com.onexshield.pagination;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Data
@Builder
@RequiredArgsConstructor
@Service
public class userService {
    private final userRepository userRepository;

    public void generateUser() {
        int i = 0;
        while (i < 100) {
            i++;
            userRepository.save(new user());
        }
    }


    public Page<user> getAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.valueOf("DESC"),"name");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository .findAll(pageable);
    }
}
