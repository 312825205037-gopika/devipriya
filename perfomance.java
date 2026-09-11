import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/StudentPerformance")
public class StudentPerformance extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");

        int maths = Integer.parseInt(request.getParameter("maths"));
        int science = Integer.parseInt(request.getParameter("science"));
        int english = Integer.parseInt(request.getParameter("english"));
        int computer = Integer.parseInt(request.getParameter("computer"));
        int social = Integer.parseInt(request.getParameter("social"));

        int total = maths + science + english + computer + social;

        double average = total / 5.0;

        String grade;
        String performance;

        if (average >= 90) {
            grade = "A+";
            performance = "Excellent";
        } 
        else if (average >= 80) {
            grade = "A";
            performance = "Very Good";
        } 
        else if (average >= 70) {
            grade = "B";
            performance = "Good";
        } 
        else if (average >= 60) {
            grade = "C";
            performance = "Average";
        } 
        else if (average >= 50) {
            grade = "D";
            performance = "Pass";
        } 
        else {
            grade = "F";
            performance = "Fail";
        }

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student Performance Result</title>");

        out.println("<style>");

        out.println("body {");
        out.println("font-family: Arial;");
        out.println("background: linear-gradient(135deg, #74ebd5, #ACB6E5);");
        out.println("display: flex;");
        out.println("justify-content: center;");
        out.println("align-items: center;");
        out.println("min-height: 100vh;");
        out.println("}");

        out.println(".result {");
        out.println("background: white;");
        out.println("padding: 35px;");
        out.println("width: 500px;");
        out.println("border-radius: 15px;");
        out.println("box-shadow: 0 10px 25px rgba(0,0,0,0.2);");
        out.println("}");

        out.println("h1 { text-align:center; color:#333; }");

        out.println(".info {");
        out.println("font-size:18px;");
        out.println("margin:12px 0;");
        out.println("}");

        out.println(".performance {");
        out.println("text-align:center;");
        out.println("font-size:25px;");
        out.println("font-weight:bold;");
        out.println("color:#3498db;");
        out.println("margin-top:20px;");
        out.println("}");

        out.println("a {");
        out.println("display:block;");
        out.println("text-align:center;");
        out.println("margin-top:25px;");
        out.println("padding:12px;");
        out.println("background:#3498db;");
        out.println("color:white;");
        out.println("text-decoration:none;");
        out.println("border-radius:6px;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='result'>");

        out.println("<h1>Performance Result</h1>");

        out.println("<div class='info'><b>Student Name:</b> "
                + name + "</div>");

        out.println("<div class='info'><b>Roll Number:</b> "
                + roll + "</div>");

        out.println("<hr>");

        out.println("<div class='info'><b>Mathematics:</b> "
                + maths + "</div>");

        out.println("<div class='info'><b>Science:</b> "
                + science + "</div>");

        out.println("<div class='info'><b>English:</b> "
                + english + "</div>");

        out.println("<div class='info'><b>Computer Science:</b> "
                + computer + "</div>");

        out.println("<div class='info'><b>Social Science:</b> "
                + social + "</div>");

        out.println("<hr>");

        out.println("<div class='info'><b>Total Marks:</b> "
                + total + " / 500</div>");

        out.println("<div class='info'><b>Average:</b> "
                + String.format("%.2f", average) + "%</div>");

        out.println("<div class='info'><b>Grade:</b> "
                + grade + "</div>");

        out.println("<div class='performance'>"
                + performance + "</div>");

        out.println("<a href='index.html'>Analyze Another Student</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}
