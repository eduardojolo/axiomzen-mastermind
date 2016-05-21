package br.com.mastermind.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hazelcast utils for Mastermind.
 * 
 * @author Eduardo Jolo
 *
 */
public class HazelcastMastermindUtils {

	/**
	 * Local instance.
	 */
	private static final HazelcastMastermindUtils utilsInstance;

	/**
	 * Hazelcast instance.
	 */
	private static HazelcastInstance hazelcastInstance;

	static {
		utilsInstance = new HazelcastMastermindUtils();

		hazelcastInstance = Hazelcast.getHazelcastInstanceByName(HazelcastConfiguration.LOCAL_INSTANCE_NAME);

	}

	/**
	 * Get the hazelcast utils instance.
	 * 
	 * @return HazelcastMastermindUtils
	 */
	public static synchronized HazelcastMastermindUtils getInstance() {
		return utilsInstance;
	}
}
