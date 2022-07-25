package MoonHalo.Fatalism.features;

import MoonHalo.Fatalism.Notification.NotificationManager;
import MoonHalo.Fatalism.features.Commands.reload;
import MoonHalo.Fatalism.features.Commands.save;
import MoonHalo.Fatalism.features.Commands.toggle;
import MoonHalo.Fatalism.features.Modules.Render.EnableList;
import MoonHalo.Fatalism.features.Modules.Render.Watermark;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {
    public static @NotNull List<Feature> featureList = new ArrayList<>();
    private static final FeatureManager instance = new FeatureManager();

    public static FeatureManager getInstance(){
        return instance;
    }
    public FeatureManager(){
        Add(new Watermark());
        Add(new toggle());
        Add(new reload());
        Add(new EnableList());
        Add(new save());
        //new features.
    }
    public Feature getFeatureByName(String name) throws ClassNotFoundException {
        for(Feature feature : featureList){
            if(feature.name.equalsIgnoreCase(name)){
                return feature;
            }
        }
        NotificationManager.PrintMessage("Failed to search feature "+name+" !");
        throw new ClassNotFoundException();
    }
    public static void Add(Feature feature){
        try {
            featureList.add(feature);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public static List<Feature> getEnableFeatures() {
        ArrayList<Feature> enableList = new ArrayList<>();
        for (Feature feature : featureList) {
            if (!feature.enabled) continue;
            enableList.add(feature);
        }
        return enableList;
    }
}
