package com.slyang.im;

import com.corundumstudio.socketio.store.RedissonStoreFactory;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisClient {

	public interface REDISKEY{
		String IM_USERID = "im:%1s";
	}

	@Bean
	RedissonClient redissonClient() {
		Config config = new Config();
		config.useSingleServer()
				.setAddress("127.0.0.1:6379");
		return Redisson.create(config);
	}

	@Bean
	RedissonStoreFactory redissonStoreFactory(RedissonClient redissonClient) {
		return new RedissonStoreFactory((Redisson) redissonClient);
	}

}