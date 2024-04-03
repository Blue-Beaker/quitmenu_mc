package io.bluebeaker.examplemod;
@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "ExampleMod";
    public static final String VERSION = "1.0";
    
    public MinecraftServer server;

    private static Logger logger;
    
    public ExampleMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    @EventHandler
    public void onServerStart(FMLServerStartingEvent event){
        this.server=event.getServer();
    }

    @SubscribeEvent
    public void onConfigChangedEvent(OnConfigChangedEvent event) {
        if (event.getModID().equals(MODID)) {
            ConfigManager.sync(MODID, Type.INSTANCE);
        }
    }
}
