package io.bluebeaker.quitmenu;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = QuitMenu.MODID,type = Type.INSTANCE,category = "general")
public class QuitMenuConfig {
    @Comment("Enable the mod")
    @LangKey("config.quitmenu.enable.name")
    public static boolean enable = true;

    @Comment("Swap yes and no buttons placement in the quit menu.")
    @LangKey("config.quitmenu.swapButtons.name")
    public static boolean swapButtons = false;
}