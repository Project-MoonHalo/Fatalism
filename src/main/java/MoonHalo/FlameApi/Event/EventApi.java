package MoonHalo.FlameApi.Event;

import MoonHalo.Fatalism.Fatalism;

import java.util.ArrayList;
import java.util.List;

public interface EventApi {
    public List<ListenerData> ListenerList = new ArrayList();
    public default void submit(Event event){
        for (ListenerData listenerData:ListenerList){
            try{
                Fatalism.logger.info("tried to post event,method is "+listenerData.method+" ,owner is "+listenerData.Owner);
                listenerData.method.invoke(listenerData.Owner,event);
            }catch (Exception e){

            }
        }
    }
    public  void Register(Object instance);
    public void Unregister(Object instance);
}
