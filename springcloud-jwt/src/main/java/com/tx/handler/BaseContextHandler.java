package com.tx.handler;

/**
 * Created by malong on 2018/2/15.
 */
import java.util.HashMap;
import java.util.Map;

public class BaseContextHandler
{
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal();

    public static void set(String key, Object value)
    {
        Map<String, Object> map;
        if ((map = (Map)threadLocal.get()) == null)
        {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key)
    {
        Map<String, Object> map;
        if ((map = (Map)threadLocal.get()) == null)
        {
            map = new HashMap();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getCentername()
    {
        Object localObject;
        return returnObjectValue(localObject = get("currentCenterName"));
    }
    public static String getSiteID()
    {
        Object localObject;
        return returnObjectValue(localObject = get("currentSiteId"));
    }

    public static String getSitename()
    {
        Object localObject;
        return returnObjectValue(localObject = get("currentSiteName"));
    }

    public static Integer getTokenType()
    {
        Object localObject = get("currentTokenType");
        return localObject ==null?null:(Integer)localObject;
    }

    public static String getUserID()
    {
        Object localObject;
        return returnObjectValue(localObject = get("currentUserId"));
    }

    public static String getUsername()
    {
        Object localObject;
        return returnObjectValue(localObject = get("currentUserName"));
    }

    public static String getName()
    {
        Object localObject = get("currentUser");
        return localObject==null?"":localObject.toString();
    }

    public static String getToken()
    {
        Object localObject = get("currentClientToken");
        return localObject==null?"":localObject.toString();
    }

    public static void setToken(String token)
    {
        set("currentClientToken", token);
    }

    public static void setName(String name)
    {
        set("currentUser", name);
    }

    public static void setUserID(String userID)
    {
        set("currentUserId", userID);
    }

    public static void setUsername(String username)
    {
        set("currentUserName", username);
    }

    public static void setCenterName(String name)
    {
        set("currentCenterName", name);
    }

    public static void setSiteID(String userID)
    {
        set("currentSiteId", userID);
    }

    public static void setSitename(String username)
    {
        set("currentSiteName", username);
    }

    public static void setTokenType(Integer tokenType)
    {
        set("currentTokenType", tokenType);
    }

    private static String returnObjectValue(Object value)
    {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static void remove()
    {
        threadLocal.remove();
    }
}