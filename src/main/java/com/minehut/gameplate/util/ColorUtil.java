package com.minehut.gameplate.util;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

public class ColorUtil {

    public static DyeColor parseDyeColor(String string) {
        for (DyeColor color : DyeColor.values()) {
            if (color.name().equals(Strings.getTechnicalName(string))) return color;
        }
        return DyeColor.WHITE;
    }

    public static Color convertChatColorToColor(ChatColor chatColor) {
        if (chatColor.isColor()) {
            switch (chatColor) {
                case AQUA:
                    return convertHexToRGB("55FFFF");
                case BLACK:
                    return convertHexToRGB("000000");
                case BLUE:
                    return convertHexToRGB("5555FF");
                case DARK_AQUA:
                    return convertHexToRGB("00AAAA");
                case DARK_BLUE:
                    return convertHexToRGB("0000AA");
                case DARK_GRAY:
                    return convertHexToRGB("555555");
                case DARK_GREEN:
                    return convertHexToRGB("00AA00");
                case DARK_PURPLE:
                    return convertHexToRGB("AA00AA");
                case DARK_RED:
                    return convertHexToRGB("AA0000");
                case GOLD:
                    return convertHexToRGB("FFAA00");
                case GRAY:
                    return convertHexToRGB("AAAAAA");
                case GREEN:
                    return convertHexToRGB("55FF55");
                case LIGHT_PURPLE:
                    return convertHexToRGB("FF55FF");
                case RED:
                    return convertHexToRGB("FF5555");
                case WHITE:
                    return convertHexToRGB("FFFFFF");
                case YELLOW:
                    return convertHexToRGB("FFFF55");
                default:
                    return convertHexToRGB("AAAAAA");
            }
        } else {
            return convertHexToRGB("AAAAAA");
        }
    }

    public static ChatColor convertDyeColorToChatColor(DyeColor dye) {
        switch (dye) {
            case WHITE:
                return ChatColor.WHITE;
            case ORANGE:
                return ChatColor.GOLD;
            case MAGENTA:
                return ChatColor.LIGHT_PURPLE;
            case LIGHT_BLUE:
                return ChatColor.BLUE;
            case YELLOW:
                return ChatColor.YELLOW;
            case LIME:
                return ChatColor.GREEN;
            case PINK:
                return ChatColor.RED;
            case GRAY:
                return ChatColor.DARK_GRAY;
            case SILVER:
                return ChatColor.GRAY;
            case CYAN:
                return ChatColor.DARK_AQUA;
            case PURPLE:
                return ChatColor.DARK_PURPLE;
            case BLUE:
                return ChatColor.DARK_BLUE;
            case BROWN:
                return ChatColor.GOLD;
            case GREEN:
                return ChatColor.DARK_GREEN;
            case RED:
                return ChatColor.DARK_RED;
            case BLACK:
                return ChatColor.BLACK;
        }

        return ChatColor.WHITE;
    }

    public static ChatColor convertDyeDataToChatColor(byte data) {
        switch (data) {
            case 0:
                return ChatColor.WHITE;
            case 1:
                return ChatColor.GOLD;
            case 2:
                return ChatColor.LIGHT_PURPLE;
            case 3:
                return ChatColor.BLUE;
            case 4:
                return ChatColor.YELLOW;
            case 5:
                return ChatColor.GREEN;
            case 6:
                return ChatColor.RED;
            case 7:
                return ChatColor.DARK_GRAY;
            case 8:
                return ChatColor.GRAY;
            case 9:
                return ChatColor.DARK_AQUA;
            case 10:
                return ChatColor.DARK_PURPLE;
            case 11:
                return ChatColor.DARK_BLUE;
            case 12:
                return ChatColor.GOLD;
            case 13:
                return ChatColor.DARK_GREEN;
            case 14:
                return ChatColor.DARK_RED;
            case 15:
                return ChatColor.BLACK;
        }

        return ChatColor.WHITE;
    }
    
    public static DyeColor convertChatColorToDyeColor(ChatColor chatColor) {
        switch (chatColor) {
            case WHITE:
                return DyeColor.WHITE;
            case AQUA:
                return DyeColor.LIGHT_BLUE;
            case GOLD:
                return DyeColor.ORANGE;
            case LIGHT_PURPLE:
                return DyeColor.MAGENTA;
            case YELLOW:
                return DyeColor.YELLOW;
            case GREEN:
                return DyeColor.LIME;
            case RED:
                return DyeColor.PINK;
            case GRAY:
                return DyeColor.SILVER;
            case DARK_GRAY:
                return DyeColor.GRAY;
            case DARK_AQUA:
                return DyeColor.CYAN;
            case DARK_PURPLE:
                return DyeColor.PURPLE;
            case DARK_BLUE:
                return DyeColor.BLUE;
            case BLUE:
                return DyeColor.BLUE;
            case DARK_GREEN:
                return DyeColor.GREEN;
            case DARK_RED:
                return DyeColor.RED;
            case BLACK:
                return DyeColor.BLACK;
        }

        return DyeColor.WHITE;
    }

    public static ChatColor convertBannerColorToChatColor(DyeColor dye) {
        switch (dye) {
            case WHITE:
                return ChatColor.WHITE;
            case ORANGE:
                return ChatColor.GOLD;
            case MAGENTA:
                return ChatColor.LIGHT_PURPLE;
            case LIGHT_BLUE:
                return ChatColor.BLUE;
            case YELLOW:
                return ChatColor.YELLOW;
            case LIME:
                return ChatColor.GREEN;
            case PINK:
                return ChatColor.RED;
            case GRAY:
                return ChatColor.DARK_GRAY;
            case SILVER:
                return ChatColor.GRAY;
            case CYAN:
                return ChatColor.DARK_AQUA;
            case PURPLE:
                return ChatUtil.HEADER;
            case BLUE:
                return ChatColor.BLUE;
            case BROWN:
                return ChatColor.GOLD;
            case GREEN:
                return ChatColor.DARK_GREEN;
            case RED:
                return ChatColor.DARK_RED;
            case BLACK:
                return ChatColor.BLACK;
        }

        return ChatColor.WHITE;
    }

    public static Color convertHexToRGB(String color) {
        return Color.fromRGB(Integer.valueOf(color.substring(0, 2), 16), Integer.valueOf(color.substring(2, 4), 16), Integer.valueOf(color.substring(4, 6), 16));
    }
}
