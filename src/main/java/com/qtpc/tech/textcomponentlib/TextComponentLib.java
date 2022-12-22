package com.qtpc.tech.textcomponentlib;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.ChatColor;

public class TextComponentLib {
    public static String chat (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    /**
     * Text Component for hoverable and clickable text.
     *
     * @param s Message string
     * @param hover Hoverable option
     * @param hs Hover text
     * @param type Type of click event (command, link, suggest_command)
     * @param value Value of click event
     * @return Text Component
     */
    public static TextComponent hoverChat (String s, Boolean hover, String hs, String type, String value) {
        TextComponent message = new TextComponent(chat(s));
        if (hover) { message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(chat(hs)))); }
        if (type == "command") {
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, value));
        } else if (type == "link") {
            message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, value));
        } else if (type == "suggest_command") {
            message.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, value));
        }
        return message;
    }
}
