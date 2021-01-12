package com.project.nitk.controller;

import com.project.nitk.model.User;
import com.project.nitk.model.request.UserRequest;
import com.project.nitk.model.response.UserResponse;
import com.project.nitk.repository.UserRepository;
import com.project.nitk.util.MediaUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@ModelAttribute UserRequest userRequest) throws IOException {
        System.out.println("Original Image Byte Size - " + userRequest.getProfilePicture().getBytes().length);
        User user = new User(userRequest.getName(), userRequest.getDesignation(), MediaUtility.compressBytes(userRequest.getProfilePicture().getBytes()));
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @CrossOrigin
    @GetMapping(path = { "/getAll" })
    public ResponseEntity<List<UserResponse>> getUser() throws IOException {
        List<User> users = (List<User>) userRepository.findAll();
        users.forEach(u -> System.out.println(u.getName()));
        List<UserResponse> response = users.stream().map(u -> new UserResponse(u.getId(), u.getName(), u.getDesignation(), Base64Utils.encodeToString(MediaUtility.decompressBytes(u.getPicByte())))).collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            userRepository.delete(user);
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
