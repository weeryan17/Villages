package com.weeryan17.vgs.GUIMannagemnt;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class Books {
	public ItemStack constructPermisionBook(String village, String rank){
		ItemStack book = new ItemStack(Material.BOOK_AND_QUILL);
		BookMeta bookmeta = (BookMeta) book.getItemMeta();
		bookmeta.setPage(1, "This is the permision book where you can asine permisions to ranks. This book if for the " + rank + " rank");
		book.setItemMeta(bookmeta);
		return book;
	}
}
