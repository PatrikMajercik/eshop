package com.cleevio.task.eshop.API;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/watch")
@Slf4j
public class WatchController {

    @Autowired
    WatchFacade watchFacade;

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WatchDTO> create(@Validated @RequestBody WatchDTO watchDTO) {
        log.info("Starting processing creation of watch.");
        log.debug("Creating watchDTO :" + watchDTO);
        if (watchDTO.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        watchFacade.create(watchDTO);
        log.debug("Created watchDTO :" + watchDTO);
        return ResponseEntity.created(URI.create(watchDTO.getId().toString())).body(watchDTO);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<WatchDTO> findUserById(@PathVariable(value = "id") long id) {
        Optional<WatchDTO> watchDTO = watchFacade.findById(id);
        log.debug("Found watchDTO :" + watchDTO);
        if (watchDTO.isPresent()) {
            return ResponseEntity.ok().body(watchDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
