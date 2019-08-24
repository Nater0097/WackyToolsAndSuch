package com.spikeyt.thermionic.wackytoolsandsuch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spikeyt.thermionic.wackytoolsandsuch.lists.ArmorMaterialList;
import com.spikeyt.thermionic.wackytoolsandsuch.lists.ToolMaterialList;
import com.spikeyt.thermionic.wackytoolsandsuch.lists.WackyToolsAndSuchBlockList;
import com.spikeyt.thermionic.wackytoolsandsuch.lists.WackyToolsAndSuchItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
					
					WackyToolsAndSuchItems.soap = new Item(new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap")),
					WackyToolsAndSuchItems.slippery_substance = new Item(new Item.Properties().group(WTASGROUP)).setRegistryName(location("slippery_substance")),
					
					//block items
					
					WackyToolsAndSuchItems.soap_block = new BlockItem(WackyToolsAndSuchBlockList.soap_block, new Item.Properties().group(WTASGROUP)).setRegistryName(WackyToolsAndSuchBlockList.soap_block.getRegistryName()),
					WackyToolsAndSuchItems.slippery_launcher = new BlockItem(WackyToolsAndSuchBlockList.slippery_launcher, new Item.Properties().group(WTASGROUP)).setRegistryName(WackyToolsAndSuchBlockList.slippery_launcher.getRegistryName()),
					
					//Weapons/Tools
					
					WackyToolsAndSuchItems.soap_axe = new AxeItem(ToolMaterialList.soapaxemat, 0, -3.1f, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_axe")),
					WackyToolsAndSuchItems.soap_sword = new SwordItem(ToolMaterialList.soapswordmat, 0, -2.4f, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_sword")),
					WackyToolsAndSuchItems.soap_pickaxe = new PickaxeItem(ToolMaterialList.soappicmat, 0, -2.8f, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_pickaxe")),
					WackyToolsAndSuchItems.soap_hoe = new HoeItem(ToolMaterialList.soaphoemat, -1.5f, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_hoe")),
					WackyToolsAndSuchItems.soap_shovel = new ShovelItem(ToolMaterialList.soapshovelmat, 0, -3, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_shovel")),
					
					//armor
					WackyToolsAndSuchItems.soap_helmet = new ArmorItem(ArmorMaterialList.SoapMat, EquipmentSlotType.HEAD, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_helmet")),
					WackyToolsAndSuchItems.soap_chestplate = new ArmorItem(ArmorMaterialList.SoapMat, EquipmentSlotType.CHEST, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_chestplate")),
					WackyToolsAndSuchItems.soap_leggings = new ArmorItem(ArmorMaterialList.SoapMat, EquipmentSlotType.LEGS, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_leggings")),
					WackyToolsAndSuchItems.soap_boots = new ArmorItem(ArmorMaterialList.SoapMat, EquipmentSlotType.FEET, new Item.Properties().group(WTASGROUP)).setRegistryName(location("soap_boots"))
					
									
					);
			
			LOGGER.info("Items Registerd");
			
			
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event){
			
			event.getRegistry().registerAll(
					
					//blocks
					
					WackyToolsAndSuchBlockList.soap_block = new Block(Block.Properties.create(Material.ICE).hardnessAndResistance(0.4f, 0.4f).lightValue(0).slipperiness(1f).sound(SoundType.STONE)).setRegistryName(location("soap_block")),
					WackyToolsAndSuchBlockList.slippery_launcher = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).slipperiness(1.6f).sound(SoundType.METAL)).setRegistryName(location("slippery_launcher"))
									
					);
			
			LOGGER.info("BLocks Registerd");
			
			
		}
		
		
		
         private static ResourceLocation location(String name){
			
			return new ResourceLocation(MODID, name);
			
		}
		
	}
	
}
