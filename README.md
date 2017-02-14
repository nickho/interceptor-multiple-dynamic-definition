interceptor-multiple-dynamic-definition is a test project for OpenWebBeans Interceptors.

To test launch am.lts.owb.TestInterceptors.

There is 3 Interceptor styles.
- @CustomInterceptorBinding1 : a binding for a dynamically added interceptor on CustomInterceptor (POJO)
- @CustomInterceptorBinding2 : a binding for dynamically added interceptor on any class (Object)
- @CustomInterceptorBinding3 : a binding for a static interceptor

You can switch between OWB CDI1.0 and CDI1.2 in pom.xml by un-commenting the necessary dependencies (i will add profiles later if needed)