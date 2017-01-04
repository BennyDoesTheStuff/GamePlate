package com.minehut.gameplate.module.modules.itemDrop;

import com.minehut.gameplate.GameHandler;
import com.minehut.gameplate.match.Match;
import com.minehut.gameplate.module.Module;
import com.minehut.gameplate.module.ModuleBuilder;
import com.minehut.gameplate.module.ModuleCollection;
import com.minehut.gameplate.module.modules.itemDrop.types.PickupItemDropModule;
import com.minehut.gameplate.module.modules.itemDrop.types.TimedItemDropModule;
import com.minehut.gameplate.module.modules.tasker.TaskerModule;
import com.minehut.gameplate.util.Items;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jdom2.DataConversionException;
import org.jdom2.Element;

/**
 * Created by Lucas on 1/4/2017.
 */
public class ItemDropModuleBuilder extends ModuleBuilder {

    @Override
    public ModuleCollection<? extends Module> load(Match match) {
        for (Element itemDropsElement : match.getDocument().getRootElement().getChildren("itemDrops")) {
            ModuleCollection<ItemDropModule> results = new ModuleCollection<>();
            for (Element itemDropElement : itemDropsElement.getChildren()) {
                String loc = itemDropElement.getAttributeValue("location");
                if (loc == null) continue;
                String[] split = loc.replace(" ", "").split(",");
                double x, y, z;
                try {
                    x = Double.parseDouble(split[0]);
                    y = Double.parseDouble(split[1]);
                    z = Double.parseDouble(split[2]);
                } catch (NumberFormatException ex) {
                    continue;
                }
                Location location = new Location(GameHandler.getGameHandler().getMatch().getCurrentMap().getWorld(), x, y, z);
                ItemStack item = Items.parseItemstack(itemDropElement);
                ItemDropModule module;
                if (itemDropElement.getAttribute("delay") != null) {
                    try {
                        module = new TimedItemDropModule(location, item, itemDropElement.getAttribute("delay").getIntValue());
                    } catch (DataConversionException ex) {
                        ex.printStackTrace();
                        continue;
                    }
                } else {
                    module = new PickupItemDropModule(location, item);
                }
                results.add(module);
            }
            return results;
        }
        return null;
    }

}
