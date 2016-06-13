package lu.crx.proto.arq;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import org.junit.Assert;

@RunWith(Arquillian.class)
public class JUnitTestExample {

    @Deployment
    public static JavaArchive createArchive() {
        return ShrinkWrap
                .create(JavaArchive.class, "helloEJB.jar")
                .addClasses(MyBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private MyBean myBean;

    @Test
    public void shouldBeInjected() {
        System.err.println("####################################");
        Assert.assertNotNull(myBean);
    }

    @Test
    public void shouldBeInjected2() {
        Assert.assertNotNull(myBean);
    }
}
