package info.u_team.music_player.impl.render.gui.button.special;

import static info.u_team.music_player.impl.render.MusicPlayerTextures.texture_button_shuffle;

import info.u_team.music_player.impl.render.gui.button.GuiButtonImageActivatedMusicPlayer;
import net.hycrafthd.basiclavamusicplayer.MusicPlayer;
import net.minecraft.client.Minecraft;

public class GuiButtonImageShuffle extends GuiButtonImageActivatedMusicPlayer {
	
	public GuiButtonImageShuffle(MusicPlayer musicplayer, int id, int x, int y, int width, int height) {
		super(musicplayer, id, x, y, width, height, texture_button_shuffle, 0x80FF00FF);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		setActivated(musicplayer.getTrackScheduler().isShuffle());
		super.drawButton(mc, mouseX, mouseY);
	}
}