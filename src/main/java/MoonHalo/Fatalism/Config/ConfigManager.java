package MoonHalo.Fatalism.Config;

import MoonHalo.Fatalism.Config.Setting;
import MoonHalo.Fatalism.Config.Settings.BooleanSetting;
import MoonHalo.Fatalism.Config.Settings.IntSetting;
import MoonHalo.Fatalism.Config.Settings.ModeSetting;
import MoonHalo.Fatalism.Config.Settings.StringSetting;
import MoonHalo.Fatalism.Fatalism;
import MoonHalo.Fatalism.Utils.ClassUtil;
import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;
import MoonHalo.Fatalism.features.FeatureManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Map;

public class ConfigManager {
    private static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    private final File MODULE_FILE = new File(Fatalism.Name+"/Module.json");
    private static ConfigManager Instance = null;
    private static final JsonParser jsonParser = new JsonParser();

    public static ConfigManager getInstance() {
        if (Instance == null) {
            Instance = new ConfigManager();
        }
        return Instance;
    }

    public void Save() {
        if (!this.MODULE_FILE.exists()) {
            this.MODULE_FILE.getParentFile().mkdirs();
            try {
                MODULE_FILE.createNewFile();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        JsonObject father = new JsonObject();
        for (Feature feature : FeatureManager.featureList) {
            if (feature.category == Category.COMMAND) continue;
            Fatalism.logger.debug("Find feature " + feature.name);
            JsonObject moduleJson = new JsonObject();
            for (Field field : feature.getClass().getFields()) {
                Setting setting;
                Fatalism.logger.debug("Find field,name is " + field.getName());
                if (field.getType() == IntSetting.class) {
                    try {
                        Fatalism.logger.debug("int");
                        setting = (IntSetting)field.get(feature);
                        moduleJson.addProperty(field.getName(), (int)((Integer)setting.getValue()));
                    }
                    catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (field.getType() == BooleanSetting.class) {
                    try {
                        Fatalism.logger.debug("bool");
                        setting = (BooleanSetting)field.get(feature);
                        moduleJson.addProperty(field.getName(), (Boolean)setting.getValue());
                    }
                    catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (field.getType() == StringSetting.class) {
                    try {
                        Fatalism.logger.debug("str");
                        setting = (StringSetting)field.get(feature);
                        moduleJson.addProperty(field.getName(), (String)setting.getValue());
                    }
                    catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (field.getType() != ModeSetting.class) continue;
                try {
                    Fatalism.logger.debug("mode");
                    setting = (ModeSetting)field.get(feature);
                    moduleJson.addProperty(field.getName(), (String)setting.getValue());
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            father.add(feature.name, moduleJson);
        }
        PrintWriter saveJSon = null;
        try {
            saveJSon = new PrintWriter(new FileWriter(this.MODULE_FILE));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        saveJSon.println(gsonPretty.toJson(father));
        saveJSon.close();
    }

    public void loadModule() {
        if (this.MODULE_FILE.exists()) {
            try {
                Feature feature = null;
                BufferedReader loadJson = new BufferedReader(new FileReader(this.MODULE_FILE));
                JsonObject moduleJason = (JsonObject)jsonParser.parse(loadJson);
                loadJson.close();
                for (Map.Entry entry : moduleJason.entrySet()) {
                    try {
                        feature = FeatureManager.getInstance().getFeatureByName((String)entry.getKey());
                    }
                    catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (feature == null) continue;
                    JsonObject jsonMod = (JsonObject)entry.getValue();
                    for (Feature mod : FeatureManager.featureList) {
                        for (Field field : mod.getClass().getFields()) {
                            try {
                                Setting setting = (Setting)field.get(mod);
                                this.EzSet(setting, jsonMod, field.getName());
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                    }
                }
            }
            catch (Exception e) {
                Fatalism.logger.fatal("Failed to load module config!");
                e.printStackTrace();
            }
        }
    }

    private void EzSet(Setting<?> setting, JsonObject jsonmod, String fieldname) {
        if (setting instanceof IntSetting) {
            ((IntSetting)setting).setValue(jsonmod.get(fieldname).getAsInt());
        }
        if (setting instanceof BooleanSetting) {
            ((BooleanSetting)setting).setValue(jsonmod.get(fieldname).getAsBoolean());
        }
        if (setting instanceof StringSetting) {
            ((StringSetting)setting).setValue(jsonmod.get(fieldname).getAsString());
        }
    }

    public void SetFeatureSetting(Feature feature, String name, Object value) {
        try {
            for (Field field : feature.getClass().getFields()) {
                if (!field.getName().equals(name)) continue;
                Setting setting = (Setting)field.get(feature);
                if (setting instanceof IntSetting) {
                    ((IntSetting)setting).setValue((int)value);
                }
                if (setting instanceof BooleanSetting) {
                    ((BooleanSetting)setting).setValue((boolean)value);
                }
                if (!(setting instanceof StringSetting)) continue;
                ((StringSetting)setting).setValue((String) value);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//
// Timed out after 9000 ms
//
// Suggestion: Change the decompiler or switch the class mode to TABLE