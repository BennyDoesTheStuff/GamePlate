package com.minehut.gameplate.module.modules.timers;

import com.minehut.gameplate.GameHandler;
import com.minehut.gameplate.chat.ChatConstant;
import com.minehut.gameplate.chat.ChatMessage;
import com.minehut.gameplate.chat.LocalizedChatMessage;
import com.minehut.gameplate.chat.UnlocalizedChatMessage;
import com.minehut.gameplate.event.MatchEndEvent;
import com.minehut.gameplate.event.MatchStartEvent;
import com.minehut.gameplate.match.MatchState;
import com.minehut.gameplate.util.ChatUtil;
import com.minehut.gameplate.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class CycleTimer extends Countdown {

    private boolean hasPlayed = false;

    @Override
    public BossBar createBossBar(Player player) {
        return Bukkit.createBossBar("", BarColor.BLUE, BarStyle.SOLID);
    }

    @EventHandler
    public void onMatchStart(MatchStartEvent event) {
        this.hasPlayed = true;
    }

    @EventHandler
    public void onMatchEnd(MatchEndEvent event) {
        startCountdown(Config.cycleDefault);
    }

    @Override
    public String getBossbarMessage(Player player) {
        return new UnlocalizedChatMessage(ChatColor.DARK_AQUA + "{0}", new LocalizedChatMessage(ChatConstant.UI_CYCLING_TIMER,
                new UnlocalizedChatMessage(ChatColor.AQUA + GameHandler.getGameHandler().getCycle().getMap().getName() + ChatColor.DARK_AQUA),
                new LocalizedChatMessage(getTime() == 1 ? ChatConstant.UI_SECOND : ChatConstant.UI_SECONDS, ChatColor.DARK_RED + "" + getTime() + ChatColor.DARK_AQUA)));
    }

    @Override
    public String getBossbarEndMessage(Player player) {
        return new UnlocalizedChatMessage(ChatColor.DARK_AQUA + "{0}", new LocalizedChatMessage(ChatConstant.UI_CYCLED_TO, ChatColor.AQUA + GameHandler.getGameHandler().getCycle().getMap().getName()));
    }

    @Override
    public void onCountdownStart() {
        if(getTime() >= 1) ChatUtil.broadcastMessage(getBossbarEndMessage());
        GameHandler.getGameHandler().getMatch().setMatchState(MatchState.CYCLING);
    }

    @Override
    public boolean canStart() {
        return !match.isRunning();
    }

    @Override
    public void onCountdownCancel() {
        match.setState(hasPlayed ? MatchState.ENDED : MatchState.WAITING);
    }

    @Override
    public void onCountdownEnd() {
        GameHandler.getGameHandler().cycleAndMakeMatch();
    }

}