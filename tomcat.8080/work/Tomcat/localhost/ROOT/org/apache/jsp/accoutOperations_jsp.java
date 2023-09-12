/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.0-M17
 * Generated at: 2023-09-12 00:23:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import br.com.kennedy.domain.entities.Account;
import br.com.kennedy.domain.services.AccountOperations;
import br.com.kennedy.utils.ServiceLocator;
import br.com.kennedy.domain.entities.TypeOperation;

public final class accoutOperations_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("br.com.kennedy.domain.entities.Account");
    _jspx_imports_classes.add("br.com.kennedy.utils.ServiceLocator");
    _jspx_imports_classes.add("br.com.kennedy.domain.services.AccountOperations");
    _jspx_imports_classes.add("br.com.kennedy.domain.entities.TypeOperation");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Inicio</title>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("          integrity=\"sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<main class=\"container-fluid full min-vh-100 d-flex flex-column justify-content-center align-items-center gap-2 bg-body-secondary\">\n");
      out.write("    <span class=\" container bg-primary rounded d-flex align-items-center justify-content-center py-2 w-100\">\n");
      out.write("             <h1 class=\"align-self-center text-light\">Caixa eletrônico</h1>\n");
      out.write("    </span>\n");
      out.write("    <section class=\"container d-flex flex-column bg-light-subtle rounded p-5\">\n");
      out.write("        <div class=\"d-flex flex-column align-items-center\">\n");
      out.write("            <h2 class=\"fs-1 text-primary fw-bold\">Saldo</h2>\n");
      out.write("            <p class=\"fs-3\">R$ ");
      out.print( request.getParameter("balance") );
      out.write("\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("        <form action=\"/\" method=\"post\">\n");
      out.write("            <div class=\"row mb-3\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <div class=\"form-floating\">\n");
      out.write("                        <input id=\"value\" required type=\"text\" class=\"form-control\" name=\"value\"/>\n");
      out.write("                        <label for=\"value\">Valor (R$)</label>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <button class=\"btn btn-primary\" name=\"");
      out.print(TypeOperation.DEPOSIT.getValue());
      out.write("\" type=\"submit\">Depositar</button>\n");
      out.write("            <button class=\"btn btn-primary\" type=\"submit\" name=\"");
      out.print(TypeOperation.WITHDRAWAL.getValue());
      out.write("\">Sacar</button>\n");
      out.write("        </form>\n");
      out.write("        ");

            if (Boolean.parseBoolean(request.getParameter("error"))) {
                out.println("<p class='text-danger'>Operação cancelada! Saldo não pode ser negativo!</p>");
            }
        
      out.write("\n");
      out.write("    </section>\n");
      out.write("</main>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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