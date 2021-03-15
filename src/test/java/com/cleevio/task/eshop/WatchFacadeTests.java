package com.cleevio.task.eshop;

import com.cleevio.task.eshop.API.WatchDTO;
import com.cleevio.task.eshop.API.WatchFacade;
import com.cleevio.task.eshop.dao.Watch;
import com.cleevio.task.eshop.service.WatchFacadeImpl;
import com.cleevio.task.eshop.service.WatchService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class WatchFacadeTests {

    @Mock
    WatchService watchServiceMock;

    @InjectMocks
    WatchFacade watchFacade = new WatchFacadeImpl();

    private Watch watchWithNullId;
    private WatchDTO watchDTOWithNullId;

    @BeforeEach
    public void tearUp() {
        watchWithNullId = Watch.builder()
                .id(1L)
                .title("Random title 1")
                .price(120)
                .image((new String("Random image1").getBytes()))
                .description("Random desc 1")
                .build();

        watchDTOWithNullId = WatchDTO.builder()
                .id(watchWithNullId.getId())
                .title(watchWithNullId.getTitle())
                .price(watchWithNullId.getPrice())
                .imageBase64(Base64.encodeBase64String(watchWithNullId.getImage()))
                .description(watchWithNullId.getDescription())
                .build();
    }

    @Test
    void createAndRetrieve_ShouldCreateAndRetrieve_WhenWatchDTOIdIsNull() {
        doAnswer(invocation-> {
            Object[] args = invocation.getArguments();
            ((Watch)args[0]).setId(1L);
            return null;
        }).when(watchServiceMock).create(any(Watch.class));
        when(watchServiceMock.findById(any(Long.class))).thenReturn(Optional.of(watchWithNullId));

        watchFacade.create(watchDTOWithNullId);
        assertThat(watchFacade.findById(watchDTOWithNullId.getId()).get()).isEqualTo(watchDTOWithNullId);
    }
}
