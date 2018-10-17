package com.stackroute.buzzup.kafka.domain;

import java.util.List;

public class Seats {

	private int totalRow;
	private int totalCol;
	private List<Integer> rowValues;
	private List<Integer> colValues;

	public Seats() {
		super();
	}

	public Seats(int totalRow, int totalCol, List<Integer> rowValues, List<Integer> colValues) {
		super();
		this.totalRow = totalRow;
		this.totalCol = totalCol;
		this.rowValues = rowValues;
		this.colValues = colValues;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalCol() {
		return totalCol;
	}

	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}

	public List<Integer> getRowValues() {
		return rowValues;
	}

	public void setRowValues(List<Integer> rowValues) {
		this.rowValues = rowValues;
	}

	public List<Integer> getColValues() {
		return colValues;
	}

	public void setColValues(List<Integer> colValues) {
		this.colValues = colValues;
	}

}
