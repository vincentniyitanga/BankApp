/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.weber.cs3230.projects.finalproject;

/**
 *
 * @author zycmm
 */
public class InsufficientFundException extends Exception{
    @Override
    public String getMessage() {
        return "No enough balance, withdraw fails!";
    }
    
}
