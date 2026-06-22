package com.endercrest.voidspawn;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.function.Consumer;

public class VoidCheckTask implements Consumer<ScheduledTask> {

    private final VoidListener listener;
    private final UUID playerId;

    public VoidCheckTask(VoidListener listener, UUID playerId) {
        this.listener = listener;
        this.playerId = playerId;
    }

    @Override
    public void accept(ScheduledTask task) {
        Player player = Bukkit.getPlayer(playerId);
        if (player == null) {
            task.cancel();
            return;
        }

        listener.performVoidSpawnCheck(player);
    }
}
