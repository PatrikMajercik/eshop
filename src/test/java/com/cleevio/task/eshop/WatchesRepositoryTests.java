package com.cleevio.task.eshop;

import com.cleevio.task.eshop.dao.WatchesDAO;
import com.cleevio.task.eshop.dao.WatchesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class WatchesRepositoryTests {

	@Autowired
	private WatchesRepository watchesRepository;

	@Test
	void saveAndCountTest() {
		WatchesDAO watchesDAO= WatchesDAO.builder().title("Watch title 1").price(150).description("Test description").build();
		watchesRepository.save(watchesDAO);
		List<WatchesDAO> watches = watchesRepository.findAll();
		assertThat(watches.size() ).isEqualTo(1);
	}

	@Test
	void saveAndRetrieveTest() {
		WatchesDAO watchesDAO= WatchesDAO.builder().title("Watch title 2").price(150).description("Test description").build();
		watchesRepository.save(watchesDAO);
		WatchesDAO found = watchesRepository.getOne(watchesDAO.getId());
		assertThat(found).isEqualTo(watchesDAO);
	}
	@Test
	void updateAndRetrieveTest() {
		WatchesDAO watchesDAO= WatchesDAO.builder().title("Watch title 3").price(250).description("Test description").build();
		watchesRepository.save(watchesDAO);
		WatchesDAO found = watchesRepository.getOne(watchesDAO.getId());
		assertThat(found).isEqualTo(watchesDAO);

		watchesDAO.setTitle("UPDATE");
		watchesRepository.save(watchesDAO);
		 found = watchesRepository.getOne(watchesDAO.getId());
		assertThat(found).isEqualTo(watchesDAO);
	}

}
