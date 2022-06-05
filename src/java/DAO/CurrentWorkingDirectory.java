/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class CurrentWorkingDirectory {

    public static void main(String[] args) {

        printCurrentWorkingDirectory1();
        printCurrentWorkingDirectory2();
        printCurrentWorkingDirectory3();
        printCurrentWorkingDirectory4();

    }

    // System Property
    private static void printCurrentWorkingDirectory1() {
        String userDirectory = System.getProperty("user.dir")+File.separator +"web\\avatar";
        System.out.println(userDirectory);
    }

    // Path, Java 7
    private static void printCurrentWorkingDirectory2() {
        String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println(userDirectory);
    }

    // File("")
    private static void printCurrentWorkingDirectory3() {
        String userDirectory = new File("").getAbsolutePath();
        System.out.println(userDirectory);
    }

    // FileSystems
    private static void printCurrentWorkingDirectory4() {
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        System.out.println(userDirectory);
    }

}