package com.stackroute.buzzup.theatreservice.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seats {
	private int rows;
	private int cols;
	private List<Integer> rowValues;
	private List<Integer> colValues;

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

	public Seats() {
		super();
	}

	public Seats(int rows, int cols, List<Integer> rowValues, List<Integer> colValues) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.rowValues = rowValues;
		this.colValues = colValues;
	}

	public List<Integer> getColValues() {
		return colValues;
	}

	public void setColValues(List<Integer> colValues) {
		this.colValues = colValues;
	}
}
