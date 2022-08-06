package me.kiernan.armorstandgui;

import me.kiernan.armorstandgui.commands.ArmorStandCommand;
import me.kiernan.armorstandgui.events.MenuHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class ArmorStandGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("armorstand").setExecutor(new ArmorStandCommand(this));
        getServer().getPluginManager().registerEvents(new MenuHandler(this), this);
    }

    public HashMap<Player, ArmorStand> armorstand = new HashMap<>();

    public void openMenu(Player player){
        Inventory menu = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Armor Stand GUI");

        ItemStack create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta meta = create.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Create Armor Stand");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.LIGHT_PURPLE + "Customize an Armor Stand!");
        meta.setLore(lore);
        create.setItemMeta(meta);

        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta exit_meta = exit.getItemMeta();
        exit_meta.setDisplayName(ChatColor.RED + "Exit Menu");
        exit.setItemMeta(exit_meta);

        menu.setItem(0, create);
        menu.setItem(8, exit);
        player.openInventory(menu);
    }

    public void openCreateMenu(Player player){
        Inventory create_menu = Bukkit.createInventory(player, 9, ChatColor.GREEN + "Customize Armor Stand");

        ItemStack glowOption = new ItemStack(Material.GLOWSTONE);
        ItemMeta glowMeta = glowOption.getItemMeta();
        glowMeta.setDisplayName(ChatColor.GOLD + "Glow");
        ArrayList<String> glowLore = new ArrayList<>();
        glowLore.add(ChatColor.YELLOW + "Makes the Armor Stand Glow!");
        glowMeta.setLore(glowLore);
        glowOption.setItemMeta(glowMeta);

        ItemStack weaponOption = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta weaponMeta = weaponOption.getItemMeta();
        weaponMeta.setDisplayName(ChatColor.AQUA + "Weapons");
        ArrayList<String> weaponLore = new ArrayList<>();
        weaponLore.add(ChatColor.LIGHT_PURPLE + "Add Weapons to the Armor Stand");
        weaponMeta.setLore(weaponLore);
        weaponOption.setItemMeta(weaponMeta);

        ItemStack armorOption = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta armorMeta = armorOption.getItemMeta();
        armorMeta.setDisplayName(ChatColor.DARK_AQUA + "Armor");
        ArrayList<String> armorLore = new ArrayList<>();
        armorLore.add(ChatColor.LIGHT_PURPLE + "Give the Armor Stand Some Armor");
        armorMeta.setLore(armorLore);
        armorOption.setItemMeta(armorMeta);

        ItemStack armOption = new ItemStack(Material.ARMOR_STAND);
        ItemMeta armMeta = armOption.getItemMeta();
        armMeta.setDisplayName(ChatColor.DARK_GREEN + "Arms");
        ArrayList<String> armLore = new ArrayList<>();
        armLore.add(ChatColor.LIGHT_PURPLE + "Give the Armor Stand Some Arms");
        armMeta.setLore(armLore);
        armOption.setItemMeta(armMeta);

        ItemStack backButton = new ItemStack(Material.RED_WOOL);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.RED + "Cancel Creation");
        backButton.setItemMeta(backButtonMeta);

        ItemStack confirmButton = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta confirmButtonMeta = confirmButton.getItemMeta();
        confirmButtonMeta.setDisplayName(ChatColor.GREEN + "Confirm & Create");
        confirmButton.setItemMeta(confirmButtonMeta);


        create_menu.setItem(0, glowOption);
        create_menu.setItem(1, weaponOption);
        create_menu.setItem(2, armorOption);
        create_menu.setItem(3, armOption);
        create_menu.setItem(7, confirmButton);
        create_menu.setItem(8, backButton);
        player.openInventory(create_menu);
    }

    public void openWeaponMenu(Player player){
        Inventory weapon_choice_menu = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Weapon Choice");

        ItemStack woodOption = new ItemStack(Material.WOODEN_SWORD);
        ItemStack stoneOption = new ItemStack(Material.STONE_SWORD);
        ItemStack ironOption = new ItemStack(Material.IRON_SWORD);
        ItemStack goldOption = new ItemStack(Material.GOLDEN_SWORD);
        ItemStack diamondOption = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack netherOption = new ItemStack(Material.NETHERITE_SWORD);
        ItemStack bowOption = new ItemStack(Material.BOW);
        ItemStack backButton = new ItemStack(Material.END_CRYSTAL);

        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.RED + "Back");
        backButton.setItemMeta(backButtonMeta);

        weapon_choice_menu.setItem(0, woodOption);
        weapon_choice_menu.setItem(1, stoneOption);
        weapon_choice_menu.setItem(2, ironOption);
        weapon_choice_menu.setItem(3, goldOption);
        weapon_choice_menu.setItem(4, diamondOption);
        weapon_choice_menu.setItem(5, netherOption);
        weapon_choice_menu.setItem(6, bowOption);
        weapon_choice_menu.setItem(8, backButton);
        player.openInventory(weapon_choice_menu);
    }

    public void openConfirmMenu(Player player){
        Inventory confirm_menu = Bukkit.createInventory(player, 27, ChatColor.GREEN + "Confirm Glow Options");

        ItemStack confirm_item = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirm_meta = confirm_item.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.GREEN + "Confirm");
        confirm_item.setItemMeta(confirm_meta);

        ItemStack deny_item = new ItemStack(Material.RED_WOOL);
        ItemMeta deny_meta = deny_item.getItemMeta();
        deny_meta.setDisplayName(ChatColor.RED + "Cancel");
        deny_item.setItemMeta(deny_meta);

        confirm_menu.setItem(12, confirm_item);
        confirm_menu.setItem(14, deny_item);
        player.openInventory(confirm_menu);
    }

    public void openArmConfirmMenu(Player player){
        Inventory arm_confirm_menu = Bukkit.createInventory(player, 27, ChatColor.GREEN + "Confirm Arm Options");

        ItemStack confirm_item = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirm_meta = confirm_item.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.GREEN + "Confirm");
        confirm_item.setItemMeta(confirm_meta);

        ItemStack deny_item = new ItemStack(Material.RED_WOOL);
        ItemMeta deny_meta = deny_item.getItemMeta();
        deny_meta.setDisplayName(ChatColor.RED + "Cancel");
        deny_item.setItemMeta(deny_meta);

        arm_confirm_menu.setItem(12, confirm_item);
        arm_confirm_menu.setItem(14, deny_item);
        player.openInventory(arm_confirm_menu);
    }

    public void openArmorMenu(Player player){
        Inventory armor_menu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "Choose Armor");

        ItemStack leather_option = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack chain_option = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack iron_option = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack gold_option = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemStack diamond_option = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack nether_option = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemStack backButton = new ItemStack(Material.END_CRYSTAL);

        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.RED + "Back");
        backButton.setItemMeta(backButtonMeta);

        armor_menu.setItem(0, leather_option);
        armor_menu.setItem(1, chain_option);
        armor_menu.setItem(2, iron_option);
        armor_menu.setItem(3, gold_option);
        armor_menu.setItem(4, diamond_option);
        armor_menu.setItem(5, nether_option);
        armor_menu.setItem(8, backButton);
        player.openInventory(armor_menu);
    }

}
