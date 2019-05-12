/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdp;

import java.util.ArrayList;


/**
 * Point Object is used to store the id and the data of the xi record.
 * 
 * @author Vasilis Vryniotis <bbriniotis at datumbox.com>
 */
public class Point {
    /**
     * The id variable is used to identify the xi record.
     */
    public Integer id;
    
    /**
     * The data variable is a RealVector which stores the information of xi record.
     */
    public ArrayList data;
    
    /**
     * Point Constructor which accepts a RealVector input.
     * 
     * @param id    The integer id of the point
     * @param data  The data of the point
     */
    public Point(Integer id, ArrayList data)  {
        this.id = id;
        this.data = data;
    }
}
