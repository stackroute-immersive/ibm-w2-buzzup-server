package com.stackroute.buzzup.kafka.domain;

import java.util.List;

public class Seats {

	private int rows;
	private int cols;
	private List<Integer> rowValues;
	private List<Integer> colValues;

	public Seats() {
		super();
	}

	public Seats(int totalRow, int totalCol, List<Integer> rowValues, List<Integer> colValues) {
		super();
		this.rows = totalRow;
		this.cols = totalCol;
		this.rowValues = rowValues;
		this.colValues = colValues;
	}

	public int getTotalRow() {
		return rows;
	}

	public void setTotalRow(int totalRow) {
		this.rows = totalRow;
	}

	public int getTotalCol() {
		return cols;
	}

	public void setTotalCol(int totalCol) {
		this.cols = totalCol;
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

