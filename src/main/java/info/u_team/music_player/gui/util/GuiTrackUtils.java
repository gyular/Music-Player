package info.u_team.music_player.gui.util;

import java.net.URI;

import info.u_team.music_player.lavaplayer.api.audio.*;
import info.u_team.music_player.util.TimeUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent.Action;

public class GuiTrackUtils {
	
	private static final Minecraft mc = Minecraft.getInstance();
	
	public static String trimToWith(String string, int width) {
		String newString = mc.fontRenderer.trimStringToWidth(string, width);
		if (!newString.equals(string)) {
			newString += "...";
		}
		return newString;
	}
	
	public static void addTrackInfo(IAudioTrack track, int x, int y, int entryWidth, int leftMargin, int titleColor) {
		
		int textSize = entryWidth - 150 - leftMargin;
		
		IAudioTrackInfo info = track.getInfo();
		
		String title = trimToWith(info.getFixedTitle(), textSize);
		String author = trimToWith(info.getFixedAuthor(), textSize);
		
		String duration;
		if (info.isStream()) {
			duration = "undefined";
		} else {
			duration = TimeUtil.timeConversion(track.getDuration() / 1000);
		}
		mc.fontRenderer.drawString(title, x + leftMargin, y + 5, titleColor);
		mc.fontRenderer.drawString(author, x + leftMargin + 4, y + 25, 0xD86D1C);
		mc.fontRenderer.drawString(duration, x + entryWidth - 140, y + 15, 0xFFFF00);
	}
	
	public static boolean openURI(String uri) {
		final Style style = new Style();
		try {
			new URI(uri);
			style.setClickEvent(new ClickEvent(Action.OPEN_URL, uri));
		} catch (Exception ex) {
			style.setClickEvent(new ClickEvent(Action.OPEN_FILE, uri));
		}
		return mc.currentScreen.handleComponentClick(new TextComponentString("").setStyle(style));
	}
	
}
