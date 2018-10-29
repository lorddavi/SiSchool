/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.davi.sischool.funcoes;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Davi
 */
public class CellRenderer extends DefaultTableCellRenderer {
    public CellRenderer(){
        super();
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
                if (column != 0){
                    this.setHorizontalAlignment(CENTER);
		} else {
                    this.setHorizontalAlignment(LEFT);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
    }
    
}
