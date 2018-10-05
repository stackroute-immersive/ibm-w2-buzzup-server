package com.stackroute.buzzup.kafka.model;

import java.util.List;

public class Seats {

	private int rows;
	private int cols;
	private List<Integer> rowValues;
	private List<Integer> colValues;

	public Seats() {
		super();
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
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

	public Seats(int rows, int cols, List<Integer> rowValues, List<Integer> colValues) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.rowValues = rowValues;
		this.colValues = colValues;
	}
	
}
