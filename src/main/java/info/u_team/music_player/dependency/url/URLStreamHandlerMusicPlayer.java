package info.u_team.music_player.dependency.url;

import java.io.*;
import java.net.*;
import java.util.Optional;

public class URLStreamHandlerMusicPlayer extends URLStreamHandler {
	
	@Override
	protected URLConnection openConnection(URL url) throws IOException {
		return new URLConnection(url) {
			
			@Override
			public void connect() throws IOException {
			}
			
			public InputStream getInputStream() throws IOException {
				return Optional.ofNullable(getClass().getClassLoader().getResourceAsStream(URLDecoder.decode(url.getFile(), "UTF-8"))).orElseThrow(MalformedURLException::new);
			}
		};
	}
}