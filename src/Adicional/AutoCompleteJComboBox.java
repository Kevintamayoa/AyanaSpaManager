/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicional;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author macbook
 */
public class AutoCompleteJComboBox {
	static final long serialVersionUID = 4321421L;
	private final Searchable<String,String> searchable;
	/**

	 * Constructs a new object based upon the parameter searchable

	 * @param s

	 */
	public AutoCompleteJComboBox(Searchable<String,String> s,JComboBox j){
		super();
		this.searchable = s;
	j.setEditable(true);
		Component c = j.getEditor().getEditorComponent();
		if ( c instanceof JTextComponent ){
			final JTextComponent tc = (JTextComponent)c;
			tc.getDocument().addDocumentListener(new DocumentListener(){
				@Override
				public void changedUpdate(DocumentEvent arg0) {}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					update();
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					update();
				}
				public void update(){
					SwingUtilities.invokeLater(new Runnable(){
						@Override
						public void run() {
							List<String> founds = new ArrayList<String>(searchable.search(tc.getText()));
							Set<String> foundSet = new HashSet<String>();
                                                        
							for ( String s : founds ){
								foundSet.add(s.toLowerCase());
							}         
							Collections.sort(founds);
							j.setEditable(false);
							j.removeAllItems();    
							if ( !foundSet.contains( tc.getText().toLowerCase()) ){
								j.addItem( tc.getText() );
							}
							for (String s : founds) {
								j.addItem(s);
							}
							j.setEditable(true);
                                                        j.setPopupVisible(true);
                                                         tc.requestFocus();
						}
					});
				}
			});
                        
			tc.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					if ( tc.getText().length() > 0 ){
                                            tc.setCaretPosition(tc.getText().length());
						j.setPopupVisible(true);
                                          //      tc.setCaretPosition(tc.getText().length());
                                                j.setEditable(true);
                                                tc.requestFocus();
					}
				}
				@Override
				public void focusLost(FocusEvent arg0) {						
				}
			});
		}else{
			throw new IllegalStateException("Editing component is not a JTextComponent!");
		}

	}

}
