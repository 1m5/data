package io.onemfive.data.util;

import io.onemfive.data.*;
import io.onemfive.data.route.SimpleRoute;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Location Constants
 *
 * @author objectorange
 */
public final class DLC {

    public static final String CONTENT = "CONTENT";
    public static final String ENTITY = "ENTITY";
    public static final String EXCEPTIONS = "EXCEPTIONS";

    public static boolean addRoute(Class service, String operation, Envelope envelope) {
        envelope.getDynamicRoutingSlip().addRoute(new SimpleRoute(service.getName(),operation));
        return true;
    }

    public static boolean addContent(Object content, Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return false;
        }
        ((DocumentMessage)m).data.get(0).put(CONTENT, content);
        return true;
    }

    public static Object getContent(Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return null;
        }
        return ((DocumentMessage)m).data.get(0).get(CONTENT);
    }

    public static boolean addEntity(Object entity, Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return false;
        }
        ((DocumentMessage)m).data.get(0).put(ENTITY, entity);
        return true;
    }

    public static Object getEntity(Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return null;
        }
        return ((DocumentMessage)m).data.get(0).get(ENTITY);
    }

    public static boolean addException(Exception e, Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return false;
        }
        List<Exception> exceptions = (List<Exception>)((DocumentMessage)m).data.get(0).get(EXCEPTIONS);
        if(exceptions == null) {
            exceptions = new ArrayList<>();
            ((DocumentMessage)m).data.get(0).put(EXCEPTIONS, exceptions);
        }
        exceptions.add(e);
        return true;
    }

    public static List<Exception> getExceptions(Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return null;
        }
        List<Exception> exceptions = (List<Exception>)((DocumentMessage)m).data.get(0).get(EXCEPTIONS);
        if(exceptions == null) {
            exceptions = new ArrayList<>();
            ((DocumentMessage)m).data.get(0).put(EXCEPTIONS, exceptions);
        }
        return exceptions;
    }

    public static void addErrorMessage(String errorMessage, Envelope envelope) {
        envelope.getMessage().addErrorMessage(errorMessage);
    }

    public static List<String> getErrorMessages(Envelope envelope) {
        return envelope.getMessage().getErrorMessages();
    }

    public static boolean addData(Class clazz, Object object, Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return false;
        }
        DocumentMessage dm = (DocumentMessage)m;
        dm.data.get(0).put(clazz.getName(), object);
        return true;
    }

    public static Object getData(Class clazz, Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return null;
        }
        return ((DocumentMessage)m).data.get(0).get(clazz.getName());
    }

    public static boolean addNVP(String name, Object object, Envelope envelope){
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return false;
        }
        DocumentMessage dm = (DocumentMessage)m;
        dm.data.get(0).put(name, object);
        return true;
    }

    public static Object getValue(String name, Envelope envelope) {
        Message m = envelope.getMessage();
        if(!(m instanceof DocumentMessage)) {
            return null;
        }
        return ((DocumentMessage)m).data.get(0).get(name);
    }

    public static EventMessage getEventMessage(Envelope e) {
        Message m = e.getMessage();
        if(!(m instanceof EventMessage))
            return null;
        return (EventMessage)m;
    }
}
