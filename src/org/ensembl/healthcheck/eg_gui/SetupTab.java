package org.ensembl.healthcheck.eg_gui;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTree;

import org.ensembl.healthcheck.GroupOfTests;
import org.ensembl.healthcheck.configuration.ConfigureHost;
import org.ensembl.healthcheck.testcase.EnsTestCase;

public class SetupTab extends JPanel {
	
	protected ActionListener actionListener;
	
	protected JPopupMenu listOfTestsToBeExecutedPopupMenu;
	protected TestInstantiatorDynamic testInstantiator;
	protected List<GroupOfTests> testGroupList;
	protected List<Class<EnsTestCase>> allTestsList;
	protected GroupOfTests allGroups;
	protected String jarFile;
	protected ConfigureHost primaryHostDetails;
	protected ConfigureHost secondaryHostDetails;
	
	protected List<ConfigureHost> dbDetails;

	/**
	 * Name of the server that will be set as default, if there is a 
	 * configuration for this.
	 */
	String defaultSecondaryServerName = "mysql.ebi.ac.uk";
	String defaultPrimaryServerName   = "staging-1";

	/**
	 * Directories in which configuration files for database servers will be 
	 * searched for.
	 * 
	 */
	String[] dirsWithDbServerConfigs = new String[] {

			// ~ does not work in java to reference the home directory:
			//
			// "~/.ensj",
			//
			System.getProperty("user.home") + "/.ensj"
	};

	// The gui widgets of this tab
	//
	protected JComboBox dbServerSelector;
	protected JComboBox secondaryDbServerSelector;
	
	protected DatabaseTabbedPaneWithSearchBox databaseTabbedPaneWithSearchBox;

	protected JTree tree;
	protected JPanel testsPane;
	protected JList listOfTestsToBeRun;
	protected JButton rmSelectedTests;
	protected JButton runAllTests;
	protected JButton runSelectedTests;
	
	protected MySqlConnectionWidget mysqlWidget;

}