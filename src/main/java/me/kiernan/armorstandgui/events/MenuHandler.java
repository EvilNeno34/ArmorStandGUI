package me.kiernan.armorstandgui.events;

import me.kiernan.armorstandgui.ArmorStandGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuHandler implements Listener {

    ArmorStandGUI plugin;

    public MenuHandler(ArmorStandGUI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        final String MENU = ChatColor.AQUA + "Armor Stand GUI";
        final String CONFIRM_GLOW_MENU = ChatColor.GREEN + "Confirm Glow Options";
        final String CUSTOMIZE_MENU = ChatColor.GREEN + "Customize Armor Stand";
        final String WEAPON_MENU = ChatColor.AQUA + "Weapon Choice";
        final String ARMOR_MENU = ChatColor.BLUE + "Choose Armor";
        final String CONFIRM_ARMS_MENU = ChatColor.GREEN + "Confirm Arm Options";

        if (e.getView().getTitle().equalsIgnoreCase(MENU)) {
            switch (e.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    player.sendMessage("Opened Armor Stand Customization");
                    plugin.openCreateMenu(player);
                    break;
                case BARRIER:
                    player.sendMessage("Closed Armor Stand Menu");
                    player.closeInventory();
                    break;
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(CUSTOMIZE_MENU)) {

            if (!plugin.armorstand.containsKey(player)) {
                ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                stand.setVisible(false);
                plugin.armorstand.put(player, stand);
            }

            switch (e.getCurrentItem().getType()) {
                case GLOWSTONE:
                    player.sendMessage("Add Glow?");
                    plugin.openConfirmMenu(player);
                    break;
                case DIAMOND_SWORD:
                    player.sendMessage("Choose a Weapon to Add");
                    plugin.openWeaponMenu(player);
                    break;
                case DIAMOND_CHESTPLATE:
                    player.sendMessage("Choose Armor to Add");
                    plugin.openArmorMenu(player);
                    break;
                case ARMOR_STAND:
                    player.sendMessage("Add Arms?");
                    plugin.openArmConfirmMenu(player);
                    break;
                case CRAFTING_TABLE:
                    player.sendMessage("Armor Stand Created");
                    if (plugin.armorstand.containsKey(player)) {
                        ArmorStand stand = plugin.armorstand.get(player);
                        stand.setVisible(true);
                        plugin.armorstand.remove(player);
                    }
                    player.closeInventory();
                    break;
                case RED_WOOL:
                    player.sendMessage("Deleted Armor Stand");
                    if (plugin.armorstand.containsKey(player)) {
                        ArmorStand stand = plugin.armorstand.get(player);
                        stand.remove();
                        plugin.armorstand.remove(player);
                    }
                    plugin.openMenu(player);
                    break;
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(CONFIRM_GLOW_MENU)) {
            switch (e.getCurrentItem().getType()) {
                case GREEN_WOOL:
                    player.sendMessage("Glow Added");
                    if (plugin.armorstand.containsKey(player)) {
                        ArmorStand stand = plugin.armorstand.get(player);
                        stand.setGlowing(true);
                    }
                    plugin.openCreateMenu(player);
                    break;
                case RED_WOOL:
                    player.sendMessage("Glow Not Added. Make Another Choice?");
                    if (plugin.armorstand.containsKey(player)) {
                        ArmorStand stand = plugin.armorstand.get(player);
                        stand.setGlowing(false);
                    }
                    plugin.openCreateMenu(player);
                    break;
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(WEAPON_MENU)) {
            if (plugin.armorstand.containsKey(player)) {
                ArmorStand stand = plugin.armorstand.get(player);
                switch (e.getCurrentItem().getType()) {
                    case WOODEN_SWORD:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.WOODEN_SWORD) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Sword");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD));
                            player.sendMessage("Gave the Armor Stand a Wooden Sword");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case STONE_SWORD:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.STONE_SWORD) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Sword");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
                            player.sendMessage("Gave the Armor Stand a Stone Sword");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case IRON_SWORD:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.IRON_SWORD) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Sword");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                            player.sendMessage("Gave the Armor Stand an Iron Sword");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case GOLDEN_SWORD:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.GOLDEN_SWORD) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Sword");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.GOLDEN_SWORD));
                            player.sendMessage("Gave the Armor Stand a Gold Sword");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case DIAMOND_SWORD:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Sword");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD));
                            player.sendMessage("Gave the Armor Stand a Diamond Sword");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case NETHERITE_SWORD:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.NETHERITE_SWORD) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Sword");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
                            player.sendMessage("Gave the Armor Stand a Netherite Sword");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case BOW:
                        if (stand.getEquipment().getItemInMainHand().getType() == Material.BOW) {
                            stand.getEquipment().setItemInMainHand(null);
                            player.sendMessage("Removed Bow");
                        } else {
                            stand.getEquipment().setItemInMainHand(new ItemStack(Material.BOW));
                            player.sendMessage("Gave the Armor Stand a Bow");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case END_CRYSTAL:
                        player.sendMessage("Make Another Choice?");
                        plugin.openCreateMenu(player);
                        break;
                }
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ARMOR_MENU)) {
            if (plugin.armorstand.containsKey(player)) {
                ArmorStand stand = plugin.armorstand.get(player);
                switch (e.getCurrentItem().getType()) {
                    case LEATHER_CHESTPLATE:
                        if (stand.getEquipment().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
                            stand.getEquipment().setHelmet(null);
                            stand.getEquipment().setChestplate(null);
                            stand.getEquipment().setLeggings(null);
                            stand.getEquipment().setBoots(null);
                            player.sendMessage("Removed Armor");
                        } else {
                            stand.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                            stand.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                            stand.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                            stand.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                            player.sendMessage("Gave the Armor Stand Leather Armor");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case CHAINMAIL_CHESTPLATE:
                        if (stand.getEquipment().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE) {
                            stand.getEquipment().setHelmet(null);
                            stand.getEquipment().setChestplate(null);
                            stand.getEquipment().setLeggings(null);
                            stand.getEquipment().setBoots(null);
                            player.sendMessage("Removed Armor");
                        } else {
                            stand.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                            stand.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                            stand.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                            stand.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                            player.sendMessage("Gave the Armor Stand Chainmail Armor");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case IRON_CHESTPLATE:
                        if (stand.getEquipment().getChestplate().getType() == Material.IRON_CHESTPLATE) {
                            stand.getEquipment().setHelmet(null);
                            stand.getEquipment().setChestplate(null);
                            stand.getEquipment().setLeggings(null);
                            stand.getEquipment().setBoots(null);
                            player.sendMessage("Removed Armor");
                        } else {
                            stand.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
                            stand.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                            stand.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                            stand.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
                            player.sendMessage("Gave the Armor Stand Iron Armor");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case GOLDEN_CHESTPLATE:
                        if (stand.getEquipment().getChestplate().getType() == Material.GOLDEN_CHESTPLATE) {
                            stand.getEquipment().setHelmet(null);
                            stand.getEquipment().setChestplate(null);
                            stand.getEquipment().setLeggings(null);
                            stand.getEquipment().setBoots(null);
                            player.sendMessage("Removed Armor");
                        } else {
                            stand.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
                            stand.getEquipment().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
                            stand.getEquipment().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
                            stand.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
                            player.sendMessage("Gave the Armor Stand Golden Armor");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case DIAMOND_CHESTPLATE:
                        if (stand.getEquipment().getChestplate().getType() == Material.DIAMOND_CHESTPLATE) {
                            stand.getEquipment().setHelmet(null);
                            stand.getEquipment().setChestplate(null);
                            stand.getEquipment().setLeggings(null);
                            stand.getEquipment().setBoots(null);
                            player.sendMessage("Removed Armor");
                        } else {
                            stand.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                            stand.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                            stand.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                            stand.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                            player.sendMessage("Gave the Armor Stand Diamond Armor");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case NETHERITE_CHESTPLATE:
                        if (stand.getEquipment().getChestplate().getType() == Material.NETHERITE_CHESTPLATE) {
                            stand.getEquipment().setHelmet(null);
                            stand.getEquipment().setChestplate(null);
                            stand.getEquipment().setLeggings(null);
                            stand.getEquipment().setBoots(null);
                            player.sendMessage("Removed Armor");
                        } else {
                            stand.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
                            stand.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
                            stand.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
                            stand.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
                            player.sendMessage("Gave the Armor Stand Netherite Armor");
                        }
                        plugin.openCreateMenu(player);
                        break;
                    case END_CRYSTAL:
                        player.sendMessage("Make Another Choice?");
                        plugin.openCreateMenu(player);
                        break;
                }
            }
                e.setCancelled(true);
            } else if (e.getView().getTitle().equalsIgnoreCase(CONFIRM_ARMS_MENU)) {
                    switch (e.getCurrentItem().getType()) {
                        case GREEN_WOOL:
                            player.sendMessage("Arms Added");
                            if (plugin.armorstand.containsKey(player)) {
                                ArmorStand stand = plugin.armorstand.get(player);
                                stand.setArms(true);
                            }
                            plugin.openCreateMenu(player);
                            break;
                        case RED_WOOL:
                            player.sendMessage("Arms Not Added. Make Another Choice?");
                            if (plugin.armorstand.containsKey(player)) {
                                ArmorStand stand = plugin.armorstand.get(player);
                                stand.setArms(false);
                            }
                            plugin.openCreateMenu(player);
                            break;
                    }
                    e.setCancelled(true);
                }
            }
        }

