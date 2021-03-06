package raspdev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ParsConf {

	private Document doc = null;
	private IProject pro;
	private static File projectDirectory;
	private String path;
	private static String pathForConf;
	private static String pathConfig;
	public ParsConf()  {
		// TODO Auto-generated constructor stub
		// Get the currently selected project from the editor
        
		if(getCurrentSelectedProject()!=null){
			pro=getCurrentSelectedProject();
			projectDirectory=pro.getLocation().toFile();}
		else {pro=null;
		projectDirectory=null;
		}

	}


	public void generatePars() {

		if(projectDirectory!=null){
			path= projectDirectory.getAbsolutePath();
			pathConfig = projectDirectory.getAbsolutePath();
			pathConfig = pathConfig+File.separatorChar+"config"+File.separatorChar+"config.txt";
			path =path+File.separatorChar+"config"+File.separatorChar+"raspConf.xml";
			System.out.println(path);}
		else {
			path=new File(pathForConf+File.separatorChar+"raspConf.xml").toString();
		}
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(path);
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
	}

	
	public void setHostValues(String user,String host, String hostPath){

		XMLOutputter xmlOutput = new XMLOutputter();
		SAXBuilder builder = new SAXBuilder();

		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {

			org.jdom.Document docj = (org.jdom.Document) builder.build(path);
			Element rootNode = docj.getRootElement();
			rootNode.getChild("user").setText(user);
			rootNode.getChild("host").setText(host);
			rootNode.getChild("host-path").setText(hostPath);
			xmlOutput.output(docj, new FileWriter(path));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void setFrameBuffer(String frameBufferWidth, String frameBufferHeight){

		File f=new File(pathConfig);

		int sub = 0, count = 0;

		StringBuffer buffer=new StringBuffer();
		FileWriter fstream = null;
		try {
			BufferedReader input = new BufferedReader(new FileReader(f));

			String text=null;
			while ((text = input.readLine()) != null){
				buffer.append(text + "\n");
				if((buffer.indexOf("=", 2*sub))!=-1){
					count++;
					
					if(count>2)
						break;
					sub =buffer.indexOf("=",2*sub);
					if(count==1){
						buffer.replace(sub+1,text.length(),frameBufferWidth);
					}
					else {

						buffer.replace(sub+1,(text.length()*2),frameBufferHeight);
						
						//buffer.append("\n");

					}
				}
			}
			input.close();

			System.out.println(buffer.toString());
		} catch (IOException ioException) {
		}
		try {
			fstream = new FileWriter(f);
			BufferedWriter outobj = new BufferedWriter(fstream);
			outobj.write(buffer.toString());
			outobj.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    public static String getPathProject(){
    	
    	return projectDirectory.getAbsolutePath()+File.separatorChar;
    	
    }
    public static String getConfig() {
    	
    	return pathForConf;
    }
 public static void setConfig(String pathForString) {
    	
    	pathForConf=pathForString;
    }
	public Document getDoc() {
		return doc;
	}
	public static IProject getCurrentSelectedProject() {
		IProject project = null;
		ISelectionService selectionService = 
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

		ISelection selection = selectionService.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection)selection).getFirstElement();

			if (element instanceof IResource) {
				project= ((IResource)element).getProject();
			} 

		}
		return project;
	}

}
