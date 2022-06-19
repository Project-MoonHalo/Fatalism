package MoonHalo.FlameApi.Event;

import MoonHalo.Square.Square;

import java.util.ArrayList;
import java.util.List;

public interface EventApi {
    public List<ListenerData> ListenerList = new ArrayList();
    public default void submit(Event event){
        for (ListenerData listenerData:ListenerList){
            try{
                Square.logger.info("tried to post event,method is "+listenerData.method+" ,owner is "+listenerData.Owner);
                listenerData.method.invoke(listenerData.Owner,event);
            }catch (Exception e){

            }
        }
    }
    public  void Register(Class clz);

}
