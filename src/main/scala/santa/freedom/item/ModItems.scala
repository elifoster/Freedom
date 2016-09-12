package santa.freedom.item

import net.minecraft.init.Items
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry
import santa.freedom.Freedom

object ModItems {
  var AMERICAN_FLAVORING = new Item()
    .setUnlocalizedName(Freedom.MODID + ":american_flavoring")
    .setCreativeTab(Freedom.tab)
    .setRegistryName(new ResourceLocation(Freedom.MODID, "american_flavoring"))

  var FLAG: Item = new Item()
    .setUnlocalizedName(Freedom.MODID + ":flag")
    .setCreativeTab(Freedom.tab)
    .setRegistryName(new ResourceLocation(Freedom.MODID, "flag"))

  var FREEDOM_BUCKET = new Item()
    .setUnlocalizedName(Freedom.MODID + ":freedom_bucket")
    .setCreativeTab(Freedom.tab)
    .setRegistryName(new ResourceLocation(Freedom.MODID, "freedom_bucket"))

  var FREEDOM_BREAD = new ItemFreedomFood(7, 1, false, List(Freedom.MODID + ".tooltip.tasteslikeamerica"))
    .setUnlocalizedName(Freedom.MODID + ":freedom_bread")
    .setRegistryName(new ResourceLocation(Freedom.MODID, "freedom_bread"))

  var FREEDOM_PIE = new ItemFreedomFood(10, 1, false, List(Freedom.MODID + ".tooltip.tasteslikeamerica"))
    .setUnlocalizedName(Freedom.MODID + ":freedom_pie")
    .setRegistryName(new ResourceLocation(Freedom.MODID, "freedom_pie"))

  var FRIED_CHICKEN = new ItemContainedFood(6, 2, false, List(), new ItemStack(FREEDOM_BUCKET))
    .setUnlocalizedName(Freedom.MODID + ":fried_chicken")
    .setRegistryName(new ResourceLocation(Freedom.MODID, "fried_chicken"))

  var MTN_DEW = new ItemContainedFood(1, 0, false, List(), new ItemStack(FREEDOM_BUCKET))
    .setUnlocalizedName(Freedom.MODID + ":mtn_dew")
    .setRegistryName(new ResourceLocation(Freedom.MODID, "mtn_dew"))

  def registerItems(): Unit = {
    AMERICAN_FLAVORING = GameRegistry.register(AMERICAN_FLAVORING)
    FLAG = GameRegistry.register(FLAG)
    FREEDOM_BUCKET = GameRegistry.register(FREEDOM_BUCKET)

    if (Freedom.config.enableBread) FREEDOM_BREAD = GameRegistry.register(FREEDOM_BREAD)
    if (Freedom.config.enablePie) FREEDOM_PIE = GameRegistry.register(FREEDOM_PIE)
    if (Freedom.config.enableFriedChicken) FRIED_CHICKEN = GameRegistry.register(FRIED_CHICKEN)
    if (Freedom.config.enableDew) MTN_DEW = GameRegistry.register(MTN_DEW)
  }

  def registerRecipes(): Unit = {
    GameRegistry.addRecipe(new ItemStack(AMERICAN_FLAVORING),
      "XXX",
      "XZX",
      "XXX",
      'X': Character, Items.SUGAR, 'Z': Character, FLAG
    )

    GameRegistry.addRecipe(new ItemStack(FLAG),
      "XYY",
      "ZZZ",
      "YYY",
      'X': Character, new ItemStack(Items.DYE, 1, 4),
      'Y': Character, new ItemStack(Items.DYE, 1, 15),
      'Z': Character, new ItemStack(Items.DYE, 1, 1)
    )

    GameRegistry.addShapelessRecipe(new ItemStack(FREEDOM_BUCKET), new ItemStack(Items.BUCKET), new ItemStack(FLAG))

    if (Freedom.config.enableBread) GameRegistry.addShapelessRecipe(new ItemStack(FREEDOM_BREAD), new ItemStack(Items.BREAD), new ItemStack(AMERICAN_FLAVORING))
    if (Freedom.config.enablePie) GameRegistry.addShapelessRecipe(new ItemStack(FREEDOM_PIE), new ItemStack(Items.PUMPKIN_PIE), new ItemStack(AMERICAN_FLAVORING))
    if (Freedom.config.enableFriedChicken) GameRegistry.addShapelessRecipe(new ItemStack(FRIED_CHICKEN), new ItemStack(Items.COOKED_CHICKEN), new ItemStack(FREEDOM_BUCKET))

    if (Freedom.config.enableDew) {
      GameRegistry.addRecipe(new ItemStack(MTN_DEW),
        "XXX",
        "XZX",
        "XXX",
        'X': Character, Items.SUGAR, 'Z': Character, FREEDOM_BUCKET
      )
    }
  }
}
