package com.songr.songr;

import com.songr.songr.album.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test public void testConstructor(){
		Album album1 = new Album("Karma", "Taylor", 8, 721 );

		String artist = album1.getArtist();

		assertEquals("Taylor", artist);
	}

}
