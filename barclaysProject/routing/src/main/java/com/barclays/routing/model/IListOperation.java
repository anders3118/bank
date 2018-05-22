package com.barclays.routing.model;

import com.barclays.routing.util.exception.NoDataFound;

import java.io.FileNotFoundException;

public interface IListOperation {
	public String getProviaders () throws NoDataFound , FileNotFoundException;
}
