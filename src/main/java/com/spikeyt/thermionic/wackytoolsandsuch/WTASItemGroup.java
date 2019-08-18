package com.spikeyt.thermionic.wackytoolsandsuch;

import com.spikeyt.thermionic.wackytoolsandsuch.lists.WackyToolsAndSuchItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WTASItemGroup extends ItemGroup {
	
	public WTASItemGroup() {
		
		super("wtas");
		
	}
	
	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(WackyToolsAndSuchItems.soap);
	}

}
