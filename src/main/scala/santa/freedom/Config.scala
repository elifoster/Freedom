package santa.freedom

import net.minecraftforge.common.config.Configuration
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

class Config(val event: FMLPreInitializationEvent) {
  val config = new Configuration(event.getSuggestedConfigurationFile)
  config.load()

  config.addCustomCategoryComment("Feature", "Enable/disable features within the mod")
  val enableBread = config.get("Feature", "Toggle Freedom Bread", true).getBoolean
  val enablePie = config.get("Feature", "Toggle Freedom Pie", true).getBoolean
  val enableFriedChicken = config.get("Feature", "Toggle Fried Chicken", true).getBoolean
  val enableDew = config.get("Feature", "Dew the Dew or Dew not Dew the Dew", true).getBoolean

  config.save()
}
