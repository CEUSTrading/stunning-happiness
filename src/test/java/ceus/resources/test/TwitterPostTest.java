package ceus.resources.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ceus.utility.TwitterPost;
import twitter4j.TwitterException;

public class TwitterPostTest {

	@Test
	public void test1() throws TwitterException {
		boolean a = TwitterPost.publicarTweet();
		assertTrue(a);
	}
	
}
