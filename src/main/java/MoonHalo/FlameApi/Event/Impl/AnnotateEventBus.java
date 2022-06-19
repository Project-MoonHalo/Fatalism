package MoonHalo.FlameApi.Event.Impl;

import MoonHalo.FlameApi.Event.EventApi;
import MoonHalo.FlameApi.Event.ListenerData;
import MoonHalo.Square.Square;
import MoonHalo.Square.Utils.ClassUtil;

import java.lang.reflect.Method;
import java.util.Comparator;

public class AnnotateEventBus implements EventApi {
    public AnnotateEventBus(){
        for (Class clz:ClassUtil.getClasses(Square.class.getName())){
            Register(clz);
        }
        ListenerList.sort(new ListenerComparator());
    }
    @Override
    public void Register(Class clz) {
        for(Method method: clz.getMethods()){
            if(method.isAnnotationPresent(Listener.class)){
                ListenerData listenerData = new ListenerData();
                listenerData.method = method;
                listenerData.Owner = clz;
                listenerData.Priority = method.getAnnotation(Listener.class).priority();
                ListenerList.add(listenerData);
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
