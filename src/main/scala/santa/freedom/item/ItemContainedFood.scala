package santa.freedom.item

import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.{ItemFood, ItemStack}
import net.minecraft.world.World
import santa.freedom.Freedom

class ItemContainedFood(hunger: Int, saturation: Float, isWolfFood: Boolean, info: List[String], container: ItemStack) extends ItemFood(hunger, saturation, isWolfFood) {
  setMaxStackSize(1)
  setAlwaysEdible()
  setCreativeTab(Freedom.tab)

  override def onItemUseFinish(stack: ItemStack, worldIn: World, entityLiving: EntityLivingBase): ItemStack = {
    super.onItemUseFinish(stack, worldIn, entityLiving)
    container.copy()
  }
}
