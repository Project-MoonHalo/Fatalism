package MoonHalo.FlameApi.Event.Impl;

import MoonHalo.FlameApi.Event.EventApi;
import MoonHalo.FlameApi.Event.ListenerData;

import java.lang.reflect.Method;
import java.util.Comparator;

public class AnnotateEventBus implements EventApi {
    public AnnotateEventBus(){
        ListenerList.sort(new ListenerComparator());
    }
    @Override
    public void Register(Object instance) {
        Class clz = instance.getClass();
        for(Method method: clz.getMethods()){
            if(method.isAnnotationPresent(Listener.class)){
                ListenerData listenerData = new ListenerData();
                listenerData.method = method;
                listenerData.Owner = instance;
                listenerData.Priority = method.getAnnotation(Listener.class).priority();
                ListenerList.add(listenerData);
            }
        }
        ListenerList.sort(new ListenerComparator());
    }
    @Override
    public void Unregister(Object instance){
        for(ListenerData listenerData : ListenerList){
            if(listenerData.Owner == instance){
                ListenerList.remove(instance);
            }
        }
    }
}
class ListenerComparator implements Comparator<ListenerData> {
    @Override
    public int compare(ListenerData l1,ListenerData l2) {
        return l2.Priority - l1.Priority;
    }
}
