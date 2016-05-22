package br.com.mastermind.hazelcast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

/**
 * Embedded hazelcast configuration.
 * 
 * @author Eduardo Jolo
 *
 */
@Configuration
public class HazelcastConfiguration {

	/**
	 * Local instance cache.
	 */
	public static final String LOCAL_INSTANCE_NAME = "local";

	/**
	 * Games cache id.
	 */
	public static final String GAME_CACHE_MAP_NAME = "games";

	/**
	 * Guesses cache id.
	 */
	public static final String GUESSES_CACHE_MAP_NAME = "guesses";
	
	/**
	 * Players cache id.
	 */
	public static final String PLAYERS_CACHE_MAP_NAME = "players";
	
	/**
	 * Time to live of the elements in the caches.
	 */
	private static final int TIME_TO_LIVE = 172800;

	/**
	 * Configuration method.
	 * 
	 * @return Config
	 */
	@Bean
	public Config config() {

		Config config = new Config(LOCAL_INSTANCE_NAME)
				.addMapConfig(
						new MapConfig()
							.setName(GAME_CACHE_MAP_NAME)
							.setEvictionPolicy(EvictionPolicy.LRU)
							.setMaxSizeConfig(new MaxSizeConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_PERCENTAGE).setSize(10))
							.setTimeToLiveSeconds(TIME_TO_LIVE))
				.addMapConfig(
						new MapConfig()
							.setName(GUESSES_CACHE_MAP_NAME)
							.setEvictionPolicy(EvictionPolicy.LRU)
							.setMaxSizeConfig(new MaxSizeConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_PERCENTAGE).setSize(10))
							.setTimeToLiveSeconds(TIME_TO_LIVE))
				.addMapConfig(
						new MapConfig()
							.setName(PLAYERS_CACHE_MAP_NAME)
							.setEvictionPolicy(EvictionPolicy.LRU)
							.setMaxSizeConfig(new MaxSizeConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_PERCENTAGE).setSize(10))
							.setTimeToLiveSeconds(TIME_TO_LIVE));

		return config;
	}
}
