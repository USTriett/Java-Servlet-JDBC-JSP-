/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.88
 * Generated at: 2023-04-21 12:57:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WebContent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EditCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/HCMUS/Nam2/semester-4/java/servlet%20+%20jdbc%20+%20jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/StudentManageServlet/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1364130896000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<title>Edit Student</title>\r\n");
      out.write("	<!-- Latest compiled and minified CSS -->\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"/>\r\n");
      out.write("\r\n");
      out.write("	<!-- jQuery library -->\r\n");
      out.write("	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Popper JS -->\r\n");
      out.write("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!-- Latest compiled JavaScript -->\r\n");
      out.write("	<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("	<style>\r\n");
      out.write("	.navbar-brand {\r\n");
      out.write("	font-size: 2rem;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	color: #333;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-nav .nav-link {\r\n");
      out.write("	font-size: 1.2rem;\r\n");
      out.write("	color: #333;\r\n");
      out.write("}\r\n");
      out.write("	</style>\r\n");
      out.write("	\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- Navbar -->\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<!--Brand/logo -->\r\n");
      out.write("		<a class=\"navbar-brand\" href=\"./\">Homepage</a> \r\n");
      out.write("		<button class=\"navbar-toggler \" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("			data-target=\"#navbarNav\" aria-controls=\"navbarNav\"\r\n");
      out.write("			aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("			<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("		</button>\r\n");
      out.write("		<!--Menu items -->\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("			<ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\" href=\"./ScoreBoard\">Score\r\n");
      out.write("						Board</a></li>\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\" href=\"./ListStudent\">Students</a>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\" href=\"./courses\">Courses</a>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"panel panel-primary\">\r\n");
      out.write("			<div class=\"panel-heading\">\r\n");
      out.write("				<h2 class=\"text-center\">Edit</h2>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"panel-body\">\r\n");
      out.write("                            <form method=\"post\" accept-charset=\"utf-8\">\r\n");
      out.write("                 <div class=\"form-group\">\r\n");
      out.write("				  <label for=\"id\">ID:</label>\r\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"  readonly id=\"id\" name=\"id\"/>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-group\">\r\n");
      out.write("				  <label for=\"year\">Year:</label>\r\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getYear()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"  readonly id=\"year\" name=\"year\"/>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"form-group\">\r\n");
      out.write("				  <label for=\"name\">Name:</label>\r\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"  required id=\"name\" name=\"name\"/>\r\n");
      out.write("				\r\n");
      out.write("				  <label for=\"notes\">Notes:</label>\r\n");
      out.write("                                  <input type=\"text\" class=\"form-control\" id=\"notes\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.getNotes()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"notes\"/>\r\n");
      out.write("				</div>\r\n");
      out.write("				<button class=\"btn btn-success\">Submit</button>\r\n");
      out.write("                            </form>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
