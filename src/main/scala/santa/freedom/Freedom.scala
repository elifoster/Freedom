package santa.freedom

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPreInitializationEvent}
import santa.freedom.item.ModItems

@Mod(modid = "santafreedom", name = "Freedom", version = "1781", modLanguage = "scala")
object Freedom {
  val MODID = "santafreedom"
  var tab: CreativeTabs = _
  var config: Config = _

  @SidedProxy(clientSide = "santa.freedom.proxy.ClientProxy")
  var PROXY: santa.freedom.proxy.Proxy = _

  @Mod.EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    config = new Config(event)
    tab = new CreativeTabs("Freedom") {
      override def getTabIconItem: Item = ModItems.FLAG
      override def hasSearchBar: Boolean = true
    }
    ModItems.registerItems()
    PROXY.registerItemModels(event)
  }

  @Mod.EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    ModItems.registerRecipes()
  }
}
