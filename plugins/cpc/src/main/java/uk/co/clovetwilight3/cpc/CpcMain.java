package uk.co.clovetwilight3.cpc;

// import net.skinsrestorer.api.SkinsRestorerProvider; // Commented out - not used yet
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.clovetwilight3.cpc.commands.SystemCommand;
import uk.co.clovetwilight3.cpc.commands.FrontCommand;
import uk.co.clovetwilight3.cpc.listeners.ChatProxyListener;
import uk.co.clovetwilight3.cpc.commands.SystemCommandTabCompleter;
import uk.co.clovetwilight3.cpc.commands.FrontCommandTabCompleter;
// import uk.co.clovetwilight3.cpc.utils.SkinManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CpcMain extends JavaPlugin {
    public static final String MOD_NAME = "Clove's PluralCraft";
    private static final Path CONFIG_DIR = Path.of("plugins/CPC");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final Map<UUID, SystemData> systemDataMap = new HashMap<>();
    private static CpcMain instance;

    @Override
    public void onEnable() {
        getLogger().info("[CPC] " + MOD_NAME + " Loaded!");
        loadAllSystems();

        // SkinManager.initialize();

        instance = this;

        getCommand("system").setExecutor(new SystemCommand());
        getCommand("system").setTabCompleter(new SystemCommandTabCompleter());

        getCommand("front").setExecutor(new FrontCommand());
        getCommand("front").setTabCompleter(new FrontCommandTabCompleter());

        getServer().getPluginManager().registerEvents(new ChatProxyListener(), this);
    }

    public static CpcMain getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        saveAllSystems();
    }

    public static void loadAllSystems() {
        try {
            Files.createDirectories(CONFIG_DIR);
            Files.list(CONFIG_DIR).forEach(path -> {
                try {
                    UUID uuid = UUID.fromString(path.getFileName().toString().replace(".json", ""));
                    SystemData data = GSON.fromJson(Files.readString(path), SystemData.class);
                    systemDataMap.put(uuid, data);
                } catch (Exception e) {
                    System.err.println("Failed to load system file: " + path);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveAllSystems() {
        systemDataMap.forEach((uuid, system) -> saveSystem(uuid));
    }

    public static void saveSystem(UUID uuid) {
        try {
            Path filePath = CONFIG_DIR.resolve(uuid.toString() + ".json");
            Files.writeString(filePath, GSON.toJson(systemDataMap.get(uuid)));
        } catch (Exception e) {
            System.err.println("Failed to save system file: " + uuid);
        }
    }

    public static class SystemData {
        public String systemName;
        public Map<String, Boolean> fronts = new HashMap<>();
        public String activeFront = "";
        public Map<String, String> frontSkins = new HashMap<>(); // Stores front -> skin URL or username

        public SystemData(String systemName) {
            this.systemName = systemName;
        }
    }
}