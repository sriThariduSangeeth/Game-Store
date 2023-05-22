<%@ page import="org.apache.http.client.methods.HttpGet" %>
<%@ page import="com.store.game.models.Invoice" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.URI" %>
<%@ page import="org.apache.http.impl.client.CloseableHttpClient" %>
<%@ page import="org.apache.http.impl.client.HttpClients" %>
<%@ page import="org.apache.http.client.methods.CloseableHttpResponse" %>
<%@ page import="org.apache.http.HttpEntity" %>
<%@ page import="com.store.game.dao.InvoiceDao" %>
<%@ page import="org.apache.http.util.EntityUtils" %>
<%@ page import="java.net.URISyntaxException" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: dtsangeeth
  Date: 5/23/23
  Time: 03:56
  To change this template use File | Settings | File Templates.
--%>
<%
    HttpGet req;
    List<Invoice> invoiceList = null;
    try {
        req = new HttpGet(new URI("http://localhost:8081/game/store/payments"));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse res = httpClient.execute(req)) {

            HttpEntity entity = res.getEntity();
            if (entity != null) {
                // return it as a String
                invoiceList = new InvoiceDao().getAllInvoices(EntityUtils.toString(entity));
            }

        }
    } catch (URISyntaxException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

%>
<html>
<head>
    <%@include file="./includes/head.jsp"%>
    <title>SQUID Game Store</title>
</head>
<body>
<%@include file="includes/navBar.jsp"%>
<div class="container">
    <div class="card-header my-3">All Purches Invoices</div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">No.</th>
            <th scope="col">Invoice ID</th>
            <th scope="col">customer ID</th>
            <th scope="col">paymentDate</th>
            <th scope="col">paymentMethod</th>
            <th scope="col">Amount</th>
            <th scope="col">Remove</th>
        </tr>
        </thead>
        <tbody>

        <%
            if (invoiceList != null) {
                int x = 1;
                for (Invoice o : invoiceList) {%>
        <tr>
            <td><%=x++ %>
            </td>
            <td><%=o.getInvoiceId() %>
            </td>
            <td><%=o.getCustomerId() %>
            </td>
            <td><%=o.getPaymentDate() %>
            </td>
            <td><%=o.getPaymentMethod() %>
            </td>
            <td><%=o.getAmount() %>
            </td>
            <td><a class="btn btn-sm btn-danger" href="#">Remove</a></td>
        </tr>
        <%
                }
            } else {
                out.println("There is no proucts Selected for your cart");
            }
        %>

        </tbody>
    </table>
</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>
