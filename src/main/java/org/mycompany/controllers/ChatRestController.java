package org.mycompany.controllers;

import org.mycompany.dto.CreateChatDTO;
import org.mycompany.dto.ChatResponseDTO;
import org.mycompany.validators.CreateChatDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/chats")
public class ChatRestController {

    @Autowired
    private CreateChatDTOValidator createChatDTOValidator;

    @InitBinder("createChatDTO")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(createChatDTOValidator);
    }

    @GetMapping
    @ResponseBody
    public List<ChatResponseDTO> getAllChats(){
        List<ChatResponseDTO> list = new ArrayList<>();
        ChatResponseDTO dto = new ChatResponseDTO();
        dto.setChatID(34L);
        dto.setTitle("sdfkdjsfkds");
        dto.getMembersIDs().add(23L);
        dto.getMembersIDs().add(6346L);
        dto.getMembersIDs().add(6346346L);
        list.add(dto);
        list.add(dto);
        return list;
    }

    @GetMapping("/{chatID}")
    public ChatResponseDTO get(@PathVariable Long chatID) {
        ChatResponseDTO dto = new ChatResponseDTO();
        dto.setChatID(34L);
        dto.setTitle("sdfkdjsfkds");
        dto.getMembersIDs().add(23L);
        dto.getMembersIDs().add(6346L);
        dto.getMembersIDs().add(6346346L);
        return dto;
    }

    @PostMapping
    @ResponseBody
    public Object createChat(@Validated @RequestBody CreateChatDTO createChatDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().
                    stream().map(i -> i.getDefaultMessage()).collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
        }
        //todo: validate permission

        //todo: transform
        return 34L;
    }
}
