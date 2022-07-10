package MoonHalo.Fatalism.features;

import MoonHalo.Fatalism.Notification.NotificationManager;
import MoonHalo.Fatalism.Fatalism;
import MoonHalo.Fatalism.features.Commands.toggle;
import MoonHalo.Fatalism.features.Modules.Render.Watermark;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {
    public static @NotNull List<Feature> featureList = new ArrayList<>();
    private static FeatureManager instance = new FeatureManager();

    public static FeatureManager getInstance(){
        return instance;
    }
    public FeatureManager(){
        Add(new Watermark());
        Add(new toggle());
        //new features.
    }
    public Feature getFeatureByName(String name) throws ClassNotFoundException {
        for(Feature feature : featureList){
            Fatalism.logger.info(feature.name);
            if(feature.name.equals(name)){
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
}
