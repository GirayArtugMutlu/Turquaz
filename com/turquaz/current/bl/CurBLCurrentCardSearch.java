/*
 * Created on 22.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.util.List;

import com.turquaz.current.dal.CurDALCurrentCardSearch;
import com.turquaz.engine.dal.TurqCurrentGroup;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurBLCurrentCardSearch {
	
	public CurBLCurrentCardSearch(){
	
	}
	
	private CurDALCurrentCardSearch curDALCurrentCardSearch=new CurDALCurrentCardSearch();
	
	public List searchCurrentCard(String currentCode, String currentName,
									TurqCurrentGroup currentGroup)
	throws Exception{
		try{
			return curDALCurrentCardSearch.searchCurrentCards(currentCode,currentName,currentGroup);

		}
		catch(Exception ex){
			throw ex;
		}
	}

}
