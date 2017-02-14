package am.lts.owb;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@CustomInterceptorBinding1
@CustomInterceptorBinding2
public class Sample2 {

    public void doSomething() {
        System.out.println("Done !");
    }

}
