package com.baioretto.wishbottle;

import com.baioretto.wishbottle.bean.PostInfo;
import com.baioretto.wishbottle.mapper.BottleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WishbottleApplicationTests {
	@Autowired
	BottleMapper bottleMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		PostInfo postInfo = new PostInfo();
		postInfo.setUsername("ba");
		postInfo.setMessage("1");
		postInfo.setAvatar("1");
		bottleMapper.uploadInfo(postInfo);
		postInfo.setUsername("ssss");
		bottleMapper.uploadInfo(postInfo);
	}

}
