package com.weeryan17.vgs.GUIMannagemnt;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

import com.weeryan17.vgs.Main;
import com.weeryan17.vgs.util.PlayerUtil;

public class Books {
	Main instance;
	public Books(Main instance){
		this.instance = instance;
	}
	public ItemStack constructPermisionBook(String village, String rank){
		ItemStack book = new ItemStack(Material.BOOK_AND_QUILL);
		BookMeta bookmeta = (BookMeta) book.getItemMeta();
		bookmeta.setPage(1, "This is the permision book where you can assine permisions to ranks. This book if for the " + rank + " rank. Use the second page and onwards to assine permissions");
		book.setItemMeta(bookmeta);
		return book;
	}
	public void givePermisionBook(PlayerUtil p, String rank){
		String village = p.getVillage();
		PlayerInventory inv = p.getInventory();
		inv.addItem(this.constructPermisionBook(village, rank));
	}
}
