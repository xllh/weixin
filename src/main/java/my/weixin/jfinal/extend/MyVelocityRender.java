package my.weixin.jfinal.extend;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.jfinal.core.JFinal;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

public class MyVelocityRender extends Render{
	
	private static final long serialVersionUID = -2409053202179375373L;
	private transient static final String encoding = getEncoding();
	private transient static final String contentType = "text/html;charset=" + encoding;
	private transient static final Properties properties = new Properties();
	
	private transient static boolean notInit = true;
	
	public MyVelocityRender(String view){
		this.view = view;
	}
	
	static void init() {
		String webPath = JFinal.me().getServletContext().getRealPath("/");
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, webPath);
		properties.setProperty(Velocity.ENCODING_DEFAULT, encoding); 
		properties.setProperty(Velocity.INPUT_ENCODING, encoding); 
		properties.setProperty(Velocity.OUTPUT_ENCODING, encoding);
	}
	
	public static void setProperties(Properties properties) {
		Set<Entry<Object, Object>> set = properties.entrySet();
		for (Iterator<Entry<Object, Object>> it=set.iterator(); it.hasNext();) {
			Entry<Object, Object> e = it.next();
			MyVelocityRender.properties.put(e.getKey(), e.getValue());
		}
	}
	
	@Override
	public void render() {
		if(notInit){
			Velocity.init("/WEB-INF/velocity/conf/velocity.properties");
			
			notInit = false;
		}
		
		PrintWriter writer = null;
        try {
            /*
             *  Make a context object and populate with the data.  This
             *  is where the Velocity engine gets the data to resolve the
             *  references (ex. $list) in the template
             */
            VelocityContext context = new VelocityContext();
            
    		// Map root = new HashMap();
    		for (@SuppressWarnings("unchecked")
			Enumeration<String> attrs=request.getAttributeNames(); attrs.hasMoreElements();) {
    			String attrName = attrs.nextElement();
    			context.put(attrName, request.getAttribute(attrName));
    		}
    		
            /*
             *  get the Template object.  This is the parsed version of your
             *  template input file.  Note that getTemplate() can throw
             *   ResourceNotFoundException : if it doesn't find the template
             *   ParseErrorException : if there is something wrong with the VTL
             *   Exception : if something else goes wrong (this is generally
             *        indicative of as serious problem...)
             */
            Template template = Velocity.getTemplate(view);
            
            /*
             *  Now have the template engine process your template using the
             *  data placed into the context.  Think of it as a  'merge'
             *  of the template and the data to produce the output stream.
             */
           response.setContentType(contentType);
           writer = response.getWriter();	// BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            
           template.merge(context, writer);
           writer.flush();	// flush and cleanup
        }
        catch(ResourceNotFoundException e) {
        	throw new RenderException("Example : error : cannot find template " + view, e);
        }
        catch( ParseErrorException e) {
            throw new RenderException("Example : Syntax error in template " + view + ":" + e, e);
        }
        catch(Exception e ) {
            throw new RenderException(e);
        }
        finally {
        	if (writer != null)
        		writer.close();
        }
	}

}
