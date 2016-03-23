package com.weeryan17.vgs.GUIMannagemnt;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

import com.weeryan17.vgs.Main;
import com.weeryan17.vgs.util.PlayerUtil;
/**
 * This is the interface for using books.
 * 
 * @author weeryan17
 *
 */
public class Books {
	/**
	 * Represents the main class.
	 */
	Main instance;
	/**
	 * Constructor
	 * 
	 * @param instance the instance of the main class.
	 */
	public Books(Main instance){
		this.instance = instance;
	}
	/**
	 * Constructs a village control book for the specified rank.
	 * 
	 * @param village The specified village.
	 * @param rank The specified rank.
	 * @return The ItemStack representing the book.
	 */
	public ItemStack constructPermisionBook(String village, String rank){
		ItemStack book = new ItemStack(Material.BOOK_AND_QUILL);
		BookMeta bookmeta = (BookMeta) book.getItemMeta();
		bookmeta.setPage(1, "This is the permision book where you can assine permisions to ranks. This book if for the " + rank + " rank. Use the second page and onwards to assine permissions");
		bookmeta.setDisplayName(rank + " Book");
		book.setItemMeta(bookmeta);
		return book;
	}
	/**
	 * Gives a permission book for the specified rank to the specified player.
	 * 
	 * @param player The specified player.
	 * @param rank The specified rank.
	 */
	public void givePermisionBook(PlayerUtil player, String rank){
		String village = player.getVillage();
		PlayerInventory inv = player.getInventory();
		inv.addItem(this.constructPermisionBook(village, rank));
	}
}
