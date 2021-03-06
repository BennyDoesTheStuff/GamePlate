package com.minehut.gameplate.module.modules.timers;

import com.minehut.gameplate.GameHandler;
import com.minehut.gameplate.chat.ChatConstant;
import com.minehut.gameplate.chat.ChatMessage;
import com.minehut.gameplate.chat.LocalizedChatMessage;
import com.minehut.gameplate.chat.UnlocalizedChatMessage;
import com.minehut.gameplate.event.CycleCompleteEvent;
import com.minehut.gameplate.event.MatchStartEvent;
import com.minehut.gameplate.match.MatchState;
import com.minehut.gameplate.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class StartTimer extends Countdown {


    @Override
    public BossBar createBossBar(Player player) {
        return Bukkit.createBossBar(getBossbarEndMessage(player).getMessage(player.spigot().getLocale()), BarColor.GREEN, BarStyle.SOLID);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCycleComplete(CycleCompleteEvent event) {
        super.startCountdown(Config.startDefault);
    }

    @EventHandler
    public void onMatchStart(MatchStartEvent event) {
        for (BossBar bossBar : super.bossBars) {
            bossBar.setVisible(false);
        }
    }

    @Override
    public ChatMessage getBossbarMessage(Player player) {
        return new UnlocalizedChatMessage(ChatColor.YELLOW + "{0}", new LocalizedChatMessage(ChatConstant.UI_STARTING_TIMER, new LocalizedChatMessage(ChatConstant.UI_SECONDS, ChatColor.RED.toString() + getTime() + ChatColor.YELLOW)));
    }

    @Override
    public ChatMessage getBossbarEndMessage(Player player) {
        return getBossbarMessage(player);
    }

    @Override
    public void onCountdownStart() {
        if(getTime() >= 1) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(getBossbarEndMessage(player).getMessage(player.spigot().getLocale()));
            }
        };
        GameHandler.getGameHandler().getMatch().setMatchState(MatchState.STARTING);
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void onCountdownEnd() {
        GameHandler.getGameHandler().getMatch().start();
    }

}