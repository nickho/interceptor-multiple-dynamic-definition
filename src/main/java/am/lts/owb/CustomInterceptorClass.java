package am.lts.owb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CustomInterceptorBinding3
public class CustomInterceptorClass {

    @AroundInvoke
    protected Object invoke(InvocationContext ctx) throws Exception {
        System.out.println("intercepted before");
        Object res = ctx.proceed();
        System.out.println("intercepted after");
        return res;
    }

}
