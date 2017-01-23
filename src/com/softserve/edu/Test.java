package com.softserve.edu;

/**
 * Created by Natalia on 20.01.2017.
 */
public class Test {
    String str = "Test";
    String str1 = "Тest1111";


    public String change(String str ){
        String newString;
        newString = str1 + str;

        return newString;


    }

    public String getStr() {
        return str;
    }

    public String changeStr(String str) {
        this.str = this.str + str;
        return this.str;
    }
}


class Test2 {
    public static void main(String[] args) {
        Test testTest = new Test();

        System.out.println(testTest.getStr());

        String str = testTest.changeStr("New");
        System.out.println(str);
        String newStr = testTest.change("sfkdsfk");
        System.out.println(newStr);

    }





}
