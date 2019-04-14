package info.u_team.music_player.gui.search;

import java.util.*;

import info.u_team.music_player.lavaplayer.api.*;

public class SearchList extends ArrayList<IAudioTrack> {
	
	private static final long serialVersionUID = 1L;
	
	private boolean changed = false;
	
	@Override
	public boolean add(IAudioTrack e) {
		changed = true;
		return super.add(e);
	}
	
	public boolean isChanged() {
		return changed;
	}
	
	public boolean isChangedAndReset() {
		if (changed) {
			changed = false;
			return true;
		}
		return false;
	}
}