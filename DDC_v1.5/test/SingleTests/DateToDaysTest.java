/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleTests;

import socialnetworkingapplicaion.*;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author Дмитрий
 */
public class DateToDaysTest {
    @Test 
    public void testDateToDays(){
        
        Assert.assertTrue(DateManipulation.dateToDays(new Date(22, 11, 22, 0))==8391);
        Assert.assertTrue(DateManipulation.dateToDays(new Date(30, 11, 10, 0))==4016);
        Assert.assertTrue(DateManipulation.dateToDays(new Date(21, 9, 12, 0))==4677);
    }
}
