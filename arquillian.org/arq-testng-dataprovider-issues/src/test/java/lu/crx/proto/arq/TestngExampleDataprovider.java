package lu.crx.proto.arq;

import org.jboss.arquillian.testng.Arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngExampleDataprovider extends Arquillian {

    @Deployment
    public static JavaArchive createArchive() {
        return ShrinkWrap
                .create(JavaArchive.class, "helloEJB.jar")
                .addClasses(MyBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @DataProvider(name = "numbers")
    public static Object[][] numbers() {
        return new Object[][]{{1}, {2}, {3}};
    }

    @Test(dataProvider = "numbers")
    public void alwaysPass(int param) {
        System.err.println("###### in alwaysPass / " + param);
    }
}
