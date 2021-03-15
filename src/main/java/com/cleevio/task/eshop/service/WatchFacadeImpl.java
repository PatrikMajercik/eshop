package com.cleevio.task.eshop.service;

import com.cleevio.task.eshop.API.WatchDTO;
import com.cleevio.task.eshop.API.WatchFacade;
import com.cleevio.task.eshop.dao.Watch;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WatchFacadeImpl implements WatchFacade {

    @Autowired
    private WatchService watchService;

    @Override
    public void create(WatchDTO watchDTO) {
        Watch watch = convertToEntity(watchDTO);
        watchService.create(watch);
        watchDTO.setId(watch.getId());
    }

    @Override
    public Optional<WatchDTO> findById(Long id) {
        return Optional.ofNullable(convertToDTO(watchService.findById(id)));
    }

    @Override
    public void update(WatchDTO watchDTO) {
        watchService.update(convertToEntity(watchDTO));
    }

    @Override
    public List<WatchDTO> findAll() {
        return watchService.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(WatchDTO watchDTO) {
        watchService.delete(convertToEntity(watchDTO));
    }

    private Watch convertToEntity(WatchDTO watchDTO){
        return Watch.builder()
                .id(watchDTO.getId())
                .title(watchDTO.getTitle())
                .price(watchDTO.getPrice())
                .image(Base64.decodeBase64(watchDTO.getImageBase64()))
                .description(watchDTO.getDescription())
                .build();
    }

    private WatchDTO convertToDTO(Watch watch){
        return WatchDTO.builder()
                .id(watch.getId())
                .title(watch.getTitle())
                .price(watch.getPrice())
                .imageBase64(Base64.encodeBase64String(watch.getImage()))
                .description(watch.getDescription())
                .build();
    }
    private WatchDTO convertToDTO(Optional<Watch> optWatch){
        if(!optWatch.isPresent()){
            return null;
        }
        Watch watch = optWatch.get();
        return WatchDTO.builder()
                .id(watch.getId())
                .title(watch.getTitle())
                .price(watch.getPrice())
                .imageBase64(Base64.encodeBase64String(watch.getImage()))
                .description(watch.getDescription())
                .build();
    }


}
