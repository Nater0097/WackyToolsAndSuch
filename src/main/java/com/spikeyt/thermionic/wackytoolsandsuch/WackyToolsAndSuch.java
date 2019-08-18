package com.spikeyt.thermionic.wackytoolsandsuch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spikeyt.thermionic.wackytoolsandsuch.lists.WackyToolsAndSuchItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("wtas")
public class WackyToolsAndSuch {
	
	public static WackyToolsAndSuch instance;
	public static final String MODID = "wtas";
	private static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public static final ItemGroup WTASGROUP = new WTASItemGroup();
	
	public WackyToolsAndSuch() {
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}	
	
	private void setup(final FMLCommonSetupEvent event){		
		LOGGER.info("Setup method registerd!");		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event){
		LOGGER.info("Client Registries method registerd!");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event){
			
			event.getRegistry().registerAll(
					
					//Items
					
					WackyToolsAndSuchItems.soap = new Item(new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap"))
					
					//Weapons
					
					
					
					);
			
			LOGGER.info("Items Registerd");
			
			
		}
		
         private static ResourceLocation location(String name){
			
			return new ResourceLocation(MODID, name);
			
		}
		
	}
	
}
