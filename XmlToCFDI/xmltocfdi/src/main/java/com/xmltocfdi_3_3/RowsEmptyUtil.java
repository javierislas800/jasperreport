package com.xmltocfdi_3_3;

public class RowsEmptyUtil {

	private static final int MAXIMUM_NUMBER_ROWS_FIRST_PAGE = 23;
	private static final int MAXIMUM_NUMBER_ROWS_SECOND_PAGE = 43;
	
	private RowsEmptyUtil() {}
	
	public static int getRowsEmpty(int totalRows) {
		if (totalRows == MAXIMUM_NUMBER_ROWS_FIRST_PAGE || 
			(totalRows - MAXIMUM_NUMBER_ROWS_FIRST_PAGE)%(MAXIMUM_NUMBER_ROWS_SECOND_PAGE) == 0) {
			return 0;
		} else if (totalRows <= MAXIMUM_NUMBER_ROWS_FIRST_PAGE) {
			return MAXIMUM_NUMBER_ROWS_FIRST_PAGE - totalRows;
		} else {
			int rowsData = totalRows - MAXIMUM_NUMBER_ROWS_FIRST_PAGE;
			int pages = rowsData / MAXIMUM_NUMBER_ROWS_SECOND_PAGE;
			rowsData = rowsData - (pages * MAXIMUM_NUMBER_ROWS_SECOND_PAGE);
			return MAXIMUM_NUMBER_ROWS_SECOND_PAGE - rowsData;
		}
	}

}
