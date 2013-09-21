/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule.web.test;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsMetadata;

/**
 *
 * @author Akhil
 */
public class Test extends BaseOpenmrsMetadata implements Serializable {
    
    String one,two;
    Integer id;
    public String getTest()
    {
        return "this is a test string";
    }
    
    public String getOne()
    {
        return "This is one's property";
        
    }
    public String getTwo()
    {
        return "This is Two's property";
        
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer intgr) {
        this.id=intgr;
    }
    
}
