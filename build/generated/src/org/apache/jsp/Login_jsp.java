package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

    String message = (String) request.getAttribute("message");
    if (message == null) {
        request.setAttribute("message", "Sign up ");
    }
    // If you use EL or JSTL, the above statement is not necessary. 

      out.write("  \r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Basic -->\r\n");
      out.write("        <meta charset=\"utf-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <!-- Mobile Metas -->\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("        <!-- Site Metas -->\r\n");
      out.write("        <meta name=\"keywords\" content=\"\" />\r\n");
      out.write("        <meta name=\"description\" content=\"\" />\r\n");
      out.write("        <meta name=\"author\" content=\"\" />\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/favicon.png\" type=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title> Chatter </title>\r\n");
      out.write("\r\n");
      out.write("        <!-- bootstrap core css -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\" />\r\n");
      out.write("\r\n");
      out.write("        <!--owl slider stylesheet -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css\" />\r\n");
      out.write("        <!-- nice select  -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css\" integrity=\"sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==\" crossorigin=\"anonymous\" />\r\n");
      out.write("        <!-- font awesome style -->\r\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom styles for this template -->\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <!-- responsive style -->\r\n");
      out.write("        <link href=\"css/responsive.css\" rel=\"stylesheet\" />\r\n");
      out.write("        <link href=\"css/phucstyle.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body class=\"sub_page\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"hero_area\"> \r\n");
      out.write("            <div class=\"bg-box\">\r\n");
      out.write("                <img src=\"images/hero-bg.jpg\" alt=\"\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- header section strats -->\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\r\n");
      out.write("            <!-- end header section -->\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- book section -->\r\n");
      out.write("        <section class=\"book_section layout_padding\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"heading_container\">\r\n");
      out.write("                    ");

      out.write("\r\n");
      out.write("                    <div class =\"text\">\r\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("       \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form_container\">\r\n");
      out.write("\r\n");
      out.write("                            <form action=\"login\" method=\"post\">\r\n");
      out.write("                                <div class =\"textusername\">\r\n");
      out.write("                                    Username              \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Enter your username\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <br>                      \r\n");
      out.write("                                <div class =\"textusername\">\r\n");
      out.write("                                    Password                 \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <input type=\"password\" name=\"pass\" class=\"form-control\" placeholder=\"Enter your password\" />\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <span>Forgot your password?</span>\r\n");
      out.write("                                    <a href=\"ResetPassword.jsp\" class=\"text-decoration-none\">Reset my password!</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"btn_box\"  type=\"submit\">\r\n");
      out.write("                                    <button>\r\n");
      out.write("                                        Login\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4\">\r\n");
      out.write("                        <div class=\"img-box\">\r\n");
      out.write("                            <img src=\"images/about-img.png\" width=\"400\" \r\n");
      out.write("                                 height=\"500\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- end book section -->\r\n");
      out.write("\r\n");
      out.write("        <!-- footer section -->\r\n");
      out.write("        <footer class=\"footer_section\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-4 footer-col\">\r\n");
      out.write("                        <div class=\"footer_contact\">\r\n");
      out.write("                            <h4>\r\n");
      out.write("                                Contact Us\r\n");
      out.write("                            </h4>\r\n");
      out.write("                            <div class=\"contact_link_box\">\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                    <span>\r\n");
      out.write("                                        Location\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-phone\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                    <span>\r\n");
      out.write("                                        Call +01 1234567890\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                    <span>\r\n");
      out.write("                                        demo@gmail.com\r\n");
      out.write("                                    </span>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 footer-col\">\r\n");
      out.write("                        <div class=\"footer_detail\">\r\n");
      out.write("                            <a href=\"\" class=\"footer-logo\">\r\n");
      out.write("                                Feane\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <p>\r\n");
      out.write("                                Necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <div class=\"footer_social\">\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-facebook\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-twitter\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-linkedin\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-instagram\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <a href=\"\">\r\n");
      out.write("                                    <i class=\"fa fa-pinterest\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 footer-col\">\r\n");
      out.write("                        <h4>\r\n");
      out.write("                            Opening Hours\r\n");
      out.write("                        </h4>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            Everyday\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            10.00 Am -10.00 Pm\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer-info\">\r\n");
      out.write("                    <p>\r\n");
      out.write("                        &copy; <span id=\"displayYear\"></span> All Rights Reserved By\r\n");
      out.write("                        <a href=\"https://html.design/\">Free Html Templates</a><br><br>\r\n");
      out.write("                        &copy; <span id=\"displayYear\"></span> Distributed By\r\n");
      out.write("                        <a href=\"https://themewagon.com/\" target=\"_blank\">ThemeWagon</a>\r\n");
      out.write("                    </p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("        <!-- footer section -->\r\n");
      out.write("\r\n");
      out.write("        <!-- jQery -->\r\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("        <!-- popper js -->\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <!-- bootstrap js -->\r\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("        <!-- owl slider -->\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <!-- isotope js -->\r\n");
      out.write("        <script src=\"https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js\"></script>\r\n");
      out.write("        <!-- nice select -->\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("        <!-- custom js -->\r\n");
      out.write("        <script src=\"js/custom.js\"></script>\r\n");
      out.write("        <!-- Google Map -->\r\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <!-- End Google Map -->\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
