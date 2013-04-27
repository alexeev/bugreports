package dozerissue;

import static org.junit.Assert.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.Mapping;
import org.junit.Test;


public class TestDozerAnnotation1 {

    static class A {
        @Mapping("answer")
        private int answer = 42;
    }

    static class B {
        private int answer;
        public boolean is42() { return 42 == answer; }
    }

    static class SubA extends A {} // NOK

    static class SubB extends B {} // OK

    Mapper mapper = new DozerBeanMapper();

    @Test // OK
    public void aToB() {
        B b = mapper.map(new A(), B.class);
        assertTrue(b.is42());
    }

    @Test // OK
    public void aToSub() {
        B b = mapper.map(new A(), SubB.class);
        assertTrue(b.is42());
    }

    @Test // NOK
    public void subToB() {
        B b = mapper.map(new SubA(), B.class);
        assertTrue(b.is42());
    }

    @Test // NOK
    public void subToSub() {
        B b = mapper.map(new SubA(), SubB.class);
        assertTrue(b.is42());
    }
}
