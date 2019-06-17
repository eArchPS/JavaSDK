/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author zemljics
 */
public enum RetentionTypeEnum
{
    NoRetentionSet (1),
    RetentionSet (2),
    RetentionWithEndOfTheYearSet (3);
    
    private final int index;

    private RetentionTypeEnum(int index)
    {
        this.index = index;
    }
    
    public int index()
    {
        return index;
    }
}
