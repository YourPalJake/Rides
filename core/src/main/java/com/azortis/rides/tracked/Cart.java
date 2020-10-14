/*
 * Create custom rides for your Minecraft server.
 *     Copyright (C) 2020  Azortis
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.azortis.rides.tracked;

import com.azortis.rides.CustomModel;
import com.azortis.rides.nativeAPI.RidesStand;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Cart {

    // Runtime assignment of main stand of cart.
    private transient RidesStand mainStand;

    // Serializable values
    private CustomModel cartModel;
    private List<Seat> seats;

    public void applyModel(){
        ItemStack itemStack = new ItemStack(cartModel.getMaterial());
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setCustomModelData(cartModel.getCustomModelData());
        itemStack.setItemMeta(meta);
        Objects.requireNonNull(mainStand.getBukkitStand().getEquipment()).setHelmet(itemStack);
    }

}
