package santa.freedom.proxy

import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import santa.freedom.Freedom
import santa.freedom.item.ModItems

class ClientProxy extends Proxy {
  override def registerItemModels(event: FMLPreInitializationEvent): Unit = {
    def setModelLoc(item: Item): Unit = {
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName, "inventory"))
    }
    setModelLoc(ModItems.FLAG)
    setModelLoc(ModItems.FREEDOM_BUCKET)
    setModelLoc(ModItems.AMERICAN_FLAVORING)
    if (Freedom.config.enableFriedChicken) setModelLoc(ModItems.FRIED_CHICKEN)
    if (Freedom.config.enableBread) setModelLoc(ModItems.FREEDOM_BREAD)
    if (Freedom.config.enablePie) setModelLoc(ModItems.FREEDOM_PIE)
    if (Freedom.config.enableDew) setModelLoc(ModItems.MTN_DEW)
  }
}
