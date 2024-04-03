package io.bluebeaker.examplemod;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = ExampleMod.MODID,type = Type.INSTANCE,category = "general")
public class ExampleModConfig {
    @Comment("Example")
    @LangKey("config.examplemod.example.name")
    public static boolean example = true;
}