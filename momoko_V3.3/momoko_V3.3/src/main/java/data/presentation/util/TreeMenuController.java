package data.presentation.util;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import data.presentation.EmployeeController;
import data.presentation.ManagerController;
import data.presentation.EnterpriseController;
import data.presentation.ProjectController;
import data.presentation.AccountController;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

@SessionScoped
@Named("treeMenuBean")
public class TreeMenuController implements Serializable{
	
	private TreeNode root;
	
	private ArrayList<String> features = new ArrayList<String>(); 

	@Inject
	private EmployeeController employeeController;	
	@Inject
	private ManagerController managerController;	
	@Inject
	private EnterpriseController enterpriseController;	
	@Inject
	private ProjectController projectController;	
	@Inject
	private AccountController accountController;	

		
	public TreeMenuController() {
		root = new DefaultTreeNode("root", null);
		
		TreeNode employee = new DefaultTreeNode("employee",root);
		features.add("employee");
		TreeNode manager = new DefaultTreeNode("manager",root);
		features.add("manager");
		TreeNode enterprise = new DefaultTreeNode("enterprise",root);
		features.add("enterprise");
		TreeNode project = new DefaultTreeNode("project",root);
		features.add("project");
		TreeNode account = new DefaultTreeNode("account",root);
		features.add("account");
		
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public boolean isFeatureNode(String arg1){
		//System.out.println(arg1 + " " + features.contains(arg1));
		return  features.contains(arg1);
	}
	
	public String linkToFeatureList(String arg1){
		switch(arg1)
		{
			case "Employee":
				return employeeController.prepareList();
			case "Manager":
				return managerController.prepareList();
			case "Enterprise":
				return enterpriseController.prepareList();
			case "Project":
				return projectController.prepareList();
			case "Account":
				return accountController.prepareList();
			default: return "";
		}
	}
}
