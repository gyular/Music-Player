package info.u_team.music_player.gui.search;

import info.u_team.music_player.init.MusicPlayerFonts;
import info.u_team.music_player.lavaplayer.api.IAudioTrack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;

public class GuiMusicSearchListEntry extends IGuiListEntry<GuiMusicSearchListEntry> {
	
	private final IAudioTrack track;
	
	private final GuiButtonAddPlaylist button;
	
	public GuiMusicSearchListEntry(IAudioTrack track) {
		this.track = track;
		button = new GuiButtonAddPlaylist(() -> System.out.println("CLICKED " + track.getInfo().getTitle()));
	}
	
	@Override
	public void drawEntry(int entryWidth, int entryHeight, int mouseX, int mouseY, boolean p_194999_5_, float partialTicks) {
		int textSize = entryWidth - 60;
		String title = track.getInfo().getTitle();
		if (title == null) {
			title = "NULL TITLE!!!!!!";
		}
		String trimmedTitle = MusicPlayerFonts.roboto.trimStringToWidth(title, textSize);
		if (!title.equals(trimmedTitle)) {
			trimmedTitle += "...";
		}
		MusicPlayerFonts.roboto.drawSplitString(trimmedTitle, getX(), getY() + 5, entryWidth - 100, 0xf4bc42);
		
		button.x = textSize + 30;
		button.y = getY() - 1;
		button.render(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int buttonType) {
		boolean clickedButton = button.mouseClicked(p_mouseClicked_1_, p_mouseClicked_3_, buttonType);
		if (clickedButton) {
			return true;
		} else if (buttonType == 0) {
			list.setSelectedEntry(getIndex());
			return true;
		} else if (buttonType == 1) {
			return Minecraft.getInstance().currentScreen.handleComponentClick(new TextComponentString("").setStyle(new Style().setClickEvent(new ClickEvent(Action.OPEN_URL, track.getInfo().getURI()))));
		}
		return false;
	}
	
	@Override
	public boolean mouseReleased(double p_mouseReleased_1_, double p_mouseReleased_3_, int buttonType) {
		return button.mouseReleased(p_mouseReleased_1_, p_mouseReleased_3_, buttonType);
	}
}