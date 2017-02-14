package am.lts.owb;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestInterceptors {

    @Inject
    private Sample sample;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class).addAsManifestResource("META-INF/beans.xml", "beans.xml")
                .addPackage("am.lts.owb");

    }

    @Test
    public void testMultiple() {
        sample.doSomething();
    }

}
