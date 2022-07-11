package org.example;

public class SectionTest {
    int outerVar = 1;

    public class InnerSection {
        int innerVar = 2;

        public void innerMethod() {
            System.out.println("InnerClass Method 실행");
            System.out.println(outerVar);
            System.out.println(innerVar);
        }
    }

    public void outer_inner_Method() {
        System.out.println("InnerMethod 호출");
    }

}
