package com.weeryan17.vgs.GUIMannagemnt;

//import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import com.weeryan17.vgs.Main;

public class BookEdit implements Listener {
	Main instance;
	public BookEdit(Main instance){
		this.instance = instance;
	}
	@EventHandler
	public void onBookEdit(PlayerEditBookEvent event){
		BookMeta meta = event.getNewBookMeta();
		String pageOne = meta.getPage(1);
		if(pageOne.contains("This is the permision book where you can assine permisions to ranks.")){
			//ArrayList<String> permisionList = new ArrayList<String>();
			//String title = meta.getTitle();
			//String rank = title.replace(" Book", "");
			for(String page : meta.getPages()){
				this.instance.getLogger().info(page);
			}
		}
	}
}
