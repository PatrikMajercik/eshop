package com.cleevio.task.eshop;

import com.cleevio.task.eshop.dao.Watch;
import com.cleevio.task.eshop.dao.WatchRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class WatchRepositoryTests {

	@Autowired
	private WatchRepository watchRepository;

	@Test
	void saveAndCountTest() {
		Watch watch = Watch.builder()
				.title("Watch title 1")
				.price(150).description("Test description")
				.image((new String("Random bytes")).getBytes())
				.build();

		watchRepository.save(watch);
		List<Watch> watches = watchRepository.findAll();
		assertThat(watches.size() ).isEqualTo(1);
	}

	@Test
	void saveAndRetrieveTest() {
		Watch watch = Watch.builder()
				.title("Watch title 2")
				.price(150)
				.image((new String("Random bytes")).getBytes())
				.description("Test description")
				.build();
		watchRepository.save(watch);
		Watch found = watchRepository.getOne(watch.getId());
		assertThat(found).isEqualTo(watch);
	}
	@Test
	void updateAndRetrieveTest() {
		Watch watch = Watch.builder()
				.title("Watch title 3")
				.price(250)
				.image((new String("Random bytes")).getBytes())
				.description("Test description")
				.build();

		watchRepository.save(watch);
		Watch found = watchRepository.getOne(watch.getId());
		assertThat(found).isEqualTo(watch);

		watch.setTitle("UPDATE");
		watchRepository.save(watch);
		 found = watchRepository.getOne(watch.getId());
		assertThat(found).isEqualTo(watch);
	}

}
