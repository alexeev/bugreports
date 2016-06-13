package lu.crx.proto.arq;

import javax.inject.Inject;
import javax.transaction.UserTransaction;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jboss.arquillian.testng.Arquillian;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.testng.IHookCallBack;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.ConstructorOrMethod;

public class TestngParamFixed extends Arquillian {
    
    private final static String NUMBERS_PROVIDER = "numbers_provider";

    @Deployment
    public static Archive createArchive() {
        return ShrinkWrap
                .create(WebArchive.class, "hello.war")
                .addAsLibraries(Maven.resolver().resolve("org.hamcrest:hamcrest-core:1.3").withTransitivity().asFile())
                .addClasses(MyBean.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @DataProvider(name = NUMBERS_PROVIDER)
    public static Object[][] numbers() {
        return new Object[][]{{1}, {2}, {3}};
    }

    @Test(dataProvider = NUMBERS_PROVIDER)
    public void failTwoTimes(int param) {
        System.err.println("###### in failTwoTimes / " + param);
        assertThat(param, is(1));
    }

    @Test(dataProvider = NUMBERS_PROVIDER)
    public void failOneTime(int param) {
        System.err.println("###### in failOneTime / " + param);
        assertThat(param, not(1));
    }

    private static int runDelay = 0;
    private static String prevMethodId = null;
    private static ConstructorOrMethod prevMethod = null;

    @Inject
    private UserTransaction utx;

    @Override
    public void run(IHookCallBack callback, ITestResult testResult) {

        // on client
        if (utx == null) {
            super.run(callback, testResult);            
        }
        
        //on server
        else {
            
            ITestNGMethod testNgMethod = testResult.getMethod();

            if (!testNgMethod.getId().equals(prevMethodId)) {
                runDelay++;
            }

            if (!testNgMethod.getConstructorOrMethod().equals(prevMethod)) {
                runDelay = 0;
            }

            prevMethodId = testNgMethod.getId();
            prevMethod = testNgMethod.getConstructorOrMethod();

            if (testNgMethod.getCurrentInvocationCount() == runDelay) {
                super.run(callback, testResult);
            }
        }
    }
}
