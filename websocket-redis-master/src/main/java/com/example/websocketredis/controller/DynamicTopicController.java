package com.example.websocketredis.controller;

import com.example.websocketredis.config.KafkaDynamicTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicTopicController {
    @Autowired
    private KafkaDynamicTopic kafkaDynamicTopic;
    @PostMapping("createTopic")
    public ResponseEntity<String> createTopic(@RequestParam String topic){
        try {
            kafkaDynamicTopic.createTopicDynamic(topic);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>("Topic " + topic + " created successfully.", HttpStatus.OK);
    }

    @DeleteMapping("deleteTopic")
    public ResponseEntity<String> deleteTopic(@RequestParam String topic) {
        kafkaDynamicTopic.deleteTopicDynamic(topic);
        return new ResponseEntity("Topic " + topic + " deleted successfully", HttpStatus.NO_CONTENT);
    }
}
