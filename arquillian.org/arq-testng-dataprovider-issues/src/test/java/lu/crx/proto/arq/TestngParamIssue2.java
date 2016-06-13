package lu.crx.proto.arq;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jboss.arquillian.testng.Arquillian;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngParamIssue2 extends Arquillian {

    @Deployment
    public static Archive createArchive() {
        return ShrinkWrap
                .create(WebArchive.class, "hello.war")
                .addAsLibraries(Maven.resolver().resolve("org.hamcrest:hamcrest-core:1.3").withTransitivity().asFile())
                .addClasses(MyBean.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @DataProvider(name = "numbers")
    public static Object[][] numbers() {
        return new Object[][] {{1}, {2}, {3}};
    }

    @Test(dataProvider = "numbers")
    public void failTwoTimes(int param) {
        System.err.println("###### in failTwoTimes / " + param);        
        assertThat(param, is(1));
    }
        
}
