package santa.freedom.item

import java.util

import net.minecraft.client.resources.I18n
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemFood, ItemStack}
import santa.freedom.Freedom

import scala.collection.JavaConversions

class ItemFreedomFood(hunger: Int, saturation: Float, isWolfFood: Boolean, info: List[String]) extends ItemFood(hunger, saturation, isWolfFood) {
  setAlwaysEdible()
  setCreativeTab(Freedom.tab)
  setMaxStackSize(1)

  override def addInformation(stack: ItemStack, playerIn: EntityPlayer, tooltip: util.List[String], advanced: Boolean) = {
    val translated = info.map(f => I18n.format(f))
    val collection = JavaConversions.asJavaCollection(translated)
    tooltip.addAll(collection)
  }
}
