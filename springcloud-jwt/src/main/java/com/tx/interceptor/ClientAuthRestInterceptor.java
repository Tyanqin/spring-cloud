package com.tx.interceptor;

import com.tx.configuration.ClientConfiguration;
import com.tx.handler.BaseContextHandler;
import com.tx.jwt.IJWTInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author:TanXiao
 * @date:2022/7/26
 */
public class ClientAuthRestInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    com.tx.jwt.user.JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ClientConfiguration clientConfiguration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(clientConfiguration.getCenterTokenHeader());
        if(StringUtils.isNotEmpty(token)){
            IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(1,token);
            BaseContextHandler.setCenterName(infoFromToken.getCenterName());
            BaseContextHandler.setSiteID(null);
            BaseContextHandler.setUsername(null);
            BaseContextHandler.setName(null);
            BaseContextHandler.setUserID(null);
            BaseContextHandler.setTokenType(1);
            BaseContextHandler.setToken(token);
            return super.preHandle(request, response, handler);
        }
        token = request.getHeader(clientConfiguration.getSiteTokenHeader());
        if(StringUtils.isNotEmpty(token)){
            IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(2,token);
            BaseContextHandler.setCenterName(infoFromToken.getCenterName());
            BaseContextHandler.setSiteID(infoFromToken.getSiteId());
            BaseContextHandler.setUsername(null);
            BaseContextHandler.setName(null);
            BaseContextHandler.setUserID(null);
            BaseContextHandler.setTokenType(2);
            BaseContextHandler.setToken(token);
            return super.preHandle(request, response, handler);
        }
        token = request.getHeader(clientConfiguration.getUserTokenHeader());
        IJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(3,token);
        BaseContextHandler.setCenterName(infoFromToken.getCenterName());
        BaseContextHandler.setSiteID(infoFromToken.getSiteId());
        BaseContextHandler.setUsername(infoFromToken.getUniqueName());
        BaseContextHandler.setName(infoFromToken.getUserName());
        BaseContextHandler.setUserID(infoFromToken.getUserId());
        BaseContextHandler.setTokenType(3);
        BaseContextHandler.setToken(token);
        return super.preHandle(request, response, handler);
        //throw new SiteForbiddenException("Client is Forbidden!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
