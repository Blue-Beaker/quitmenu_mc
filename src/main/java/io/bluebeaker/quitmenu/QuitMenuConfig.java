package io.bluebeaker.quitmenu;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = QuitMenu.MODID,type = Type.INSTANCE,category = "general")
public class QuitMenuConfig {
    @Comment("Example")
    @LangKey("config.quitmenu.example.name")
    public static boolean example = true;
}