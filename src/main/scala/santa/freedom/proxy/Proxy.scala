package santa.freedom.proxy

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

abstract class Proxy {
  def registerItemModels(event: FMLPreInitializationEvent)
}
