package my.fast.admin.framework.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;


/**
 * token工具
 *
 * @author cc
 */
public class TokenUtils {

    /**
     * 获取基础用户的id
     *
     * @param request HttpServletRequest
     * @return long
     */
    public static Long getUserId(HttpServletRequest request) {
        String token = request.getHeader("token");
        Assert.isTrue(StringUtils.isNotBlank(token), "用户未登录");
        String[] split = token.split("-");
        Assert.isTrue(split.length == 3, "请重新登录");
        String userId = split[0];
        Assert.notNull(userId, "用户信息为空");
        return Long.parseLong(String.valueOf(userId));
    }

    /**
     * 获取基础用户的id
     *
     * @param request HttpServletRequest
     * @return long
     */
    /*public static Long getUserIdByJWT(HttpServletRequest request) {
        String token = request.getHeader("token");
        Assert.isTrue(StringUtils.isNotBlank(token), "用户未登录");
        Claims claims = JWTUtils.parseJWT(token);
        Object object = claims.get("id");
        Assert.notNull(object, "用户信息为空");
        return Long.parseLong(String.valueOf(object));
    }*/
}
