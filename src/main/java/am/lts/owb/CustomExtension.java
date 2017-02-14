package am.lts.owb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InterceptionType;
import javax.enterprise.inject.spi.Interceptor;
import javax.interceptor.InvocationContext;

public class CustomExtension implements Extension {

    public void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager beanManager) {
        // Add a dynamic interceptor 1 with CustomInterceptor
        abd.addBean(new Interceptor<CustomInterceptor>() {

            public Set<Type> getTypes() {
                Set<Type> types = new HashSet<Type>();
                types.add(Object.class);
                return types;
            }

            public Set<Annotation> getQualifiers() {
                return Collections.emptySet();
            }

            public Class<? extends Annotation> getScope() {
                return Dependent.class;
            }

            public String getName() {
                return null;
            }

            public Set<Class<? extends Annotation>> getStereotypes() {
                return Collections.emptySet();
            }

            public Class<?> getBeanClass() {
                return Object.class;
            }

            public boolean isAlternative() {
                return false;
            }

            public boolean isNullable() {
                return false;
            }

            public Set<InjectionPoint> getInjectionPoints() {
                return Collections.emptySet();
            }

            public CustomInterceptor create(CreationalContext<CustomInterceptor> creationalContext) {
                return new CustomInterceptor();
            }

            public void destroy(CustomInterceptor instance, CreationalContext<CustomInterceptor> creationalContext) {
                // Nothing
            }

            public Set<Annotation> getInterceptorBindings() {
                Set<Annotation> types = new HashSet<Annotation>();
                types.add(new CustomInterceptorBinding1() {

                    public Class<? extends Annotation> annotationType() {
                        return CustomInterceptorBinding1.class;
                    }
                });
                return types;
            }

            public boolean intercepts(InterceptionType type) {
                return InterceptionType.AROUND_INVOKE == type;
            }

            public Object intercept(InterceptionType type, CustomInterceptor instance, InvocationContext ctx) {
                System.out.println("Intercepted 1 !");
                try {
                    return ctx.proceed();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        });

        // Add a dynamic interceptor 2 with Object
        abd.addBean(new Interceptor<Object>() {

            public Set<Type> getTypes() {
                Set<Type> types = new HashSet<Type>();
                types.add(Object.class);
                return types;
            }

            public Set<Annotation> getQualifiers() {
                return Collections.emptySet();
            }

            public Class<? extends Annotation> getScope() {
                return Dependent.class;
            }

            public String getName() {
                return null;
            }

            public Set<Class<? extends Annotation>> getStereotypes() {
                return Collections.emptySet();
            }

            public Class<?> getBeanClass() {
                return Object.class;
            }

            public boolean isAlternative() {
                return false;
            }

            public boolean isNullable() {
                return false;
            }

            public Set<InjectionPoint> getInjectionPoints() {
                return Collections.emptySet();
            }

            public Object create(CreationalContext<Object> creationalContext) {
                return new Object();
            }

            public void destroy(Object instance, CreationalContext<Object> creationalContext) {
                // Nothing
            }

            public Set<Annotation> getInterceptorBindings() {
                Set<Annotation> types = new HashSet<Annotation>();
                types.add(new CustomInterceptorBinding2() {

                    public Class<? extends Annotation> annotationType() {
                        return CustomInterceptorBinding2.class;
                    }
                });
                return types;
            }

            public boolean intercepts(InterceptionType type) {
                return InterceptionType.AROUND_INVOKE == type;
            }

            public Object intercept(InterceptionType type, Object instance, InvocationContext ctx) {
                System.out.println("Intercepted 2 !");
                try {
                    return ctx.proceed();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        });
    }

}
