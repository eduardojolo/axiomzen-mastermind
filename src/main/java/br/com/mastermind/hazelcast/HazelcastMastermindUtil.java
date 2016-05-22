package br.com.mastermind.hazelcast;

import java.util.HashMap;
import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Hazelcast utils for Mastermind.
 * 
 * @author Eduardo Jolo
 *
 */
public class HazelcastMastermindUtil {

	/**
	 * Local instance.
	 */
	private static final HazelcastMastermindUtil utilsInstance = new HazelcastMastermindUtil();

	/**
	 * Hazelcast instance.
	 */
	private static HazelcastInstance hazelcastInstance;
	
	/**
	 * Map with all the accessed hazelcast maps names.
	 */
	private static Map<String, IMap<String, Object>> cacheMaps = new HashMap<String, IMap<String, Object>>();

	static {
		hazelcastInstance = Hazelcast.getHazelcastInstanceByName(HazelcastConfiguration.LOCAL_INSTANCE_NAME);
	}

	/**
	 * Static constructor for singleton
	 */
	private HazelcastMastermindUtil() {
	}

	/**
	 * Get the hazelcast utils instance.
	 * 
	 * @return HazelcastMastermindUtils
	 */
	public static HazelcastMastermindUtil getInstance() {
		return utilsInstance;
	}
	
	/**
	 * Gets IMap representation of the given chacheName.
	 * 
	 * @param cacheName Cache name
	 * @return Cache map instance
	 */
	public static IMap<String, Object> getIMap(String cacheName) {
		IMap<String, Object> map = cacheMaps.get(cacheName);

		if (map == null) {
			map = hazelcastInstance.getMap(cacheName);

			cacheMaps.put(cacheName, map);
		}

		return map;
	}
}
