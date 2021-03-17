package com.cleevio.task.eshop.unit;

import com.cleevio.task.eshop.dao.Watch;
import com.cleevio.task.eshop.dao.WatchRepository;
import com.cleevio.task.eshop.service.WatchService;
import com.cleevio.task.eshop.service.WatchServiceImpl;
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
class WatchServiceTests {
    @Mock
    WatchRepository watchRepositoryMock;

    @InjectMocks
    private WatchService watchService = new WatchServiceImpl();

    private Watch watchWithNoNullAttr1;
    private Watch watchWithNoNullAttr2;
    private Watch watchWithNullID;

    @BeforeEach
    public void tearUp(){
        watchWithNoNullAttr1 = Watch.builder()
                .id(1L)
                .title("Random title 1")
                .price(120)
                .image((new String("Random image1").getBytes()))
                .description("Random desc 1")
                .build();

        watchWithNoNullAttr2 = Watch.builder()
                .id(2L)
                .title("Random title 2")
                .price(220)
                .image((new String("Random image2").getBytes()))
                .description("Random desc 2")
                .build();

        watchWithNullID = Watch.builder()
                .id(null)
                .title("Random title 1")
                .price(120)
                .image((new String("Random image1").getBytes()))
                .description("Random desc 1")
                .build();
    }
    @Test
    void createWithIdNonNullTest() {
        assertThrows(IllegalArgumentException.class,()->{
            watchService.create(watchWithNoNullAttr1);});
    }

    @Test
    void updateWithIdNullTest() {
        assertThrows(IllegalArgumentException.class,()->{
            watchService.update(watchWithNullID);});
    }

    @Test
    void createAndRetrieve_ShouldCreateAndRetrieve_WhenWatchIdIsNull() {
        when(watchRepositoryMock.findById(any(Long.class))).thenReturn(Optional.of(watchWithNullID));
        doAnswer(invocation-> {
            Object[] args = invocation.getArguments();
            ((Watch)args[0]).setId(1L);
            return null;
        }).when(watchRepositoryMock).save(any(Watch.class));

        watchService.create(watchWithNullID);

        assertThat(watchService.findById(watchWithNullID.getId()).get()).isEqualTo(watchWithNullID);
    }
}
