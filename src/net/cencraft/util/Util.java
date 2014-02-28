package net.cencraft.util;

import net.cencraft.main.Main;
import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Util {

	public static void sendMessage(Player player, String message) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			String g = Main.perms.getPrimaryGroup(player);
			IChatBaseComponent comp = ChatSerializer
					.a("{\"text\":\"\",\"extra\":[{\"text\":\"[Hub] \",\"color\":\"white\"},{\"text\":\""
							+ player.getDisplayName()
							+ "\",\"color\":\"white\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\""
							+ g
							+ "\"},\"italic\":\"true\"},{\"text\":\""
							+ ": " + message + "\",\"color\":\"gray\"}]}");
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}
}
