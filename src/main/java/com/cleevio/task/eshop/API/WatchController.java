package com.cleevio.task.eshop.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/watch")
public class WatchController {

    @Autowired
    WatchFacade watchFacade;

    @PostMapping(
            value="/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WatchDTO> create(@Validated @RequestBody WatchDTO watchDTO) {
        watchFacade.create(watchDTO);
        return (new ResponseEntity<WatchDTO>(HttpStatus.OK));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<WatchDTO> findUserById(@PathVariable(value = "id") long id) {

        Optional<WatchDTO> watchDTO = watchFacade.findById(id);

        if(watchDTO.isPresent()) {
            return ResponseEntity.ok().body(watchDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
