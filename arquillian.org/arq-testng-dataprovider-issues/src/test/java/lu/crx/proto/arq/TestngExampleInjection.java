package lu.crx.proto.arq;

import org.jboss.arquillian.testng.Arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;


import javax.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngExampleInjection extends Arquillian {

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
        System.err.println("###### in shouldBeInjected");
        System.err.println(myBean);
        Assert.assertNotNull(myBean);
    }
}
