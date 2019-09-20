package com.kgc.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 配置zuul过滤器
 * 验证请求是否携带令牌
 * 用来进行权限管理；即通过过滤器来进行请求的拦截和过滤；过滤器中可以进行鉴权、签名校验、权限验证
 * 在启动类中配置过滤器
 */
@Component
public class AccessTokenFilter extends ZuulFilter {
    @Override
    /**
     * 过滤类型它决定过滤器在请求的哪个生命周期中执行
     * 	// pre：可以在请求被路由之前调用
     * 	// route：在路由请求时候被调用
     * 	// post：在route和error过滤器之后被调用
     * 	// error：处理请求时发生错误时被调用
     */
    public String filterType() {
        return "pre";
    }
    // filterOrder：过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
    @Override
    public int filterOrder() {
        return 0;
    }
    // shouldFilter：判断该过滤器是否需要被执行。
    // true表示该过滤器对所有请求都会生效。
    // 实际运用中我们可以利用该函数来指定过滤器的有效范围。
    @Override
    public boolean shouldFilter() {
        return true;
    }
// run：过滤器的具体逻辑。
    // 通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
    // 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
    // 也可以进一步优化比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
    public Object run() throws ZuulException {
        //获取网关请求的上下文对象
        RequestContext requestContest = RequestContext.getCurrentContext();
        //获取请求对象
        HttpServletRequest request = requestContest.getRequest();
        //判断请求中是否携带令牌
        String accessToken = request.getParameter("accessToken");
        System.out.println("令牌是"+accessToken);
        //验证令牌是不正确时
        if(accessToken==null || "zuul".equals(accessToken)){
            System.out.println("*******************************************");
            //设置不进行路由跳转
            requestContest.setSendZuulResponse(false);
            //响应401状态码为进行验证授权
            //返回错群五信息
            requestContest.setResponseBody("error token");
            requestContest.setResponseStatusCode(401);
            //响应编码格式
            requestContest.getResponse().setContentType("text/html;cahrset=UTF-8");
            return  null;

        }
        return null;


    }
}
