package utility;

import bot.botData.ThreadSafeTestContext;

public class TestLogic {
    public static void main(String[] args) {

        ThreadSafeTestContext.setGrade("Class 2");
        ThreadSafeTestContext.setGrade("Class 3");

        System.out.println(ThreadSafeTestContext.getGrade());
        System.out.println(ThreadSafeTestContext.getGrade());
        System.out.println(ThreadSafeTestContext.getGrade());
        System.out.println(ThreadSafeTestContext.getGrade());
        System.out.println(ThreadSafeTestContext.getGrade());
        System.out.println(ThreadSafeTestContext.getGrade());


    }
}
