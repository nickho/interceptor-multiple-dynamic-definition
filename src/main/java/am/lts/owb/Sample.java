package am.lts.owb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@CustomInterceptorBinding1
@CustomInterceptorBinding2
@CustomInterceptorBinding3
public class Sample {

    @Inject
    private Sample2 sample2;

    public void doSomething() {
        sample2.doSomething();
    }

}
