package dozerissue;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.Mapping;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestDozerAnnotation0 {

    static class A {
        private int answer = 42;
    }

    static class B {
        @Mapping("answer") private int answer;
        public boolean is42() { return 42 == answer; }
    }

    static class SubA extends A {}

    static class SubB extends B {}

    Mapper mapper = new DozerBeanMapper();

    @Test // OK
    public void subToB() {
        B b = mapper.map(new SubA(), B.class);
        assertTrue(b.is42());
    }

    @Test // NOK
    public void aToSub() {
        SubB b = mapper.map(new A(), SubB.class);
        assertTrue(b.is42());
    }

}
