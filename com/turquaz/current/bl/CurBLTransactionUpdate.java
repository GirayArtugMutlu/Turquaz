
package com.turquaz.current.bl;

import com.turquaz.current.dal.CurDALCurrentCardUpdate;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel Armagan
* @version  $Id$
*/

public class CurBLTransactionUpdate {

    static CurDALCurrentCardUpdate dalUpdate = new CurDALCurrentCardUpdate();
    
    public static void updateTrans(Object trans)throws Exception{
        try{
            
          dalUpdate.updateObject(trans);  
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
}
