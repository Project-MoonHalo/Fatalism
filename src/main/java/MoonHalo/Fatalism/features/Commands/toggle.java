package MoonHalo.Fatalism.features.Commands;


import MoonHalo.Fatalism.features.Category;
import MoonHalo.Fatalism.features.Feature;
import MoonHalo.Fatalism.features.FeatureManager;

public class toggle extends Feature {
    public toggle(){
        super("toggle", Category.COMMAND,"toggle some features.");
    }
    @Override
    protected void onCall(String[] arg){
        try {
            FeatureManager.getInstance().getFeatureByName(arg[1]).Toggle();
        } catch (ClassNotFoundException e) {

        }
    }
}
